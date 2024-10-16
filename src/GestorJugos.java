
import java.util.HashMap;

public class GestorJugos {
    private HashMap<String, Integer> mapaVentas;
    private HashMap<String, Integer> mapaPrecios;

    public GestorJugos() {
        mapaVentas = new HashMap<>();
        mapaPrecios = new HashMap<>();
        mapaPrecios.put("Fresa", 5000);
        mapaPrecios.put("Guanábana", 7000);
        mapaPrecios.put("Mango", 6000);
    }

    public void registrarVenta(String jugo) {
        mapaVentas.put(jugo, mapaVentas.getOrDefault(jugo, 0) + 1);
    }

    public int obtenerPrecio(String jugo) {
        return mapaPrecios.getOrDefault(jugo, 0);
    }

    public String obtenerResumenVentas() {
        StringBuilder resumen = new StringBuilder();
        int ventasTotales = 0;
        for (String jugo : mapaVentas.keySet()) {
            int cantidadVendida = mapaVentas.get(jugo);
            resumen.append(jugo).append(": ").append(cantidadVendida).append("\n");
            ventasTotales += cantidadVendida;
        }
        resumen.append("\nTotal de ventas: ").append(ventasTotales);
        return resumen.toString();
    }
}
