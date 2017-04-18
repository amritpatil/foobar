package com.foo.bar.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.foo.bar.main.GenerateReport;
import com.foo.bar.main.Instruction;

/**
 * Test report creation class for border cases - leap year, weekend, Arabic currency and USD
 *
 */
public class GenerateReportTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}

	@Test
	public void testCreateReport() {
		GenerateReport generateBuyReport = new GenerateReport(); 
		List<Instruction> insTructionList = new ArrayList<Instruction>();
		Instruction ins = new Instruction();
		ins.setCompany("foo");
		ins.setBuy_sell("B");
		ins.setAgreedFx("0.50");
		ins.setCurrency("SGP");
		ins.setInsDate("01 Jan 2016");
		ins.setSettleDate("02 Jan 2016");
		ins.setUnits("200");
		ins.setPricePerUnit("100.25");
		insTructionList.add((Instruction) ins);
		generateBuyReport.createReport(insTructionList);
		generateBuyReport.printReport();
		assertTrue(outContent.toString().contains("Outgoing Amount settled in USD on 04 Jan 2016 = $10,025.00"));
		assertTrue(outContent.toString().contains("Outgoing rank 1 [foo] amount $10,025.00"));

	}
	@Test
	public void testCreateReport2() {
		GenerateReport generateBuyReport = new GenerateReport(); 
		List<Instruction> insTructionList = new ArrayList<Instruction>();
		Instruction ins = new Instruction();
		ins.setCompany("foo");
		ins.setBuy_sell("B");
		ins.setAgreedFx("0.50");
		ins.setCurrency("USD");
		ins.setInsDate("01 Jan 2016");
		ins.setSettleDate("02 Jan 2016");
		ins.setUnits("200");
		ins.setPricePerUnit("100.25");
		insTructionList.add((Instruction) ins);

		Instruction ins1 = new Instruction();
		ins1.setCompany("bar");
		ins1.setBuy_sell("B");
		ins1.setAgreedFx("0.22");
		ins1.setCurrency("USD");
		ins1.setInsDate("01 Jan 2016");
		ins1.setSettleDate("04 Jan 2016");
		ins1.setUnits("450");
		ins1.setPricePerUnit("150.50");
		insTructionList.add((Instruction) ins1);

		generateBuyReport.createReport(insTructionList);
		generateBuyReport.printReport();
		assertTrue(outContent.toString().contains("Outgoing Amount settled in USD on 04 Jan 2016 = $24,924.50"));
		assertTrue(outContent.toString().contains("Outgoing rank 1 [bar] amount $14,899.50"));


	}

	@Test
	public void testCreateReport3() {

		GenerateReport generateBuyReport = new GenerateReport(); 
		List<Instruction> insTructionList = new ArrayList<Instruction>();
		Instruction ins = new Instruction();
		ins.setCompany("foo");
		ins.setBuy_sell("B");
		ins.setAgreedFx("0.50");
		ins.setCurrency("SGP");
		ins.setInsDate("01 Jan 2016");
		ins.setSettleDate("02 Jan 2016");
		ins.setUnits("200");
		ins.setPricePerUnit("100.25");
		insTructionList.add((Instruction) ins);

		Instruction ins1 = new Instruction();
		ins1.setCompany("bar");
		ins1.setBuy_sell("B");
		ins1.setAgreedFx("0.22");
		ins1.setCurrency("AED");
		ins1.setInsDate("05 Jan 2016");
		ins1.setSettleDate("07 Jan 2016");
		ins1.setUnits("450");
		ins1.setPricePerUnit("150.50");
		insTructionList.add((Instruction) ins1);

		Instruction ins2 = new Instruction();
		ins2.setCompany("foo");
		ins2.setBuy_sell("B");
		ins2.setAgreedFx("0.50");
		ins2.setCurrency("AED");
		ins2.setInsDate("24 Feb 2015");
		ins2.setSettleDate("28 Feb 2015");
		ins2.setUnits("200");
		ins2.setPricePerUnit("100.25");

		insTructionList.add((Instruction) ins2);

		System.out.println(insTructionList.size());
		generateBuyReport.createReport(insTructionList);
		generateBuyReport.printReport();
		assertTrue(outContent.toString().contains("Outgoing Amount settled in USD on 01 Mar 2015 = $10,025.00"));
		assertTrue(outContent.toString().contains("Outgoing Amount settled in USD on 04 Jan 2016 = $10,025.00"));
		assertTrue(outContent.toString().contains("Outgoing Amount settled in USD on 07 Jan 2016 = $14,899.50"));
		assertTrue(outContent.toString().contains("Outgoing rank 1 [bar] amount $14,899.50"));
		assertTrue(outContent.toString().contains("Outgoing rank 2 [foo, foo] amount $10,025.00"));

	}

}
