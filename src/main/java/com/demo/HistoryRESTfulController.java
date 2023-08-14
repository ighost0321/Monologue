package com.demo;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@CrossOrigin
@RestController
public class HistoryRESTfulController extends MapperRESTfulController {
	private static final Logger log = (Logger) LoggerFactory.getLogger(HistoryRESTfulController.class);
	
	@Autowired
	private MemoService service;

	@GetMapping("/api/history")
	public String getHistory() {
		log.info("To search DB....");
		var list = service.findAll();
		var history = new History();
		if (list != null) {
			history.setStatusCode("200");
			history.setMessage("OK");
			history.setData(list);
		} else {
			history.setStatusCode("500");
			history.setMessage("Fail");
			history.setData(null);
		}
		return this.toJson(history);

	}

}
