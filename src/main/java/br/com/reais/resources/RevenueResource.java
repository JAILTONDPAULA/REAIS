package br.com.reais.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="receitas")
public class RevenueResource {
	@GetMapping
	public String list() {
		return "teste";
	}
}
