import static org.junit.Assert.assertEquals;

class TennisChecker {
	Tennis tennis = new Tennis();

	TennisChecker p1TakeScores(int score) {
		while (score-- > 0)
			tennis.p1TakeScore();
		return this;
	}

	TennisChecker p2TakeScores(int score) {
		while (score-- > 0)
			tennis.p2TakeScore();
		return this;
	}

	void andScoreShouldBe(String expect) {
		assertEquals(expect, tennis.scoreText());
	}

	TennisChecker equalScores(int score) {
		return p1TakeScores(score).p2TakeScores(score);
	}

	TennisChecker duaceScores() {
		return equalScores(3);
	}

	TennisChecker p2AdventageScore() {
		return duaceScores().p2TakeScores(1);
	}

	TennisChecker p1AdventageScore() {
		return duaceScores().p1TakeScores(1);
	}

}