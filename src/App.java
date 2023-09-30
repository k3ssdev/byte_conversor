import java.util.Scanner;


public class App {

    public static void main(String[] args) {

        // Limpiamos la consola
        System.out.print("\033[H\033[2J");

        try {
            Scanner sc = new Scanner(System.in);
            double cantidad;
            Unidades unidadEntrada;
            Unidades unidadSalida;

        // Imprimimos las unidades de almacenamiento
            System.out.println("Unidades de almacenamiento disponibles:");
            imprimirUnidadesAlmacenamiento();

            // Pedimos los datos
            System.out.println("Introduce la cantidad a convertir:");
            cantidad = sc.nextDouble();

            // Pedimos las unidades de entrada
            System.out.println("Introduce la unidad de entrada:");
            unidadEntrada = Unidades.valueOf(sc.next().toUpperCase());

            // Pedimos las unidades de salida
            System.out.println("Introduce la unidad de salida:");
            unidadSalida = Unidades.valueOf(sc.next().toUpperCase());

            // Mostramos el resultado
            System.out.println();
            Conversor.convertir(cantidad, unidadEntrada, unidadSalida); 


        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        } finally {
            System.out.println();
            System.out.println("Pulse enter para reiniciar el programa");
            // Pausa para que de tiempo a leer el mensaje de fin del programa
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
            // Reiniciamos el programa
            main(args);
        }
    }


    // Imprime lista de unidades de almacenamiento
    public static void imprimirUnidadesAlmacenamiento() {
        for (Unidades unidad : Unidades.values()) {
            System.out.println(unidad);
        }
    }



}


