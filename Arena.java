import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Arena {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Personajes> lista = new ArrayList<Personajes>();

    public static void main(String[] args){
        // Crear un guerrero y un mago

        System.out.println("Bienvenido a la arena de combate");
        System.out.println("Ingrese el nombre del guerrero");
        String nombre_guerrero = sc.nextLine();
        System.out.println("Ingrese el nombre del mago");
        String nombre_mago = sc.nextLine();
        System.out.println("Ingrese el arma del guerrero");
        String arma_guerrero = sc.nextLine();
        System.out.println("Ingrese el poder del mago");
        String poder_mago = sc.nextLine();
        Guerreros guerrero1 = new Guerreros(nombre_guerrero, arma_guerrero, generateRandomValue(50, 120), generateRandomValue(10, 20));
        Magos mago1 = new Magos(nombre_mago, poder_mago, 100, generateRandomValue(20, 25));

        // Listar información de los personajes
        guerrero1.mostrar_info();
        mago1.mostrar_info();

        // Alimentar a los personajes
        guerrero1.Alimentarse();
        mago1.Alimentarse();

        // Realizar combates o encantamientos
        guerrero1.combatir(); // Consumir 15 de energía en el combate
        mago1.Encantar(); // Consumir 20 de energía en el encantamiento

        // Agregar los personajes a la lista
        lista.add(guerrero1);
        lista.add(mago1);
        
	// Simular tres batallas
        int i = 1;
	do {
            System.out.println("Batalla " + i);
            for (Personajes personaje : lista) {

                // Alimentar a los personajes y pelear
                if (personaje instanceof Guerreros){
                    Guerreros guerrero = (Guerreros) personaje;
                    guerrero.Alimentarse();
                } else if (personaje instanceof Magos){
                    Magos mago = (Magos) personaje;
                    mago.Alimentarse();
                }

                // combatir y encantar
                if(personaje instanceof Guerreros){
                    Guerreros guerrero = (Guerreros) personaje;
                    guerrero.combatir();
                }else if(personaje instanceof Magos){
                    Magos mago = (Magos) personaje;
                    mago.Encantar();
                }

                //recibir daño
                if(personaje instanceof Guerreros){
                    Guerreros guerrero = (Guerreros) personaje;
                    guerrero.modificar_vida(generateRandomValue(1, 100));
                }else if(personaje instanceof Magos){
                    Magos mago = (Magos) personaje;
                    mago.modificar_vida(generateRandomValue(1, 100));
                } 
            }
	    i++;
        } while (i<4);

        // Mostrar resumen de la batalla
        Personajes ganador = obtenerGanador(lista);
        System.out.println("Resumen de la batalla:");
        for (Personajes personaje : lista) {
            personaje.mostrar_info();
            System.out.println("Vida: " + personaje.vida);
        }
        System.out.println("El ganador es: " + ganador.nombre + " con " + ganador.energia + " puntos de energía. y " + ganador.vida + " puntos de vida.");
    }

    // Método para obtener al ganador basado en la mayor energía
    public static Personajes obtenerGanador(ArrayList<Personajes> personajes) {
        Personajes ganador = personajes.get(0);
        
        for (Personajes personaje : personajes) {
            if (personaje.vida > ganador.vida || (personaje.vida == ganador.vida && personaje.energia > ganador.energia && personaje.energia > 0)) {
                ganador = personaje;
            }
        }
        
        return ganador;
    }
    
    

    public static int generateRandomValue(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
    
}