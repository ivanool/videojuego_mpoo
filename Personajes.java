public class Personajes{
    //atributos
    protected String nombre;
    protected int energia;
    protected int vida;
    protected int energia_gastada;
    //constructor 


    public Personajes(String nombre, int energia, int energia_gastada){
        this.nombre = nombre;
        this.vida = 100;
    }
    //métodos
    public void Alimentarse(){
        //segun yo así es como funciona jaja
        System.out.print("El personaje "+this.nombre+" se ha alimentado y su energia es: ");
        this.energia = this.energia + 30;
        System.out.println(this.energia);
    }

    public void mostrar_info(){
        //mostramos info del personaje
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Energia: "+this.energia);
    }

    public int verificar_vida(){
        if(vida <= 0){
            System.out.println("El mago "+this.nombre+" ha muerto");
            return -1;
        }
        else{
            //System.out.println("El mago "+this.nombre+" tiene "+this.vida+" puntos de vida");
            return 1;
        }
    }

    public int modificar_vida(int valor_random){
        if(valor_random >1 && valor_random <49){
            System.out.println("El mago "+this.nombre+" no ha perdido vida");
            int estado = verificar_vida();
            System.out.println(this.nombre + "tiene una vida de" + this.vida);
            return estado;
        }
        else if(valor_random >=50 && valor_random <=70){
            vida = vida - 10;
            System.out.println(this.nombre+" ha perdido 10 puntos de vida");
            
            int estado = verificar_vida();
            System.out.println(this.nombre + "tiene una vida de" + this.vida);
            return estado;
        }
        else if(valor_random >=71 &&valor_random<=89){
            vida = vida-20;
            System.out.println(this.nombre+" ha perdido 20 puntos de vida");
            int estado =verificar_vida();
            System.out.println(this.nombre + "tiene una vida de" + this.vida);
            return estado;

        }
        else if(valor_random >=90 && valor_random <=99){
            vida = vida - 30;
            System.out.println(this.nombre+" ha perdido 30 puntos de vida");
            int estado =verificar_vida();
            System.out.println(this.nombre + "tiene una vida de" + this.vida);
            return estado;
        }

        else if(valor_random == 100){
            return 0;
        }
        return 0;
    }

}