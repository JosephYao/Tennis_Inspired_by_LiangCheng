package tennis;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static tennis.Player.*;

public class Tennis {

	private MatchState matchState = new EqualState(Score.Love);

	private Map<Class, Map<Player, Function<MatchState, MatchState>>> scoreToNextScore = new HashMap<Class, Map<Player, Function<MatchState, MatchState>>>() {{
		put(EqualState.class, new HashMap<Player, Function<MatchState, MatchState>>(){{
			put(P1, score -> {
				return new DifferentScoreState(score.p1().nextScore(), score.p2());
			});
			put(P2, score -> {
				return new DifferentScoreState(score.p1(), score.p2().nextScore());
			});
		}});
		put(DifferentScoreState.class, new HashMap<Player, Function<MatchState, MatchState>>(){{
			put(P1, score -> {
				return nextMatchScoreOfPlaying(score.p1().nextScore(), score.p2(), P1);
			});
			put(P2, score -> {
				return nextMatchScoreOfPlaying(score.p1(), score.p2().nextScore(), P2);
			});
		}});
		put(DuaceState.class, new HashMap<Player, Function<MatchState, MatchState>>(){{
			put(P1, score -> {
				return new AdventageState(P1);
			});
			put(P2, score -> {
				return new AdventageState(P2);
			});
		}});
		put(WinState.class, new HashMap<Player, Function<MatchState, MatchState>>(){{
			put(P1, score -> {
				throw new IllegalStateException("Game over");
			});
			put(P2, score -> {
				throw new IllegalStateException("Game over");
			});
		}});
		put(AdventageState.class, new HashMap<Player, Function<MatchState, MatchState>>(){{
			put(P1, score -> {
				return nextMatchScoreOfAdvantage(score, P1);
			});
			put(P2, score -> {
				return nextMatchScoreOfAdvantage(score, P2);
			});
		}});
	}

		private MatchState nextMatchScoreOfAdvantage(MatchState score, Player advantager) {
			if (advantager == score.advantager())
				return new WinState(advantager);
			return new DuaceState();
		}

		private MatchState nextMatchScoreOfPlaying(Score nextP1, Score nextP2, Player player) {
			if (isSomeOneWin(nextP1, nextP2))
				return new WinState(player);
			if (isDuaceScore(nextP1, nextP2))
				return new DuaceState();
			if (nextP1 == nextP2)
				return new EqualState(nextP1);
			return new DifferentScoreState(nextP1, nextP2);
		}

		private boolean isDuaceScore(Score nextP1, Score nextP2) {
			return nextP1 == nextP2 && nextP1 == Score.Fourty;
		}

		private boolean isSomeOneWin(Score nextP1, Score nextP2) {
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
