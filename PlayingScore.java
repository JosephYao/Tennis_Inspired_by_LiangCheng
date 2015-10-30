public class PlayingScore implements MatchScore {

	final private TennisScore p1;
	final private TennisScore p2;

	@Override
	public TennisScore p2() {
		return p2;
	}

	@Override
	public TennisScore p1() {
		return p1;
	}

	public PlayingScore(TennisScore p1, TennisScore p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public String scoreText() {
		return String.format("%s %s", p1, p2);
	}

}