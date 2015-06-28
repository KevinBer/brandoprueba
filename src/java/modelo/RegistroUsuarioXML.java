/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author usuario
 */

public class RegistroUsuarioXML {
    
    Element raiz;
    Document documento;
    String ruta;

    private RegistroUsuarioXML(String ruta, String nombreRaiz) throws IOException {
        this.raiz = new Element(nombreRaiz);
        this.documento = new Document(raiz);
        this.ruta = ruta;
        guardar();
    }

    private RegistroUsuarioXML(String rutaArchivo) throws JDOMException, IOException {
        SAXBuilder saxB = new SAXBuilder();
        saxB.setIgnoringElementContentWhitespace(true);
        this.documento = saxB.build(rutaArchivo);
        this.raiz = this.documento.getRootElement();
        this.ruta = rutaArchivo;
    }

    public void guardar() throws FileNotFoundException, IOException {
        XMLOutputter xmlOut = new XMLOutputter();
        xmlOut.output(this.documento, new PrintWriter(this.ruta));
        xmlOut.output(this.documento, System.out);
    }

    public static RegistroUsuarioXML crearDocumento(String rutaDocumento) throws IOException {
        return new RegistroUsuarioXML(rutaDocumento, "usuarios");
    }

    public static RegistroUsuarioXML abrirDocumento(String rutaDocumento) throws JDOMException, IOException {
        return new RegistroUsuarioXML(rutaDocumento);
    }

    public void addUser(Usuario usuario) throws IOException {
        Element eUsuario = new Element("usuario");
        Element eNombre = new Element("nombre");
        eNombre.addContent(usuario.getNombre());
        Element eFechaN = new Element("fechaNacimiento");
        eFechaN.addContent(usuario.getFechaNacimiento().toString());
        Element eCarrera = new Element("carrera");
        eCarrera.addContent(usuario.getCarrera());
        Element ePassword = new Element("clave");
        ePassword.addContent(usuario.getClave());
        Element carne= new Element("Carné");
        carne.addContent(usuario.getIdentificador());
        
        eUsuario.addContent(eNombre);
        eUsuario.addContent(eFechaN);
        eUsuario.addContent(eCarrera);
        eUsuario.addContent(ePassword);
        eUsuario.addContent(carne);
        raiz.addContent(eUsuario);
        this.guardar();
    }

}
    

