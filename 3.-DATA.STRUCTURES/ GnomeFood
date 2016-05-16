import java.util.Arrays;

public class GnomeFood {
    public static void main(String[] args) {
        GnomeFood gf = new GnomeFood();
        int[] a = {5, 7, 6, 9, 4};
        int[] b = {8, 5, 6, 2, 3};
        int[] result = gf.find(a, b);
        for (int i :result){
            System.out.print(i+", ");
        }
    }
    public int[] find(int[] gnomes, int[] portions) {
        int[] gnomes_sorted = Arrays.copyOf(gnomes, gnomes.length);
        int[] portions_sorted = Arrays.copyOf(portions, portions.length);

        Arrays.sort(gnomes_sorted);
        Arrays.sort(portions_sorted);

        int[] result = new int[gnomes.length];

        for (int i = 0; i < gnomes.length; i++) {
            int portion = portions_sorted[Arrays.binarySearch(gnomes_sorted, gnomes[i])];
            int portion_index = find(portions, portion);
            result[i] = portion_index;
        }
        return result;
    }
    private int find(int[] array, int symbol){
        for(int i = 0; i< array.length; i++){
            if(array[i] == symbol){
                return i;
            }
        }
        return -1;
    }
}
