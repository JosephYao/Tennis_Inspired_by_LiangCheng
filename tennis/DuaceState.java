package tennis;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class DuaceState implements MatchState {

	public String scoreText() {
		return "Duace";
	}

	public Score p1Score() {
		throw new NotImplementedException();
	};

	public Score p2Score() {
		throw new NotImplementedException();
	}

	public Player advantager() {
		throw new NotImplementedException();
	}
}
