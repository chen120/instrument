package com.demo.instrument.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.instrument.model.Instrument;
import com.demo.instrument.service.InstrumentService;

/*
 * The application provide 3 Restful API for adding, publishing and list instruments
 */
@RestController
public class InstrumentController {
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	InstrumentService service;
	
	@PostMapping("/instrument/add")
	public String add() {
		//get instrument info from request
		String publisher = request.getParameter("publisher");
		String code = request.getParameter("code");
		String exchangeCode = request.getParameter("exchangeCode");
		String lastTradingDate = request.getParameter("lastTradingDate");
		String deliveryDate = request.getParameter("deliveryDate");
		String market = request.getParameter("market");
		String label = request.getParameter("label");
		boolean tradable = request.getParameter("tradable") == null? false : request.getParameter("tradable").equalsIgnoreCase("true");
		
		Instrument instrument = new Instrument(publisher, code, exchangeCode, lastTradingDate, deliveryDate, market, label, tradable);
		service.add(instrument);
		return "success";
	}
	
	@PutMapping("/instrument/publish")
	public String publish() {
		String publisher = request.getParameter("publisher");
		String code = request.getParameter("code");
		Instrument i = new Instrument();
		i.setPublisher(publisher);
		i.setCode(code);
		if(service.publishInstrument(i))
			return "success";
		else
			return "failed";
	}
	
	@GetMapping("/instrument/listPublished")
	public String listPublished() {
		return service.listPublishedInstruments();
	}

}
