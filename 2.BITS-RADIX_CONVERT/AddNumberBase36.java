import java.math.BigInteger;

/**
 * Created by Столик on 07.05.2016.
 */
public class AddNumberBase36 {
    final static int base = 36;
    final static BigInteger diff_letter = new BigInteger("87");
    final static BigInteger diff_number = new BigInteger("48");

    public String add(String a, String b) {
        BigInteger bigA = convertToDecimal(a);
        BigInteger bigB = convertToDecimal(b);
        BigInteger result = bigA.add(bigB);
        return convertToBase36(result);
    }

    private BigInteger convertToDecimal(String input){
        BigInteger result = BigInteger.valueOf(0);

        String reverseInput = new StringBuilder(input).reverse().toString();
        for(int i = 0; i < reverseInput.length(); i++){
            int code = reverseInput.toLowerCase().codePointAt(i);
            BigInteger multiplier = BigInteger.valueOf(code);
            if (code > 58){
                multiplier = multiplier.subtract(diff_letter);
            } else {
                multiplier = multiplier.subtract(diff_number);
            }
           /// Math.pow(base, i)*code;
            BigInteger currentResult = BigInteger.valueOf(base);
            currentResult = currentResult.pow(i).multiply(multiplier);
            result = result.add(currentResult);
        }
        return result;
    }

    private String convertToBase36(BigInteger result){
        StringBuilder finalResult = new StringBuilder();
        BigInteger base36 = BigInteger.valueOf(base);

        while (result.compareTo(base36)>=0){
            BigInteger[] vals = result.divideAndRemainder(base36);
            result = vals[0];
            finalResult.append(convertSymbolToBase36(vals[1].intValue()));
        }

        finalResult.append(convertSymbolToBase36(result.intValue()));

        return finalResult.reverse().toString();
    }

    private char convertSymbolToBase36(int number){
        if (number < 10) {
            return (char) (number + 48);
        } else {
            return (char) (number + 87);
        }
    }

}