package com.sii.constants;

import java.util.Arrays;
import java.util.Optional;

public enum Genders {
    MALE("Male", 1), FEMALE("Female", 2),
    OTHER("Other", 3);

    private final String sex;
    private final int number;

    Genders(String sex, int number) {
        this.sex = sex;
        this.number = number;
    }

    public static Genders getByNumber(int number) {
        return Optional.of(Arrays.stream(Genders.values()).findFirst().filter(x -> x.number == number)).get().orElse(OTHER);
    }

    public String getSex() {
        return sex;
    }

    public int getNumber() {
        return number;
    }
}
