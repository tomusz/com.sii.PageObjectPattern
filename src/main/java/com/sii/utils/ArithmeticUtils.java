package com.sii.utils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ArithmeticUtils {

    public static int getRandomNumberInRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static Object getRandomObjectFromList(List<Object> objects) {
        return objects.get(getRandomNumberInRange(1, objects.size()));
    }
}