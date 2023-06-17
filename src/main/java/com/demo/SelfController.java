package com.demo;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.classic.Logger;

@Controller
public class SelfController {
	private static final Logger log = (Logger) LoggerFactory.getLogger(SelfController.class);

	@Autowired
	private MemoService service;

	@RequestMapping("/")
	public String self() {
		return "redirect:self.html";
	}

	@PostMapping("/speak")
	public String hear(@RequestParam("talking") String words, Model model) {
		log.info("Hear....",words);
		Memo m = new Memo();
		m.setWords(words);
		try {
			service.save(m);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return "redirect:self.html";
	}

}
