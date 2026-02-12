package juegoEstrategia;
/*
public class Acciones {
	
	public static boolean mover(Tablero tablero, int f1, int c1, int f2, int c2) {
		Personaje p = tablero.getCasilla(f1, c1);

		
		int distancia = Math.abs(f1 - f2) + Math.abs(c1 - c2);

		
		if (tablero.getCasilla(f2, c2) == null && distancia <= p.getMovMax()) {
			tablero.colocar(f2, c2, p);
			tablero.colocar(f1, c1, null);
			System.out.println("Movimiento éxito: " + p.getIcono() + " se movió " + distancia + " casillas.");
			return true;
		} else {
			System.out.println("Error: Movimiento inválido (casilla ocupada o fuera de rango).");
			return false;
		}
	}

	
	public static void atacar(Tablero tablero, int fA, int cA, int fO, int cO) {
		Personaje atacante = tablero.getCasilla(fA, cA);
		Personaje objetivo = tablero.getCasilla(fO, cO);

		if (objetivo == null || atacante.getEquipo().equals(objetivo.getEquipo())) {
			System.out.println("Error: No hay enemigo en el destino.");
			return;
		}

		
		int distancia = Math.max(Math.abs(fA - fO), Math.abs(cA - cO)); 
		if (distancia > atacante.getRadioAtaque()) {
			System.out.println("Error: El enemigo está fuera del radio de alcance (" + distancia + ">" + atacante.getRadioAtaque() + ").");
			return;
		}

	
		System.out.println("¡" + atacante.getIcono() + " ataca a " + objetivo.getIcono() + "!");
		atacante.atacar(objetivo); 

		
		if (objetivo.getVida() <= 0) {
			System.out.println("¡El " + objetivo.getIcono() + " ha sido eliminado!");
			tablero.colocar(fO, cO, null);
		}
	}


	public static void curar(Tablero tablero, String equipo) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Personaje p = tablero.getCasilla(i, j);
				if (p != null && p.getEquipo().equals(equipo)) {
					p.descansar(); 
				}
			}
		}
		System.out.println("Las tropas del Jugador " + equipo + " han recuperado vida.");
	}
}
*/

