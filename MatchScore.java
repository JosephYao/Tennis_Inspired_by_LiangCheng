interface MatchScore {
	String scoreText();

	MatchScore nextMatchScore(Players takeScorePlayer);

	default TennisScore p1() {
		return TennisScore.Love;
	};

	default TennisScore p2() {
		return TennisScore.Love;
	}

	default Players advantager() {
		return Players.P1;
	}
}