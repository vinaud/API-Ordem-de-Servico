package com.algaworks.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Joao snow");
		cliente1.setEmail("email@email.com");
		cliente1.setTelefone("+5511912345678");
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Maria");
		cliente2.setEmail("email2@email.com");
		cliente2.setTelefone("+551191235433");
		
		return Arrays.asList(cliente1, cliente2);
	}
}
