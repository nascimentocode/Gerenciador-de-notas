package Entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaov
 */
public class Nota{
    private double nota01;
    private double nota02;
    private double sub;
    private double exame;
    
    public Nota(){
    }
    
    public void setNota01(double aNota){
        this.nota01 = aNota;
    }
    
    public double getNota01(){
        return nota01;
    }
    
    public void setNota02(double aNota){
        this.nota02 = aNota;
    }
    
    public double getNota02(){
        return nota02;
    }
    
    public void setSub(double aNota){
        this.sub = aNota;
    }
    
    public double getSub(){
        return sub;
    }
    
    public void setExame(double aNota){
        this.exame = aNota;
    }
    
    public double getExame(){
        return exame;
    }
}
