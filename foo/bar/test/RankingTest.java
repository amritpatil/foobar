package com.foo.bar.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.foo.bar.main.Ranking;
import com.google.common.collect.Iterables;

public class RankingTest {

	/**
	 * Test cases to check whether the rankings are sorted correctly
	 */
	@Test
	public void testDailyRankingIncoming() {
		
		Ranking ranking = new Ranking();

		ranking.setDailyRankingIncoming(1000.35, "foo");
		assertEquals(1000.35, Iterables.getFirst(ranking.getRankingIncoming().keys(), 0));
		assertEquals(1000.35, Iterables.getLast(ranking.getRankingIncoming().keys(), 0));
		
		ranking.setDailyRankingIncoming(1500.01, "foo");
		assertEquals(1500.01, Iterables.getFirst(ranking.getRankingIncoming().keys(), 0));
		assertEquals(1000.35, Iterables.getLast(ranking.getRankingIncoming().keys(), 0));
		
		ranking.setDailyRankingIncoming(1000.35, "foo");
		assertEquals(1500.01, Iterables.getFirst(ranking.getRankingIncoming().keys(), 0));
		assertEquals(1000.35, Iterables.getLast(ranking.getRankingIncoming().keys(), 0));
		
		ranking.setDailyRankingIncoming(2000.05, "foo");
		assertEquals(2000.05, Iterables.getFirst(ranking.getRankingIncoming().keys(), 0));
		assertEquals(1000.35, Iterables.getLast(ranking.getRankingIncoming().keys(), 0));

		ranking.setDailyRankingIncoming(700.35, "foo");
		assertEquals(2000.05, Iterables.getFirst(ranking.getRankingIncoming().keys(), 0));
		assertEquals(700.35, Iterables.getLast(ranking.getRankingIncoming().keys(), 0));
		
	}

	/**
	 * Test cases to check whether the rankings are sorted correctly
	 */
	@Test
	public void testDailyRankingOutgoing() {
		
		Ranking ranking = new Ranking();

		ranking.setDailyRankingOutgoing(1000.35, "foo");
		assertEquals(1000.35, Iterables.getFirst(ranking.getRankingOutgoing().keys(), 0));
		assertEquals(1000.35, Iterables.getLast(ranking.getRankingOutgoing().keys(), 0));
		
		ranking.setDailyRankingOutgoing(1500.01, "foo");
		assertEquals(1500.01, Iterables.getFirst(ranking.getRankingOutgoing().keys(), 0));
		assertEquals(1000.35, Iterables.getLast(ranking.getRankingOutgoing().keys(), 0));
		
		ranking.setDailyRankingOutgoing(2000.05, "foo");
		assertEquals(2000.05, Iterables.getFirst(ranking.getRankingOutgoing().keys(), 0));
		assertEquals(1000.35, Iterables.getLast(ranking.getRankingOutgoing().keys(), 0));

		ranking.setDailyRankingOutgoing(700.35, "foo");
		assertEquals(2000.05, Iterables.getFirst(ranking.getRankingOutgoing().keys(), 0));
		assertEquals(700.35, Iterables.getLast(ranking.getRankingOutgoing().keys(), 0));
		
	}

}
