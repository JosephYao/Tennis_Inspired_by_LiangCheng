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

}
