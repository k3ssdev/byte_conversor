import java.util.EnumMap;
import java.util.Map;

public class Conversor {

    private static final Map<Unidades, Double> FACTORES_CONVERSION = new EnumMap<>(Unidades.class);

    static {
        // Inicializa los factores de conversión
        FACTORES_CONVERSION.put(Unidades.BIT, 1.0 / 8);
        FACTORES_CONVERSION.put(Unidades.BYTE, 1.0);
        FACTORES_CONVERSION.put(Unidades.KILOBYTE, 1.0 / 1024);
        FACTORES_CONVERSION.put(Unidades.MEGABYTE, 1.0 / 1024 / 1024);
        FACTORES_CONVERSION.put(Unidades.GIGABYTE, 1.0 / 1024 / 1024 / 1024);
        FACTORES_CONVERSION.put(Unidades.TERABYTE, 1.0 / 1024 / 1024 / 1024 / 1024);
        FACTORES_CONVERSION.put(Unidades.PETABYTE, 1.0 / 1024 / 1024 / 1024 / 1024 / 1024);
        FACTORES_CONVERSION.put(Unidades.EXABYTE, 1.0 / 1024 / 1024 / 1024 / 1024 / 1024 / 1024);
        FACTORES_CONVERSION.put(Unidades.ZETTABYTE, 1.0 / 1024 / 1024 / 1024 / 1024 / 1024 / 1024 / 1024);
        FACTORES_CONVERSION.put(Unidades.YOTTABYTE, 1.0 / 1024 / 1024 / 1024 / 1024 / 1024 / 1024 / 1024 / 1024);
        FACTORES_CONVERSION.put(Unidades.BRONTOBYTE, 1.0 / 1024 / 1024 / 1024 / 1024 / 1024 / 1024 / 1024 / 1024 / 1024);
        FACTORES_CONVERSION.put(Unidades.GEOPBYTE, 1.0 / 1024 / 1024 / 1024 / 1024 / 1024 / 1024 / 1024 / 1024 / 1024 / 1024);
    }

    public static double convertir(double cantidad, Unidades unidadEntrada, Unidades unidadSalida) {
        
        // Comprueba que las unidades de entrada y salida sean válidas
        if (!FACTORES_CONVERSION.containsKey(unidadEntrada) || !FACTORES_CONVERSION.containsKey(unidadSalida)) {
            throw new IllegalArgumentException("Unidad de almacenamiento no válida");
        }

        // Calcula el resultado, usa get() para obtener el factor de conversión del mapa
        double factorEntrada = FACTORES_CONVERSION.get(unidadEntrada);
        double factorSalida = FACTORES_CONVERSION.get(unidadSalida);

        return cantidad * (factorEntrada / factorSalida);
    }
}
