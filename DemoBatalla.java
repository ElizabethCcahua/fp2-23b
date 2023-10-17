//KARINA
import java.util.*; 
public class DemoBatalla {
public static void main(String [] args){
 Nave [] misNaves = new Nave[8];
 Scanner sc = new Scanner(System.in);
 String nomb, col;
 int fil, punt;
 boolean est;
 
 for (int i = 0; i < misNaves.length; i++) {
 System.out.println("Nave " + (i+1));
 System.out.print("Nombre: ");
 nomb = sc.next();
 System.out.println("Fila ");
 fil = sc.nextInt();
 System.out.print("Columna: ");
 col = sc.next();
 System.out.print("Estado: ");
 est = sc.nextBoolean();
 System.out.print("Puntos: ");
 punt = sc.nextInt();
 
 misNaves[i] = new Nave(); //Se crea un objeto Nave y se asigna su referencia a misNaves

 misNaves[i].setNombre(nomb);
 misNaves[i].setFila(fil);
 misNaves[i].setColumna(col);
 misNaves[i].setEstado(est);
 misNaves[i].setPuntos(punt);
}

 System.out.println("\nNaves creadas:");
 mostrarNaves(misNaves);
 mostrarPorNombre(misNaves);
 mostrarPorPuntos(misNaves);
 System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves));
//leer un nombre
String nombre =sc.next();

//mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario
int pos=busquedaLinealNombre(misNaves,nombre);
ordenarPorPuntosBurbuja(misNaves);
mostrarNaves(misNaves);
ordenarPorNombreBurbuja(misNaves);
mostrarNaves(misNaves);

//mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario
pos=busquedaBinariaNombre(misNaves,nombre);
ordenarPorPuntosSeleccion(misNaves);
mostrarNaves(misNaves);
ordenarPorNombreSeleccion(misNaves);
mostrarNaves(misNaves);
ordenarPorPuntosInsercion(misNaves);
mostrarNaves(misNaves);
ordenarPorNombreInsercion(misNaves);
mostrarNaves(misNaves);
} 
//Método para mostrar todas las naves
public static void mostrarNaves(Nave[] flota){
//REUTILIZAR
for(int i=0;i<flota.length;i++){
    flota[i].getNombre();
    flota[i].getFila();
    flota[i].getColumna();
    flota[i].getEstado();
    flota[i].getPuntos();

}
 }

//Método para mostrar todas las naves de un nombre que se pide por teclado
public static void mostrarPorNombre(Nave[] flota){
//REUTILIZAR
Scanner sc = new Scanner (System.in);
        System.out.println("Ingrese un nombre a buscar");
        String nombre =sc.next();
        for(int i=0;i<flota.length;i++){
            if (flota[i].getNombre().equals(nombre))
            mostrarNaves(flota);
}
}

//Método para mostrar todas las naves con un número de puntos inferior o igual
//al número de puntos que se pide por teclado
public static void mostrarPorPuntos(Nave[] flota){
//REUTILIZAR
Scanner cs=new Scanner(System.in);
System.out.println("ingrese puntos:");
int puntos=sc.nextInt();
for(int i=0;1<flota.length;i++){
    if (flota[i].getPuntos()<=puntos)
    System .out.println(flota[i].getNombre);
}

}

//Método que devuelve la Nave con mayor número de Puntos
public static Nave mostrarMayorPuntos(Nave[] flota){
//REUTILIZAR
int mayor=0;
for(int i=0;i<flota.length;i++){
    if (flota[i].getPuntos()>mayor)
    mayor=flota[i].getPuntos();

}
return flota[mayor];
} 
//Método para buscar la primera nave con un nombre que se pidió por teclado
public static int busquedaLinealNombre(Nave[] flota, String s){
    for(int i=0;i<flota.length;i++)
    if(flota[i].equals(s))
    return i;
return -1;
}
//Método que ordena por número de puntos de menor a mayor
public static void ordenarPorPuntosBurbuja(Nave[] flota){
}
//Método que ordena por nombre de A a Z
public static void ordenarPorNombreBurbuja(Nave[] flota){
}
//Método para buscar la primera nave con un nombre que se pidió por teclado
public static int busquedaBinariaNombre(Nave[] flota, String s){
}
//Método que ordena por número de puntos de menor a mayor
public static void ordenarPorPuntosSeleccion(Nave[] flota){
}
//Método que ordena por nombre de A a Z
public static void ordenarPorNombreSeleccion(Nave[] flota){
}
//Método que muestra las naves ordenadas por número de puntos de mayor a menor
public static void ordenarPorPuntosInsercion(Nave[] flota){
}
//Método que muestra las naves ordenadas por nombre de Z a A
public static void ordenarPorNombreInsercion(Nave[] flota){
}
}
            