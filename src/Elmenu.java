import java.util.Scanner;
import static java.lang.System.out;

public class Elmenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ordenacion obj = new ordenacion();
        int[] array = new int[50];
        for(int i = 0; i < array.length; i++){
            array[i]= (int) (Math.random()*50);
        }

        try {
            int option;
            do {

                out.println("\n1. Ordenamiento Burbuja");
                out.println("2. Ordenamiento Shell");
                out.println("3. Ordenamiento Radix");
                out.println("4. Ordenamiento por mezcla (Merge sort)");
                out.println("5. Ordenamiento por distribución (BucketSort )");
                out.println("6. Ordenamiento por montículos (Heapsort)");
                out.println("7. Ordenamiento rápido (Quicksort)");
                out.println("8. consultar arreglo puchale 8");
                out.println("0. exit");
                out.print("tu selecion: ");
                option = sc.nextInt();

                switch (option)
                {
                    default:
                        out.println("la '" +option+ "' no es una opcion...");
                        break;
                    case 1:
                        out.println("\n+++++++++++++++++++++++++++++++++++++++ Ordenamiento Burbuja +++++++++++++++++++++++++++++++++++++++\n");
                        long inicio = System.nanoTime();
                        obj.burbuja(array);
                        out.print("\n");
                        long fin = System.nanoTime();
                        double dif = (double) (fin - inicio) * 1.0e-9;
                        System.out.println("El programa dura " + dif + " s");
                        out.println("\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                        break;

                    case 2:
                        out.println("\n+++++++++++++++++++++++++++++++++++++++++ Ordenamiento Shell +++++++++++++++++++++++++++++++++++++++\n");
                        long inicioo = System.nanoTime();
                        obj.shell(array);
                        long finn = System.nanoTime();
                        double diff = (double) (finn - inicioo) * 1.0e-9;
                        System.out.println("El programa dura " + diff + " s");
                        out.println("\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                        break;

                    case 3:
                        out.println("\n++++++++++++++++++++++++++++++++++++++++ Ordenamiento Radix +++++++++++++++++++++++++++++++++++++++++\n");
                        long start = System.nanoTime();
                        obj.radixSort(array);
                        long finish = System.nanoTime();
                        double difin = (double) (finish - start) * 1.0e-9;
                        System.out.println("El programa dura " + difin + " s");
                        out.println("\n\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                        break;

                    case 4:
                        out.println("\n+++++++++++++++++++++++++++++++ Ordenamiento por mezcla (Merge sort) ++++++++++++++++++++++++++++++++\n");
                        long inicio0 = System.nanoTime();
                        obj.merge(array);
                        long fin0 = System.nanoTime();
                        double dif0 = (double) (fin0 - inicio0) * 1.0e-9;
                        System.out.println("El programa dura " + dif0 + " s");
                        out.println("\n\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                        break;

                    case 5:
                        out.println("\n+++++++++++++++++++++++++++++ Ordenamiento por distribución (BucketSort ) ++++++++++++++++++++++++++++\n");
                        long inicio1 = System.nanoTime();
                        int maxVal = 100;
                        obj.bucket(array, maxVal);
                        long fin1 = System.nanoTime();
                        double dif1 = (double) (fin1 - inicio1) * 1.0e-9;
                        System.out.println("El programa dura " + dif1 + " s");
                        out.println("\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                        break;

                    case 6:
                        out.println("\n+++++++++++++++++++++++++++++++ Ordenamiento por montículos (Heapsort) ++++++++++++++++++++++++++++++++\n");
                        long inicio2 = System.nanoTime();
                        obj.Heapsort(array);
                        obj.heapify(array,0,100);
                        obj.printArrayyy(array);
                        long fin2 = System.nanoTime();
                        double dif2 = (double) (fin2 - inicio2) * 1.0e-9;
                        System.out.println("El programa dura " + dif2 + " s");
                        out.println("\n\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                        break;

                    case 7:
                        out.println("\n+++++++++++++++++++++++++++++++ Ordenamiento rápido (Quicksort) ++++++++++++++++++++++++++++++++\n");
                        long iniciooo = System.nanoTime();
                        obj.QuickSort(array,0, array.length-1);
                        long finnn = System.nanoTime();
                        double difff = (double) (finnn - iniciooo) * 1.0e-9;
                        System.out.println("El programa dura " + difff + " s");
                        out.println("\n\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                        break;

                    case 8:
                        long inicio3 = System.nanoTime();
                        for(int i=0;i<array.length;i++){
                            out.println("POSICIÓN ["+(i+1)+"]: "+array[i]);
                        }
                        long fin3 = System.nanoTime();
                        double dif3 = (double) (fin3 - inicio3) * 1.0e-9;
                        System.out.println("El programa dura " + dif3 + " s");
                        break;

                    case 0:
                        out.print("\n");
                        out.println("$$$$$$$                       $$ | ");
                        out.println("$$  __$$                      $$ | ");
                        out.println("$$ |  $$ |$$    $$   $$$$$$   $$ | ");
                        out.println("$$$$$$$  |$$ |  $$ |$$  __$$  $$ | ");
                        out.println("$$  __$$  $$ |  $$ |$$$$$$$$ | __| ");
                        out.println("$$ |  $$ |$$ |  $$ |$$   ____|     ");
                        out.println("$$$$$$$  | $$$$$$$$ | $$$$$$$  $$   ");
                        out.println(" _______/   ____$$ |  _______| __| ");
                        out.println("          $$    $$ |               ");
                        out.println("           $$$$$$  |               ");
                        out.println("            ______/                ");
                        out.println("me tarde un buen en este 'bye' porfavor dame 10 <3");
                        System.exit(0);
                        break;
                }
            }while(option != 0);
        } catch (Exception e) {
            out.print("ERROR! ¡input incorrecto!");
        }
    }
}
