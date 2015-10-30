import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class DuaceScore implements MatchScore {

	public String scoreText() {
		return "Duace";
	}

	public TennisScore p1() {
		throw new NotImplementedException();
	};

	public TennisScore p2() {
		throw new NotImplementedException();
	}

	public Players advantager() {
		throw new NotImplementedException();
	}
}
