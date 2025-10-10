package guessing.service.multi;

import guessing.service.dto.GuessResult;

public interface MultiGameManagingFlow {

    GuessResult submitGuess(int id, int answer, int max);
}
