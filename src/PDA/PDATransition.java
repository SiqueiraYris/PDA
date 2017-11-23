package PDA;

class PDATransition  {
	private final String letter;
	private final String pop;
	private final String push;
	private final PDAState next;

	public PDATransition(final String letter, final String pop, final String push, final PDAState next) {
		this.letter = letter;
		this.pop = pop;
		this.push = push;
		this.next = next;
	}

	public String getLetter() {
		return letter;
	}

	public String getPop() {
		return pop;
	}

	public String getPush() {
		return push;
	}

	public PDAState getNext() {
		return next;
	}
}
