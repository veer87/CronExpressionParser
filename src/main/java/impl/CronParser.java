package impl;

import Enums.TimeField;
import Exceptions.CronParserException;
import ResponseMapper.CronParserResponse;
import utils.CronParserUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CronParser implements Api.Parser {
    private static final Logger logger;

    static {
        logger = Logger.getLogger(CronParser.class.getName());
    }

    @Override
    public Object parse(String exp) {
        Map<String, List<String>> result = new LinkedHashMap<>();
        try {
            if (exp == null) throw new CronParserException.NotValidExpression("expression is null.");

            String[] tokens = exp.split(" ");

            if (tokens.length <= 0 || tokens.length > 6) throw new CronParserException.NotValidExpression.NotValidExpressionLength("No of expressions are zero or more than 6: " + tokens.length);

            for (int i = 0; i < tokens.length; i++) {
                result.put(TimeField.ofId(i).name(), CronParserUtils.parseToken(TimeField.ofId(i), tokens[i]));
            }


        } catch (CronParserException e) {
            logger.log(Level.SEVERE, e.getMessage(), (Object[]) null);
            return e.getMessage();
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), (Object[]) null);
            return "Not Valid Expression";
        } finally {

        }
        return new CronParserResponse().build(result);
    }

}
