import java.util.*;
public class Prac02 { 
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        System.out.print("cantidad de soldados: ");
        int n = scanner.nextInt();
        System.out.print("Tamaño del campo nxn: ");
        int campoSize = scanner.nextInt();
      

        ArrayList<Soldado> ejercitoA =generarEjercito(n);
        ArrayList<Soldado> ejercitoB = generarEjercito(n);

        Soldado[][] campoA = new Soldado[campoSize][campoSize];
        Soldado[][] campoB = new Soldado[campoSize][campoSize];

        ubicarSoldadosAleatoriamente(campoA, ejercitoA);
        ubicarSoldadosAleatoriamente(campoB, ejercitoB);

        System.out.println("Campo del primer ejército:");
        imprimirCampo(campoA);

        System.out.println("Campo del segundo ejército:");
        imprimirCampo(campoB);

        cruzarPosiciones(campoA, campoB);

        System.out.println("Campo con los soldados sobrevivientes:");
        
        for (int i = 0; i <campoA.length; i++) {
            for (int j = 0; j < campoA[0].length; j++) {
                if (campoB[i][j]!=null)
                    campoA[i][j]=new Soldado(campoB[i][j].getVida());   
                }
            }
            System.out.println();
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
public static  ArrayList<Soldado> generarEjercito(int nSoldados) {
    ArrayList<Soldado> ejercito = new ArrayList<>();
    
    for (int i = 0; i < nSoldados; i++) {
        int vida = (int)(Math.random() * (5 - 1 + 1) + 1);
        Soldado soldado = new Soldado(vida);
        ejercito.add(soldado);
    }
    return ejercito;
}

    public static void ubicarSoldadosAleatoriamente(Soldado [][] campo, ArrayList<Soldado> ejercito) {
 Random random = new Random();

        for (Soldado soldado : ejercito) {
             int x = random.nextInt(campo.length);
            int y = random.nextInt(campo[0].length);

            if (campo[x][y] == null) {
                campo[x][y] = soldado;
            } else {
                // Si la posición ya está ocupada, buscar una posición vacía
                boolean posicionOcupada = false;

                for (int i = 0; i < campo.length && !posicionOcupada; i++) {
                    for (int j = 0; j < campo[0].length && !posicionOcupada; j++) {
                        if (campo[i][j] == null) {
                            campo[i][j] = soldado;
                            posicionOcupada = true;
                        }
                    }
                }
            }
        }
    }

    public static void cruzarPosiciones(Soldado[][] campoA, Soldado[][] campoB) {
        for (int i = 0; i < campoA.length; i++) {
            for (int j = 0; j < campoA[0].length; j++) {
                if (campoA[i][j] !=null && campoB[i][j] !=null) {
                    if (campoA[i][j].getVida()> campoB[i][j].getVida()) {
                        campoA[i][j].setVida(campoA[i][j].getVida()-campoB[i][j].getVida());
                        campoB[i][j] =  null;
                    } else if (campoB[i][j].getVida() > campoA[i][j].getVida()) {
                        campoB[i][j].setVida(campoB[i][j].getVida()-campoA[i][j].getVida());
                        campoA[i][j] =  null;
                    } else {
                        campoA[i][j] = null;
                        campoB[i][j] = null;
                    }
                }
            }
        }
    }

    public static void imprimirCampo(Soldado[][] campo) {
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[0].length; j++) {
                if(campo[i][j]!=null)
                System.out.print(campo[i][j].getVida() + " ");
                else
                System.out.print("0 ");
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
