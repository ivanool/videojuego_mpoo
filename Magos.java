public class Magos extends Personajes{
    // Atributos
    int UsoDeEnergía;
    String poder;

    // Constructores
    public Magos(String nombre, String poder, int energia, int energia_gastada){
        super(nombre, energia, energia_gastada);
        this.poder = poder;
        this.vida = 100;
        this.energia_gastada = energia_gastada;
        this.energia = energia;

        System.out.println("El mago " + nombre + " tiene un poder " + poder + " con una energía inicial de " + energia);
    }

    // Métodos 

    @Override
    public void Alimentarse(){
        int energiaAnterior = energia;
        super.Alimentarse();
        System.out.println("Mago [energía anterior: " + energiaAnterior + ", energía actual: " + energia + "]");
    }
    public void Encantar(){
        int UsoDeEnergía = this.energia_gastada;
        System.out.print("Mago " + nombre + " [Poder: " + poder + ", Energía gastada: "
                            + this.energia_gastada + ",  Nivel de energía anterior: " + energia +
                            ", Energía actual: ");
        energia = energia - UsoDeEnergía;
        System.out.println(energia);
    }

    @Override
    public void mostrar_info(){
        super.mostrar_info();
        System.out.println("Poder: "+this.poder);
        System.out.println("Vida: "+this.vida);
    }
    
}