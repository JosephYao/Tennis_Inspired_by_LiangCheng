package tennis;

public class EqualState extends TennisScoreOnlyMatchState {

	public EqualState(Score score) {
		super(score, score);
	}

	public String scoreText() {
		return p1() + " all";
	}

}
