public class WinScore implements MatchScore {

	final private Players winner;

	public WinScore(Players winner) {
		this.winner = winner;
	}

	public String scoreText() {
		return winner + " Win";
	}

}
