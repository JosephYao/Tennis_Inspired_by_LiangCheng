public class PlayingScore implements MatchScore {

	final private TennisScore p1;
	final private TennisScore p2;

	public PlayingScore(TennisScore p1, TennisScore p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public String scoreText() {
		return String.format("%s %s", p1, p2);
	}

	public MatchScore nextMatchScore(Players takeScorePlayer) {
		TennisScore nextP1 = takeScorePlayer == Players.P1 ? p1.nextScore() : p1;
		TennisScore nextP2 = takeScorePlayer == Players.P1 ? p2 : p2.nextScore();

		if (isSomeOneWin(nextP1, nextP2))
			return new WinScore(takeScorePlayer);
		if (isDuaceScore(nextP1, nextP2))
			return new DuaceScore();
		if (nextP1 == nextP2)
			return new EqualScore(nextP1);
		return new PlayingScore(nextP1, nextP2);
	}

	private boolean isDuaceScore(TennisScore nextP1, TennisScore nextP2) {
		return nextP1 == nextP2 && nextP1 == TennisScore.Fourty;
	}

	private boolean isSomeOneWin(TennisScore nextP1, TennisScore nextP2) {
		return nextP1 == TennisScore.DirectlyWin || nextP2 == TennisScore.DirectlyWin;
	}

}