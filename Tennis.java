import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Tennis {

	private MatchScore matchScore = new EqualScore(TennisScore.Love);

	public static Map<Class, Map<Players, Function<MatchScore, MatchScore>>> scoreToNextScore = new HashMap<Class, Map<Players, Function<MatchScore, MatchScore>>>() {{
		put(EqualScore.class, new HashMap<Players, Function<MatchScore, MatchScore>>(){{
			put(Players.P1, (score -> {
				return new PlayingScore(score.p1().nextScore(), score.p2());
			}));
			put(Players.P2, (score -> {
				return new PlayingScore(score.p1(), score.p2().nextScore());
			}));
		}});
		put(PlayingScore.class, new HashMap<Players, Function<MatchScore, MatchScore>>(){{
			put(Players.P1, (score -> {
				TennisScore nextP1 = score.p1().nextScore();
				TennisScore nextP2 = score.p2();

				if (isSomeOneWin(nextP1, nextP2))
					return new WinScore(Players.P1);
				if (isDuaceScore(nextP1, nextP2))
					return new DuaceScore();
				if (nextP1 == nextP2)
					return new EqualScore(nextP1);
				return new PlayingScore(nextP1, nextP2);
			}));
			put(Players.P2, (score -> {
				TennisScore nextP1 = score.p1();
				TennisScore nextP2 = score.p2().nextScore();

				if (isSomeOneWin(nextP1, nextP2))
					return new WinScore(Players.P2);
				if (isDuaceScore(nextP1, nextP2))
					return new DuaceScore();
				if (nextP1 == nextP2)
					return new EqualScore(nextP1);
				return new PlayingScore(nextP1, nextP2);
			}));
		}});
	}

		private boolean isDuaceScore(TennisScore nextP1, TennisScore nextP2) {
			return nextP1 == nextP2 && nextP1 == TennisScore.Fourty;
		}

		private boolean isSomeOneWin(TennisScore nextP1, TennisScore nextP2) {
			return nextP1 == TennisScore.DirectlyWin || nextP2 == TennisScore.DirectlyWin;
		}

	};

	public String scoreText() {
		return matchScore.scoreText();
	}

	public void p1TakeScore() {
		matchScore = matchScore.nextMatchScore(Players.P1);
	}

	public void p2TakeScore() {
		matchScore = matchScore.nextMatchScore(Players.P2);
	}

}
