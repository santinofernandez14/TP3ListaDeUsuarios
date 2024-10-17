package com.mysoft.tp3listadeusuarios;

import androidx.lifecycle.ViewModel;
import java.util.ArrayList;

public class UserViewModel extends ViewModel {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void addUser(Usuario usuario) {
        usuarios.add(usuario);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}