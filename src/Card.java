public class Card implements Comparable<Card> { // class Card implements interface Comparable<Card> which compares different cards

	private Rank rank;
	private Suit suit;
	private boolean picked;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
		this.picked = false;
	}
	
	public String getName() {
		return rank.getName();
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public boolean sameSuit(Card o) {
		return suit.equals(o.suit);
	}

	// This isPicked method will be called later to determine whether the card is selected by each hand
	public boolean isPicked() {
		return picked;
	}
    // setter of picked
	public void setPicked(boolean picked) {
		this.picked = picked;
	}

	@Override
	public int compareTo(Card o) {
		return rank.compareTo(o.rank);
	}

	@Override
	public String toString() {
		return rank.getName() + suit.getSuit();
	}

}
