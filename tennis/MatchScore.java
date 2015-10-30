package tennis;

interface MatchScore {
	String scoreText();

	TennisScore p1();

	TennisScore p2();

	Players advantager();
}