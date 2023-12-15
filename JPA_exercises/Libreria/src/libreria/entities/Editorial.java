/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Soso
 */
@Entity
public class Editorial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //esto lo genera autoincremental
    private Integer id;
    
    private String nombre;

    public Integer getId() {
        return id;
    }

  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Editorial(String nombre) {
        this.nombre = nombre;
    }

    public Editorial() {
    }

    @Override
    public String toString() {
        return "Editorial{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
    
    
}
