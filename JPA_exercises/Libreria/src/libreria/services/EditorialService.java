/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.services;

import libreria.entities.Editorial;
import libreria.persistencia.EditorialDAO;



/**
 *
 * @author Soso
 */
public class EditorialService {
    
        private EditorialDAO dao;

    public EditorialService() {
        this.dao= new EditorialDAO();
    }
        
        
        
    
     public void crearEditorial(String nombre)throws Exception{
        
        try{
        
        if(nombre==null || nombre.trim().isEmpty()){
            throw new Exception("Indique un nombre");
        
        }
        
       
            Editorial editorial = new Editorial();
            
            editorial.setNombre(nombre);
            dao.guardar(editorial);
            
                } catch (Exception e) {
            throw e;

        }
     }
        

   public Editorial buscarEditorialPorNombre(String nombre) throws Exception{
    
        try{
            
            Editorial editorial = new Editorial();
            
           editorial = dao.buscarPorNombre(nombre);
            
            return editorial;
        }catch(Exception e){
            throw e;
        
        }
    
    
   }
    
}
  
    
    
    

