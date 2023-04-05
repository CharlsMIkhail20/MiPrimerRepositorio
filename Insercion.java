import java.util.Scanner;
import java.io.*;
public class Insercion {
	public static void main (String args[]) {		
		System.out.println("Algoritmo de metodo de ordenamiendo por INSERCION");
		Scanner lector = new Scanner(System.in);
		System.out.print("Indique el numero de arrglos que quiere ordenar: ");
		int n = lector.nextInt();
		//int[] A = {5, 2, 4, 6, 1, 3};
		//int[] A;
		//A = worstCase(10);
		//System.out.println("Arreglo de tamanio :" + A.length);
		//System.out.println("DESORDENDO: ");
		//printA(A);
		//System.out.println("---------------------------------");
		//sort(A);
		
		System.out.println("---------------------------------");
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:/LP3/Insercion/datos.txt");
            pw = new PrintWriter(fichero);
            for (int i = 0; i < n; i++){
				pw.println(i + " " + sort(worstCase(i)));
			}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero) {
              fichero.close();
		   }
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
		System.out.println("Se guardo el archivo correctamente");
		/*for (int k = 1; k <= n; k++) {
			System.out.print(k);
			System.out.print("\t");
			System.out.print(sort(worstCase(k)));
			System.out.print("\n");
		}*/
		System.out.println("---------------------------------");
		System.out.println("Hecho por: Carlos Mijail Mamani Anccasi - cmamania@ulasalle.edu.pe - 29/03/23");
	}
	
	public static long sort(int[] A) {	
		long star = System.nanoTime();		
		//System.out.println("ORDENADO: ");
		int key, i, j;
		for (j = 1; j < A.length; j++) {
			key = A[j];
			i = j - 1;
			while (i > -1 && A[i] > key) {
				A[i + 1] = A[i];
				i--;
			}
			A[i + 1] = key;
			//printA(A);
		}
		long end = System.nanoTime();
		//System.out.println("Time: " + (end-star) + "ns");
		return (end-star);
	}

	public static void printA(int[] Aa) {
		for (int i = 0; i < Aa.length; i++) {
			System.out.print(Aa[i] + " ");
		}
		System.out.println("");
	}
	
	public static int[] worstCase(int n) {
		int M[] = new int[n];
		int i = 0;
		for (int t = n; t >= 1; t--) {
			M[i] = t;
			i++;	
		}
		return M;
	}
}