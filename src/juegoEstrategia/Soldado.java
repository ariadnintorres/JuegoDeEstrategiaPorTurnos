package juegoEstrategia;


class Soldado extends Personaje {
	public Soldado(String eq) { super("Soldado", 10, 10, 10, 1, 1, 10, eq); }
}

class Caballero extends Personaje {
	public Caballero(String eq) { super("Caballero", 20, 15, 15, 2, 3, 25, eq); }
}

class Arquero extends Personaje {
	public Arquero(String eq) { super("Arquero", 10, 10, 5, 3, 2, 15, eq); }
}

class Lancero extends Personaje {
	public Lancero(String eq) { super("Lancero", 10, 10, 5, 2, 2, 5, eq); 
	}
}