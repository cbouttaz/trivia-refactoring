package kata.tennis.statemachine;

import java.util.Map;

public class FirstPoints implements GameScore {
    public static Map<Score, String> ScorePrint = Map.of(
        Score.Love, "Love",
        Score.Fifteen, "15",
        Score.Thirty, "30",
        Score.Forty, "40"
    );

    public static Map<Score, Score> ScoreEvolution = Map.of(
        Score.Love, Score.Fifteen,
        Score.Fifteen, Score.Thirty,
        Score.Thirty, Score.Forty
    );

    private Score scoreP1 = Score.Love;
    private Score scoreP2 = Score.Love;

    public FirstPoints(Score player1, Score player2) {
    }

    @Override
    public GameScore nextScore(Player player) {
        if (scoreP1 == Score.Thirty && player == Player.P1)
            return new Forty(Player.P1, scoreP2);
        if (scoreP2 == Score.Thirty && player == Player.P2)
            return new Forty(Player.P2, scoreP1);
        if (player == Player.P1)
            scoreP1 = ScoreEvolution.get(scoreP1);
        else
            scoreP2 = ScoreEvolution.get(scoreP2);
        return this;
    }

    @Override
    public String getScore() {
        return ScorePrint.get(scoreP1)
            + "-" + ScorePrint.get(scoreP2);
    }
}
