package PDA;

import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author SIQUEIRA
 */
public class Main {

    public static void main(String[] args) {

        PDAState q0 = new PDAState("q0");
        PDAState q1 = new PDAState("q1");
        PDA pda = new PDA(q0, 'a', 'b', 'c', 'd', 'e', 'f');
        q1.setFinal();
        //V -> variavel para o vazio
        
        q0.addTransition("V", "Z", "SZ", q1); //inicial
        q1.addTransition("", "Z", "", q1); //final
        q1.addTransition("a", "S", "H", q1);
        q1.addTransition("b", "A", "I", q1);
        q1.addTransition("c", "A", "J", q1);
        q1.addTransition("c", "B", "J", q1);
        q1.addTransition("f", "C", "FF", q1);
        q1.addTransition("e", "D", "G", q1);
        q1.addTransition("d", "E", "", q1);
        q1.addTransition("f", "F", "", q1);
        q1.addTransition("e", "G", "", q1);
        q1.addTransition("f", "H", "FF", q1);
        q1.addTransition("a", "H", "HC", q1);
        q1.addTransition("b", "H", "IC", q1);
        q1.addTransition("c", "H", "JC", q1);
        q1.addTransition("e", "I", "G", q1);
        q1.addTransition("b", "I", "ID", q1);
        q1.addTransition("c", "I", "JD", q1);
        q1.addTransition("d", "J", "", q1);
        q1.addTransition("c", "J", "JE", q1);

        String word = JOptionPane.showInputDialog("Digite uma palavra: ");
        
        if (pda.testWord("V" + word).isValid()) {
            JOptionPane.showMessageDialog(null, "A palavra " + word + " foi aceita");
        } else {
            JOptionPane.showMessageDialog(null, "A palavra " + word + " não foi aceita");
        }
    }

}
