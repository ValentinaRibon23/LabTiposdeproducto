package co.edu.unipiloto.convergentes.labtiposdeproducto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeleccionadorProductos {
    private Map<String, Map<String, List<String>>> productosPorTipo;

    public SeleccionadorProductos() {
        productosPorTipo = new HashMap<>();
        inicializarProductos();
    }

    private void inicializarProductos() {
        // Productos sólidos
        Map<String, List<String>> solidos = new HashMap<>();
        List<String> solidosBulto = new ArrayList<>();
        solidosBulto.add("Azúcar");
        solidosBulto.add("Sal");
        solidosBulto.add("Harina");
        solidosBulto.add("Café");
        solidosBulto.add("Cacao");
        solidosBulto.add("Cereales");
        solidosBulto.add("Leche en polvo");
        solidosBulto.add("Cemento");
        solidosBulto.add("Arena");
        solidos.put("Bulto", solidosBulto);
        List<String> solidosGranel = new ArrayList<>();
        solidosGranel.add("Arroz");
        solidosGranel.add("Frijoles");
        solidosGranel.add("Garbanzos");
        solidosGranel.add("Lentejas");
        solidosGranel.add("Quinoa");
        solidosGranel.add("Avena");
        solidosGranel.add("Té");
        solidosGranel.add("Azúcar morena");
        solidosGranel.add("Sal de mar");
        solidos.put("Granel", solidosGranel);
        productosPorTipo.put("Sólido", solidos);


// Productos agrícolas
        Map<String, List<String>> agricolas = new HashMap<>();
        List<String> agricolasBulto = new ArrayList<>();
        agricolasBulto.add("Maíz");
        agricolasBulto.add("Trigo");
        agricolasBulto.add("Frijoles");
        agricolasBulto.add("Cebada");
        agricolasBulto.add("Sorgo");
        agricolasBulto.add("Arvejas");
        agricolasBulto.add("Cacao");
        agricolasBulto.add("Café");
        agricolasBulto.add("Ajonjolí");
        agricolas.put("Bulto", agricolasBulto);
        List<String> agricolasGranel = new ArrayList<>();
        agricolasGranel.add("Arroz");
        agricolasGranel.add("Maíz");
        agricolasGranel.add("Trigo");
        agricolasGranel.add("Frijoles");
        agricolasGranel.add("Lentejas");
        agricolasGranel.add("Cebada");
        agricolasGranel.add("Soya");
        agricolasGranel.add("Girasol");
        agricolasGranel.add("Sésamo");
        agricolas.put("Granel", agricolasGranel);
        productosPorTipo.put("Agrícola", agricolas);

// Productos líquidos
        Map<String, List<String>> liquidos = new HashMap<>();
        List<String> liquidosBulto = new ArrayList<>();
        liquidosBulto.add("Agua");
        liquidosBulto.add("Aceite vegetal");
        liquidosBulto.add("Leche");
        liquidosBulto.add("Vino");
        liquidosBulto.add("Refresco");
        liquidosBulto.add("Jugo");
        liquidosBulto.add("Vinagre");
        liquidosBulto.add("Cerveza");
        liquidosBulto.add("Sidra");
        liquidos.put("Bulto", liquidosBulto);
        List<String> liquidosGranel = new ArrayList<>();
        liquidosGranel.add("Gasolina");
        liquidosGranel.add("Petróleo");
        liquidosGranel.add("Aceite de motor");
        liquidosGranel.add("Alcohol");
        liquidosGranel.add("Tintura");
        liquidosGranel.add("Perfume");
        liquidosGranel.add("Disolvente");
        liquidosGranel.add("Lubricante");
        liquidosGranel.add("Anticongelante");
        liquidos.put("Granel", liquidosGranel);
        productosPorTipo.put("Líquido", liquidos);

    }

    public List<String> getProductosPorTipoYEmpaque(String tipo, String empaque) {
        Map<String, List<String>> productosPorEmpaque = productosPorTipo.get(tipo);
        if (productosPorEmpaque != null) {
            return productosPorEmpaque.get(empaque);
        }
        return null;
    }
}


