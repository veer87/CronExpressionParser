package utils;

import Enums.TimeField;
import Exceptions.CronParserException;

import java.util.*;
import java.util.logging.Logger;

public class CronParserUtils {
    private static Logger logger = Logger.getLogger(CronParserUtils.class.getName());

    public static List<String> parseToken(TimeField tokenType, String token) throws Exception {
        List<String> result = new ArrayList<>();

        logger.info(tokenType + " ==  " + token);

        String description = "";
        switch (tokenType) {
            case MINUTES:
                description = findDescription(token, 0, 59);
                break;
            case HOURS:
                description = findDescription(token, 0, 23);
                break;
            case DAY_OF_MONTH:
                description = findDescription(token, 1, 31);
                break;
            case MONTH:
                description = findDescription(token, 1, 12);
                break;
            case DAY_OF_WEEK:
                description = findDescription(token, 1, 7);
                break;
            case COMMAND:
                description = token;
                break;
            default:
                break;
        }
        result.add(description);

        return result;
    }

    private static String findDescription(String token, int lowerTimeValue, int upperTimeValue) throws Exception {
        List<String> result = new ArrayList<>();

        String[] splitsByComma = token.split(",");

        logger.info(Arrays.toString(splitsByComma));

        for (String split : splitsByComma) {

            if (split.contains("*/")) split = split.replace("*/", "0/");

            ValidateExpressionSplit(split);

            if (split.contains("/")) {
                int slashIdx = split.indexOf("/");
                int min = Integer.parseInt(split.substring(0, slashIdx));
                int interval = Integer.parseInt(split.substring(slashIdx + 1));
                result.addAll(generateRange(min, upperTimeValue, interval));
            } else if (split.contains("-")) {
                int dashIdx = split.indexOf("-");
                int min = Integer.parseInt(split.substring(0, dashIdx));
                int max = Integer.parseInt(split.substring(dashIdx + 1));
                int interval = 1;
                result.addAll(generateRange(min, max, interval));
            } else if (split.contains("*")) {
                result.addAll(generateRange(lowerTimeValue, upperTimeValue, 1));
            } else {
                result.add(split);
            }
        }

        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        });
        return String.join(" ", result);
    }

    private static void ValidateExpressionSplit(String split) throws CronParserException.NotValidExpression {
        char[] chars = split.toCharArray();
        Set<Character> validSpecialSymbolSet = Collections.unmodifiableSet(new HashSet<>(Arrays.asList('*', '/', '-')));
        Set<Character> isSpecialCharsVisited = new HashSet<>();
        for (char ch : chars) {
            if (validSpecialSymbolSet.contains(ch)) {
                if (isSpecialCharsVisited.contains(ch)) throw new CronParserException.NotValidExpression.NotValidSpecialCharacter("Not Valid Special Character found : " + split);
                isSpecialCharsVisited.add(ch);
            } else if (!Character.isDigit(ch)) throw new CronParserException.NotValidExpression.NotValidNumericCharacter("Not Valid Numeric Character found: " + split);
        }
    }


    private static List<String> generateRange(int min, int max, int interval) {
        List<String> result = new ArrayList<>();
        while(min <= max) {
            result.add(String.valueOf(min));
            min += interval;
        }
        return result;
    }

}
