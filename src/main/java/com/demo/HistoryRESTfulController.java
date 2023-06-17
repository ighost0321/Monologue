package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HistoryRESTfulController extends MapperRESTfulController {
	
	@Autowired
	private MemoService service;

	@GetMapping("/api/history")
	public String getHistory() {
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
