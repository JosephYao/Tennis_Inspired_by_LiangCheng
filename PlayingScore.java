public class PlayingScore extends TennisScoreOnlyMatchScore {

	public PlayingScore(TennisScore p1, TennisScore p2) {
		super(p1, p2);
	}

	public String scoreText() {
		return String.format("%s %s", p1(), p2());
	}

}