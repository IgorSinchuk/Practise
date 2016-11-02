public class Parser {
    public Double parse(String s) {

        Double result;

        double resultIntPart = 0;
        double resultFractPart = 0;
        double fractionBase = 1;

        boolean isFraction = false;
        boolean hasE = false;
        boolean hasSymbolsIntPart = false;
        boolean hasSymbolsFractPart = false;
        int negativeSign = 1;

        char[] symbols = s.toCharArray();
        for (int i = 0; i < symbols.length; i++) {
            char symbol = symbols[i];
            if (!isNumeric(symbol)) {
                if (symbol == '-' && i == 0) {
                    negativeSign = -1;
                } else if (symbol == 'e') {
                    hasE = true;
                } else {
                    return null;
                }
            } else if (symbol == '.') {
                isFraction = true;
            } else {
                int valueOfSymbol = symbol - 48;
                if (!isFraction) {
                    resultIntPart = resultIntPart * 10 + valueOfSymbol;
                    if(!hasSymbolsIntPart){hasSymbolsIntPart = true;}
                } else {
                    resultFractPart = resultFractPart * 10 + valueOfSymbol;
                    fractionBase *= 10;
                    if(!hasSymbolsFractPart){hasSymbolsFractPart = true;}
                }
            }
        }
        if (isFraction && !hasSymbolsIntPart && !hasSymbolsFractPart) {
            result = null;
        } else if (hasE && isFraction && !hasSymbolsIntPart) {
            result = null;
        } else {
            if (hasE) {
                result = (resultIntPart * Math.pow(10, resultFractPart));
            } else {
                result = (resultIntPart + resultFractPart / fractionBase);
            }
            if (hasSymbolsIntPart) {
                result = negativeSign * result;
            }
        }
        return result;
    }


    private boolean isNumeric(char symbol) {
        int code = (int) symbol;
        if ((code >= 48 && code <= 57)
                || (symbol == '.')) {
            return true;
        } else {
            return false;
        }
    }
}
