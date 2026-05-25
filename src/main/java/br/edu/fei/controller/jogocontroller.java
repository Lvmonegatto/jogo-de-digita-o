/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.controller;

import br.edu.fei.model.Frase;
import br.edu.fei.model.CarregarFrase;
import br.edu.fei.model.Score;
import br.edu.fei.view.TelaDigitacao;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class jogocontroller {

    private TelaDigitacao tela;

    private ArrayList<Frase> frases;

    private int indice = 0;
    private int score = 0;

    public jogocontroller() {

        tela = new TelaDigitacao();

        tela.setController(this);

        CarregarFrase dao = new CarregarFrase();

        frases = dao.carregarFrases();

        mostrarFrase();

        tela.setVisible(true);
    }

    public void mostrarFrase() {

        if (indice < frases.size()) {
            tela.getFraseLabel().setText(frases.get(indice).getTexto());
            tela.getTextoDigitadoArea().setText("");
        } else {
            finalizar();
        }
    }

    public void verificar() {

        String digitado = tela.getTextoDigitadoArea().getText();
        if (frases.get(indice).comparar(digitado)) {
            JOptionPane.showMessageDialog(tela,"Correta");
            score++;
        } else {
            JOptionPane.showMessageDialog(tela,"Errada");
        }
        indice++;
        mostrarFrase();
    }

    public void finalizar() {
        Score sc = new Score();
        sc.salvarScore(score);
        JOptionPane.showMessageDialog(tela,"Score: " + score+ "\nRecorde: " + sc.lerScore());
        tela.dispose();
    }
}
