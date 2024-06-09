package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Partido;
import com.example.demo.repository.PartidoRepository;

@Service
public class PartidoService {
	@Autowired
	PartidoRepository repositorio;
	
	public List<Partido> partidos(){
		return repositorio.findAll();
	}
	// Obtener un partido por su ID
    public Partido obtenerPartidoPorId(int idpartido) {
        Optional<Partido> optionalPartido = repositorio.findById_Partido(idpartido);
        if (optionalPartido.isPresent()) {
            return optionalPartido.get();
        } else {
        	  throw new RuntimeException("Partido no encontrado con el id del partido " + idpartido);
        }
    }

    // Crear o actualizar un partido
    public Partido guardarPartido(Partido partido) {
        return repositorio.save(partido);
    }
    public Partido actualizarPartido(int idpartido, Partido detallesPartido) {
        Optional<Partido> partidoExistente = repositorio.findById_Partido(idpartido);
        if (partidoExistente.isPresent()) {
            Partido partido = partidoExistente.get();
            partido.setIdpartido(detallesPartido.getIdpartido());
            partido.setCategoria(detallesPartido.getCategoria());
            partido.setFechapartido(detallesPartido.getFechapartido());
            partido.setGolesL(detallesPartido.getGolesL());
            partido.setGolesV(detallesPartido.getGolesV());
            partido.setNrofecha(detallesPartido.getNrofecha());
            partido.setNrozona(detallesPartido.getNrozona());
            partido.setClubVisitante(detallesPartido.getClubVisitante());
            partido.setClubLocal(detallesPartido.getClubLocal());
            return repositorio.save(partido);
        } else {
            // Maneja el caso en el que el partido no existe
            throw new RuntimeException("Partido no encontrado con el id del partido " + idpartido);
        }
    }

    // Eliminar un partido por su ID
    public void eliminarPartido(int idpartido) {
        repositorio.deleteById_Partido(idpartido);
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