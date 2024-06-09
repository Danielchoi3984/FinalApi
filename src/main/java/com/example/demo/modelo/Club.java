package com.example.demo.modelo;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clubes")
public class Club {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_Club")
	private Integer idclub;
	
	@Column(name="Nombre")
	private String nombre;
	@ManyToOne
    @OneToMany(mappedBy = "clubVisitante")
    private List<Partido> partidosVisitante;
    @OneToMany(mappedBy = "clubLocal")
    private List<Partido> partidosLocal;
    @OneToMany(mappedBy = "club")
    private List<Jugador> jugadores;
    public Club() {}
	public Integer getIdclub() {
		return idclub;
	}
	public void setIdclub(Integer idclub) {
		this.idclub = idclub;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Partido> getPartidosVisitante() {
		return partidosVisitante;
	}
	public void setPartidosVisitante(List<Partido> partidosVisitante) {
		this.partidosVisitante = partidosVisitante;
	}
	public List<Partido> getPartidosLocal() {
		return partidosLocal;
	}
	public void setPartidosLocal(List<Partido> partidosLocal) {
		this.partidosLocal = partidosLocal;
	}
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	@Override
	public String toString() {
		return "Club [idclub=" + idclub + ", nombre=" + nombre + ", partidosVisitante=" + partidosVisitante
				+ ", partidosLocal=" + partidosLocal + ", jugadores=" + jugadores + "]";
	}
	public Club(String nombre, List<Partido> partidosVisitante, List<Partido> partidosLocal, List<Jugador> jugadores) {
		super();
		this.nombre = nombre;
		this.partidosVisitante = partidosVisitante;
		this.partidosLocal = partidosLocal;
		this.jugadores = jugadores;
	}
	



}
