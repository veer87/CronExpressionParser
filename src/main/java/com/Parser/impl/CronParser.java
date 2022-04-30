package com.Parser.impl;

import com.Parser.Enums.TimeField;
import com.Parser.Exceptions.CronParserException;
import com.Api.ResponseMapper.CronParserResponse;
import com.Parser.utils.CronParserUtils;

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

            if (tokens.length <= 0 || tokens.length > 6) throw new CronParserException.NotValidExpression.NotValidExpressionLength("Number of expressions should be between 1 to 6: Given length = " + tokens.length);

            for (int i = 0; i < tokens.length; i++) {
                result.put(TimeField.ofId(i).name(), CronParserUtils.parseToken(TimeField.ofId(i), tokens[i]));
            }


        } catch (CronParserException e) {
            logger.log(Level.SEVERE, e.getMessage(), (Object[]) null);
            return e.getMessage();
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), (Object[]) null);
            return "Not Valid Expression : " + exp;
        } finally {

        }
        return new CronParserResponse().build(result);
    }

}
