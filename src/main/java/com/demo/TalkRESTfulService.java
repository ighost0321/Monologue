package com.demo;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import ch.qos.logback.classic.Logger;

@CrossOrigin
@RestController
public class TalkRESTfulService {
	private static final Logger log = (Logger) LoggerFactory.getLogger(TalkRESTfulService.class);

	@Autowired
	private MemoService service;

	@PostMapping("/api/talk")
	public String talk(@RequestBody JsonNode jsonNode) {
		String text = jsonNode.get("text").asText();
		log.info("Hear...." , text);
		Memo m = new Memo();
		m.setWords(text);
		try {
			service.save(m);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return "{\"message\":\"OK\"}";
	}

}
