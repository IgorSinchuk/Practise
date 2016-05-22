public class WordNumber {
    public int count(String input) {
         int wordCount = 0;

        boolean word = false;
        int endOfLine = input.length() - 1;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i)) && i != endOfLine) {
                word = true;
            } else if (!Character.isLetter(input.charAt(i)) && word) {
                wordCount++;
                word = false;
            } else if (Character.isLetter(input.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
            return wordCount;
        }
    }
