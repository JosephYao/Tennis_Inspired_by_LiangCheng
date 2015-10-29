public class AdventageScore implements MatchScore {

	final private Players player;

	public AdventageScore(Players player) {
		this.player = player;
	}

	public String scoreText() {
		return player + " Adventage";
	}

	public MatchScore nextMatchScore(Players takeScorePlayer) {
		if (player == takeScorePlayer)
			return new WinScore(player);
		return new DuaceScore();
	}

}
