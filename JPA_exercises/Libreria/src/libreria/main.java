/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entities.Autor;
import libreria.entities.Editorial;
import libreria.entities.Libro;
import libreria.services.AutorService;
import libreria.services.EditorialService;
import libreria.services.LibroService;

/**
 *
 * @author Soso
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EditorialService es = new EditorialService();
        AutorService as = new AutorService();
        LibroService ls = new LibroService();
        
        
        try{
        
            
         
           
            
            //as.imprimirAutores();
            //as.buscarAutorPorNombre("Artaud");
            as.crearAutor("Virginia Wolf");
            as.crearAutor("Artaud");
            //as.editarAutor(1, "Artaud");
            es.crearEditorial("Pinguin");
            es.crearEditorial("Cuenco de plata");
            
            
            Autor autor2 = as.buscarAutorPorNombre("Artaud");
            Editorial editorial2 =  es.buscarEditorialPorNombre("Pinguin");
            
            System.out.println(editorial2);
            
            //ls.crearLibro("El ombligo",autor2,editorial2);
            
            Libro libro = new Libro();

           libro = ls.crearLibro("El ombligo", 1933, 5, true, as.buscarAutorPorNombre("Artaud"), es.buscarEditorialPorNombre("Pinguin"));
            System.out.println("********"); 
           System.out.println(libro);
            //ls.crearLibro("Historias de fantasmas", 1925, 5, true, as.buscarAutorPorNombre("Virginia Wolf"), es.buscarEditorialPorNombre("Pinguin"));

            //ls.buscarLibroPorISBN(1);

            //es.crearEditorial("Pinguin");

            
            
            
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
        
    }
    
}
