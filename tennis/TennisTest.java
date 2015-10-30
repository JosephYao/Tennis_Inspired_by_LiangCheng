package tennis;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class TennisTest {

	Tennis tennis = new Tennis();

	private void p1TakeScores(int score) {
		while (score-- > 0)
			tennis.p1TakeScore();
	}

	private void p2TakeScores(int score) {
		while (score-- > 0)
			tennis.p2TakeScore();
	}

	private void andScoreShouldBe(String expect) {
		assertEquals(expect, tennis.scoreText());
	}

	private void equalScores(int score) {
		p1TakeScores(score);
		p2TakeScores(score);
	}

	private void duaceScores() {
		equalScores(3);
	}

	private void p2AdventageScore() {
		duaceScores();
		p2TakeScores(1);
	}

	private void p1AdventageScore() {
		duaceScores();
		p1TakeScores(1);
	}

	@Test
	public void startWithLoveAll() {
		andScoreShouldBe("Love all");
	}

	@Test
	public void fifteenLove() {
		p1TakeScores(1);

		andScoreShouldBe("Fifteen Love");
	}

	@Test
	public void thirtyLove() {
		p1TakeScores(2);

		andScoreShouldBe("Thirty Love");
	}

	@Test
	public void fourtyLove() {
		p1TakeScores(3);

		andScoreShouldBe("Fourty Love");
	}

	@Test
	public void loveFifteen() {
		p2TakeScores(1);

		andScoreShouldBe("Love Fifteen");
	}

	@Test
	public void loveThirty() {
		p2TakeScores(2);

		andScoreShouldBe("Love Thirty");
	}

	@Test
	public void equalScore() {
		equalScores(1);

		andScoreShouldBe("Fifteen all");
	}

	@Test
	public void p1TakeScoreAfterEqualScore() {
		equalScores(1);
		p1TakeScores(1);

		andScoreShouldBe("Thirty Fifteen");
	}

	@Test
	public void p2TakeScoreAfterEqualScore() {
		equalScores(1);
		p2TakeScores(1);

		andScoreShouldBe("Fifteen Thirty");
	}

	@Test
	public void duaceScore() {
		duaceScores();

		andScoreShouldBe("Duace");
	}

	@Test
	public void p1Adventage() {
		p1AdventageScore();

		andScoreShouldBe("P1 Adventage");
	}

	@Test
	public void p2Adventage() {
		p2AdventageScore();

		andScoreShouldBe("P2 Adventage");
	}

	@Test
	public void p1TakeScoreAfterP2Adventage() {
		p2AdventageScore();
		p1TakeScores(1);

		andScoreShouldBe("Duace");
	}

	@Test
	public void p2TakeScoreAfterP1Adventage() {
		p1AdventageScore();
		p2TakeScores(1);

		andScoreShouldBe("Duace");
	}

	@Test
	public void p1WinAfterAdventage() {
		p1AdventageScore();
		p1TakeScores(1);

		andScoreShouldBe("P1 Win");
	}

	@Test
	public void p2WinAfterAdventage() {
		p2AdventageScore();
		p2TakeScores(1);

		andScoreShouldBe("P2 Win");
	}

	@Test
	public void p1WinDirectly() {
		p1TakeScores(4);

		andScoreShouldBe("P1 Win");
	}

	@Test
	public void p2WinDirectly() {
		p2TakeScores(4);

		andScoreShouldBe("P2 Win");
	}
	
	@Test(expected = IllegalStateException.class)
	public void gameOver(){
		p1TakeScores(4);
		p1TakeScores(1);
	}
}