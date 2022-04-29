package utils;

import Enums.TimeField;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CronParserUtilsTest {

    @Test
    public void testParseTokenMinutesAll() throws Exception {
        List<String> expected = generateNumbers(0, 59);
        List<String> actual = CronParserUtils.parseToken(TimeField.MINUTES, "*");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testParseTokenMinutes1() throws Exception {
        List<String> expected = Arrays.asList("2 32");
        List<String> actual = CronParserUtils.parseToken(TimeField.MINUTES, "2/30");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testParseTokenMonth() throws Exception {
        List<String> expected = Arrays.asList("2");
        List<String> actual = CronParserUtils.parseToken(TimeField.MONTH, "2/30");

        Assertions.assertEquals(expected, actual);

    }

    private static List<String> generateNumbers(int start, int end) {
        List<String> result = new ArrayList<>();
        while(start <= end) {
            result.add(String.valueOf(start++));
        }

        return new ArrayList<String>(Arrays.asList(String.join(" ", result)));
    }
}
