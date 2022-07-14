package api_blue.api.services;

import java.io.Console;
import java.util.ArrayList;
import java.util.Optional;

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

    public Optional<UserModel> obtenerUsuariosId(Long id) {
        return usuarioRepository.findById(id);
    }

    public ArrayList<UserModel> obtenerUsuariosPorPrioridad(Integer prioridad) {
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

}
