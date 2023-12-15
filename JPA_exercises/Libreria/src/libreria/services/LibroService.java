/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.services;


import java.util.Collection;
import libreria.entities.Autor;
import libreria.entities.Editorial;
import libreria.entities.Libro;
import libreria.persistencia.LibroDAO;

/**
 *
 * @author Soso
 */
public class LibroService {
    
    private LibroDAO dao;

    public LibroService() {
        this.dao = new LibroDAO();
    }
    
    
     public Libro crearLibro(String titulo, Integer anio, Integer ejemplares, boolean alta, Autor autor, Editorial editorial)throws Exception{
        
         
        try{
        
        if(titulo==null || titulo.trim().isEmpty()){
            throw new Exception("Indique un nombre");
        
        }
       /*if(dao.seEncuentraEnLaBase(titulo)){
            throw new Exception("El libro ya se encuentra en la base");
        }*/
       /* if(anio==null){
            throw new Exception("Indique un año");
        }
        
        if(ejemplares==null){
            throw new Exception("Indique una cantidad de ejemplares");
        
        }*/
        if(autor==null){
            throw new Exception("Indique un autor");
        
        }
        if(editorial==null){
            throw new Exception("Indique una editorial");
        
        }
        
 
            Libro libro = new Libro();
            
            libro.setTitulo(titulo);
            libro.setAnio(anio);
           
             libro.setEjemplares(ejemplares);
          
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro.setAlta(true);
            
            
            dao.guardar(libro);
            
          return libro;
            
        }catch(Exception e){
        throw e;
        
        }
        
     }
     
     
       public void imprimirLibros() throws Exception {

        try {

            //Listamos los Fabricantes
            Collection<Libro> libros = dao.listarTodos();

            //Imprimimos los Fabricantes
            if (libros.isEmpty()) {
                throw new Exception("No existen Autores para imprimir");
            } else {
                for (Libro u : libros) {
                    System.out.println(u.getTitulo());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
     
     /*9) Búsqueda de un libro por ISBN.*/
    
    public void buscarLibroPorISBN(Integer isbn) throws Exception{
        
        try{
           if(isbn==null){
           throw new Exception("Indique un isbn");
           }        
            
           
            System.out.println(dao.buscarPorISBN(isbn));
           
            
            
        }catch(Exception e){
         throw e;
        }
    
    }
    
    /*10) Búsqueda de un libro por Título.*/
    public void busquedaPorTitulo(String titulo){
    
    try{
        if(titulo==null){
        throw new Exception("Ingrese titulo");
        }
        
        System.out.println(dao.buscarPorTitulo(titulo));
                
    } catch(Exception e){
    }
    
    
    }
    
    
    /*11) Búsquedadeunlibro/spornombredeAutor.*/
    /*12) Búsqueda de un libro/s por nombre de Editorial.*/
    
    
    
}
