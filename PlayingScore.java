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

	public MatchScore nextMatchScore(Players takeScorePlayer) {
		return Tennis.scoreToNextScore.get(this.getClass()).get(takeScorePlayer).apply(this);
	}

	private boolean isDuaceScore(TennisScore nextP1, TennisScore nextP2) {
		return nextP1 == nextP2 && nextP1 == TennisScore.Fourty;
	}

	private boolean isSomeOneWin(TennisScore nextP1, TennisScore nextP2) {
		return nextP1 == TennisScore.DirectlyWin || nextP2 == TennisScore.DirectlyWin;
	}

}