import java.util.EnumMap;
import java.util.Map;
import java.text.DecimalFormat;

public class Conversor {

    private static final Map<Unidades, Double> FACTORES_CONVERSION = new EnumMap<>(Unidades.class);

    static {
        // Inicializa los factores de conversión
        FACTORES_CONVERSION.put(Unidades.BIT, 1.0 / 8.0);
        FACTORES_CONVERSION.put(Unidades.BYTE, 1.0);
        FACTORES_CONVERSION.put(Unidades.KILOBYTE, 1024.0);
        FACTORES_CONVERSION.put(Unidades.MEGABYTE, 1024.0 * 1024.0);
        FACTORES_CONVERSION.put(Unidades.GIGABYTE, 1024.0 * 1024.0 * 1024.0);
        FACTORES_CONVERSION.put(Unidades.TERABYTE, 1024.0 * 1024.0 * 1024.0 * 1024.0);
        FACTORES_CONVERSION.put(Unidades.PETABYTE, 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0);
        FACTORES_CONVERSION.put(Unidades.EXABYTE, 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0);
        FACTORES_CONVERSION.put(Unidades.ZETTABYTE, 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0);
        FACTORES_CONVERSION.put(Unidades.YOTTABYTE,
                1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0);
        FACTORES_CONVERSION.put(Unidades.BRONTOBYTE,
                1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0);
        FACTORES_CONVERSION.put(Unidades.GEOPBYTE,
                1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0);

    }

    // map con las siglas de las unidades de almacenamiento
    private static final Map<Unidades, String> unidadesAlmacenamiento = new EnumMap<>(Unidades.class);

    static {
        unidadesAlmacenamiento.put(Unidades.BIT, "bit");
        unidadesAlmacenamiento.put(Unidades.BYTE, "B");
        unidadesAlmacenamiento.put(Unidades.KILOBYTE, "KB");
        unidadesAlmacenamiento.put(Unidades.MEGABYTE, "MB");
        unidadesAlmacenamiento.put(Unidades.GIGABYTE, "GB");
        unidadesAlmacenamiento.put(Unidades.TERABYTE, "TB");
        unidadesAlmacenamiento.put(Unidades.PETABYTE, "PB");
        unidadesAlmacenamiento.put(Unidades.EXABYTE, "EB");
        unidadesAlmacenamiento.put(Unidades.ZETTABYTE, "ZB");
        unidadesAlmacenamiento.put(Unidades.YOTTABYTE, "YB");
        unidadesAlmacenamiento.put(Unidades.BRONTOBYTE, "BB");
        unidadesAlmacenamiento.put(Unidades.GEOPBYTE, "GB");
    }

    

    public static double convertir(double cantidad, Unidades unidadEntrada, Unidades unidadSalida) {
        // Comprueba que las unidades de entrada y salida sean válidas
        if (!FACTORES_CONVERSION.containsKey(unidadEntrada) || !FACTORES_CONVERSION.containsKey(unidadSalida)) {
            throw new IllegalArgumentException("Unidad de almacenamiento no válida");
        }

        // Calcula el resultado, usa get() para obtener el factor de conversión del mapa
        double factorEntrada = FACTORES_CONVERSION.get(unidadEntrada);
        double factorSalida = FACTORES_CONVERSION.get(unidadSalida);

        // Realiza la conversión
        double resultado = cantidad * factorEntrada / factorSalida;

        DecimalFormat df;
        // Notación científica
        if (resultado > 1000) {
        df = new DecimalFormat("0.##E0");
        } else {
        df = new DecimalFormat("0.##");
        }

        // Imprime el resultado
        System.out.println(cantidad + " " + unidadesAlmacenamiento.get(unidadEntrada) + " = " + df.format(resultado) + " " + unidadesAlmacenamiento.get(unidadSalida));
        System.out.println();

        // Imprime resultados para depuración
        System.out.println("Resultados para depuración:");
        System.out.println("Cantidad: " + cantidad + " " + unidadesAlmacenamiento.get(unidadEntrada));
        System.out.println("Factor de entrada: " + factorEntrada + " " + unidadesAlmacenamiento.get(unidadEntrada));
        System.out.println("Factor de salida: " + factorSalida + " " + unidadesAlmacenamiento.get(unidadSalida));
        System.out.println("Resultado: " + resultado + " " + unidadesAlmacenamiento.get(unidadSalida));

        return resultado;
    }

}
