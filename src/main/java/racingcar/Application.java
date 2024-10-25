package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

    }
}

class Car {
    private final String name;
    private int movingCount;

    public Car(String name) {
        this.name = name;
        this.movingCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getMovingCount() {
        return movingCount;
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            movingCount++;
        }
    }
}

class UserInput {
    private final List<Car> cars = new ArrayList<>();
    private int attempts = 0;
    private boolean isValidCarNames = false;
    private boolean isPositiveAttempts = false;
    private boolean isIntegerAttempts = false;

    public List<Car> getCarList() {
        return cars;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        for (String name : carNames) {
            if (name.trim().length() <= 5) {
                isValidCarNames = true;
                cars.add(new Car(name.trim()));
            } else {
                isValidCarNames = false;
                break;
            }
        }
    }
}
