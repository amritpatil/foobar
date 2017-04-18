package com.foo.bar.main;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.google.common.collect.ListMultimap;

/**
 * Generate and Create Reports for the following:
 * 
 * Amount in USD settled incoming everyday
 * Amount in USD settled outgoing everyday
 * Ranking of entities based on incoming and outgoing amount
 * 
 */
public class GenerateReport {

	private WorkDay workDay = new WorkDay();
	private DailyAmount dailyAmount = new DailyAmount();
	private Ranking ranking = new Ranking();
	private TradeAmount tradeAmount = new TradeAmount();
	private final String FORMATDATE = "dd MMM uuuu";	
	private final String outgoing = "B";
	private final String incoming = "S";
	private NumberFormat usdFormat = NumberFormat.getCurrencyInstance(Locale.US);
	/**
	 * Making sure to Strict Resolver Style to avoid leap year errors
	 */
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATDATE, Locale.ENGLISH ).withResolverStyle(ResolverStyle.STRICT);

	/**
	 * Create the Required Report
	 */
	public void createReport(List<Instruction> instructionList) {
		if(instructionList!=null)
		{
			for(int i = 0; i < instructionList.size(); i++) {  

				Instruction instruction = (Instruction)(instructionList.get(i));		

				double transactionAmount = tradeAmount.getAmount(instruction.getPricePerUnit(), 
						instruction.getUnits(), instruction.getAgreedFx());

				if(!workDay.isWorkday(instruction.getSettleDate(), instruction.getCurrency()))
				{
					LocalDate localdate= workDay.nextWorkingDay(instruction.getSettleDate(), instruction.getCurrency());
					instruction.setSettleDate(localdate.format(formatter));
				}

				if(instruction.getBuy_sell().equalsIgnoreCase(outgoing))
				{	
					dailyAmount.setDailyAmountOutgoing(instruction.getSettleDate(), transactionAmount);
					ranking.setDailyRankingOutgoing(transactionAmount, instruction.getCompany());
				}
				else if (instruction.getBuy_sell().equalsIgnoreCase(incoming))
				{
					dailyAmount.setDailyAmountIncoming(instruction.getSettleDate(), transactionAmount);
					ranking.setDailyRankingIncoming(transactionAmount, instruction.getCompany());

				}
			}
		}  
	}

	/**
	 * Print the following:
	 * 	Daily incoming amount
	 * 	Daily outgoing amount
	 *  Daily incoming ranking
	 *  Daily outgoing ranking
	 * 
	 */
	public void printReport() {

		printAmountIncomingReport();
		printAmountOutgoingReport();
		printRankIncomingReport();
		printRankOutgoingReport();

	}


	/**
	 * Print Total Daily incoming Amount
	 * 
	 */
	public void printAmountIncomingReport() {

		Map<String, Double> multiMapInComing = dailyAmount.getAmountIncoming();
		for(String settlementDate : multiMapInComing.keySet()) {
			System.out.println("Incoming Amount settled in USD on " + settlementDate + " = " + usdFormat.format(multiMapInComing.get(settlementDate)));
		}

	}


	/**
	 * Print Total Daily outgoing Amount
	 * 
	 */
	public void printAmountOutgoingReport() {

		Map<String, Double> multiMapOutGoing = dailyAmount.getAmountOutgoing();

		for(String settlementDate : multiMapOutGoing.keySet()) {
			System.out.println("Outgoing Amount settled in USD on " + settlementDate + " = " + usdFormat.format(multiMapOutGoing.get(settlementDate)));

		}
	}


	/**
	 * Print Daily incoming rankings sorted by amount
	 * 
	 */
	public void printRankIncomingReport() {

		ListMultimap<Double, String>  rankingIncoming = ranking.getRankingIncoming();

		int x=1;
		for (Double amount : rankingIncoming.keySet()) {
			System.out.println("Incoming rank " + x + " " +  rankingIncoming.get(amount) + " amount "+ usdFormat.format(amount));
			x+=1;
		}

	}


	/**
	 * Print Daily outgoing rankings sorted by amount
	 * 
	 */
	public void printRankOutgoingReport() {

		ListMultimap<Double, String>  rankingOutgoing = ranking.getRankingOutgoing();

		int x=1;
		for (Double amount : rankingOutgoing.keySet()) {
			System.out.println( "Outgoing rank " + x + " " +  rankingOutgoing.get(amount) + " amount "+ usdFormat.format(amount));
			x+=1;
		}

	}
}
