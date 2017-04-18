package com.foo.bar.main;

import java.util.Comparator;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;

/**
 * Calculates Ranking in descending order for outgoing and incoming trades
 *
 */
public class Ranking {


	/**
	 *  Customized comparator to sort ranking in descending order 
	 */
	private static final Comparator<Double> DESC_ORDER = new Comparator<Double>() {

		@Override
		public int compare(Double o1, Double o2) {
			// TODO Auto-generated method stub
			return o2.compareTo(o1);
		}
	};

	private ListMultimap<Double, String> rankingIncoming = MultimapBuilder.treeKeys(DESC_ORDER).arrayListValues().build();

	private ListMultimap<Double, String> rankingOutgoing = MultimapBuilder.treeKeys(DESC_ORDER).arrayListValues().build();



	/**
	 * Sort the daily incoming ranking based on trade amount and storing it in a ListMultimap
	 * 
	 * @param amount
	 * @param company
	 */
	public void setDailyRankingIncoming (Double amount, String company) {
		rankingIncoming.put(amount, company);
	}

	/**
	 * Sort the daily outgoing ranking based on trade amount and storing it in a ListMultimap
	 * 
	 * @param amount
	 * @param company
	 */
	public void setDailyRankingOutgoing (Double amount, String company) {
		rankingOutgoing.put(amount, company);
	}
	
	

	/**
	 * Return the daily outgoing ranking based on highest per trade amount - incoming
	 * 
	 */
	public ListMultimap<Double, String>  getRankingIncoming() {
		return rankingIncoming;
	}

	/**
	 * Return the daily outgoing ranking based on highest per trade amount - outgoing
	 * 
	 */
	public ListMultimap<Double, String>  getRankingOutgoing() {		
		return rankingOutgoing;
	}

}
