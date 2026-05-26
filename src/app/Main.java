package app;

import javax.swing.SwingUtilities;

import view.TelaFClienteFicha;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TelaFClienteFicha tela = new TelaFClienteFicha();
                tela.setVisible(true);
            }
        });
    }
}