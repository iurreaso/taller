package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
	
	private static final String template = "MODIFICACIÓN FERNANDO Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/saludo")
    public Saludo greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Saludo(counter.incrementAndGet(),
                            String.format(template, name));
    }

}
