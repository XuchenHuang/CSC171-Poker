public class Driver4 {

	public static void main(String[] args) {
		// TCJcQHKDAD 3H3S3D3HAC two pairs of 10-character hands from the terminal.
		// input these two 10-character hands (TCJcQHKDAD 3H3S3D3HAC) inside the argument of run configuation

		// Your program also must be able to identify which hand \wins" given
		// two hands. You must write an additional driver program which reads
		// pairs of 10-character hands from the terminal. Each string will be of
		// the form RSRSRSRSRS where R can be any one of the set
		// (2,3,4,5,6,7,8,9,T,t,J,j,Q,q,K,k,A,a) and S can be any one of the
		// set (C,c,H,h,S,s,D,d). Your program must then classify both hands and
		// print the winner.
		Card[] firstHand = parse(args[0]);
		Card[] secondHand = parse(args[1]);

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

	private static Card[] parse(String str) {
		Card[] cards = new Card[5];
		for (int i = 0; i < 5; i++) {
			int idx = i * 2;
			Rank rank = Rank.getByName(String.valueOf(str.charAt(idx))
					.toUpperCase());
			Suit suit = Suit.getSuit(String.valueOf(str.charAt(idx + 1))
					.toUpperCase());
			cards[i] = new Card(rank, suit);
		}

		return cards;
	}
}
