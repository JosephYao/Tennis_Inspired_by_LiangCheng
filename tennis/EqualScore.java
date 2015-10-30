package tennis;

public class EqualScore extends TennisScoreOnlyMatchScore {

	public EqualScore(TennisScore score) {
		super(score, score);
	}

	public String scoreText() {
		return p1() + " all";
	}

}
