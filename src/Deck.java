import java.util.Random;

public class Deck {
	public static final int NUM = 52;
	public static final int ONE_HAND = 5;

	private Card[] cards = new Card[NUM];
	private Random rand = new Random();

	public Deck() {
		generate(); //call method generate to generate new deck with cards inside
	}

	//create a new deck with rank and suit
	private void generate() {
		int idx = 0;
		for (Suit suit : Suit.values()) { // using for-each loop to put suit and rank inside each card in the array
			for (Rank rank : Rank.values()) {
				cards[idx++] = new Card(rank, suit);
			}
		}
	}

   
	public Card[] pickHand() {
		Card[] results = new Card[ONE_HAND];
		shuffle();
		for (int i = 0; i < ONE_HAND; i++) {
			while (true) {
				int num = rand.nextInt(NUM);
				if (!cards[num].isPicked()) {
					results[i] = cards[num];
					cards[num].setPicked(true);
					break;
				}
			}
		}

		return results;
	}

	public void shuffle() {
		for (int i = NUM; i > 0; i--) {
			int num = rand.nextInt(i);
			swapCards(num, i - 1);
		}
	}

	public void showHand(Card[] hands) {
		for (int i = 0; i < hands.length; ++i) {
			System.out.print(hands[i] + " ");
		}
	}

	public void show() {
		int count = 0;
		for (int i = 0; i < NUM; ++i) {
			if (!cards[i].isPicked()) {
				System.out.print(cards[i] + " ");
				++count;
				if (count == 13) {
					System.out.println();
					count = 0;
				}
			}
		}
	}

	private void swapCards(int i, int j) {
		Card temp = cards[i];
		cards[i] = cards[j];
		cards[j] = temp;
	}

}
