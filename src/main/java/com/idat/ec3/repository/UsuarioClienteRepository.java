package com.idat.ec3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.ec3.model.UsuarioCliente;

@Repository
public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Integer> {
	
	
	UsuarioCliente findByUsuario(String usuario);

}
