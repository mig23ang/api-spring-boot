package api_blue.api.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api_blue.api.models.UserModel;
import api_blue.api.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UserModel> obtenerUsuarios() {
        return (ArrayList<UserModel>) usuarioRepository.findAll();
    }

    public UserModel guardarUsuario(UserModel usuario) {
        return usuarioRepository.save(usuario);
    }

}
