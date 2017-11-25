package PDA;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import javax.swing.JOptionPane;

public class PDA {

    public static final char START_CHARACTER = 'Z';

    private final Stack<String> stack;
    private final List<String> alphabet;
    private final PDAState initialState;

    public PDA(PDAState initialState, char... alphabet) {
        this.stack = new Stack<String>();
        this.alphabet = new LinkedList<String>();
        this.initialState = initialState;

        for (char character : alphabet) {
            this.alphabet.add(String.valueOf(character));
        }
    }

    public Result testWord(String word) {
        boolean valid = true;

        stack.push(String.valueOf(START_CHARACTER));

        PDAState currentState = initialState;

        System.out.println("Testando a palavra => " + word.substring(1));
        
        if (!word.startsWith("V")) {
            JOptionPane.showMessageDialog(null, "A palavra " + word + " não foi aceita, pois q0 não pode processar outro caracter além do vazio!");
            valid = false;
        }
        for (int i = 1; i < word.length(); i++) {
            String letter = String.valueOf(word.charAt(i));
            if (!alphabet.contains(letter)) {
                JOptionPane.showMessageDialog(null, "A palavra " + word.substring(1) + " não foi aceita, pois o caracter " + "'" + word.charAt(i) +"'"+ " não faz parte do alfabeto");
                valid = false;
            }
        }

        for (int i = 0; i < word.length() && valid; i++) {
            String letter = String.valueOf(word.charAt(i));

            String pop = stack.pop();

            PDATransition transition = currentState.getNext(letter, pop);

            if (transition == null) {
                System.out.println("A palavra " + word.substring(1) + " não foi aceita, pois o autômato não tem movimento previsto!");
                valid = false;
            } else {
                String push = transition.getPush();

                if (!push.isEmpty()) {
                    for (int h = 0; h < push.length(); h++) {
                        stack.push(push.substring(push.length() - 1 - (h), push.length() - h));
                    }
                }

                currentState = transition.getNext();

                System.out.println("(" + currentState.getStateName() + ", " + stack + ", " + word.substring(i) + ")");
            }
        }
        
        if(!currentState.isFinal()){
            JOptionPane.showMessageDialog(null, "A palavra " + word.substring(1) + " não foi aceita, pois não finalizou em um estado final!");
            valid = false;
        }
        
        if(stack.empty()){
            JOptionPane.showMessageDialog(null, "A palavra " + word.substring(1) + " não foi aceita, pois a pilha está vazia!");
            valid = false;
        }
        
        if(!stack.pop().equals(String.valueOf(START_CHARACTER))){
            JOptionPane.showMessageDialog(null, "A palavra " + word.substring(1) + " não foi aceita, pois a pilha não está vazia!");
            valid = false;
        }
        
        return new Result(stack, word, valid);
    }

}
