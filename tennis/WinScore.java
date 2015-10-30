package tennis;

public class WinScore extends PlayerOnlyMatchScore {

	public WinScore(Players winner) {
		super(winner);
	}

	public String scoreText() {
		return player + " Win";
	}

}
