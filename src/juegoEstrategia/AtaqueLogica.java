package juegoEstrategia;

import java.util.Random;

public class AtaqueLogica {
	private static final Random rnd = new Random();

	public static int calcularDanio(Personaje atk, Personaje def) {
		double multiplicador = obtenerBonificacion(atk, def);


		int fuerzaAtaque = (int) (rnd.nextInt(atk.getAtkMax() + 1) * multiplicador);

		int fuerzaDefensa = rnd.nextInt(def.getDefMax() + 1);

		int danioFinal = fuerzaAtaque - fuerzaDefensa;
		return Math.max(0, danioFinal); 
	}

	private static double obtenerBonificacion(Personaje atk, Personaje def) {
		if (atk instanceof Arquero && def instanceof Lancero) return 3.0;
		if (atk instanceof Soldado && def instanceof Arquero) return 2.0;
		if (atk instanceof Caballero && (def instanceof Arquero || def instanceof Soldado)) return 2.0;
		if (atk instanceof Lancero && def instanceof Caballero) return 5.0;
		return 1.0;
	}

	public static boolean estaEnRango(int f1, int c1, int f2, int c2, int radio) {
		int distancia = Math.max(Math.abs(f1 - f2), Math.abs(c1 - c2));
		return distancia <= radio;
	}
}