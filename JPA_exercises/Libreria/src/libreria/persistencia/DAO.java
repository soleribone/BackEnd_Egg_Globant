package libreria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public abstract class DAO <T>{
    
    //<T> esto convierte la clase abstracta en genérica,la T se sobre escribe con el objeto con el que se va a usar. 
   
    
   protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
   //esto es para conectarse a la base de datos y va acá por eso
   //final para que no se modifique
   
   protected EntityManager em = emf.createEntityManager();
   //ahora todos los métodos usan este manager
 
    
    
    protected void guardar(T objeto){
   
    em.getTransaction().begin();
    em.persist(objeto);
    em.getTransaction().commit();
    
     
    }
    
    protected void editar(T objeto){
  
    em.getTransaction().begin();
    em.merge(objeto);
    em.getTransaction().commit();
  
    
    }
    
    protected void eliminar(T objeto){

    em.getTransaction().begin();
    em.remove(objeto);
    em.getTransaction().commit();
  
    }
   
    
    
}
