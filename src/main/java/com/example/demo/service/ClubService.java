package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Club;
import com.example.demo.repository.ClubRepository;

@Service
public class ClubService {
	@Autowired
	ClubRepository repositorio;
	
	public List<Club> clubes(){
		return repositorio.findAll();
	}
	// Obtener un club por su ID
    public Club obtenerClubPorId(int idclub) {
        Optional<Club> optionalClub = repositorio.findById_Club(idclub);
        if (optionalClub.isPresent()) {
            return optionalClub.get();
        } else {
        	  throw new RuntimeException("Club no encontrado con el id del club " + idclub);
        }
    }

    // Crear o actualizar un club
    public Club guardarClub(Club club) {
        return repositorio.save(club);
    }
    public Club actualizarClub(int idclub, Club detallesClub) {
        Optional<Club> clubExistente = repositorio.findById_Club(idclub);
        if (clubExistente.isPresent()) {
            Club club = clubExistente.get();
            club.setNombre(detallesClub.getNombre());
            club.setIdclub(detallesClub.getIdclub());
            club.setJugadores(detallesClub.getJugadores());
            club.setPartidosLocal(detallesClub.getPartidosLocal());
            club.setPartidosVisitante(detallesClub.getPartidosVisitante());
            return repositorio.save(club);
        } else {
            // Maneja el caso en el que el club no existe
            throw new RuntimeException("Club no encontrado con el id del club " + idclub);
        }
    }

    // Eliminar un club por su ID
    public void eliminarClub(int idclub) {
        repositorio.deleteByIdClub(idclub);
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