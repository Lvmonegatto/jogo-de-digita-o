/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model;

import java.io.*;
import java.util.ArrayList;

public class CarregarFrase {

    public ArrayList<Frase> carregarFrases() {
        ArrayList<Frase> frases = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("frases.txt"));
            String linha;
            while((linha = br.readLine()) != null) {
                frases.add(new Frase(linha));
            }        
        } catch(Exception e) {
            System.out.println("Erro: ");
        }
        return frases;
    }
}
