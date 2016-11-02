public class KmpSmallestPeriod {

    public String findSmalletstPeriod(String input) {

        String result ="";
        int periodSize = 1;

        while (!result.equals(input) &&
                periodSize <= input.length()){
            result = input.substring(0, periodSize);

            boolean successful = true;
            int i = periodSize;
            for (; i <= input.length()- periodSize; i+=periodSize){
                String nextSubstring = input.substring(i, i + periodSize);
                if (!nextSubstring.equals(result)){
                    successful = false;
                    break;
                }
            }
            if (i != input.length()){successful = false;}

            if(successful){
                break;
            } else {
                periodSize++;
            }
        }
        return result;
    }

}
