/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author usuario
 */
@ManagedBean
@RequestScoped
public class Carrera {
    private List<String> arrayCarreras;

    /**
     * Creates a new instance of Carrera
     */
    public Carrera() {
        arrayCarreras=new ArrayList<>();
        arrayCarreras.add("Bach.Diseño Grafico");
        arrayCarreras.add("Bach.Informática Empresarial");        
        arrayCarreras.add("Bach.Enfermería");
        arrayCarreras.add("Bach.Derecho");
    }

    public List<String> getArrayCarreras() {
        return arrayCarreras;
    }

    public void setArrayCarreras(List<String> arrayCarreras) {
        this.arrayCarreras = arrayCarreras;
    }
    
    
}
