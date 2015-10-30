public class AdventageScore extends PlayerOnlyMatchScore {

	public AdventageScore(Players player) {
		super(player);
	}

	public String scoreText() {
		return player + " Adventage";
	}

}
