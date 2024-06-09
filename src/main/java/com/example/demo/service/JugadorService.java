package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.modelo.Jugador;
import com.example.demo.repository.JugadorRepository;

public class JugadorService {
	@Autowired
	JugadorRepository repositorio;
	
//	public boolean loginInspector(Integer legajo, String password) {
//		Optional<Personal> optionalPersonal = repositorio.findById(legajo);
//		if(optionalPersonal.isEmpty()) {
//			System.out.println("No sos inspector");
//			return false;
//		}else if(optionalPersonal.get().getPassword().equals(password)) {
//			System.out.println("Login exitoso");
//			return true;
//		}else {
//			System.out.println("Contraseña incorrecta");
//			return false;
//		}
//	}
//	
//	public boolean cambiarPassword(Integer legajo, String passwordActual, String passwordNueva, String passwordNueva2) {
//		Optional<Personal> optionalPersonal = repositorio.findById(legajo);
//		if(optionalPersonal.isPresent()) {
//			Personal personal = optionalPersonal.get();
//			if(personal.getPassword().equals(passwordActual) && passwordNueva.equals(passwordNueva2)) {
//				personal.setPassword(passwordNueva);
//				repositorio.save(personal);
//				return true;
//			}else {
//				return false;
//			}
//			
//		}
//		return false;
//	}
	
	public List<Jugador> jugadores(){
		return repositorio.findAll();
	}
	
}