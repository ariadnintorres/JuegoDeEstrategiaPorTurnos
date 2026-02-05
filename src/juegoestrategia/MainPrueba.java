package juegoestrategia;

public class MainPrueba {
  
       public static void main(String[] args) {
        
           Tablero c = new Tablero();

           
           Soldado s1 = new Soldado("A"); 

           
           c.colocarPersonaje(0, 0, s1);

           
           c.mostrarTablero();
       }
   }
	

