package com.Parser.Exceptions;

public class CronParserException extends BaseParserException {
    public CronParserException(String msg) {
        super(msg);
    }

    public static class NotValidExpression extends CronParserException {

        public NotValidExpression(String msg) {
            super(msg);
        }

        public static class NotValidSpecialCharacter extends NotValidExpression {
            public NotValidSpecialCharacter(String msg) {
                super(msg);
            }
        }

        public static class NotValidExpressionLength extends NotValidExpression {
            public NotValidExpressionLength(String msg) {
                super(msg);
            }
        }

        public static class NotValidNumericCharacter extends NotValidExpression {
            public NotValidNumericCharacter(String msg) {
                super(msg);
            }
        }
    }
}
