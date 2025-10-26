package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;

    public static void main(String[] args) {
        InputReader inputReader = new InputReader();

        String carNamesInput = inputReader.readCarNames();
        int attemptCount = inputReader.readAttemptCount();

        List<Car> cars = createCars(carNamesInput);

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < attemptCount; i++) {
            playOneRound(cars);
            printRoundResult(cars);
        }
        printWinners(cars);
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
            int randomValue = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
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
        StringBuilder winnerNames = new StringBuilder();
        boolean isFirst = true;

        for (Car car : cars) {
            if (car.getPosition() == maxPos) {
                if (!isFirst) {
                    winnerNames.append(", ");
                }
                winnerNames.append(car.getName());
                isFirst = false;
            }
        }
        return winnerNames.toString();
    }
}