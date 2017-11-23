package PDA;

import java.util.LinkedList;
import java.util.List;

public class PDAState {

    private String stateName;

    private boolean isFinal = false;

    private List<PDATransition> transitions;

    public PDAState(String stateName) {
        this.transitions = new LinkedList<PDATransition>();
        this.stateName = stateName;
    }

    public PDAState addTransition(String letter, String pop, String push, PDAState next) {
        transitions.add(new PDATransition(letter, pop, push, next));
        return this;
    }
    
    public PDATransition getNext(String letter, String pop) {
        for (PDATransition transition : transitions) {
            if (transition.getLetter().equals(letter) && transition.getPop().equals(pop)) {
                return transition;
            }
        }

        return null;
    }

    public String getStateName() {
        return this.stateName;
    }

    public void setFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    public void setFinal() {
        this.isFinal = true;
    }

    public boolean isFinal() {
        return this.isFinal;
    }
}
