package com.idat.ec3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.ec3.model.UsuarioCliente;
import com.idat.ec3.service.UsuarioClienteService;


@RestController
@RequestMapping("/usuariocliente/v1")
public class UsuarioClienteController {
	
	
	@Autowired
	private UsuarioClienteService service;
	

	
	

	@RequestMapping(path="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<UsuarioCliente>> listar(){
		return new ResponseEntity<List<UsuarioCliente>>(service.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody UsuarioCliente usuarioCliente){
		service.guardar(usuarioCliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@RequestMapping(path="/listar/{id}", method=RequestMethod.GET)
	public ResponseEntity<UsuarioCliente> obtenerPorId(@PathVariable Integer id){
		UsuarioCliente usuarioCliente=service.obtener(id);
		if(usuarioCliente!=null) {
			return new ResponseEntity<UsuarioCliente>(usuarioCliente,HttpStatus.OK);
		}else {
			return new ResponseEntity<UsuarioCliente>(usuarioCliente,HttpStatus.NOT_FOUND);
		}
		
	}
	

	
	@RequestMapping(path="/editar", method =RequestMethod.PUT )
	public ResponseEntity<Void> editar(@RequestBody UsuarioCliente usuarioCliente){
		
		UsuarioCliente Obj=service.obtener(usuarioCliente.getIdUsuario());
		if(Obj !=null) {
			service.actualizar(usuarioCliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path="/eliminar/{id}",  method =RequestMethod.DELETE )
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		UsuarioCliente Obj=service.obtener(id);
		if(Obj !=null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else{

			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		
	}

}
