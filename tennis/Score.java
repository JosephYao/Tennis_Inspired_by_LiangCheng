package tennis;

public enum Score {
	DirectlyWin(null), Fourty(DirectlyWin), Thirty(Fourty), Fifteen(Thirty), Love(Fifteen);

	Score(Score next) {
		this.next = next;
	}

	final private Score next;

	public Score nextScore() {
		return next;
	}
}
