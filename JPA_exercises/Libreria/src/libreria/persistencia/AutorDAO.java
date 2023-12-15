/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.util.List;
import javax.persistence.TypedQuery;
import libreria.entities.Autor;

/**
 *
 * @author Soso
 */
public class AutorDAO extends DAO<Autor>{
    
    @Override
    public void guardar(Autor autor){
        super.guardar(autor);
    }
    
    public void eliminar(Integer id) throws Exception{ //los métodos del EntityManager lanzan Exception
       Autor autor = buscarPorId(id);
       super.eliminar(autor);
    
    }
    
    
    @Override
    public void editar(Autor autor){
        
        super.editar(autor);
        
        
    }
    
    public Autor buscarPorId(Integer id) throws Exception{
   
    Autor autor = em.find(Autor.class,id);  //Autor.class significa "de la tabla autor, buscar autor por id
                                            //recordemos que las clases en JPA son entidades, y las entidades son tablas.
    
    return autor;
    }
    
    
    public Autor buscarPorNombre(String nombre) throws Exception {

        TypedQuery<Autor> nombresAutores = em.createQuery("SELECT b FROM Autor b WHERE b.nombre = :nombre", Autor.class).setParameter("nombre", nombre);

        
        System.out.println(nombresAutores);
        Autor autor = nombresAutores.getSingleResult();

        return autor;

    }
    
    
    
    public List<Autor> listarTodos() throws Exception{
       
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a").getResultList(); //getResultList, te devuelve la consulta en formato lista               
       
        return autores;
    }

    public boolean seEncuentraEnLaBase(Integer id) throws Exception{

        
        
        Autor autor = buscarPorId(id);
        
        boolean flag = false;

        if (autor != null) {

            flag = true;

        }
        return flag;
    }

}
