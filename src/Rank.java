public enum Rank { //list all the ranks of the card with enumerated type

	TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"), SEVEN(
			7, "7"), EIGHT(8, "8"), NINE(9, "9"), TEN(10, "T"), JACK(11, "J"), QUEEN(
			12, "Q"), KING(13, "K"), ACE(1, "A");

	private final int value;
	private final String name;
	
	// Constructor of rank
	// The constructor inside the rank should be private since the initialization of the enumerated type is done in the current enumeration class.
	private Rank(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	
	public static Rank getByName(String name) {
		for (Rank rank : values()) {
			if (rank.getName().equals(name)) {
				return rank;
			}
		}

		return null;
	}

	public static String getNameByValue(int value) {
		for (Rank rank : values()) {
			if (value == rank.getValue()) {
				return rank.getName();
			}
		}

		return null;
	}

	public static Rank getByValue(int value) {
		for (Rank rank : values()) {
			if (rank.getValue() == value) {
				return rank;
			}
		}

		return null;
	}

	public String getName() {
		return name;
	}

}
