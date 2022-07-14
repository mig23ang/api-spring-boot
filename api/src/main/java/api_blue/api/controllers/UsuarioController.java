package api_blue.api.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api_blue.api.models.UserModel;
import api_blue.api.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UserModel> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UserModel guardarUsuario(@RequestBody UserModel usuario) {
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerUsuariosId(id);
    }

    @GetMapping("/query")
    public ArrayList<UserModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
        return this.usuarioService.obtenerUsuariosPorPrioridad(prioridad);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok) {
            return "Usuario eliminado";
        } else {
            return "error no se puedo eliminar el usuario";
        }
    }
}
