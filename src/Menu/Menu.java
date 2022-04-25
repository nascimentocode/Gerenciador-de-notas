package Menu;

import Entidades.Materia;
import Entidades.Historico;

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
public class Menu {
    public static void menu(){
        Historico historico = new Historico();
        
        String[] opcoes = {"1", "2", "3", "4", "Sair"};
        int menu = -1;
        while(menu != 4){
            try {
                menu = JOptionPane.showOptionDialog(null,
                    "Escolha uma opção: " + "\n\n" +
                    "1- Cadastrar matéria" + "\n" +
                    "2- Listar todas as matérias" + "\n" +
                    "3- Listar as matérias por ano" + "\n" +
                    "4- Listar as matérias por aprovação", "Sistema - Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, null);
                switch(menu){
                    case 0:
                        int qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade de matérias que você deseja cadastrar: ", "Sistema - Cadastro de materia", JOptionPane.QUESTION_MESSAGE));
                        for(int i = 0; i < qtd; i++){
                            Materia materia = new Materia();
                            materia.setNome(JOptionPane.showInputDialog(null, "Nome da matéria: ", "Sistema - Materia " + Integer.toString(i+1), JOptionPane.QUESTION_MESSAGE));
                            materia.setAno(Integer.parseInt(JOptionPane.showInputDialog(null, "Ano da matéria: ", "Sistema - Materia " + Integer.toString(i+1), JOptionPane.QUESTION_MESSAGE)));
                            materia.setNota01(Double.parseDouble(JOptionPane.showInputDialog(null, "Nota 01: ", "Sistema - Materia " + Integer.toString(i+1), JOptionPane.QUESTION_MESSAGE)));
                            materia.setNota02(Double.parseDouble(JOptionPane.showInputDialog(null, "Nota 02: ", "Sistema - Materia " + Integer.toString(i+1), JOptionPane.QUESTION_MESSAGE)));
                            materia.setSub(Double.parseDouble(JOptionPane.showInputDialog(null, "Nota Sub: ", "Sistema - Materia " + Integer.toString(i+1), JOptionPane.QUESTION_MESSAGE)));
                            materia.setExame(Double.parseDouble(JOptionPane.showInputDialog(null, "Nota Exame: ", "Sistema - Materia " + Integer.toString(i+1), JOptionPane.QUESTION_MESSAGE)));
                            materia.verificarAprovacao(materia.getNota01(), materia.getNota02(), materia.getSub(), materia.getExame());
                            historico.adicionarMaterias(materia);      
                        }
                        break;
                    case 1:
                        historico.calcularMediaMaterias();
                        historico.relatorio();
                        break;      
                    case 2:
                        int anoMateria = Integer.parseInt(JOptionPane.showInputDialog(null, "Ano da matéria: ", "Sistema - Relatorio das matérias", JOptionPane.QUESTION_MESSAGE));
                        historico.listarMateriaAno(anoMateria);
                        break;
                    case 3:
//                        historico.listarMateriaAprovacao2();
                        String[] opcaoAprovacao = {"Aprovado", "Reprovado"};
                        int menuAprovacao = JOptionPane.showOptionDialog(null,
                            "Exibir matérias: " + "\n", "Sistema - Relatorio das matérias", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcaoAprovacao, null);
                        switch(menuAprovacao){
                            case 0:
                                historico.listarMateriaAprovacao(true);
                                break;
                            case 1:
                                historico.listarMateriaAprovacao(false);
                                break;
                        }
                        break;
                    case 4:
                        System.exit(0); 
                        break;
                }   
            }catch(NumberFormatException e){
                
            }
        }
    }
}
