package tennis;

public class AdventageState extends PlayerOnlyState {

	public AdventageState(Player player) {
		super(player);
	}

	public String scoreText() {
		return player + " Adventage";
	}

}
