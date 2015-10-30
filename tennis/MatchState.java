package tennis;

interface MatchState {
	String scoreText();

	Score p1();

	Score p2();

	Player advantager();
}