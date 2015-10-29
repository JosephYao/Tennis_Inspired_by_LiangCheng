public class Tennis {

	private MatchScore matchScore = new EqualScore(TennisScore.Love);

	public String scoreText() {
		return matchScore.scoreText();
	}

	public void p1TakeScore() {
		matchScore = matchScore.nextMatchScore(Players.P1);
	}

	public void p2TakeScore() {
		matchScore = matchScore.nextMatchScore(Players.P2);
	}

}
