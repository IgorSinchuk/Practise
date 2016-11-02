import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

public class LongestStabilityPeriod {
    public int count(int[] gdp) {
        int result = 0;

        ArrayList<HashMap<String, Integer>> openStabilityPeriods = new ArrayList<>();

        for (int i = 0; i < gdp.length; i++) {

            int value = gdp[i];

            for (ListIterator<HashMap<String, Integer>> iterator = openStabilityPeriods.listIterator(); iterator.hasNext(); ) {

                HashMap<String, Integer> element = iterator.next();

                int currentLength = element.get("length");
                int currentMaxValue = element.get("maxValue");
                int currentMinValue = element.get("minValue");

                if (Math.abs(currentMaxValue - value) <= 1
                        && Math.abs(currentMinValue - value) <= 1) {

                    element.put("maxValue", Math.max(currentMaxValue, value));
                    element.put("minValue", Math.min(currentMinValue, value));
                    element.put("length", currentLength + 1);

                } else {
                    result = Math.max(result, currentLength);
                    iterator.remove();
                }
            }

            if (i == 0 || ( i > 0 && value != gdp[i-1])){
                //new period
                HashMap<String, Integer> newPeriod = new HashMap<>();

                newPeriod.put("length", 1);
                newPeriod.put("maxValue", value);
                newPeriod.put("minValue", value);

                openStabilityPeriods.add(newPeriod);

            }
        }

        for (ListIterator<HashMap<String, Integer>> iterator = openStabilityPeriods.listIterator(); iterator.hasNext(); ) {
            HashMap<String, Integer> element = iterator.next();
            result = Math.max(result, element.get("length"));
        }

        return result;
    }
}
