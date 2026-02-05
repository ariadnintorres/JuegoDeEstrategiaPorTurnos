package juegoestrategia;


public class Soldado extends Personaje {
	public Soldado(String equipo) {
		super(10, equipo); 
	}

	@Override
	public String getIcono() {
		return "S"; 
	}
}

