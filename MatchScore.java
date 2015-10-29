interface MatchScore {
	String scoreText();

	MatchScore nextMatchScore(Players takeScorePlayer);
}