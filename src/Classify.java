import java.util.Arrays;

public class Classify {

	enum ClassifyType { //list all the categories of hand with enumerated type 
		HighCard, OnePair, TwoPair, ThreeOfAKind, Straight, Flush, FullHouse, FourOfAKind, StraightFlush
	}

	private ClassifyType type;
	private String classification;
	private Rank r1 = null;
	private Rank r2 = null;
	private Rank r3 = null;
	private Rank r4 = null;
	private Rank r5 = null;

	// make the rank of the 5 cards' ranks before classifying level of hands.
	// after classifying the categories of hands in judge method, if two hands are in the same category, return to compareTo method to find the highest card in two hands.
	// we return from judge method to compareTo method by using different cases in compareTo method
	public int compareTo(Classify o) {
		int diff = type.compareTo(o.type);
		if (diff < 0) {
			return -1;
		} else if (diff > 0) {
			return 1;
		} else {
			switch (type) {
			case HighCard:
				diff = r1.compareTo(o.r1);
				if (diff < 0) {
					return -1;
				} else if (diff > 0) {
					return 1;
				} else {
					diff = r2.compareTo(o.r2);
					if (diff < 0) {
						return -1;
					} else if (diff > 0) {
						return 1;
					} else {
						diff = r3.compareTo(o.r3);
						if (diff < 0) {
							return -1;
						} else if (diff > 0) {
							diff = r4.compareTo(o.r4);
							if (diff < 0) {
								return -1;
							} else if (diff > 0) {
								return 1;
							} else {
								return checkDiff(r5.compareTo(o.r5));
							}
						}
					}
				}
			case OnePair:
				diff = r1.compareTo(o.r1);
				if (diff < 0) {
					return -1;
				} else if (diff > 0) {
					return 1;
				} else {
					diff = r2.compareTo(o.r2);
					if (diff < 0) {
						return -1;
					} else if (diff > 0) {
						return 1;
					} else {
						diff = r3.compareTo(o.r3);
						if (diff < 0) {
							return -1;
						} else if (diff > 0) {
							return checkDiff(r4.compareTo(o.r4));
						}
					}
				}
			case TwoPair:
				diff = r1.compareTo(o.r1);
				if (diff < 0) {
					return -1;
				} else if (diff > 0) {
					return 1;
				} else {
					diff = r2.compareTo(o.r2);
					if (diff < 0) {
						return -1;
					} else if (diff > 0) {
						return 1;
					} else {
						return checkDiff(r3.compareTo(o.r3));
					}
				}
			case ThreeOfAKind:
			case Straight:
			case Flush:
			case FullHouse:
			case FourOfAKind:
			case StraightFlush:
				return checkDiff(r1.compareTo(o.r1));
			}
			return 0;
		}
	}

