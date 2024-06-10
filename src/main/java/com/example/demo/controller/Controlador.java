package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Club;
import com.example.demo.modelo.Jugador;
import com.example.demo.modelo.Partido;
import com.example.demo.service.ClubService;
import com.example.demo.service.JugadorService;
import com.example.demo.service.PartidoService;

import jakarta.persistence.Entity;

@RestController
@RequestMapping("/inicio")
public class Controlador {
	@Autowired
	PartidoService partidoService;
	@Autowired
	ClubService clubService;
	@Autowired
	JugadorService jugadorService;
	
	@GetMapping("/clubes")
    public List<Club> TraerClubes() {
        return clubService.clubes();
    }
	@GetMapping("/partidos")
	public List<Partido> TraerPartidos() {
        return partidoService.partidos();
    }	
	@GetMapping("/jugadores")
	public List<Jugador> TraerJugadores() {
        return jugadorService.jugadores();
    }
	
	@GetMapping("/clubes/{id}")
    public Club TraerClubXId(@PathVariable int id) {
        return clubService.obtenerClubPorId(id);
    }
	@GetMapping("/{id}")
    public Partido TraerPartidoXId(@PathVariable int id) {
        return partidoService.obtenerPartidoPorId(id);
    }

    @PostMapping
    public Club createClub(@RequestBody Club club) {
        return clubService.guardarClub(club);
    }

    @PutMapping("/{id}")
    public Club updateClub(@PathVariable Integer id, @RequestBody Club clubDetails) {
        return clubService.actualizarClub(id, clubDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteClub(@PathVariable Integer id) {
        clubService.eliminarClub(id);
    }

}
