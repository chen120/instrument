package com.demo.instrument.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.instrument.dao.InstrumentDao;
import com.demo.instrument.model.Instrument;

@Service
public class LMECodePrimeExchangeCodeMapper implements InstrumentMapper {
	@Autowired
	InstrumentDao dao;

	@Override
	public Instrument map(Instrument i) {
		return dao.findByExchangeCode(i.getCode());
	}

}
