package com.example.demo.modelo;

import java.util.Date;
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
@Table(name = "Partidos")
public class Partido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_Partido")
	private Integer idpartido;
	@Column(name="NroFecha")
	private Integer nrofecha;
	@Column(name="Nombre")
	private String nombre;
	@Column(name="Fecha_Nac")
	private Date fechanac;
	@Column(name="Categoria")
	private String categoria;
	@ManyToOne
    @JoinColumn(name = "Id_ClubV", referencedColumnName = "idClub")
    private Club clubVisitante;
    @ManyToOne
    @JoinColumn(name = "Id_ClubL", referencedColumnName = "idClub")
    private Club clubLocal;
    public Partido() {}
	public Partido( Integer nrofecha, String nombre, Date fechanac, String categoria,
			Club clubVisitante, Club clubLocal) {
		super();
		
		this.nrofecha = nrofecha;
		this.nombre = nombre;
		this.fechanac = fechanac;
		this.categoria = categoria;
		this.clubVisitante = clubVisitante;
		this.clubLocal = clubLocal;
	}
	@Override
	public String toString() {
		return "Partido [idpartido=" + idpartido + ", nrofecha=" + nrofecha + ", nombre=" + nombre + ", fechanac="
				+ fechanac + ", categoria=" + categoria + ", clubVisitante=" + clubVisitante + ", clubLocal="
				+ clubLocal + "]";
	}
	
	public Integer getIdpartido() {
		return idpartido;
	}
	public void setIdpartido(Integer idpartido) {
		this.idpartido = idpartido;
	}
	public Integer getNrofecha() {
		return nrofecha;
	}
	public void setNrofecha(Integer nrofecha) {
		this.nrofecha = nrofecha;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechanac() {
		return fechanac;
	}
	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Club getClubVisitante() {
		return clubVisitante;
	}
	public void setClubVisitante(Club clubVisitante) {
		this.clubVisitante = clubVisitante;
	}
	public Club getClubLocal() {
		return clubLocal;
	}
	public void setClubLocal(Club clubLocal) {
		this.clubLocal = clubLocal;
	}
    
    


}
