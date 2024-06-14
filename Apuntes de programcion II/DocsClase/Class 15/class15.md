# Clases absatractas e interfaces

 Se utiliza cuando se hace diseño y no quiero instanciarlo

## Diferencia en tre una clase y una clase abstracta

Una clase abstracta es diferente porque está diseñada para ser una plantilla para otras clases, y no se puede usar para crear objetos directamente. No puedes crear una instancia de una clase abstracta porque está incompleta; puede tener métodos abstractos (sin implementación) que necesitan ser definidos por una subclase concreta

 **Ejemplo**
 // Clase abstracta
public abstract class Animal {
    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    // Método abstracto (sin implementación)
    public abstract void hacerSonido();

    // Método concreto (con implementación)
    public void dormir() {
        System.out.println(nombre + " está durmiendo.");
    }
}

## Over Ride

## Polimorfismo

## Interface

Se pude referir como establecer  un contrato
 Realizacion o implementacion
 se utiliza una flecha entrecortada ----->

implemnte mas potente que la herencia 