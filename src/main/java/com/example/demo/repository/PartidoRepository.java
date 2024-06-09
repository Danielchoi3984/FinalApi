package com.example.demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Partido;
@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer>{

	Optional<Partido> findById_Partido(int idpartido);
    
	void deleteById_Partido(int idpartido);
	

}

