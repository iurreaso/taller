package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
	
	private final Logger logger = LoggerFactory.getLogger(SaludoController.class);
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/saludo")
    public Saludo greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	
    	this.logger.info("Esto es un mensaje de información");
    	
    	if (name.equals("pepe")) {
    		return new Saludo(1,
                    String.format(template, name));
    	}
        return new Saludo(counter.incrementAndGet(),
                            String.format(template, name));
    }

}
