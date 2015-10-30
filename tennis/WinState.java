package tennis;

public class WinState extends PlayerOnlyState {

	public WinState(Player winner) {
		super(winner);
	}

	public String scoreText() {
		return player + " Win";
	}

}
