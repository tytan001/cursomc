package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.reposituries.ClienteRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	/*
	 * public Cliente buscar(Integer id) { Cliente obj = repo.findOne(id);
	 * return obg; }
	 */
	//// sem tratamento de excessão
	/*
	 * public Cliente find(Integer id) { Optional<Cliente> obj =
	 * repo.findById(id); return obj.orElse(null); }
	 */
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
