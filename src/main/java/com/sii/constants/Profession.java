package com.sii.constants;

import java.util.Arrays;
import java.util.Optional;

public enum Profession {
    MANUAL_TESTER("Manual tester",1),
    AUTOMATION_TESTER("Automation Tester",2),
    OTHER("Other",3);


    private final String label;
    private final int number;

    public String getLabel() {
        return label;
    }

    Profession(String label, int number) {
        this.label = label;
        this.number = number;
    }

    public static Profession getByNumber(int number) {
        return Optional.of(Arrays.stream(Profession.values()).findFirst().filter(x -> x.number == number)).get().orElse(OTHER);
    }
}
