import static java.lang.System.out;
import java.util.*;
import java.util.Random;

public class ordenacion {
    // 1 Ordenamiento Burbuja
    static void burbuja(int array[]) {
        int aux;
        int cont = 0;
        int inter = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                cont++;
                if (array[j] > array[j + 1]) {
                    aux = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = aux;
                    inter++;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(String.format("\nPosición [%d] Elemento: %d", i, array[i]));
        }
        out.print("\nLas Compraraciones que se hicieron son: " + cont);
        out.print("\nLos intercambios que se hicieron son: " + inter);

    }

    //############################################################################################################################

    // 2 Ordenamiento Shell
    public void shell(int[] arreglo) {
        int inta, i, aux;
        int saltos = 0, compa = 0, inter = 0;
        boolean band;
        inta = arreglo.length;
        while (inta > 0) {
            inta = inta / 2;
            band = true;
            while (band) {
                band = false;
                i = 0;
                while ((i + inta) <= arreglo.length - 1) {
                    if (arreglo[i] > arreglo[i + inta]) {
                        aux = arreglo[i];
                        arreglo[i] = arreglo[i + inta];
                        arreglo[i + inta] = aux;
                        band = true;
                        compa++;
                    }
                    i = i + 1;
                    inter++;
                }
                saltos++;
            }
        }
        for (i = 0; i < arreglo.length; i++) {
            out.print(String.format("\nPosición [%d] Elemento: %d", i, arreglo[i]));
        }
        out.println("\nSaltos del programa " + saltos);
        out.println("Las Compraraciones que se hicieron son: " + compa);
        out.println("Los intercambios que se hicieron son: " + inter);

    }


    //############################################################################################################################

    // 3 Ordenamiento Radix


    public void radixSort(int[] radix) {
        int evaluaciones = 0, intercambios = 0;

        if (radix.length == 0)
            return;
        int[][] np = new int[radix.length][2];
        int[] q = new int[0x100];
        int i, j, k, l, f = 0;
        for (k = 0; k < 4; k++) {
            for (i = 0; i < (np.length - 1); i++)
                np[i][1] = i + 1;
            np[i][1] = -1;
            for (i = 0; i < q.length; i++)
                q[i] = -1;

            for (f = i = 0; i < radix.length; i++) {
                j = ((0xFF << (k << 3)) & radix[i]) >> (k << 3);
                if (q[j] == -1)
                    l = q[j] = f;
                else {
                    l = q[j];
                    while (np[l][1] != -1)
                        l = np[l][1];
                    np[l][1] = f;
                    l = np[l][1];
                    intercambios++;
                }
                f = np[f][1];
                np[l][0] = radix[i];
                np[l][1] = -1;
                evaluaciones++;
            }
            for (l = q[i = j = 0]; i < 0x100; i++)
                for (l = q[i]; l != -1; l = np[l][1])
                    radix[j++] = np[l][0];
        }
        for (i = 0; i < radix.length; i++) {
            out.print(String.format("\nPosición [%d] Elemento: %d", i, radix[i]));
        }
        out.println("\nLas Compraraciones que se hicieron son: " + evaluaciones);
        out.println("Los intercambios que se hicieron son: " + intercambios);
    }


    //############################################################################################################################

    // 4 Ordenamiento por mezcla (Merge sort)


    public void merge(int vec[]) {

        System.out.println("\nOrdenado");
        ordenacionMergeSort(vec);
        imprimirVector(vec);
    }

    public void ordenacionMergeSort(int vec[]) {
        if (vec.length <= 1) return;
        int mitad = vec.length / 2;
        int izq[] = Arrays.copyOfRange(vec, 0, mitad);
        int der[] = Arrays.copyOfRange(vec, mitad, vec.length);
        ordenacionMergeSort(izq);
        ordenacionMergeSort(der);
        combinarVector(vec, izq, der);
    }

    public void combinarVector(int v[], int izq[], int der[]) {
        int compa = 0, subdiv = 0, inter = 0;
        int i = 0;
        int j = 0;
        for (int k = 0; k < v.length; k++) {
            if (i >= izq.length) {
                v[k] = der[j];
                j++;
                compa++;
                continue;
            }
            if (j >= der.length) {
                v[k] = izq[i];
                i++;
                continue;
            }
            if (izq[i] < der[j]) {
                v[k] = izq[i];
                i++;
                inter++;
            } else {
                v[k] = der[j];
                j++;

            }

        }
        System.out.println("intercambios " + inter);
        System.out.println("--------------------");
    }

    public void imprimirVector(int vec[]) {
        for (int i = 0; i < vec.length; i++) {
            out.println("Posición" + "[" + i + "]:[" + vec[i] + "]");
        }
    }


    //############################################################################################################################

