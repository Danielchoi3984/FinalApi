package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Jugador;
import com.example.demo.repository.JugadorRepository;

@Service
public class JugadorService {
	@Autowired
	JugadorRepository repositorio;
	
	public List<Jugador> jugadores(){
		return repositorio.findAll();
	}
	// Obtener un jugador por su ID
    public Jugador obtenerJugadorPorId(int doc) {
        Optional<Jugador> optionalJugador = repositorio.findByDocumento(doc);
        if (optionalJugador.isPresent()) {
            return optionalJugador.get();
        } else {
           return null;
        }
    }

    // Crear o actualizar un jugador
    public Jugador guardarJugador(Jugador jugador) {
        return repositorio.save(jugador);
    }
    public Jugador actualizarJugador(int doc, Jugador detallesJugador) {
        Optional<Jugador> jugadorExistente = repositorio.findByDocumento(doc);
        if (jugadorExistente.isPresent()) {
            Jugador jugador = jugadorExistente.get();
            jugador.setNombre(detallesJugador.getNombre());
            jugador.setCategoria(detallesJugador.getCategoria());
            jugador.setFechanac(detallesJugador.getFechanac());
            jugador.setNrodoc(detallesJugador.getNrodoc());
            jugador.setTipodoc(detallesJugador.getTipodoc());
            jugador.setClub(detallesJugador.getClub());
            return repositorio.save(jugador);
        } else {
            // Maneja el caso en el que el jugador no existe
            throw new RuntimeException("Jugador no encontrado con el Documento " + doc);
        }
    }

    // Eliminar un jugador por su ID
    public void eliminarJugador(int doc) {
        repositorio.deleteByDocumeto(doc);
    }
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


	
}
