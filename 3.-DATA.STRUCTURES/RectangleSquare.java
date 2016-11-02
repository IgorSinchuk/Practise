public class RectangleSquare {
    public int measure(int[] x, int[] h, int[] w) {

        int totalSquare = 0;

        for (int i = 0; i < x.length; i ++){

            int currentSquare = h[i] * w[i];
            int deltaSquare = 0;

            for (int j = 0; j < i; j++){
                int deltaX = Math.min(x[j] + w[j], x[i]+ w[i]) - Math.max(x[j], x[i]);
                if (deltaX > 0){
                    int currentDeltaSquare = Math.min(h[i], h[j]) * deltaX;
                    if (currentDeltaSquare > deltaSquare){
                        deltaSquare = currentDeltaSquare;
                    }
                }
            }
            totalSquare = totalSquare + currentSquare - deltaSquare;
        }

        return totalSquare;
    }
}
