package Entidades;

import Comparator.ComparatorAno;
import Comparator.ComparatorAprovacao;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaov
 */
public class Historico{
    private ArrayList<Materia> materias = new ArrayList<>();
    private double mediaMaterias;
    
    public void adicionarMaterias(Materia aMateria){
        materias.add(aMateria);
    }
    
    public void listarMateria(){
        for (Materia materia: materias){
            materia.relatorioMateria();
        }
    }
    
    public void listarMateriaAno(int aAno) {
        boolean haveMateria = false;
        for(Materia materia: materias){
            if (aAno == materia.getAno()){
                haveMateria = true;
                materia.relatorioMateria();
            }
        }
        if(! haveMateria){
            JOptionPane.showMessageDialog(null, "Nao existe materia com esse ano", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//    public void listarMateriaAno2() {
//        Collections.sort(materias, new ComparatorAno());
//        for(Materia materia: materias){
//            materia.relatorioMateria();
//        }
//    }
    
//    public void listarMateriaAprovacao2(){
//        Collections.sort(materias, new ComparatorAprovacao());
//        for(Materia materia: materias){
//            materia.relatorioMateria();
//        }
//    }
    
    public void listarMateriaAprovacao(boolean aAprovacao){
        for (Materia materia: materias){
            if (aAprovacao == materia.getStatus()){
                materia.relatorioMateria();
            }
        }
    }
    
    public String verificarMaiorMateria(){
        double maior = 0;
        String materiaMaior = "";
        for(Materia materia: materias){
            if(materia.getMedia() > maior){
                maior = materia.getMedia();
                materiaMaior = materia.getNome();
            }
            
        }
        return materiaMaior;
    }
    
    public String verificarMenorMateria(){
        double menor = 10;
        String materiaMenor = "";
        for(Materia materia: materias){
            if(materia.getMedia() <= menor){
                menor = materia.getMedia();
                materiaMenor = materia.getNome();
            }
        }
        return materiaMenor;
    }
    
    public double calcularMediaMaterias(){
        double media = 0;
        for(Materia materia: materias){
            media += materia.getMedia();
        }
        mediaMaterias = media / materias.size();
        
        return mediaMaterias;
    } 

    public void relatorio(){
        listarMateria();
        JOptionPane.showMessageDialog(null, 
            "Maior média de todas as matérias: " + verificarMaiorMateria() + "\n" + 
            "Menor média de todas as matérias: " + verificarMenorMateria() + "\n" +
            "Coeficiente de rendimento: " + this.mediaMaterias, "Sistema - Relatório das matérias", JOptionPane.INFORMATION_MESSAGE);
    }
}
