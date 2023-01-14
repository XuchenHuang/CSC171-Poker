public class Driver3 {
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

		Classify classifyFirst = new Classify();
		classifyFirst.judge(firstHand);

		Classify classifySecond = new Classify();
		classifySecond.judge(secondHand);

		System.out.println("Classify of first hand: "
				+ classifyFirst.getClassification());

		System.out.println("Classify of second hand: "
				+ classifySecond.getClassification());

		System.out.println();
		int result = classifyFirst.compareTo(classifySecond);
		if (result == -1) {
			System.out.println("Second player wins!");
		} else if (result == 1) {
			System.out.println("First player wins!");
		} else {
			System.out.println("It is a draw!");
		}
	}
}
