package nextstep.blackjac.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    private static final String REGEX = ",";
    public static List<String> splitName(String names) {
        return Arrays.stream(names.split(REGEX))
                .filter(item -> !item.isEmpty())
                .collect(Collectors.toList());
    }




}
