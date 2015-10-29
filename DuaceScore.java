public class DuaceScore implements MatchScore {

	public String scoreText() {
		return "Duace";
	}

	public MatchScore nextMatchScore(Players takeScorePlayer) {
		return new AdventageScore(takeScorePlayer);
	}

}
