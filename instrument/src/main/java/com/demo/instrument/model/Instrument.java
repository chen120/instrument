package com.demo.instrument.model;

public class Instrument {
	public static String LME = "LME";
	public static String PRIME = "PRIME";
	
	String publisher;
	String code;
	String exchangeCode;
	String lastTradingDate;
	String deliveryDate;
	String market;
	String label;
	boolean tradable;
	
	public Instrument() {
		
	}
	
	public Instrument(String publisher, String code, String exchangeCode, String lastTradingDate, String deliveryDate,
			String market, String label, boolean tradable) {
		super();
		this.publisher = publisher;
		this.code = code;
		this.exchangeCode = exchangeCode;
		this.lastTradingDate = lastTradingDate;
		this.deliveryDate = deliveryDate;
		this.market = market;
		this.label = label;
		this.tradable = tradable;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getExchangeCode() {
		return exchangeCode;
	}
	public void setExchangeCode(String exchangeCode) {
		this.exchangeCode = exchangeCode;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getLastTradingDate() {
		return lastTradingDate;
	}
	public void setLastTradingDate(String lastTradingDate) {
		this.lastTradingDate = lastTradingDate;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public boolean getTradable() {
		return tradable;
	}
	public void setTradable(boolean tradable) {
		this.tradable = tradable;
	}

	@Override
	public String toString() {
		return "{publisher:" + publisher + ", code:" + code + ", exchangeCode:" + exchangeCode
				+ ", lastTradingDate:" + lastTradingDate + ", deliveryDate:" + deliveryDate + ", market:" + market
				+ ", label:" + label + ", tradable:" + tradable + "}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
		result = prime * result + ((exchangeCode == null) ? 0 : exchangeCode.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((lastTradingDate == null) ? 0 : lastTradingDate.hashCode());
		result = prime * result + ((market == null) ? 0 : market.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + (tradable ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instrument other = (Instrument) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (deliveryDate == null) {
			if (other.deliveryDate != null)
				return false;
		} else if (!deliveryDate.equals(other.deliveryDate))
			return false;
		if (exchangeCode == null) {
			if (other.exchangeCode != null)
				return false;
		} else if (!exchangeCode.equals(other.exchangeCode))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (lastTradingDate == null) {
			if (other.lastTradingDate != null)
				return false;
		} else if (!lastTradingDate.equals(other.lastTradingDate))
			return false;
		if (market == null) {
			if (other.market != null)
				return false;
		} else if (!market.equals(other.market))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (tradable != other.tradable)
			return false;
		return true;
	}
	

}
