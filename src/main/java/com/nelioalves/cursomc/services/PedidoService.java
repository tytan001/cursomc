package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.reposituries.PedidoRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	/*
	 * public Pedido buscar(Integer id) { Pedido obj = repo.findOne(id);
	 * return obg; }
	 */
	//// sem tratamento de excessão
	/*
	 * public Pedido find(Integer id) { Optional<Pedido> obj =
	 * repo.findById(id); return obj.orElse(null); }
	 */
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
