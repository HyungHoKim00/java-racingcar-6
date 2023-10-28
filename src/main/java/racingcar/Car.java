package racingcar;

import java.util.List;

public class Car {
    private final List<String> names;
    private final int[] moveAmount;
    private final int number;
    private static final int CAR_NAME_LENGTH_MAX = 5;

    public Car(String carNamesString) {
        this.names = List.of(carNamesString.split(","));
        number = names.size();
        isCorrectName();
        moveAmount = new int[number];
    }

    private void isCorrectName() {
        for (String name : names) {
            checkCarNameLength(name);
        }
        checkCarNameDuplication();
    }

    private void checkCarNameLength(String name) {
        if (name.length() > CAR_NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_LENGTH_OVERED);
        }
    }

    private void checkCarNameDuplication() {
        if (number != names.stream().distinct().count()) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_DUPLICATION);
        }
    }
}
