public enum TennisScore {
	DirectlyWin(null), Fourty(DirectlyWin), Thirty(Fourty), Fifteen(Thirty), Love(Fifteen);

	private TennisScore(TennisScore next) {
		this.next = next;
	}

	final private TennisScore next;

	public TennisScore nextScore() {
		return next;
	}
}
