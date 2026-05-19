/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model;

import java.io.*;

public class Score {

    public int lerScore() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("score.txt"));
            int score = Integer.parseInt(br.readLine());
            br.close();
            return score;
        } catch (Exception e) {
            return 0;
        }
    }

    public void salvarScore(int novoScore) {

        int recorde = lerScore();

        if (novoScore > recorde) {

            try {
                FileWriter fw = new FileWriter("score.txt");
                fw.write(String.valueOf(novoScore));
                fw.close();
            } catch (Exception e) {
                System.out.println("Erro");
            }
        }
    }
}
