package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Jugador;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer>{

	public Optional<Jugador> findByDocumento(int doc);

	public void deleteByDocumeto(int id);

}
