/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloRanking;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author yair
 */
public class RelacionesEntrantes {
     
    private   SimpleStringProperty entidad1= new SimpleStringProperty();
    
    
    
    
    private   SimpleIntegerProperty nfrecuenciaE1=new SimpleIntegerProperty();
    
 

    private  SimpleStringProperty relaciones= new SimpleStringProperty();
    
    private  SimpleIntegerProperty nfrecuenciaR1=new SimpleIntegerProperty();

     private SimpleStringProperty entidad2= new SimpleStringProperty();
    
    public RelacionesEntrantes() {
    }
    
    
    
  

    public RelacionesEntrantes(String entidad1, int nfrecuenciaE1, String relaciones, int nfrecuenciaR1, String entidad2) {
        this.entidad1 = new SimpleStringProperty(entidad1);
        this.nfrecuenciaE1 = new SimpleIntegerProperty(nfrecuenciaE1);
        this.relaciones = new SimpleStringProperty(relaciones);
        this.nfrecuenciaR1 = new SimpleIntegerProperty(nfrecuenciaR1);
        this.entidad2 = new SimpleStringProperty(entidad2);
    }

    
    
    public String getEntidad1() {
        return entidad1.get();
    }

     public SimpleStringProperty   Entidad1property(){
     
     return entidad1;
     }
     
    
    
    public void setEntidad1(String entidad1) {
        this.entidad1.set(entidad1);
    }

//
    
    public int getNfrecuenciaE1() {
        return nfrecuenciaE1.get();
    }
    
    public SimpleIntegerProperty   NfrecuenciaE1property(){
     
     return nfrecuenciaE1;
     }
    public void setNfrecuenciaE1(int nfrecuenciaE1) {
        this.nfrecuenciaE1.set(nfrecuenciaE1);
    }

//    
    
    public String getRelaciones() {
        return relaciones.get();
    }
    
    
     public SimpleStringProperty   Relacionesproperty(){
     
     return entidad1;
     }
     

    public void setRelaciones(String relaciones) {
        this.relaciones.set(relaciones);
    }

  
    //
    
    public int getNfrecuenciaR1() {
        return nfrecuenciaR1.get();
    }
    
    
     public SimpleIntegerProperty   NfrecuenciaR1property(){
     
     return nfrecuenciaR1;
     }

    public void setNfrecuenciaR1(int nfrecuenciaR1) {
        this.nfrecuenciaR1.set(nfrecuenciaR1);
    }

    //
    
    public String getEntidad2() {
        return entidad2.get();
    }

    
     public SimpleStringProperty   Entidad2property(){
     
     return entidad2;
     }
     
    
    public void setEntidad2(String entidad2) {
        this.entidad2.set(entidad2);
    }

 

   
    
    
    
    
    
    
    

    
    
}
