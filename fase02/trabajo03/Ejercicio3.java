// Definición de la interfaz Avion con métodos que devuelven cadenas específicas
interface Avion {
    default String despegar() {
        return "Puedo despegar";
    }

    default String aterrizar() {
        return "Puedo aterrizar";
    }
}

// Definición de la interfaz Barco con método que devuelve una cadena específica
interface Barco {
    default String navegar() {
        return "Puedo navegar";
    }
}

// Implementación de Hidroavion que combina funcionalidades de Avion y Barco
class Hidroavion implements Avion, Barco {
    private String forma; // Forma del hidroavión
    private String tamaño; 

    // Constructor para inicializar la forma y tamaño del hidroavión
    public Hidroavion(String forma, String tamaño) {
        this.forma = forma;
        this.tamaño = tamaño;
    }

    public String Forma() {
        return "Tengo forma de " + forma;
    }
}

class Ejercicio3 {
    public static void main(String[] args) {
        
        Hidroavion hidroavion = new Hidroavion("avion acuatico", "grande");

        // Mostrar mensajes relacionados con acciones implementadas del hidroavion
        System.out.println(hidroavion.despegar());
        System.out.println(hidroavion.aterrizar());
        System.out.println(hidroavion.navegar());
        System.out.println(hidroavion.Forma());
    }
}
