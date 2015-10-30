package tennis;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class TennisScoreOnlyMatchScore implements MatchScore {

    private final TennisScore p1;
    private final TennisScore p2;

    public TennisScoreOnlyMatchScore(TennisScore p1, TennisScore p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public TennisScore p1() {
        return p1;
    }

    @Override
    public TennisScore p2() {
        return p2;
    }

    public Players advantager() {
        throw new NotImplementedException();
    }
}
