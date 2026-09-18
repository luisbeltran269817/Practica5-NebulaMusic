package com.example.NebulaMusic.service;

import com.example.NebulaMusic.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class UsuarioService {
    private final Map<String, Usuario> usuarios = new ConcurrentHashMap<>();

    public UsuarioService(){

    }

    public void registrar(Usuario usuario){
//        if (existeCorreo(usuario.getEmail())){
//
//        }
        usuarios.put(usuario.getEmail(), usuario);
    }

    public boolean existeCorreo(String correo){
        return usuarios.containsKey(correo);
    }

    public boolean autenticar(String email, String contrasena){
        Usuario usuario=usuarios.get(email);
        return usuario!=null && usuario.getContrasena().equals(contrasena);
    }
}
