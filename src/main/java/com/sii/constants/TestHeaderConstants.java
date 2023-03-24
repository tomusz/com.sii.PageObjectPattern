package com.sii.constants;

public enum TestHeaderConstants {

    TABLE_RANK_HEADER("./th","Rank"),TABLE_PEAK_HEADER("./td[1]","Peak"),
    TABLE_MOUNTAIN_RANGE_HEADER("./td[2]","Mountain range"), TABLE_STATE_HEADER("./td[3]","State"),
    TABLE_HEIGHT_HEADER("./td[4]","Height");

    private final String xpath;
    private final String name;

    public String getXpath() {
        return xpath;
    }

    public String getName() {
        return name;
    }

    TestHeaderConstants(String xpath, String name) {
        this.xpath = xpath;
        this.name = name;
    }
}
