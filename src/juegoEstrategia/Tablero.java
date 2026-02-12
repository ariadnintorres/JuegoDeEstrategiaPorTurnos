package juegoEstrategia;
/*
public class Tablero {

	Personaje[][] mapa = new Personaje[8][8];

	public Tablero() {
	}

	public void colocarPersonaje(int fila, int columna, Personaje p) {
		this.mapa[fila][columna] = p;
	}

	public void moverPersonaje(int fOrig, int cOrig, int fDest, int cDest) {
		this.mapa[fDest][cDest] = this.mapa[fOrig][cOrig];
		this.mapa[fOrig][cOrig] = null;
	}

	public Personaje getCasilla(int f, int c) {
		return this.mapa[f][c];
	}

	public void mostrarTablero() {
		String azul = "\u001b[34m";
		String rojo = "\u001b[31m";
		String reset = "\u001b[0m";
		System.out.println("   0   1   2   3   4   5   6   7");
		System.out.println(" ---------------------------------");

		for(int i = 0; i < 8; ++i) {
			System.out.print("" + i + "|");

			for(int j = 0; j < 8; ++j) {
				if (this.mapa[i][j] == null) {
					System.out.print("   |");
				} else {
					String color = this.mapa[i][j].getEquipo().equals("A") ? azul : rojo;
					System.out.print(color + " " + this.mapa[i][j].getIcono() + "(" + this.mapa[i][j].getVida() + ")" + reset + "|");
				}
			}

			System.out.println("\n ---------------------------------");
		}

	}





	public void colocar(int f, int c, Personaje p) {
		mapa[f][c] = p; 
	}

}

*/

