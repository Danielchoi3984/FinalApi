package com.example.demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Club;
@Repository
public interface ClubRepository extends JpaRepository<Club, Integer> {

	Optional<Club> findById_Club(int doc);

	void deleteByIdClub(int idclub);

}
