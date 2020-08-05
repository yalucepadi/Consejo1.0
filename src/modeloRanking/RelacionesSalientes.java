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
public class RelacionesSalientes {
     
    private SimpleStringProperty entidad1=  new SimpleStringProperty();
    
    private  SimpleIntegerProperty nfrecuenciaE2= new SimpleIntegerProperty();

    private SimpleStringProperty relaciones=  new SimpleStringProperty();
    
    private  SimpleIntegerProperty nfrecuenciaR2= new SimpleIntegerProperty();
    
    private SimpleStringProperty entidad2=  new SimpleStringProperty();

    public RelacionesSalientes() {
    }
    
    
    public RelacionesSalientes(String entidad1, int nfrecuenciaE2, String relaciones, int nfrecuenciaR2, String entidad2) {
        this.entidad1 = new SimpleStringProperty(entidad1);
        this.nfrecuenciaE2 = new SimpleIntegerProperty(nfrecuenciaE2);
        this.relaciones = new SimpleStringProperty(relaciones);
        this.nfrecuenciaR2 = new SimpleIntegerProperty(nfrecuenciaR2);
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
    
    public int getNfrecuenciaE2() {
        return nfrecuenciaE2.get();
    }
    
    public SimpleIntegerProperty   NfrecuenciaE1property(){
     
     return nfrecuenciaE2;
     }
    public void setNfrecuenciaE2(int nfrecuenciaE2) {
        this.nfrecuenciaE2.set(nfrecuenciaE2);
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
    
    public int getNfrecuenciaR2() {
        return nfrecuenciaR2.get();
    }
    
    
     public SimpleIntegerProperty   NfrecuenciaR2property(){
     
     return nfrecuenciaR2;
     }

    public void setNfrecuenciaR2(int nfrecuenciaR2) {
        this.nfrecuenciaR2.set(nfrecuenciaR2);
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
