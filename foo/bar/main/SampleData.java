package com.foo.bar.main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * A sample data class to test the application
 *
 */
public class SampleData {

	public static void main (String args[] ) throws NumberFormatException, IOException
	{
		List<Instruction> insTructionList = new ArrayList<Instruction>();

		Instruction ins = new Instruction();
		ins.setCompany("foo");
		ins.setBuy_sell("B");
		ins.setAgreedFx("0.50");
		ins.setCurrency("AED");
		ins.setInsDate("01 Jan 2015");
		ins.setSettleDate("28 Feb 2015");
		ins.setUnits("200");
		ins.setPricePerUnit("100.25");
		insTructionList.add((Instruction) ins);

		Instruction ins1 = new Instruction();
		ins1.setCompany("bar");
		ins1.setBuy_sell("B");
		ins1.setAgreedFx("0.22");
		ins1.setCurrency("AED");
		ins1.setInsDate("05 Jan 2016");
		ins1.setSettleDate("28 Feb 2016");
		ins1.setUnits("450");
		ins1.setPricePerUnit("150.50");
		insTructionList.add((Instruction) ins1);

		Instruction ins2 = new Instruction();
		ins2.setCompany("bar");
		ins2.setBuy_sell("B");
		ins2.setAgreedFx("0.50");
		ins2.setCurrency("AED");
		ins2.setInsDate("24 Feb 2016");
		ins2.setSettleDate("31 Dec 2016");
		ins2.setUnits("200");
		ins2.setPricePerUnit("20.25");
		insTructionList.add((Instruction) ins2);

		Instruction ins3 = new Instruction();
		ins3.setCompany("foo");
		ins3.setBuy_sell("B");
		ins3.setAgreedFx("0.50");
		ins3.setCurrency("USD");
		ins3.setInsDate("01 Jan 2016");
		ins3.setSettleDate("02 Jan 2016");
		ins3.setUnits("200");
		ins3.setPricePerUnit("30.25");
		insTructionList.add((Instruction) ins3);
		
		Instruction ins4 = new Instruction();
		ins4.setCompany("foo");
		ins4.setBuy_sell("B");
		ins4.setAgreedFx("0.50");
		ins4.setCurrency("USD");
		ins4.setInsDate("01 Jan 2016");
		ins4.setSettleDate("04 Jan 2016");
		ins4.setUnits("200");
		ins4.setPricePerUnit("30.25");
		insTructionList.add((Instruction) ins4);
		
		Instruction ins5 = new Instruction();
		ins5.setCompany("foo");
		ins5.setBuy_sell("S");
		ins5.setAgreedFx("0.50");
		ins5.setCurrency("USD");
		ins5.setInsDate("01 Jan 2016");
		ins5.setSettleDate("04 Jan 2016");
		ins5.setUnits("200");
		ins5.setPricePerUnit("50.25");
		insTructionList.add((Instruction) ins5);
		
		Instruction ins6 = new Instruction();
		ins6.setCompany("bar");
		ins6.setBuy_sell("S");
		ins6.setAgreedFx("0.10");
		ins6.setCurrency("AED");
		ins6.setInsDate("01 Jan 2016");
		ins6.setSettleDate("04 Jan 2016");
		ins6.setUnits("200");
		ins6.setPricePerUnit("150.25");
		insTructionList.add((Instruction) ins6);

		Instruction ins7 = new Instruction();
		ins7.setCompany("bar");
		ins7.setBuy_sell("S");
		ins7.setAgreedFx("0.10");
		ins7.setCurrency("AED");
		ins7.setInsDate("01 Jan 2016");
		ins7.setSettleDate("04 Jan 2016");
		ins7.setUnits("200");
		ins7.setPricePerUnit("150.25");
		insTructionList.add((Instruction) ins6);
		
		GenerateReport generateReport = new GenerateReport(); 
		generateReport.createReport(insTructionList);
		generateReport.printReport();
	}

}
