package br.com.cod3r.cm.visao;

import br.com.cod3r.cm.modelo.Tabuleiro;

import javax.swing.*;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {
    private Score score = new Score();

    public TelaPrincipal() {
        Tabuleiro tabuleiro = new Tabuleiro(16, 30, 50);

        add(new PainelTabuleiro(tabuleiro));

        setTitle("Campo Minado");
        setSize(690, 438);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        tabuleiro.registrarObservador(e -> {
            SwingUtilities.invokeLater(() -> {
                if (e.isGanhou()) {
                    score.incrementWins();
                    JOptionPane.showMessageDialog(this, "Ganhou :) \n" +
                            "Wins: " + score.getWins() + ", Losses: " + score.getLosses());
                } else {
                    score.incrementLosses();
                    JOptionPane.showMessageDialog(this, "Perdeu :( \n" +
                            "Wins: " + score.getWins() + ", Losses: " + score.getLosses());
                }
                tabuleiro.reiniciar();
            });
        });
    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }
}
