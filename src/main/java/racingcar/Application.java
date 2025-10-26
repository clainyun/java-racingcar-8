package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();

        String carNamesInput = inputReader.readCarNames();
        int attemptCount = inputReader.readAttemptCount();

        List<Car> cars = createCars(carNamesInput);

        for (int i = 0; i < attemptCount; i++) {
            playOneRound(cars);
            printRoundResult(cars); // 실행결과 출력
        }
        printWinners(cars); // 우승자 출력
    }

    private static List<Car> createCars(String carNamesInput) {
        List<Car> cars = new ArrayList<>();
        String[] names = carNamesInput.split(",");
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void playOneRound(List<Car> cars) {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }

    private static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getDisplay());
        }
        System.out.println();
    }

    private static void printWinners(List<Car> cars) {
        int maxPos = findMaxPosition(cars);
        String winnerNames = createWinnerNamesString(cars, maxPos);
        System.out.println("최종 우승자 : " + winnerNames);
    }

    private static int findMaxPosition(List<Car> cars) {
        int maxPos = 0;
        for (Car car : cars) {
            if (maxPos < car.getPosition()) {
                maxPos = car.getPosition();
            }
        }
        return maxPos;
    }

    private static String createWinnerNamesString(List<Car> cars, int maxPos) {
        String winnerNames = "";
        for (Car car : cars) {
            if (car.getPosition() == maxPos) {
                winnerNames = addWinnerNameWithComma(winnerNames, car.getName());
            }
        }
        return winnerNames;
    }

    private static String addWinnerNameWithComma(String winnerNames, String carName) {
        if (!winnerNames.isEmpty()) {
            winnerNames += ", ";
        }
        winnerNames += carName;
        return winnerNames;
    }
}