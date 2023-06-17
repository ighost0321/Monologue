package com.demo;

import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.classic.Logger;

public class MapperRESTfulController {
	private static final Logger log = (Logger) LoggerFactory.getLogger(TalkRESTfulService.class);

	public final ObjectMapper mapper = new ObjectMapper();

	public <T> String toJson(T object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			log.error("", e);
		} 
		return null;
	}

}
