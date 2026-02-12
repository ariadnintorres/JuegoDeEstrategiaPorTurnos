package juegoEstrategia;
import java.util.Scanner;
public class JuegoMain {


	public static void main(String[] args) {
		Juego partida = new Juego();
		Scanner sc = new Scanner(System.in);

		System.out.println("=== BIENVENIDOS AL JUEGO DE ESTRATEGIA ===");


		System.out.println("\n--- JUGADOR A (ROJO) ---");
		configurarEquipos(partida, sc, "A", 0, 1);

		System.out.println("\n--- JUGADOR B (AZUL) ---");
		configurarEquipos(partida, sc, "B", 6, 7);

		String turno = "A";
		boolean finJuego = false;

		while (!finJuego) {
			partida.imprimirTablero();
			System.out.println("\n>>> Turno Jugador " + turno);
			System.out.println("Acciones: 1.Atacar  2.Mover  3.Curar");
			int accion = sc.nextInt();

			procesarAccion(partida, accion, turno, sc);


			partida.eliminarMuertos();

			if (verificarFinJuego(partida)) {
				finJuego = true;
				partida.imprimirTablero();
				System.out.println("¡FIN DEL JUEGO! El ganador es el Jugador " + turno);
			} else {
				turno = turno.equals("A") ? "B" : "A";
			}
		}
	}

	private static void configurarEquipos(Juego partida, Scanner sc, String equipo, int colMin, int colMax) {
		int presupuesto = 50;
		while (presupuesto >= 5) {
			System.out.println("Presupuesto actual: " + presupuesto);
			System.out.println("Seleccione tropa: 1.Soldado(10) 2.Caballero(25) 3.Arquero(15) 4.Lancero(5) 0.Terminar");
			int opcion = sc.nextInt();

			if (opcion == 0) break;

			Personaje p = null;
			switch (opcion) {
			case 1 -> p = new Soldado(equipo);
			case 2 -> p = new Caballero(equipo);
			case 3 -> p = new Arquero(equipo);
			case 4 -> p = new Lancero(equipo);
			}

			if (p != null && presupuesto >= p.coste) {
				System.out.println("Indique posición (fila 0-7 y columna " + colMin + "-" + colMax + "):");
				int f = sc.nextInt();
				int c = sc.nextInt();

				if (c >= colMin && c <= colMax && partida.colocarPersonaje(p, f, c)) {
					presupuesto -= p.coste;
					System.out.println(p.getTipo() + " colocado.");
				} else {
					System.out.println("Posición inválida u ocupada. Intente de nuevo.");
				}
			} else {
				System.out.println("No tienes suficiente presupuesto u opción inválida.");
			}
		}
	}

	private static void procesarAccion(Juego partida, int accion, String turno, Scanner sc) {
		switch (accion) {
		case 1 -> { // ATACAR
			System.out.println("Coordenadas de TU unidad (fila col):");
			int f1 = sc.nextInt(), c1 = sc.nextInt();
			Personaje atacante = partida.getPersonaje(f1, c1);

			if (atacante != null && atacante.getEquipo().equals(turno)) {
				System.out.println("Coordenadas del OBJETIVO enemigo (fila col):");
				int f2 = sc.nextInt(), c2 = sc.nextInt();
				Personaje objetivo = partida.getPersonaje(f2, c2);

				if (objetivo != null && !objetivo.getEquipo().equals(turno)) {
					if (AtaqueLogica.estaEnRango(f1, c1, f2, c2, atacante.getRadioAtk())) {
						int danio = AtaqueLogica.calcularDanio(atacante, objetivo);
						objetivo.recibirDanio(danio);
						System.out.println("¡Ataque realizado! Daño causado: " + danio);
					} else {
						System.out.println("Objetivo fuera de rango.");
					}
				} else {
					System.out.println("No hay un enemigo en esa posición.");
				}
			} else {
				System.out.println("No seleccionaste una unidad propia válida.");
			}
		}
		case 2 -> { // MOVER
			System.out.println("Coordenadas unidad a mover (fila col):");
			int f1 = sc.nextInt(), c1 = sc.nextInt();
			Personaje p = partida.getPersonaje(f1, c1);

			if (p != null && p.getEquipo().equals(turno)) {
				System.out.println("Coordenadas destino (fila col):");
				int f2 = sc.nextInt(), c2 = sc.nextInt();
				partida.moverPersonaje(f1, c1, f2, c2);
			} else {
				System.out.println("Unidad no válida.");
			}
		}
		case 3 -> { // CURAR
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					Personaje p = partida.getPersonaje(i, j);
					if (p != null && p.getEquipo().equals(turno)) {

						int cura = new java.util.Random().nextInt(p.vidaMax + 1);
						p.curar(cura);
					}
				}
			}
			System.out.println("¡Tus tropas han descansado y recuperado vida!");
		}
		}
	}

	private static boolean verificarFinJuego(Juego partida) {
		boolean hayA = false, hayB = false;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Personaje p = partida.getPersonaje(i, j);
				if (p != null) {
					if (p.getEquipo().equals("A")) hayA = true;
					if (p.getEquipo().equals("B")) hayB = true;
				}
			}
		}
		return !(hayA && hayB); 
	}
}