	private int checkDiff(int diff) {
		if (diff < 0) {
			return -1;
		} else if (diff > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	// a getClassification method of return classification of level of hands
	// we will call getClassification method in judge method to return classification
	public String getClassification() {
		return classification;
	}

	private boolean straight(Card cards[]) {
		int rank1 = cards[0].getRank().ordinal();
		int rank2 = cards[1].getRank().ordinal();
		int rank3 = cards[2].getRank().ordinal();
		int rank4 = cards[3].getRank().ordinal();
		int rank5 = cards[4].getRank().ordinal();

		return (rank1 + 1 == rank2) && (rank2 + 1 == rank3)
				&& (rank3 + 1 == rank4) && (rank4 + 1 == rank5);
	}

	private boolean flush(Card cards[]) {
		boolean flag1 = cards[0].sameSuit(cards[1]);
		boolean flag2 = cards[1].sameSuit(cards[2]);
		boolean flag3 = cards[2].sameSuit(cards[3]);
		boolean flag4 = cards[3].sameSuit(cards[4]);

		return flag1 && flag2 && flag3 && flag4;
	}

	// a method StraightFlush to determine if the level of the hand is straightflush
	// we call method straight and flush in this method to determine if the level of the hand is straightflush
	private boolean straightFlush(Card cards[]) {
		if (flush(cards) && straight(cards)) {
			return true;
		}

		return false;
	}

	// a method judge to classify the categories of hands
	public void judge(Card cards[]) {
		Arrays.sort(cards);
		int length = cards.length;
		// Card -> Straight flush
		if (straightFlush(cards)) {
			type = ClassifyType.StraightFlush;
			classification = String.format("%s-high straight flush",
					cards[length - 1].getName());
			r1 = cards[length - 1].getRank();
			return;
		}

		int[] table = new int[15];
		int i = 0;
		for (; i < table.length; i++) {
			table[i] = 0;
		}

		for (i = 0; i < length; ++i) {
			table[cards[i].getRank().getValue()] += 1;
		}

		// Card -> Four of a kind
		i = 1;
		while (i < 15) {
			if (table[i] == 4) {
				type = ClassifyType.FourOfAKind;
				classification = String.format("Four %ss",
						Rank.getNameByValue(i));
				r1 = Rank.getByValue(i);
				return;
			}
			i += 1;
		}

		boolean threeCard = false;
		boolean firstTwoCard = false;
		boolean secondTwoCard = false;

		int idxOfThree = 0;
		int idxOfFirstTwo = 0;
		int idxOfSecondTwo = 0;

		i = 1;
		while (i < 15) {
			if (table[i] == 2) {
				if (!firstTwoCard) {
					firstTwoCard = true;
					idxOfFirstTwo = i;
				} else {
					secondTwoCard = true;
					idxOfSecondTwo = i;
				}
			} else if (table[i] == 3) {
				threeCard = true;
				idxOfThree = i;
			}
			++i;
		}

		String nameOfThree = Rank.getNameByValue(idxOfThree);
		String nameOfFirstTwo = Rank.getNameByValue(idxOfFirstTwo);

		// Card -> Full house
		if (threeCard && firstTwoCard) {
			type = ClassifyType.FullHouse;
			classification = String.format("%ss full of %ss", nameOfThree,
					nameOfFirstTwo);
			r1 = Rank.getByValue(idxOfThree);
			return;
		}

		String nameOfHighCard = cards[length - 1].getName();
		// Card -> Flush
		if (flush(cards)) {
			type = ClassifyType.Flush;
			classification = String.format("%s-high flush", nameOfHighCard);
			r1 = cards[length - 1].getRank();
			return;
		}

		// Card -> Straight
		if (straight(cards)) {
			type = ClassifyType.Straight;
			classification = String.format("%s-high straight", nameOfHighCard);
			r1 = cards[length - 1].getRank();
			return;
		}

		// Card -> Three of a kind
		if (threeCard) {
			type = ClassifyType.ThreeOfAKind;
			classification = String.format("Three %ss", nameOfThree);
			r1 = Rank.getByValue(idxOfThree);
			return;
		}

		// Card -> Two pair
		if (secondTwoCard) {
			type = ClassifyType.TwoPair;
			classification = String
					.format("%ss over %ss", Rank.getNameByValue(Math.max(
							idxOfFirstTwo, idxOfSecondTwo)), Rank
							.getNameByValue(Math.min(idxOfFirstTwo,
									idxOfSecondTwo)));
			r1 = Rank.getByValue(Math.max(idxOfFirstTwo, idxOfSecondTwo));
			r2 = Rank.getByValue(Math.min(idxOfFirstTwo, idxOfSecondTwo));
			for (int j = 0; j < length; ++j) {
				Rank cRank = cards[j].getRank();
				if (cRank != r1 && cRank != r2) {
					r3 = cRank;
					break;
				}
			}
			return;
		}

		// Card -> One pair
		if (firstTwoCard) {
			type = ClassifyType.OnePair;
			classification = String.format("Pair of %ss", nameOfFirstTwo);
			r1 = Rank.getByValue(idxOfFirstTwo);
			Card tmp[] = new Card[3];
			int idx = 0;
			for (int j = 0; j < length; ++j) {
				Rank cRank = cards[j].getRank();
				if (cRank != r1) {
					tmp[idx++] = cards[j];
				}
			}
			r2 = tmp[2].getRank();
			r3 = tmp[1].getRank();
			r4 = tmp[0].getRank();

			return;
		} else {
			type = ClassifyType.HighCard;
			// Card -> High card
			classification = String.format("%s-high", nameOfHighCard);
			r1 = cards[length - 1].getRank();
			r2 = cards[length - 2].getRank();
			r3 = cards[length - 3].getRank();
			r4 = cards[length - 4].getRank();
			r5 = cards[length - 5].getRank();

			return;
		}
	}
}
