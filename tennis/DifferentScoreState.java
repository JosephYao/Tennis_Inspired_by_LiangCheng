package tennis;

public class DifferentScoreState extends TennisScoreOnlyMatchState {

	public DifferentScoreState(Score p1, Score p2) {
		super(p1, p2);
	}

	public String scoreText() {
		return String.format("%s %s", p1Score(), p2Score());
	}

}