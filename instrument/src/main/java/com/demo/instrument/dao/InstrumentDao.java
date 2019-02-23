package com.demo.instrument.dao;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.demo.instrument.InstrumentApplication;
import com.demo.instrument.model.Instrument;

@Component
public class InstrumentDao {
	public boolean add(Instrument instrument) {
		return InstrumentApplication.instruments.add(instrument);
	}
	
	public Instrument findByCode(String code) {
		Instrument returnVal = null;
		for(Instrument i: InstrumentApplication.instruments) {
			if(code.equals(i.getCode())) {
				returnVal = i;
				break;
			}
		}
		return returnVal;
	}

	public boolean savePublished(Instrument published) {
		return InstrumentApplication.publishedInstruments.add(published);
	}

	public Collection<Instrument> listPublishedInstruments() {
		return InstrumentApplication.publishedInstruments;
	}

	public Instrument findByExchangeCode(String code) {
		Instrument returnVal = null;
		for(Instrument i: InstrumentApplication.instruments) {
			if(code.equals(i.getExchangeCode())) {
				returnVal = i;
				break;
			}
		}
		return returnVal;
	}
}
