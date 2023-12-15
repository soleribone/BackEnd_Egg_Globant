/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.util.List;
import javax.persistence.TypedQuery;
import libreria.entities.Editorial;

/**
 *
 * @author Soso
 */
public class EditorialDAO extends DAO<Editorial> {
    
    @Override
    public void guardar(Editorial editorial){
    
        super.guardar(editorial);
    
    }
    
    public void eliminar(Integer id) throws Exception{
            Editorial editorial = buscarPorId(id);
        super.eliminar(editorial);
    
    }
    
    public Editorial buscarPorId(Integer id) throws Exception{
       
        Editorial editorial = em.find(Editorial.class,id);  //como heredamos del DAO podemos usar sus ateibutos y métodos directamente (lo decía por el "em")
     
        return editorial;
        
    }
    
    public List<Editorial> listarTodos() throws Exception {
      
        List<Editorial> editoriales = em.createQuery("select e from Editorial e").getResultList();
 
        
        return editoriales;
    
    }
    
    public Editorial buscarPorNombre(String nombre) throws Exception {

        Editorial editorial = (Editorial) em.createQuery("SELECT b FROM Editorial b WHERE b.nombre = :nombre", Editorial.class).setParameter("nombre", nombre).getSingleResult();
        
      
        return editorial;

    }

    public boolean seEncuentraEnLaBase(Integer id) throws Exception{

        
        
        Editorial editorial = buscarPorId(id);
       
        boolean flag = false;

        if (editorial != null) {

            flag = true;

        }
        return flag;
    }
    
}
