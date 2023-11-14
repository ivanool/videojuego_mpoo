public class Guerreros extends Personajes {
    // Atributos específicos de Guerreros
    private String arma;

    // Constructor de Guerreros
    public Guerreros(String nombre, String arma, int energia, int energia_gastada) {
        super(nombre, energia, energia_gastada);
        this.arma = arma;
        this.vida = 100; // Inicializamos la vida en 100
        this.energia_gastada = energia_gastada;
        this.energia = energia;

        System.out.println("El guerrero " + nombre + " tiene un arma " + arma + " con una energía inicial de " + energia);
    }

    // Método para que un Guerrero combata
    public void combatir() {
        int energiaGastada = this.energia_gastada;
        int energiaAnterior = energia;
        energia -= energiaGastada;
        System.out.println("Guerrero " + nombre + " [arma: " + arma + ", energía gastada: " + energiaGastada +", nivel de energía anterior: " + energiaAnterior + ", energía actual: " + energia + "]");
    }

    // Método para alimentar a un Guerrero (agrega 30 de energía)
    @Override
    public void Alimentarse() {
        int energiaAnterior = energia;
        super.Alimentarse();
        System.out.println("Guerrero [energía anterior: " + energiaAnterior + ", energía actual: " + energia + "]");
    }

    // Método para verificar la vida del Guerrero
    public void ConteoVida() {
        if (vida <= 0) {
            System.out.println("El guerrero " + nombre + " ha muerto");
        } else {
            System.out.println("El guerrero " + nombre + " tiene " + vida + " puntos de vida");
        }
    }

    @Override

    public void mostrar_info() {
        super.mostrar_info();
        System.out.println("Arma: " + this.arma);
        System.out.println("Vida: " + this.vida);
    }
}




