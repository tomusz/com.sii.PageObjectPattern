package com.sii.constants;

public enum Continents {

    ASIA("asia"), AFRICA("africa"), EUROPE("europe"),
    ANTARCTICA("antarctica"), NORTH_AMERICA("north-america"),
    SOUTH_AMERICA("south-america"), AUSTRALIA("australia");

    private final String value;

    Continents(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
