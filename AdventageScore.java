public class AdventageScore implements MatchScore {

	final private Players player;

	public AdventageScore(Players player) {
		this.player = player;
	}

	public String scoreText() {
		return player + " Adventage";
	}

	@Override
	public Players advantager() {
		return player;
	}

	public MatchScore nextMatchScore(Players takeScorePlayer) {
		return Tennis.scoreToNextScore.get(this.getClass()).get(takeScorePlayer).apply(this);
	}

}
