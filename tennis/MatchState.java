package tennis;

interface MatchState {
	String scoreText();

	Score p1Score();

	Score p2Score();

	Player advantager();
}