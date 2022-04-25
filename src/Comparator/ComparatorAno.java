/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparator;

import Entidades.Materia;
import java.util.Comparator;

/**
 *
 * @author joaov
 */
public class ComparatorAno implements Comparator<Materia>{
    @Override
    public int compare(Materia materia01, Materia materia02) {
        if(materia01.getAno() > materia02.getAno()){
            return 1;
        }
        return -1;
    }   
}
