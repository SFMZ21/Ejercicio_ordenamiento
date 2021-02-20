import java.util.Arrays;
import java.util.Scanner;
public class main {



        public static void main(String[] args) {

            //variables auxilares para almacenar datos
            int auxiliar1[] = new int[50];
            int auxiliar2[] = new int[50];
            String auxiliar3[] = new String[50];



            //llenado de arrays auxiliares
            System.out.println("Ingrese los datos");
            Scanner leer_teclado = new Scanner(System.in);
            int o=0;
            while (o<50){
                System.out.println("DPI:");
                auxiliar1[o]=leer_teclado.nextInt();
                System.out.println("Edad:");
                auxiliar2[o]=leer_teclado.nextInt();
                System.out.println("Nombre");
                auxiliar3[o]=leer_teclado.next();
                System.out.println("Ingresar otro dato?");
                int opcion = leer_teclado.nextInt();
                if(opcion==1){
                    o++;
                }
                else if (opcion==2){
                    o++;
                    break;
                }
            }

            //variables reales a utilizar
            int DPI[] = new int[o];
            int EDAD[] = new int[o];
            String NOMBRE[] = new String[o];

            //llenado de array
            for (int i=0;i<o;i++){
                DPI[i]=auxiliar1[i];
                EDAD[i]=auxiliar2[i];
                NOMBRE[i] = auxiliar3[i];
            }

            //funcion de ordenamiento por seleccion
            ordenamientoSeleccion(DPI,EDAD,NOMBRE);

            //variable para detener el menu.
            int encendido = 1;
            //ciclo para que se repita
            while (encendido==1) {
                System.out.println("Que desea hacer?");
                System.out.println("1.Buscar datos");
                System.out.println("2.Mostrar todos los datos");
                System.out.println("3.Cerrar programa");
                int menu = leer_teclado.nextInt();
                switch (menu){
                    case 1:
                        System.out.println("Dato a buscar?");
                        int dpi_buscado = leer_teclado.nextInt();
                        System.out.println("DPI No." + DPI[binarySearch(DPI,dpi_buscado)]);
                        System.out.println("Nombre " + NOMBRE[binarySearch(DPI,dpi_buscado)]);
                        System.out.println("Edad " + EDAD[binarySearch(DPI,dpi_buscado)] + " años");
                        break;
                    case 2:
                        System.out.println("DPI: " + Arrays.toString(DPI));
                        System.out.println("Edades: " + Arrays.toString(EDAD));
                        System.out.println("Nombres: " + Arrays.toString(NOMBRE));
                        break;
                    case 3:
                        encendido=0;
                        break;
                    default:
                        System.out.println("Esa opcion no existe");
                }
            }




        }


        public static void ordenamientoSeleccion(int a[],int edad[], String nombre[]) {
            int indiceMenor;

            for (int i = 0;i<a.length; i++) {
                //comientza con la exploracion del indice i
                indiceMenor = i;
                //j explora la sublista [i+1]..[n-1] y busca el menor de todos
                for (int j = i+1; j<a.length; j++) {
                    if (a[j] < a[indiceMenor]) {
                        indiceMenor = j;
                    }

                }
                if (i != indiceMenor) {
                    intercambiar(a, i, indiceMenor,edad,nombre);
                }
            }
        }

        static void intercambiar(int[] lista, int i, int j,int edad[] ,String nombre[]) {
            int aux = lista[i];
            int auxiliar2 = edad[i];
            String auxiliar3 = nombre[i];
            lista[i] = lista[j];
            lista[j] = aux;
            edad[i] = edad[j];
            edad[j] = auxiliar2;
            nombre[i] = nombre[j];
            nombre[j] = auxiliar3;
        }





        public static int binarySearch(int[] numbers, int numberToSearch) {

            int size = numbers.length;
            int middle = size/2;



            if (numbers[middle] == numberToSearch)
                return middle;
            else if (size == 1)
                return -1;
            else if (numbers[middle] > numberToSearch)
                return binarySearch(Arrays.copyOfRange(numbers,0,middle),numberToSearch);
            else
                return binarySearch(Arrays.copyOfRange(numbers,middle+1,size),numberToSearch);

        }


}
