public class Driver1 {

	public static void main(String[] args) {
		// Generate a new in-order deck,
		Deck deck = new Deck();

		// Print an entire deck (and therefore any card).
		System.out.println("Before shuffle: ");
		deck.show();
		System.out.println();

		// Shuffle the deck into a random order.
		deck.shuffle();
		// Print an entire deck (and therefore any card).
		System.out.println("After shuffle: ");
		deck.show();
		System.out.println();
	}
}
