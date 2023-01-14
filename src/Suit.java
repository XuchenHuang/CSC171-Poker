public enum Suit {
	Clubs("C"), Diamonds("D"), Hearts("H"), Spades("S");

	private final String suit;

	private Suit(String suit) {
		this.suit = suit;
	}

	public static Suit getSuit(String s) {
		String sUpper = s.toUpperCase();
		for (Suit suit : values()) {
			if (sUpper.equals(suit.getSuit())) {
				return suit;
			}
		}

		return null;
	}

	public String getSuit() {
		return suit;
	}

}