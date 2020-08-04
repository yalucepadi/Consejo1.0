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
     
    private StringProperty entidad1=  new SimpleStringProperty();
    
    private  IntegerProperty nfrecuenciaEntidad2= new SimpleIntegerProperty();

    private StringProperty relaciones=  new SimpleStringProperty();
    
    private  IntegerProperty nfrecuenciaRelacion2= new SimpleIntegerProperty();
    
    private StringProperty entidad2=  new SimpleStringProperty();

    public String getEntidad1() {
        return entidad1.get();
    }

    public void setEntidad1(String entidad1) {
        this.entidad1.set(entidad1);
    }

    public int getnfrecuenciaEntidad2() {
        return nfrecuenciaEntidad2.get();
    }

    public void setnFrecuenciaEntidad2(int nfrecuenciaEntidad1) {
        this.nfrecuenciaEntidad2.set(nfrecuenciaEntidad1);
    }

    public String getRelaciones() {
        return relaciones.get();
    }

    public void setRelaciones(String relaciones) {
        this.relaciones.set(relaciones);
    }

    public int getnFrecuenciaRelacion2() {
        return nfrecuenciaRelacion2.get();
    }

    public void setnFrecuenciaRelacion2(int nfrecuenciaRelacion2) {
        this.nfrecuenciaRelacion2.set(nfrecuenciaRelacion2);
    }

    public String getEntidad2() {
        return entidad2.get();
    }

    public void setEntidad2(String entidad2) {
        this.entidad2.set(entidad2);
    }

    
    
    
    
    
    

    
    
}
