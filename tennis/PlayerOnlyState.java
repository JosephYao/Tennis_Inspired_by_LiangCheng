package tennis;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

abstract public class PlayerOnlyState implements MatchState {

    protected final Player player;

    public PlayerOnlyState(Player player) {
        this.player = player;
    }

    @Override
    public Player advantager() {
        return player;
    }

    public Score p1Score() {
        throw new NotImplementedException();
    };

    public Score p2Score() {
        throw new NotImplementedException();
    }

}
