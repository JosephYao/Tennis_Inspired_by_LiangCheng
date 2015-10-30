package tennis;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class TennisScoreOnlyMatchState implements MatchState {

    private final Score p1;
    private final Score p2;

    public TennisScoreOnlyMatchState(Score p1, Score p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public Score p1() {
        return p1;
    }

    @Override
    public Score p2() {
        return p2;
    }

    public Player advantager() {
        throw new NotImplementedException();
    }
}
