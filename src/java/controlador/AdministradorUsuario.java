/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import modelo.RegistroUsuarioXML;
import modelo.Usuario;

/**
 *
 * @author kevin
 */
@ManagedBean
@RequestScoped
public class AdministradorUsuario {

    @ManagedProperty(value="#{usuario}")
    private Usuario usuario;
    
    public AdministradorUsuario() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String agregarUsuario() throws IOException
    {
        
        RegistroUsuarioXML registroUsuarioXML= RegistroUsuarioXML.crearDocumento("");
        registroUsuarioXML.addUser(usuario);
        return null;
    }
}
