package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {
    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int readAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return validateAndParseInt(input);
    }

    private int validateAndParseInt(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("시도 횟수를 입력해야 합니다.");
        }

        int attemptCount = Integer.parseInt(input);
        if (attemptCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return attemptCount;
    }
}