    // 5 Ordenamiento por distribución (BucketSort )
    public void bucket(int[] arreglo, int maxVal) {
        int[] bucket = new int[maxVal + 1];
        int cas = 0, inte = 0;
        for (int i = 0; i > bucket.length; i++) {
            bucket[i] = 0;

        }
        for (int i = 0; i < arreglo.length; i++) {
            bucket[arreglo[i]]++;
            cas++;

        }
        int outPos = arreglo.length - 1;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arreglo[outPos--] = i;
                inte++;
            }
        }

        // rr
        int evaluaciones = 0, intercambios = 0;

        if (arreglo.length == 0)
            return;
        int[][] np = new int[arreglo.length][2];
        int[] q = new int[0x100];
        int i, j, k, l, f = 0;
        for (k = 0; k < 4; k++) {
            for (i = 0; i < (np.length - 1); i++)
                np[i][1] = i + 1;
            np[i][1] = -1;
            for (i = 0; i < q.length; i++)
                q[i] = -1;

            for (f = i = 0; i < arreglo.length; i++) {
                j = ((0xFF << (k << 3)) & arreglo[i]) >> (k << 3);
                if (q[j] == -1)
                    l = q[j] = f;
                else {
                    l = q[j];
                    while (np[l][1] != -1)
                        l = np[l][1];
                    np[l][1] = f;
                    l = np[l][1];
                    intercambios++;
                }
                f = np[f][1];
                np[l][0] = arreglo[i];
                np[l][1] = -1;
                evaluaciones++;
            }
            for (l = q[i = j = 0]; i < 0x100; i++)
                for (l = q[i]; l != -1; l = np[l][1])
                    arreglo[j++] = np[l][0];
        }
        for (i = 0; i < arreglo.length; i++) {
            out.print(String.format("\nPosición [%d] Elemento: %d", i, arreglo[i]));
        }
        out.println("\nLas Compraraciones que se hicieron son: " + evaluaciones);
        out.println("Los intercambios que se hicieron son: " + intercambios);

        for (int ii = 0; i < arreglo.length; i++) {
            out.println("Posición" + "[" + i + "]:[" + arreglo[i] + "]");
        }
    }

    private static int hash(int num) {
        return num / 10;
    }


    //############################################################################################################################

    // 6 Ordenamiento por montículos (Heapsort)
    public void Heapsort(int array[]) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    void heapify(int array[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && array[l] > array[largest])
            largest = l;

        if (r < n && array[r] > array[largest])
            largest = r;

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }

    void printArrayyy(int array[]) {
        int evaluaciones = 0, intercambios = 0;

        if (array.length == 0)
            return;
        int[][] np = new int[array.length][2];
        int[] q = new int[0x100];
        int i, j, k, l, f = 0;
        for (k = 0; k < 4; k++) {
            for (i = 0; i < (np.length - 1); i++)
                np[i][1] = i + 1;
            np[i][1] = -1;
            for (i = 0; i < q.length; i++)
                q[i] = -1;

            for (f = i = 0; i < array.length; i++) {
                j = ((0xFF << (k << 3)) & array[i]) >> (k << 3);
                if (q[j] == -1)
                    l = q[j] = f;
                else {
                    l = q[j];
                    while (np[l][1] != -1)
                        l = np[l][1];
                    np[l][1] = f;
                    l = np[l][1];
                    intercambios++;
                }
                f = np[f][1];
                np[l][0] = array[i];
                np[l][1] = -1;
                evaluaciones++;
            }
            for (l = q[i = j = 0]; i < 0x100; i++)
                for (l = q[i]; l != -1; l = np[l][1])
                    array[j++] = np[l][0];
        }
        for (i = 0; i < array.length; i++) {
            out.print(String.format("\nPosición [%d] Elemento: %d", i, array[i]));
        }
        out.println("\nLas Compraraciones que se hicieron son: " + evaluaciones);
        out.println("Los intercambios que se hicieron son: " + intercambios);

    }

    //############################################################################################################################


    // 7 Ordenamiento rápido (Quicksort)
    public void QuickSort(int array[], int izq, int der) {

        int pivote = array[izq];
        int i = izq;
        int j = der;
        int aux;

        while (i < j) {
            while (array[i] <= pivote && i < j) i++;
            while (array[j] > pivote) j--;
            if (i < j) {
                aux = array[i];
                array[i] = array[j];
                array[j] = aux;
            }
        }

        array[izq] = array[j];
        array[j] = pivote;

        if (izq < j - 1)
            QuickSort(array, izq, j - 1);
        if (j + 1 < der)
            QuickSort(array, j + 1, der);

        int evaluaciones = 0, intercambios = 0;

        if (array.length == 0)
            return;
        int[][] np = new int[array.length][2];
        int[] q = new int[0x100];
        int ii, ji, k, l, f = 0;
        for (k = 0; k < 4; k++) {
            for (i = 0; i < (np.length - 1); i++)
                np[i][1] = i + 1;
            np[i][1] = -1;
            for (i = 0; i < q.length; i++)
                q[i] = -1;

            for (f = i = 0; i < array.length; i++) {
                j = ((0xFF << (k << 3)) & array[i]) >> (k << 3);
                if (q[j] == -1)
                    l = q[j] = f;
                else {
                    l = q[j];
                    while (np[l][1] != -1)
                        l = np[l][1];
                    np[l][1] = f;
                    l = np[l][1];
                    intercambios++;
                }
                f = np[f][1];
                np[l][0] = array[i];
                np[l][1] = -1;
                evaluaciones++;
            }
            for (l = q[i = j = 0]; i < 0x100; i++)
                for (l = q[i]; l != -1; l = np[l][1])
                    array[j++] = np[l][0];
        }

        for (i = 0; i < array.length; i++) {
            out.print(String.format("\nPosición [%d] Elemento: %d", i, array[i]));
        }
        out.println("\nLas Compraraciones que se hicieron son: " + evaluaciones);
        out.println("Los intercambios que se hicieron son: " + intercambios);
    }
}
