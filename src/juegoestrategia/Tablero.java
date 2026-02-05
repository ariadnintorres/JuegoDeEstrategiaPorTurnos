package juegoestrategia;

public class Tablero {


	Personaje[][] mapa;

	public Tablero() {
		this.mapa = new Personaje[8][8]; 
	}


	public void colocarPersonaje(int fila, int columna, Personaje p) {
		mapa[fila][columna] = p;
	}

	//
	public void moverPersonaje(int fOrig, int cOrig, int fDest, int cDest) {
		mapa[fDest][cDest] = mapa[fOrig][cOrig];
		mapa[fOrig][cOrig] = null;
	}
	//obtener casilla del personaje 
	public Personaje getCasilla(int f, int c) {
		return mapa[f][c];
	}

	//tablero de prueba 
	public void mostrarTablero() {
		String azul = "\u001B[34m";
		String rojo = "\u001B[31m";
		String reset = "\u001B[0m";

		System.out.println("   0   1   2   3   4   5   6   7"); 
		System.out.println(" ---------------------------------");

		for (int i = 0; i < 8; i++) {
			System.out.print(i + "|"); 
			for (int j = 0; j < 8; j++) {
				if (mapa[i][j] == null) {
					System.out.print("   |"); 
				} else {

					String color = mapa[i][j].getEquipo().equals("A") ? azul : rojo;


					System.out.print(color + " " + mapa[i][j].getIcono() + 
							"(" + mapa[i][j].getVida() + ")" + reset + "|");
				}
			}
			System.out.println("\n ---------------------------------");
		}
	}
}

