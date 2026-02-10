package juegoestrategia;

	public abstract class Personaje {
	    protected int vida;
	    protected String equipo; 

	    public Personaje(int vida, String equipo) {
	        this.vida = vida;
	        this.equipo = equipo;
	    }

	   
	    public String getEquipo() {
	        return equipo;
	    }

	    public int getVida() {
	        return vida;
	    }

	   
	    public abstract String getIcono();
	}

