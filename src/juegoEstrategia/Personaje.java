package juegoEstrategia;


public abstract class Personaje {

	protected String tipo;
	protected int vidaActual, vidaMax, atkMax, defMax, radioAtk, movMax, coste;
	protected String equipo; 

	public Personaje(String tipo, int vida, int atk, int def, int radio, int mov, int coste, String equipo) {
		this.tipo = tipo;
		this.vidaActual = vida;
		this.vidaMax = vida;
		this.atkMax = atk;
		this.defMax = def;
		this.radioAtk = radio;
		this.movMax = mov;
		this.coste = coste;
		this.equipo = equipo;
	}

	public void curar(int puntos) {
		this.vidaActual = Math.min(this.vidaMax, this.vidaActual + puntos);
	}

	public void recibirDanio(int danio) {
		this.vidaActual -= danio;
	}


	public String getTipo() { return tipo; }
	public String getEquipo() { return equipo; }
	public int getVidaActual() { return vidaActual; }
	public int getAtkMax() { return atkMax; }
	public int getDefMax() { return defMax; }
	public int getRadioAtk() { return radioAtk; }
	public int getMovMax() { return movMax; }

	@Override
	public String toString() {

		String color = equipo.equals("A") ? "\u001B[31m" : "\u001B[34m";
		return color + tipo.charAt(0) + "(" + vidaActual + ")" + "\u001B[0m";
	}
}
