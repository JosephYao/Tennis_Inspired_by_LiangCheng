package tennis;

public class DrawState extends TennisScoreOnlyMatchState {

	public DrawState(Score score) {
		super(score, score);
	}

	public String scoreText() {
		return p1Score() + " all";
	}

}
