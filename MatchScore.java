interface MatchScore {
	String scoreText();

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