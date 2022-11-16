package com.idat.ec3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.ec3.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
