package utils;

import com.Parser.Enums.TimeField;
import com.Parser.utils.CronParserUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CronParserUtilsTest {

    @Test
    public void testParseTokenMinutesAll() throws Exception {
        List<String> expected = generateNumbers(0, 59);
        List<String> actual = CronParserUtils.parseToken(TimeField.MINUTES, "*");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testParseTokenMinutes1() throws Exception {
        List<String> expected = Arrays.asList("0 1 2 3 4 5 12 24 36 48");
        List<String> actual = CronParserUtils.parseToken(TimeField.MINUTES, "4-5,*/12,1,2,3");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testParseTokenMinutes2() throws Exception {
        List<String> expected = Arrays.asList("2 32");
        List<String> actual = CronParserUtils.parseToken(TimeField.MINUTES, "2/30");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testParseTokenMinutes3() throws Exception {
        List<String> expected = Arrays.asList("2 32");
        List<String> actual = CronParserUtils.parseToken(TimeField.MINUTES, "2/*30");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testParseTokenHoursAll() throws Exception {
        List<String> expected = generateNumbers(0, 23);
        List<String> actual = CronParserUtils.parseToken(TimeField.HOURS, "*");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testParseTokenDayOfMonthAll() throws Exception {
        List<String> expected = generateNumbers(1, 31);
        List<String> actual = CronParserUtils.parseToken(TimeField.DAY_OF_MONTH, "*");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testParseTokenMonthAll() throws Exception {
        List<String> expected = generateNumbers(1, 12);
        List<String> actual = CronParserUtils.parseToken(TimeField.MONTH, "*");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testParseTokenDayOfWeekAll() throws Exception {
        List<String> expected = generateNumbers(1, 7);
        List<String> actual = CronParserUtils.parseToken(TimeField.DAY_OF_WEEK, "*");

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
