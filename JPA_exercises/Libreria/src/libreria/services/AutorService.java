/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.services;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entities.Autor;
import libreria.persistencia.AutorDAO;

/**
 *
 * @author Soso
 */
public class AutorService {

    private final AutorDAO dao;

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");

    private final EntityManager em = emf.createEntityManager();

    public AutorService() {
        this.dao = new AutorDAO();
    }
    
    

    /*6) Crear los métodos para persistir entidades en la base de datos librería*/
    public Autor crearAutor(String nombre) throws Exception {

        try {

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Indique un nombre");

            }
           

            Autor autor = new Autor();

            autor.setNombre(nombre);
         
        
            dao.guardar(autor);

            return autor;
        } catch (Exception e) {
            throw e;

        }

    }
    
      public void imprimirAutores() throws Exception {

        try {

            //Listamos los Fabricantes
            Collection<Autor> autores = dao.listarTodos();

            //Imprimimos los Fabricantes
            if (autores.isEmpty()) {
                throw new Exception("No existen Autores para imprimir");
            } else {
                for (Autor u : autores) {
                    System.out.println(u.getNombre());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

  
/*7) Crear los métodos para dar de alta/bajo o editar dichas entidades.*/
    
    public void editarAutor(Integer id, String nombreNuevo) throws Exception{
    
        try{
            if(nombreNuevo==null || nombreNuevo.trim().isEmpty()){
                throw new Exception("Ingrese un nombre");
            }
            /*if(dao.seEncuentraEnLaBase(id)){
            throw new Exception("El libro ya se encuentra en la base");
        }*/
            
            Autor autor = dao.buscarPorId(id);
            
             if (autor.getNombre() == nombreNuevo) {
                throw new Exception("El nombre que quiere cambiar es el mismo que està en la base");
            }
            
            autor.setNombre(nombreNuevo);
            dao.editar(autor);
        
        }catch(Exception e){
            throw e;
        }
    
    
    }
    
/*8) Búsqueda de un Autor por nombre.*/
    public Autor buscarAutorPorNombre(String nombre) throws Exception{
    
        try{
          
            
            Autor autor = dao.buscarPorNombre(nombre);
            
        return autor;
        }catch(Exception e){
            throw e;
        
        }
    
    
    }
    
    
    
/*9) Búsqueda de un libro por ISBN.*/
    
  
/*10) Búsqueda de un libro por Título.*/
/*11) Búsquedadeunlibro/spornombredeAutor.*/
/*12) Búsqueda de un libro/s por nombre de Editorial.*/
      
      
      
/*13) Agregar las siguientes validaciones a todas las funcionalidades de la aplicación:
• Validar campos obligatorios.
• No ingresar datos duplicados.*/
    
    
    
    
}
