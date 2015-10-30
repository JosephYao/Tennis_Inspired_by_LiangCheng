public class DuaceScore implements MatchScore {

	public String scoreText() {
		return "Duace";
	}

	public MatchScore nextMatchScore(Players takeScorePlayer) {
		return Tennis.scoreToNextScore.get(this.getClass()).get(takeScorePlayer).apply(this);
	}

}
