package com.example.repository;

import com.example.model.Conta;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface ContaRepository extends CrudRepository<Conta, Long> {
    Conta findByEmail(String email);
}