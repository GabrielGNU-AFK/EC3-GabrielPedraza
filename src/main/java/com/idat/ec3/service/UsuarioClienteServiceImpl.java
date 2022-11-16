package com.idat.ec3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec3.model.UsuarioCliente;
import com.idat.ec3.repository.UsuarioClienteRepository;


@Service
public class UsuarioClienteServiceImpl implements UsuarioClienteService {
	
	@Autowired
	private UsuarioClienteRepository repository;

	@Override
	public void guardar(UsuarioCliente usuarioCliente) {
		repository.save(usuarioCliente);
		
	}

	@Override
	public void actualizar(UsuarioCliente usuarioCliente) {
		repository.saveAndFlush(usuarioCliente);
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<UsuarioCliente> listar() {
		return repository.findAll();
	}

	@Override
	public UsuarioCliente obtener(Integer id) {
		
		return repository.findById(id).orElse(null);
	}

}
