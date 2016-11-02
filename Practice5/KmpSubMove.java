public class KmpSubMove {
    public int subMoveQuantity(String inputStr, String resultStr) {
        int move = 0;
        char[] inputSymbols = inputStr.toCharArray();
        char[] movedSymbols = resultStr.toCharArray();
        int length = inputSymbols.length;

        while (true){
           boolean successful = true;

           for (int i = 0; i < length-1; i++){
               int j = (i+move > length-1)?(i + move - length):(i + move);
               if (inputSymbols[i] != movedSymbols[j]){
                   successful = false;
                   break;
               }
           }

           if (successful){
               break;
           } else {
               if (move < inputStr.length()) {
                   move++;
               } else {
                   move = -1;
                   break;
               }
           }
        }

        return move;
    }
}
