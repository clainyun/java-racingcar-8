package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        String carNamesInput = Console.readLine();
        String attemptCountInput = Console.readLine();
        int attemptCount = Integer.parseInt(attemptCountInput);

        String[] carNames = carNamesInput.split(",");
        int[] positions = new int[carNames.length]; // carNames 원소 개수만큼의 크기로 생성

        for (int i = 0; i < attemptCount; i++) {
            playOneRound(carNames, positions);
            printRoundResult(carNames, positions); // 실행결과 출력
        }
        printWinners(carNames, positions); // 우승자 출력
    }

    private static void playOneRound(String[] carNames, int[] positions) {
        for (int i = 0; i < carNames.length; i++) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (shouldMoveForward(randomValue)) { // 전진 조건을 만족하면
                positions[i]++;
            }
        }
    }

    private static boolean shouldMoveForward(int randomValue) {
        return randomValue >= 4;
    }

    private static void printRoundResult(String[] carNames, int[] positions) {
        for (int i = 0; i < carNames.length; i++) { // 리팩토링 예정! (Java에서 제공하는 API 찾아보기)
            System.out.print(carNames[i] + " : ");
            int n = positions[i];
            for (int j = 0; j < n; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    private static void printWinners(String[] carNames, int[] positions) {
        int maxPos = findMaxPosition(positions);
        String winnerNames = createWinnerNamesString(carNames, positions, maxPos);
        System.out.println("최종 우승자 : " + winnerNames);
    }

    private static int findMaxPosition(int[] positions) {
        int maxPos = 0;
        for (int position : positions) {
            if (maxPos < position)
                maxPos = position;
        }
        return maxPos;
    }

    private static String createWinnerNamesString(String[] carNames, int[] positions, int maxPos) {
        String winnerNames = "";
        for (int i = 0; i < carNames.length; i++) {
            if (positions[i] == maxPos) {
                if (!winnerNames.isEmpty()) {
                    winnerNames += ", ";
                }
                winnerNames += carNames[i];
            }
        }
        return winnerNames;
    }
}