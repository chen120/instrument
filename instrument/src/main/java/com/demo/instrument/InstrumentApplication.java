package com.demo.instrument;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.instrument.model.Instrument;

@SpringBootApplication
public class InstrumentApplication {
	
	public static Collection<Instrument> instruments = Collections.synchronizedCollection(new HashSet<>());
	public static Collection<Instrument> publishedInstruments = Collections.synchronizedCollection(new HashSet<>());

	public static void main(String[] args) {
		SpringApplication.run(InstrumentApplication.class, args);
	}

}
