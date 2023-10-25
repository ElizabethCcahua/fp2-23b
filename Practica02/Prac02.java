import java.util.*;
public class Prac02 {

    public static void main(String[] args) {
        int n = 5; // Número de soldados en cada ejército
        int campoSize = n; // Tamaño del campo (cuadrado de NxN)

        ArrayList<Soldado> ejercitoA = generarEjercito(n);
        ArrayList<Soldado> ejercitoB = generarEjercito(n);

        int[][] campoA = new int[campoSize][campoSize];
        int[][] campoB = new int[campoSize][campoSize];

        ubicarSoldadosAleatoriamente(campoA, ejercitoA);
        ubicarSoldadosAleatoriamente(campoB, ejercitoB);

        System.out.println("Campo del primer ejército:");
        imprimirCampo(campoA);

        System.out.println("Campo del segundo ejército:");
        imprimirCampo(campoB);

        cruzarPosiciones(campoA, campoB);

        System.out.println("Campo con los soldados sobrevivientes:");
        imprimirCampo(campoA);

        // Calcular el promedio de vida global
        double promedioVida = calcularPromedioVida(ejercitoA, ejercitoB);
        System.out.println("Promedio de vida global: " + promedioVida);

        // Determinar el ganador o declarar empate
        int totalVidaA = calcularTotalVida(ejercitoA);
        int totalVidaB = calcularTotalVida(ejercitoB);

        if (totalVidaA > totalVidaB) {
            System.out.println("El primer ejército es el ganador.");
        } else if (totalVidaB > totalVidaA) {
            System.out.println("El segundo ejército es el ganador.");
        } else {
            System.out.println("Empate.");
        }
    }
public static ArrayList<Soldado> generarEjercito(int nSoldados) {
    ArrayList<Soldado> ejercito = new ArrayList<>();
    
    for (int i = 0; i < nSoldados; i++) {
        int vida = (int)(Math.random() * (5 - 1 + 1) + 1);
        Soldado soldado = new Soldado(vida);
        ejercito.add(soldado);
    }
    return ejercito;
}

    public static void ubicarSoldadosAleatoriamente(int[][] campo, ArrayList<Soldado> ejercito) {
 Random random = new Random();

        for (Soldado soldado : ejercito) {
             int x = random.nextInt(campo.length);
            int y = random.nextInt(campo[0].length);

            if (campo[x][y] == 0) {
                campo[x][y] = soldado.vida;
            } else {
                // Si la posición ya está ocupada, buscar una posición vacía
                boolean posicionEncontrada = false;

                for (int i = 0; i < campo.length && !posicionEncontrada; i++) {
                    for (int j = 0; j < campo[0].length && !posicionEncontrada; j++) {
                        if (campo[i][j] == 0) {
                            campo[i][j] = soldado.vida;
                            posicionEncontrada = true;
                        }
                    }
                }
            }
        }
    }

    public static void cruzarPosiciones(int[][] campoA, int[][] campoB) {
        for (int i = 0; i < campoA.length; i++) {
            for (int j = 0; j < campoA[0].length; j++) {
                if (campoA[i][j] > 0 && campoB[i][j] > 0) {
                    if (campoA[i][j] > campoB[i][j]) {
                        campoA[i][j] -= campoB[i][j];
                        campoB[i][j] = 0;
                    } else if (campoB[i][j] > campoA[i][j]) {
                        campoB[i][j] -= campoA[i][j];
                        campoA[i][j] = 0;
                    } else {
                        campoA[i][j] = 0;
                        campoB[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void imprimirCampo(int[][] campo) {
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[0].length; j++) {
                System.out.print(campo[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static double calcularPromedioVida(ArrayList<Soldado> ejercitoA, ArrayList<Soldado> ejercitoB) {
        int sumaVida = 0;
        int totalSoldados = ejercitoA.size() + ejercitoB.size();

        for (Soldado soldado : ejercitoA) {
            sumaVida += soldado.vida;
        }

        for (Soldado soldado : ejercitoB) {
            sumaVida += soldado.vida;
        }

        return (double) sumaVida / totalSoldados;
    }

    public static int calcularTotalVida(ArrayList<Soldado> ejercito) {
        int totalVida = 0;

        for (Soldado soldado : ejercito) {
            totalVida += soldado.vida;
        }

        return totalVida;
    }
    //metodo para poder obtener numeros aleatorios
    public static int Aleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
