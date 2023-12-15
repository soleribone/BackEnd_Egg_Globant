/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.util.List;
import javax.persistence.TypedQuery;
import libreria.entities.Autor;
import libreria.entities.Libro;

/**
 *
 * @author Soso
 */
public class LibroDAO extends DAO<Libro> {
    
    @Override
    public void guardar(Libro libro){
    
        super.guardar(libro);
    
    }
    
    public void eliminar(Integer id) throws Exception{
            Libro libro = buscarPorId(id);
        super.eliminar(libro);
    
    }
    
    public Libro buscarPorId(Integer id) throws Exception{
       
        Libro libro = em.find(Libro.class,id);  //como heredamos del DAO podemos usar sus ateibutos y métodos directamente (lo decía por el "em")
        
        return libro;
        
    }
    
    public List<Libro> listarTodos() throws Exception {
        
        List<Libro> libros = em.createQuery("select e from Libro e").getResultList();
       
        
        return libros;
    
    }
    
    public Libro buscarPorISBN(Integer isbn){
    
        Libro libro = em.find(Libro.class,isbn);
        
        return libro;
    
  
    }
    
    public Libro buscarPorTitulo(String titulo) throws Exception{
    
       
        TypedQuery<Libro> titulos = em.createQuery("SELECT b FROM Libro b WHERE b.titulo = :titulo", Libro.class).setParameter("titulo", titulo);

     
        Libro libro = titulos.getSingleResult();
        
        return libro;
    
    
    }
    
    
        public boolean seEncuentraEnLaBase(String titulo) {

        Libro libro = (Libro) em.createQuery("Select a from Libro a where a.libro = ' " + titulo + " ' ").getResultList().get(0);

        boolean flag = false;

           
        if (libro != null) {

            flag = true;

        }
        return flag;
    }
    
}
