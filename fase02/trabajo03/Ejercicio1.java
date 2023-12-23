
class Punto { 
    private double x; // Coordenada x del punto
    private double y; // Coordenada y del punto

    Punto(double x, double y) { 
        this.x = x;
        this.y = y; 
    } 

    // Método para calcular la distancia entre dos puntos usando la fórmula 
    double distancia(Punto punto2) { 
       
        return Math.sqrt(Math.pow(punto2.getX() - this.x, 2 ) + Math.pow(punto2.getY() - this.y, 2)); 
    } 
    
    // Métodos para obtener y establecer la coordenada x
    double getX() { 
        return x; 
    } 

    void setX(double x) { 
        this.x = x; 
    } 
    
    // Métodos para obtener y establecer la coordenada y
    double getY() { 
        return y; 
    } 

    void setY(double y) { 
        this.y = y; 
    } 
}


class Circulo extends Punto { 
    private Punto centro; // Centro del círculo (coordenadas x, y)--> de la clase punto
    private double radio; // Radio del círculo

    Circulo(double x, double y, double radio) { 
        super(x, y); // Llama al constructor de la clase base (Punto) para establecer las coordenadas
        this.centro = new Punto(x, y); 
        this.radio = radio;
    } 

    Punto getCentro() { 
        return centro; 
    } 

    void setCentro(Punto centro) { 
        this.centro = centro; 
    } 

    double getRadio() { 
        return radio; 
    } 

    void setRadio(double radio) { 
        this.radio = radio; 
    }  
}

class Ejercicio1 {
    public static  void main(String[] args) {
      
        Punto punto1 = new Punto(1, 2); 
        Punto punto2 = new Punto(4, 2); 

        // Cálculo de la distancia entre los dos puntos
        double distancia = punto1.distancia(punto2); 

        System.out.println("La distancia entre los puntos es: " + distancia); 
    }
}
