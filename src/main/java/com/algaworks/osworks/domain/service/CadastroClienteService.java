package com.algaworks.osworks.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.repository.ClienteRepository;

public class CadastroClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente){
		return clienteRepository.save(cliente);
		
	}
}
