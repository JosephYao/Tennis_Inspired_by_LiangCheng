package tennis;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class DuaceState implements MatchState {

	public String scoreText() {
		return "Duace";
	}

	public Score p1() {
		throw new NotImplementedException();
	};

	public Score p2() {
		throw new NotImplementedException();
	}

	public Player advantager() {
		throw new NotImplementedException();
	}
}
