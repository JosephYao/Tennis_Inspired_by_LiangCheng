public class EqualScore implements MatchScore {

	final private TennisScore score;

	public EqualScore(TennisScore score) {
		this.score = score;
	}

	public String scoreText() {
		return score + " all";
	}

	public MatchScore nextMatchScore(Players takeScorePlayer) {
		TennisScore nextP1 = score;
		TennisScore nextP2 = score;
		if (takeScorePlayer == Players.P1)
			nextP1 = score.nextScore();
		else
			nextP2 = score.nextScore();
		return new PlayingScore(nextP1, nextP2);
	}

}
