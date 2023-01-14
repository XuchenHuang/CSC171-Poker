public class Driver2 {
	public static void main(String[] args) {
		// Generated two (5 card) hands for the two players
		Deck deck = new Deck();

		// Print the first hand,
		Card[] firstHand = deck.pickHand();
		System.out.println("Fisrt hand: ");
		deck.showHand(firstHand);
		System.out.println("\n");

		// then the second, then
		Card[] secondHand = deck.pickHand();
		System.out.println("Second hand: ");
		deck.showHand(secondHand);
		System.out.println("\n");

		// The remaining 42 cards in the deck.
		System.out.println("Remaining cards: ");
		deck.show();
		System.out.println("\n");
	}
}
