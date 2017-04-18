package com.foo.bar.main;

/**
 * Customer Instruction
 *
 */
public class Instruction {
	
	
	 /**
	 *  Assuming Customer instructions will be supplied as Strings in text format
	 */
	 private String company;
	 private String buy_sell;
	 private String agreedFx;
	 private String currency;
	 private String insDate;
	 private String settleDate;
	 private String units;
	 private String pricePerUnit;

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBuy_sell() {
		return buy_sell;
	}
	public void setBuy_sell(String buy_sell) {
		this.buy_sell = buy_sell;
	}
	public String getAgreedFx() {
		return agreedFx;
	}
	public void setAgreedFx(String agreedFx) {
		this.agreedFx = agreedFx;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getInsDate() {
		return insDate;
	}
	public void setInsDate(String insDate) {
		this.insDate = insDate;
	}
	public String getSettleDate() {
		return settleDate;
	}
	public void setSettleDate(String localDate) {
		this.settleDate = localDate;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public String getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(String pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

}
