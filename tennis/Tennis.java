package tennis;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static tennis.Players.*;

public class Tennis {

	private MatchScore matchScore = new EqualScore(TennisScore.Love);

	private Map<Class, Map<Players, Function<MatchScore, MatchScore>>> scoreToNextScore = new HashMap<Class, Map<Players, Function<MatchScore, MatchScore>>>() {{
		put(EqualScore.class, new HashMap<Players, Function<MatchScore, MatchScore>>(){{
			put(P1, score -> {
				return new PlayingScore(score.p1().nextScore(), score.p2());
			});
			put(P2, score -> {
				return new PlayingScore(score.p1(), score.p2().nextScore());
			});
		}});
		put(PlayingScore.class, new HashMap<Players, Function<MatchScore, MatchScore>>(){{
			put(P1, score -> {
				return nextMatchScoreOfPlaying(score.p1().nextScore(), score.p2(), P1);
			});
			put(P2, score -> {
				return nextMatchScoreOfPlaying(score.p1(), score.p2().nextScore(), P2);
			});
		}});
		put(DuaceScore.class, new HashMap<Players, Function<MatchScore, MatchScore>>(){{
			put(P1, score -> {
				return new AdventageScore(P1);
			});
			put(P2, score -> {
				return new AdventageScore(P2);
			});
		}});
		put(WinScore.class, new HashMap<Players, Function<MatchScore, MatchScore>>(){{
			put(P1, score -> {
				throw new IllegalStateException("Game over");
			});
			put(P2, score -> {
				throw new IllegalStateException("Game over");
			});
		}});
		put(AdventageScore.class, new HashMap<Players, Function<MatchScore, MatchScore>>(){{
			put(P1, score -> {
				return nextMatchScoreOfAdvantage(score, P1);
			});
			put(P2, score -> {
				return nextMatchScoreOfAdvantage(score, P2);
			});
		}});
	}

		private MatchScore nextMatchScoreOfAdvantage(MatchScore score, Players advantager) {
			if (advantager == score.advantager())
				return new WinScore(advantager);
			return new DuaceScore();
		}

		private MatchScore nextMatchScoreOfPlaying(TennisScore nextP1, TennisScore nextP2, Players player) {
			if (isSomeOneWin(nextP1, nextP2))
				return new WinScore(player);
			if (isDuaceScore(nextP1, nextP2))
				return new DuaceScore();
			if (nextP1 == nextP2)
				return new EqualScore(nextP1);
			return new PlayingScore(nextP1, nextP2);
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
		matchScore = nextMatchScore(P1);
	}

	public void p2TakeScore() {
		matchScore = nextMatchScore(P2);
	}

	private MatchScore nextMatchScore(Players playerTakeScore) {
		return scoreToNextScore.get(matchScore.getClass()).get(playerTakeScore).apply(matchScore);
	}

}
