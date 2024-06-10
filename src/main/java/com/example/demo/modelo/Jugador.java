package com.example.demo.modelo;

import java.util.Date;

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
@Table(name = "Jugadores")
public class Jugador {

	@Id
	@Column(name="Tipodoc")
	private Integer tipodoc;

	@Column(name="Nrodoc")
	private Integer nrodoc;
	
	@Column(name="Nombre")
	private String nombre;
	@Column(name="Fecha_Nac")
	private Date fechanac;
	@Column(name="Categoria")
	private String categoria;
	@ManyToOne
	@JoinColumn(name = "Id_Club", referencedColumnName = "Id_Club", nullable = false)
	private Club club;
	public Jugador() {} 
	public Jugador(Integer tipodoc, Integer nrodoc, String nombre, Date fechanac, String categoria, Club club) {
		super();
		this.tipodoc = tipodoc;
		this.nrodoc = nrodoc;
		this.nombre = nombre;
		this.fechanac = fechanac;
		this.categoria = categoria;
		this.club = club;
	}
	@Override
	public String toString() {
		return "Jugador [tipodoc=" + tipodoc + ", nrodoc=" + nrodoc + ", nombre=" + nombre + ", fechanac=" + fechanac
				+ ", categoria=" + categoria + ", club=" + club + "]";
	}
	public Integer getTipodoc() {
		return tipodoc;
	}
	public void setTipodoc(Integer tipodoc) {
		this.tipodoc = tipodoc;
	}
	public Integer getNrodoc() {
		return nrodoc;
	}
	public void setNrodoc(Integer nrodoc) {
		this.nrodoc = nrodoc;
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
	public Club getClub() {
		return club;
	}
	public void setClub(Club club) {
		this.club = club;
	}	


}
