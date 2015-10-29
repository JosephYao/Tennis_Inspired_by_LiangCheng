import org.junit.*;

public class TennisTest {

	TennisChecker tennisCheckec = new TennisChecker();

	@Test
	public void startWithLoveAll() {
		tennisCheckec.andScoreShouldBe("Love all");
	}

	@Test
	public void fifteenLove() {
		tennisCheckec.p1TakeScores(1).andScoreShouldBe("Fifteen Love");
	}

	@Test
	public void thirtyLove() {
		tennisCheckec.p1TakeScores(2).andScoreShouldBe("Thirty Love");
	}

	@Test
	public void fourtyLove() {
		tennisCheckec.p1TakeScores(3).andScoreShouldBe("Fourty Love");
	}

	@Test
	public void loveFifteen() {
		tennisCheckec.p2TakeScores(1).andScoreShouldBe("Love Fifteen");
	}

	@Test
	public void loveThirty() {
		tennisCheckec.p2TakeScores(2).andScoreShouldBe("Love Thirty");
	}

	@Test
	public void equalScore() {
		tennisCheckec.equalScores(1).andScoreShouldBe("Fifteen all");
	}

	@Test
	public void p1TakeScoreAfterEqualScore() {
		tennisCheckec.equalScores(1).p1TakeScores(1).andScoreShouldBe("Thirty Fifteen");
	}

	@Test
	public void p2TakeScoreAfterEqualScore() {
		tennisCheckec.equalScores(1).p2TakeScores(1).andScoreShouldBe("Fifteen Thirty");
	}

	@Test
	public void duaceScore() {
		tennisCheckec.duaceScores().andScoreShouldBe("Duace");
	}

	@Test
	public void p1Adventage() {
		tennisCheckec.p1AdventageScore().andScoreShouldBe("P1 Adventage");
	}

	@Test
	public void p2Adventage() {
		tennisCheckec.p2AdventageScore().andScoreShouldBe("P2 Adventage");
	}

	@Test
	public void p1TakeScoreAfterP2Adventage() {
		tennisCheckec.p2AdventageScore().p1TakeScores(1).andScoreShouldBe("Duace");
	}

	@Test
	public void p2TakeScoreAfterP1Adventage() {
		tennisCheckec.p1AdventageScore().p2TakeScores(1).andScoreShouldBe("Duace");
	}

	@Test
	public void p1WinAfterAdventage() {
		tennisCheckec.p1AdventageScore().p1TakeScores(1).andScoreShouldBe("P1 Win");
	}

	@Test
	public void p2WinAfterAdventage() {
		tennisCheckec.p2AdventageScore().p2TakeScores(1).andScoreShouldBe("P2 Win");
	}

	@Test
	public void p1WinDirectly() {
		tennisCheckec.p1TakeScores(4).andScoreShouldBe("P1 Win");
	}

	@Test
	public void p2WinDirectly() {
		tennisCheckec.p2TakeScores(4).andScoreShouldBe("P2 Win");
	}
	
	@Test(expected = IllegalStateException.class)
	public void gameOver(){
		tennisCheckec.p1TakeScores(4).p1TakeScores(1);
	}
}