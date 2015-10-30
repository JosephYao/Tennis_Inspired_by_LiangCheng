package tennis;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static tennis.Player.*;

public class Tennis {

	private MatchState matchState = new DrawState(Score.Love);

	private static final Map<Class, Map<Player, Function<MatchState, MatchState>>> scoreToNextScore = new HashMap<Class, Map<Player, Function<MatchState, MatchState>>>() {{
		put(DrawState.class, new HashMap<Player, Function<MatchState, MatchState>>(){{
			put(P1, state -> {
				return new DifferentScoreState(state.p1Score().nextScore(), state.p2Score());
			});
			put(P2, state -> {
				return new DifferentScoreState(state.p1Score(), state.p2Score().nextScore());
			});
		}});
		put(DifferentScoreState.class, new HashMap<Player, Function<MatchState, MatchState>>(){{
			put(P1, state -> {
				return nextMatchStateAfterDifferentScore(state.p1Score().nextScore(), state.p2Score(), P1);
			});
			put(P2, state -> {
				return nextMatchStateAfterDifferentScore(state.p1Score(), state.p2Score().nextScore(), P2);
			});
		}});
		put(DuaceState.class, new HashMap<Player, Function<MatchState, MatchState>>(){{
			put(P1, state -> {
				return new AdventageState(P1);
			});
			put(P2, state -> {
				return new AdventageState(P2);
			});
		}});
		put(WinState.class, new HashMap<Player, Function<MatchState, MatchState>>(){{
			put(P1, state -> {
				throw new IllegalStateException("Game over");
			});
			put(P2, state -> {
				throw new IllegalStateException("Game over");
			});
		}});
		put(AdventageState.class, new HashMap<Player, Function<MatchState, MatchState>>(){{
			put(P1, state -> {
				return nextMatchStateAfterAdvantage(state, P1);
			});
			put(P2, state -> {
				return nextMatchStateAfterAdvantage(state, P2);
			});
		}});
	}

		private MatchState nextMatchStateAfterAdvantage(MatchState score, Player advantager) {
			if (isWinWhenAdvantage(score, advantager))
				return new WinState(advantager);
			return new DuaceState();
		}

		private boolean isWinWhenAdvantage(MatchState score, Player advantager) {
			return advantager == score.advantager();
		}

		private MatchState nextMatchStateAfterDifferentScore(Score nextP1, Score nextP2, Player player) {
			if (isWin(nextP1, nextP2))
				return new WinState(player);
			if (isDuace(nextP1, nextP2))
				return new DuaceState();
			if (isDraw(nextP1, nextP2))
				return new DrawState(nextP1);
			return new DifferentScoreState(nextP1, nextP2);
		}

		private boolean isDraw(Score nextP1, Score nextP2) {
			return nextP1 == nextP2;
		}

		private boolean isDuace(Score nextP1, Score nextP2) {
			return isDraw(nextP1, nextP2) && nextP1 == Score.Fourty;
		}

		private boolean isWin(Score nextP1, Score nextP2) {
			return nextP1 == Score.DirectlyWin || nextP2 == Score.DirectlyWin;
		}

	};

	public String scoreText() {
		return matchState.scoreText();
	}

	public void p1TakeScore() {
		matchState = nextMatchScore(P1);
	}

	public void p2TakeScore() {
		matchState = nextMatchScore(P2);
	}

	private MatchState nextMatchScore(Player playerTakeScore) {
		return scoreToNextScore.get(matchState.getClass()).get(playerTakeScore).apply(matchState);
	}

}
