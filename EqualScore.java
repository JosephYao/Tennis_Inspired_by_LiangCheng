public class EqualScore implements MatchScore {

	final private TennisScore score;

	@Override
	public TennisScore p2() {
		return score;
	}

	@Override
	public TennisScore p1() {
		return score;
	}

	public EqualScore(TennisScore score) {
		this.score = score;
	}

	public String scoreText() {
		return score + " all";
	}

	public MatchScore nextMatchScore(Players takeScorePlayer) {
		return Tennis.scoreToNextScore.get(this.getClass()).get(takeScorePlayer).apply(this);
	}

}
