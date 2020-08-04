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
     
    private StringProperty entidad1=  new SimpleStringProperty();
    
    private  IntegerProperty nfrecuenciaEntidad1= new SimpleIntegerProperty();

    private StringProperty relaciones=  new SimpleStringProperty();
    
    private  IntegerProperty nfrecuenciaRelacion1= new SimpleIntegerProperty();
    
    private StringProperty entidad2=  new SimpleStringProperty();

    public String getEntidad1() {
        return entidad1.get();
    }

    public void setEntidad1(String entidad1) {
        this.entidad1.set(entidad1);
    }

    public int getnfrecuenciaEntidad1() {
        return nfrecuenciaEntidad1.get();
    }

    public void setnFrecuenciaEntidad1(int nfrecuenciaEntidad1) {
        this.nfrecuenciaEntidad1.set(nfrecuenciaEntidad1);
    }

    public String getRelaciones() {
        return relaciones.get();
    }

    public void setRelaciones(String relaciones) {
        this.relaciones.set(relaciones);
    }

    public int getnFrecuenciaRelacion1() {
        return nfrecuenciaRelacion1.get();
    }

    public void setnFrecuenciaRelacion1(int nfrecuenciaRelacion1) {
        this.nfrecuenciaRelacion1.set(nfrecuenciaRelacion1);
    }

    public String getEntidad2() {
        return entidad2.get();
    }

    public void setEntidad2(String entidad2) {
        this.entidad2.set(entidad2);
    }

    
    
    
    
    
    

    
    
}
