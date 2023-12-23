class Cilindro extends Circulo { 
    private double longitud; 

  
    Cilindro(double x, double y, double radio, double longitud) { 
        super(x, y, radio); // Llama al constructor de la clase base (Circulo) para establecer las coordenadas y el radio
        this.longitud = longitud;
    } 

    // Método para calcular la superficie del cilindro segun la formula
    double superficie() { 
        return 2 * Math.PI * getRadio() * (longitud + getRadio()); 
    } 

    double getLongitud() { 
        return longitud; 
    } 

    void setLongitud(double longitud) { 
        this.longitud = longitud; 
    } 
}

class Ejercicio2 {
    public static void main(String[] args) {
        // Creamos un objeto Cilindro con datos (x=1, y=2, radio=3, longitud=8)
        Cilindro cilindro = new Cilindro(1, 2, 3, 8);
      
        double superficie = cilindro.superficie();

        System.out.println("La superficie del cilindro es: " + superficie);
    }
}
