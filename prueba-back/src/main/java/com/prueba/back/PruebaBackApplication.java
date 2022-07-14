package com.prueba.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class PruebaBackApplication {
	@RequestMapping("/")
    @ResponseBody
    String home() {
      return "Examen";
    }

	public static void main(String[] args) {
		SpringApplication.run(PruebaBackApplication.class, args);
	}

}
