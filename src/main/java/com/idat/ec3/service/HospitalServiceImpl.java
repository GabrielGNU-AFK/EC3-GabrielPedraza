package com.idat.ec3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec3.model.Hospital;
import com.idat.ec3.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {
	
	@Autowired
	private HospitalRepository repository;

	@Override
	public void guardar(Hospital hospital) {
		repository.save(hospital);

	}

	@Override
	public void actualizar(Hospital hospital) {
		repository.saveAndFlush(hospital);

	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public List<Hospital> listar() {
		
		return repository.findAll();
	}

	@Override
	public Hospital obtener(Integer id) {
		
		return repository.findById(id).orElse(null);
	}

}
