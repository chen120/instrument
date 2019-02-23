package com.demo.instrument.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.instrument.dao.InstrumentDao;
import com.demo.instrument.model.Instrument;

@Service
public class DefaultPublisher implements Publisher {
	@Autowired
	private InstrumentDao instrumentDao;
	
	@Autowired
	private InstrumentMapper mapper;

	@Override
	public boolean publish(Instrument i) {
		String code = i.getCode();
		String publisher = i.getPublisher();
		Instrument LEMInstrument = instrumentDao.findByCode(code);
		if(LEMInstrument == null) {
			return false;
		}
		Instrument published = new Instrument();
		published.setLastTradingDate(LEMInstrument.getLastTradingDate());
		published.setDeliveryDate(LEMInstrument.getDeliveryDate());
		if(publisher.equalsIgnoreCase(Instrument.LME)) {
			published.setTradable(true);
			published.setMarket(LEMInstrument.getMarket().replaceAll(".*_", ""));
			published.setLabel(LEMInstrument.getLabel());
			published.setPublisher(LEMInstrument.getPublisher());
			published.setCode(LEMInstrument.getCode());
			published.setExchangeCode(LEMInstrument.getExchangeCode());
		}
		else if(publisher.equalsIgnoreCase(Instrument.PRIME)) {
			//if you want to change the map rule, just implements InstrumentMapper
			Instrument primeInstrument = mapper.map(LEMInstrument);
			published.setTradable(primeInstrument.getTradable());
			published.setMarket(primeInstrument.getMarket().replaceAll(".*_", ""));
			published.setLabel(primeInstrument.getLabel());
			published.setPublisher(primeInstrument.getPublisher());
			published.setCode(primeInstrument.getCode());
			published.setExchangeCode(primeInstrument.getExchangeCode());
			
		}
		return instrumentDao.savePublished(published);
	}

}
