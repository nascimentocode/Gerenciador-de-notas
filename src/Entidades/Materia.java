package Entidades;

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
public class Materia{
    private String nome;
    private int ano;
    private double media;
    private Nota nota = new Nota();
    private boolean status; 

    public Materia(){
    }
    
    public Materia(String aNome, int aAno){
        this.nome = aNome;
        this.ano = aAno;
    }
    
    public void setNome(String aNome){
        this.nome = aNome;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setAno(int aAno){
        this.ano = aAno;
    }
    
    public int getAno(){
        return ano;
    }
    
    public void setNota01(double aNota){
        this.nota.setNota01(aNota);
    }
     
    public double getNota01(){
        return nota.getNota01();
    }
    
    public void setNota02(double aNota){
        this.nota.setNota02(aNota);
    }
    
    public double getNota02(){
        return nota.getNota02();
    }
    
    public void setSub(double aNota){
        this.nota.setSub(aNota);
    }
    
    public double getSub(){
        return nota.getSub();
    }
    
    public void setExame(double aNota){
        this.nota.setExame(aNota);
    }
    
    public double getExame(){
        return nota.getExame();
    }
    
    public boolean getStatus(){
        return status;
    }
    
    public double getMedia(){
        return media;
    }

    public double verificarAprovacao(double aNota01, double aNota02, double aSub, double aExame){
        ArrayList<Double> listNotas = new ArrayList<>();
        listNotas.add(aNota01);
        listNotas.add(aNota02);
        listNotas.add(aSub);
        Collections.sort(listNotas, Collections.reverseOrder());
        
        media = (listNotas.get(0) + listNotas.get(1)) /2;
        if(media < 7){                       
            media = (media + aExame) /2;
        }
        if(media < 5){
            this.status = false;  
        } else {
            this.status = true;
        }
        
        return media;
//        //Verificando qual o maior e medio valor para calcular a media.
//        double maior = aNota01;
//        double medio = aNota01;
//        double menor = aNota01;
//        if(aNota02 > maior){
//            maior = aNota02;
//        }
//        if(aSub > maior){
//            maior = aSub;
//        }
//        if(aNota02 < menor){
//            menor = aNota02;
//        }
//        if(aSub < menor){
//            menor = aSub;
//        }
//        if(aNota02 < maior && aNota02 > menor){
//            medio = aNota02;
//        }
//        if(aSub < maior && aSub > menor){
//            medio = aSub;
//        }else if(aSub == aNota02){
//            medio = aSub;
//        }
//        //Depois de saber qual é o maior e medio valor, descubrimos qual a media e se essa media não for maior que 6.9, o aluno precisara do exame...
//        media = (maior + medio) /2;
//        if(media < 7){                       
//            media = (media + aExame) /2;    //...nisso calculamos a media com a nota do exame.
//        }
//        
//        //Verificando se o aluno está aprovado na materia. Se a media for menor que 5 ele está "reprovado", caso seja maior que 4.9 ele está "aprovado".
//        if(media < 5) {
//            this.status = false;  
//        } else {
//            this.status = true;
//        }
//        return media;
    }
    
    public void relatorioMateria(){
        String valorStatus;
        if(status == false){
            valorStatus = "Reprovado";
        }else{
            valorStatus = "Aprovado";
        }
        JOptionPane.showMessageDialog(null, "Matéria: " + this.nome + "\n" +
            "Ano: " + this.ano + "\n" +
            "Média: " + this.media + "\n" + 
            "Status: " + valorStatus, "Sistema - Relatório das matérias", JOptionPane.INFORMATION_MESSAGE);
    }
}
