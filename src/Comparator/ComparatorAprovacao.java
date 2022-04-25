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
public class ComparatorAprovacao implements Comparator<Materia>{

    @Override
    public int compare(Materia materia01, Materia materia02) {
        //1 = primeiro
        //-1 = depois
        if(materia01.getStatus() == true && materia02.getStatus() == false){
            return -1;
        }
        return 1;
    }
        
}
