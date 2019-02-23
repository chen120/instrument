package com.demo.instrument.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.instrument.dao.InstrumentDao;
import com.demo.instrument.helper.Publisher;
import com.demo.instrument.model.Instrument;

@Component
public class InstrumentService {
	
	@Autowired
	private InstrumentDao instrumentDao;
	
	@Autowired
	private Publisher publisher;
	
	public boolean add(Instrument instrument) {
		return instrumentDao.add(instrument);
	}
	
	public boolean publishInstrument(Instrument i) {
		//if you want to change the rule of publish, just implements Publisher and override the publish() method 
		return publisher.publish(i);
	}

	public String listPublishedInstruments() {
		Collection<Instrument> publishedInstruments = instrumentDao.listPublishedInstruments();
		StringBuilder s = new StringBuilder();
		for(Instrument i : publishedInstruments) {
			s.append(i.toString()).append("\n");
		}
		return s.toString();
	}
}
