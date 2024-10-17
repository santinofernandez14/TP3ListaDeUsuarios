package com.mysoft.tp3listadeusuarios;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.ViewModelProvider;
import android.view.View;
import android.widget.Toast;
import androidx.core.view.WindowInsetsCompat;
import com.mysoft.tp3listadeusuarios.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);


        binding.btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = binding.etNombre.getText().toString();
                String edadString = binding.etEdad.getText().toString();

                if (!nombre.isEmpty() && !edadString.isEmpty()) {
                    int edad = Integer.parseInt(edadString);
                    Usuario nuevoUsuario = new Usuario(nombre, edad);
                    userViewModel.addUser(nuevoUsuario);
                    Toast.makeText(MainActivity.this, "Usuario guardado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Complete los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });


        binding.btMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder listaUsuarios = new StringBuilder();
                for (Usuario usuario : userViewModel.getUsuarios()) {
                    listaUsuarios.append("Nombre: ").append(usuario.getNombre())
                            .append(", Edad: ").append(usuario.getEdad()).append("\n");
                }
                binding.tvLista.setText(listaUsuarios.toString());
            }
        });
    }
}