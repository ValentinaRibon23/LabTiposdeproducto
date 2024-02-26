package co.edu.unipiloto.convergentes.labtiposdeproducto;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerTipoProducto;
    private Spinner spinnerTipoEmpaque;
    private ListView listViewProductos;
    private SeleccionadorProductos seleccionadorProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerTipoProducto = findViewById(R.id.spinner_tipo_producto);
        spinnerTipoEmpaque = findViewById(R.id.spinner_tipo_empaque);
        listViewProductos = findViewById(R.id.list_view_productos);

        // Inicializar el seleccionador de productos
        seleccionadorProductos = new SeleccionadorProductos();

        // Configurar el adaptador para el spinner de tipo de producto
        ArrayAdapter<CharSequence> tipoProductoAdapter = ArrayAdapter.createFromResource(this,
                R.array.tipos_producto_array, android.R.layout.simple_spinner_item);
        tipoProductoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoProducto.setAdapter(tipoProductoAdapter);

        // Configurar el adaptador para el spinner de tipo de empaque
        ArrayAdapter<CharSequence> tipoEmpaqueAdapter = ArrayAdapter.createFromResource(this,
                R.array.tipos_empaque_array, android.R.layout.simple_spinner_item);
        tipoEmpaqueAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoEmpaque.setAdapter(tipoEmpaqueAdapter);

        // Manejar la selección de tipo de producto y tipo de empaque
        spinnerTipoProducto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mostrarProductos();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nada que hacer aquí
            }
        });

        spinnerTipoEmpaque.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mostrarProductos();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nada que hacer aquí
            }
        });
    }

    private void mostrarProductos() {
        String tipoSeleccionado = spinnerTipoProducto.getSelectedItem().toString();
        String empaqueSeleccionado = spinnerTipoEmpaque.getSelectedItem().toString();
        List<String> productos = seleccionadorProductos.getProductosPorTipoYEmpaque(tipoSeleccionado, empaqueSeleccionado);
        if (productos != null) {
            ArrayAdapter<String> productosAdapter = new ArrayAdapter<>(MainActivity.this,
                    android.R.layout.simple_list_item_1, productos);
            listViewProductos.setAdapter(productosAdapter);
        }
    }
}
