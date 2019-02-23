package com.demo.instrument.service;

import java.util.Collections;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.instrument.InstrumentApplication;
import com.demo.instrument.model.Instrument;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InstrumentServiceTest {
	final static String LME_CODE = "PB_03_2018";
	final static String LME_LAST_TRADING_DATE = "15-03-2018";
	final static String LME_DELIVERY_DATE = "17-03-2018";
	final static String LME_MARKET = "LME_PB";
	final static String LME_LABEL = "Lead 13 March 2018";
	
	final static String PRIME_CODE = "PRIME_PB_03_2018";
	final static String PRIME_EXCHANGE_CODE = "PB_03_2018";
	final static String PRIME_LAST_TRADING_DATE = "14-03-2018";
	final static String PRIME_DELIVERY_DATE = "18-03-2018";
	final static String PRIME_MARKET = "LME_PB";
	final static String PRIME_LABEL = "Lead 13 March 2018";

	@Autowired
	InstrumentService service;
	
	private void cleanCache() {
		InstrumentApplication.instruments = Collections.synchronizedCollection(new HashSet<>());
		InstrumentApplication.publishedInstruments = Collections.synchronizedCollection(new HashSet<>());
	}
	
	@Test
	public void addLMESuccessfully() {
		cleanCache();
		addLMEInstrument();
		assert InstrumentApplication.instruments.size() == 1;
		Instrument instrumentStored = InstrumentApplication.instruments.iterator().next();
		assert instrumentStored.getLastTradingDate().equals(LME_LAST_TRADING_DATE);
		assert instrumentStored.getDeliveryDate().equals(LME_DELIVERY_DATE);
		assert instrumentStored.getMarket().equals(LME_MARKET);
		assert instrumentStored.getLabel().equals(LME_LABEL);
	}

	private void addLMEInstrument() {
		String publisher = Instrument.LME;
		String code = LME_CODE;
		String exchangeCode = "";
		String lastTradingDate = LME_LAST_TRADING_DATE;
		String deliveryDate = LME_DELIVERY_DATE;
		String market = LME_MARKET;
		String label = LME_LABEL;
		boolean tradable = false;
		Instrument instrument = new Instrument(publisher, code, exchangeCode, lastTradingDate, deliveryDate, market, label, tradable);
		service.add(instrument);
	}
	
	@Test
	public void publishLMESuccessfully() {
		cleanCache();
		addLMEInstrument();
		assert InstrumentApplication.instruments.size() == 1;
		publishLMEInstrument();
		assert InstrumentApplication.publishedInstruments.size() == 1;
		Instrument instrument = InstrumentApplication.publishedInstruments.iterator().next();
		assert instrument.getLastTradingDate().equals(LME_LAST_TRADING_DATE);
		assert instrument.getDeliveryDate().equals(LME_DELIVERY_DATE);
		assert instrument.getMarket().equals("PB");
		assert instrument.getLabel().equals(LME_LABEL);
		assert instrument.getTradable();
	}

	private void publishLMEInstrument() {
		Instrument i = new Instrument();
		i.setPublisher(Instrument.LME);
		i.setCode("PB_03_2018");
		service.publishInstrument(i);
	}

	@Test
	public void listLMEPublishedInstruments() {
		cleanCache();
		addLMEInstrument();
		publishLMEInstrument();
		String instruments = "{publisher:LME, code:PB_03_2018, exchangeCode:, lastTradingDate:15-03-2018, deliveryDate:17-03-2018, market:PB, label:Lead 13 March 2018, tradable:true}\n";
		assert instruments.equals(service.listPublishedInstruments());
	}

	private void addPrimeInstrument() {
		String publisher = Instrument.PRIME;
		String code = PRIME_CODE;
		String exchangeCode = PRIME_EXCHANGE_CODE;
		String lastTradingDate = PRIME_LAST_TRADING_DATE;
		String deliveryDate = PRIME_DELIVERY_DATE;
		String market = PRIME_MARKET;
		String label = PRIME_LABEL;
		boolean tradable = false;
		Instrument instrument = new Instrument(publisher, code, exchangeCode, lastTradingDate, deliveryDate, market, label, tradable);
		service.add(instrument);
	}
	
	@Test
	public void publishLMEAndPRIMESuccessfully() {
		cleanCache();
		addLMEInstrument();
		addPrimeInstrument();
		assert InstrumentApplication.instruments.size() == 2;
		publishLMEInstrument();
		publishPrimeInstrument();
		assert InstrumentApplication.publishedInstruments.size() == 2;
		String instruments = "{publisher:LME, code:PB_03_2018, exchangeCode:, lastTradingDate:15-03-2018, deliveryDate:17-03-2018, market:PB, label:Lead 13 March 2018, tradable:true}\n" + 
				"{publisher:PRIME, code:PRIME_PB_03_2018, exchangeCode:PB_03_2018, lastTradingDate:15-03-2018, deliveryDate:17-03-2018, market:PB, label:Lead 13 March 2018, tradable:false}\n";
		assert instruments.equals(service.listPublishedInstruments());
	}
	
	private void publishPrimeInstrument() {
		Instrument i = new Instrument();
		i.setPublisher(Instrument.PRIME);
		i.setCode("PB_03_2018");
		service.publishInstrument(i);
	}
}
