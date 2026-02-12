package juegoEstrategia;

public class Juego {
private Personaje[][] tablero = new Personaje[8][8];

	public boolean colocarPersonaje(Personaje p, int f, int c) {
		if (f >= 0 && f < 8 && c >= 0 && c < 8 && tablero[f][c] == null) {
			tablero[f][c] = p;
			return true;
		}
		return false;
	}

	public Personaje getPersonaje(int f, int c) {
		if (f >= 0 && f < 8 && c >= 0 && c < 8) {
			return tablero[f][c];
		}
		return null;
	}

	public void moverPersonaje(int f1, int c1, int f2, int c2) {
		if (f2 < 0 || f2 > 7 || c2 < 0 || c2 > 7) {
			System.out.println("Destino fuera del tablero.");
			return;
		}
		if (tablero[f2][c2] != null) {
			System.out.println("La casilla destino ya está ocupada.");
			return;
		}
		tablero[f2][c2] = tablero[f1][c1];
		tablero[f1][c1] = null;
		System.out.println("Unidad movida con éxito.");
	}

	public void eliminarMuertos() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (tablero[i][j] != null && tablero[i][j].getVidaActual() <= 0) {
					System.out.println("¡El " + tablero[i][j].getTipo() + " del equipo " + tablero[i][j].getEquipo() + " ha muerto!");
					tablero[i][j] = null;
				}
			}
		}
	}

	public void imprimirTablero() {
		System.out.println("\n      0      1      2      3      4      5      6      7");
		for (int i = 0; i < 8; i++) {
			System.out.print(i + " | ");
			for (int j = 0; j < 8; j++) {
				if (tablero[i][j] == null) {
					System.out.print("[    ] ");
				} else {

					System.out.printf("[%s] ", String.format("%-4s", tablero[i][j].toString()));
				}
			}
			System.out.println();
		}
	}
}

