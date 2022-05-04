package entidades;

import java.util.Scanner;

public class Participante implements Comparable<Participante>{
	protected long id;
	protected int dorsal; // valor entre 001 y 150
	protected char calle;
	
	//Ejecricio 2 Eval1
	protected Tiempo tiempo;
	protected boolean penalizacion;
	protected String otros;

	public Participante(long id, int dorsal, char calle) {
		super();
		this.id = id;
		this.dorsal = dorsal;
		this.calle = calle;
	}
	
	//NUEVO CONSTRUCTOR CON LOS NUEVOS CAMPOS

	public Participante(long id, int dorsal, char calle, Tiempo tiempo, boolean penalizacion, String otros) {
		this.id = id;
		this.dorsal = dorsal;
		this.calle = calle;
		this.tiempo = tiempo;
		this.penalizacion = penalizacion;
		this.otros = otros;
	}



	public Participante() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public char getCalle() {
		return calle;
	}

	public void setCalle(char calle) {
		this.calle = calle;
	}

	public Tiempo getTiempo() {
		return tiempo;
	}

	public void setTiempo(Tiempo tiempo) {
		this.tiempo = tiempo;
	}

	public boolean isPenalizacion() {
		return penalizacion;
	}

	public void setPenalizacion(boolean penalizacion) {
		this.penalizacion = penalizacion;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	@Override
	public String toString() {
		return "Participante [id=" + id + ", dorsal=" + dorsal + ", calle=" + calle + ", tiempo=" + tiempo
				+ ", penalizacion=" + penalizacion + ", otros=" + otros + "]";
	}
	
	public static Participante nuevoParticipante() {
		Participante participante = null;
		Scanner sc = new Scanner(System.in);
		
		
		return participante;
	}

	@Override
	public int compareTo(Participante o) {
		// TODO Auto-generated method stub
		int resultado = 0;
		
		resultado = this.getTiempo().compareTo(o.getTiempo());
		if(resultado == 0) {
			resultado = String.valueOf (this.getCalle()).compareTo(String.valueOf (o.getCalle()));
			if(resultado == 0) {
				resultado = (int) (this.getId() - o.getId());
			}
		}
		return 0;
	}
	
	

}
