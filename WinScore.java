public class WinScore implements MatchScore {

	final private Players winner;

	public WinScore(Players winner) {
		this.winner = winner;
	}

	public String scoreText() {
		return winner + " Win";
	}

	public MatchScore nextMatchScore(Players takeScorePlayer) {
		return Tennis.scoreToNextScore.get(this.getClass()).get(takeScorePlayer).apply(this);
	}

}
