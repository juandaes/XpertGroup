import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class RecibeDatos {
    public static void ordenarDatos() throws Exception {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String stCasos = scan.readLine();
        int casos = Integer.valueOf(stCasos);

        for (int i = 1; i <= casos; i++) {
            String[] nm = scan.readLine().split(" ");
            int n = Integer.valueOf(nm[0]);
            Matriz matriz = new Matriz();
            matriz.crearMatriz(n);
            int m = Integer.valueOf(nm[1]);
            for (int j = 1; j <= m; j++) {
                String query = scan.readLine();
                String[] datos = query.split(" ");
                int x1;
                int x2;
                int y1;
                int y2;
                int z1;
                int z2;
                long w;
                if (datos[0].equals("QUERY")) {
                    x1 = Integer.valueOf(datos[1]);
                    y1 = Integer.valueOf(datos[2]);
                    z1 = Integer.valueOf(datos[3]);
                    x2 = Integer.valueOf(datos[4]);
                    y2 = Integer.valueOf(datos[5]);
                    z2 = Integer.valueOf(datos[6]);
                    long resultado = matriz.sumarCeldad(x1, x2, y1, y2, z1, z2);
                    System.out.println(resultado);
                } else if (datos[0].equals("UPDATE")) {
                    x1 = Integer.valueOf(datos[1]);
                    y1 = Integer.valueOf(datos[2]);
                    z1 = Integer.valueOf(datos[3]);
                    w = Integer.valueOf(datos[4]);
                    matriz.asignarValor(x1, y1, z1, w);
                }
            }
        }
    }
}

class Matriz {
    private long[][][] matriz;

    public void crearMatriz(int n) {
        matriz = new long[n][n][n];
    }

    public void asignarValor(int x, int y, int z, long w) {
        matriz[x - 1][y - 1][z - 1] = w;
    }

    private long consultarValor(int x, int y, int z) {
        return matriz[x -1][y - 1][z - 1];
    }

    public long sumarCeldad(int x1, int x2, int y1, int y2, int z1, int z2) {
        long resultado = 0;
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                for (int z = z1; z <= z2; z++) {
                    resultado += consultarValor(x, y, z);
                }
            }
        }

        return resultado;
    }
}

public class Solution {

    public static void main(String[] args) throws Exception {        
        RecibeDatos.ordenarDatos();
    }    
}
