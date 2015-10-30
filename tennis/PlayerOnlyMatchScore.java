package tennis;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

abstract public class PlayerOnlyMatchScore implements MatchScore {

    protected final Players player;

    public PlayerOnlyMatchScore(Players player) {
        this.player = player;
    }

    @Override
    public Players advantager() {
        return player;
    }

    public TennisScore p1() {
        throw new NotImplementedException();
    };

    public TennisScore p2() {
        throw new NotImplementedException();
    }

}
