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
	@Column(name="NroZona")
	private Integer nrozona;
	@Column(name="fechaPartido")
	private Date fechapartido;
	@Column(name="Categoria")
	private String categoria;

	@Column(name="GolesV")
	private Integer golesV;
	@Column(name="GolesL")
	private Integer golesL;
	@ManyToOne
    @JoinColumn(name = "Id_ClubV", referencedColumnName = "idClub")
    private Club clubVisitante;
    @ManyToOne
    @JoinColumn(name = "Id_ClubL", referencedColumnName = "idClub")
    private Club clubLocal;
    public Partido() {}

	public Integer getNrozona() {
		return nrozona;
	}
	public void setNrozona(Integer nrozona) {
		this.nrozona = nrozona;
	}
	public Date getFechapartido() {
		return fechapartido;
	}
	public void setFechapartido(Date fechapartido) {
		this.fechapartido = fechapartido;
	}
	public Integer getGolesV() {
		return golesV;
	}
	public void setGolesV(Integer golesV) {
		this.golesV = golesV;
	}
	public Integer getGolesL() {
		return golesL;
	}
	public void setGolesL(Integer golesL) {
		this.golesL = golesL;
	}
	
	public Partido(Integer idpartido, Integer nrofecha, Integer nrozona, Date fechapartido, String categoria,
			Integer golesV, Integer golesL, Club clubVisitante, Club clubLocal) {
		super();
		this.idpartido = idpartido;
		this.nrofecha = nrofecha;
		this.nrozona = nrozona;
		this.fechapartido = fechapartido;
		this.categoria = categoria;
		this.golesV = golesV;
		this.golesL = golesL;
		this.clubVisitante = clubVisitante;
		this.clubLocal = clubLocal;
	}
	@Override
	public String toString() {
		return "Partido [idpartido=" + idpartido + ", nrofecha=" + nrofecha + ", nrozona=" + nrozona + ", fechapartido="
				+ fechapartido + ", categoria=" + categoria + ", golesV=" + golesV + ", golesL=" + golesL
				+ ", clubVisitante=" + clubVisitante + ", clubLocal=" + clubLocal + "]";
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
