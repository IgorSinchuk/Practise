import java.util.ArrayList;
import java.util.List;

public class BinaryHeap {

    private List<Integer> heap;

    public BinaryHeap(int size) {
        heap = new ArrayList<>(size);
    }

    public void insert(int val) {
        heap.add(val);

        int i = heap.size() - 1;
        int parent = (i - 1) / 2;

        while (i > 0 && heap.get(parent) <  heap.get(i))
        {
            int temp = heap.get(i);
            heap.set(i,  heap.get(parent));
            heap.set(parent,  temp);

            i = parent;
            parent = (i - 1) / 2;
        }
    }

    public int poll() {

        int result = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        sortHeap();

        return result;

    }

    private void sortHeap(){

        int i = 0;

        int leftChild;
        int rightChild;
        int largestChild;

        while (true){

            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;
            largestChild = i;

            if (leftChild < heap.size()
                    && heap.get(leftChild) > heap.get(largestChild)) {
                largestChild = leftChild;
            }

            if (rightChild < heap.size()
                    && heap.get(rightChild) > heap.get(largestChild)) {
                largestChild = rightChild;
            }

            if (largestChild == i) {
                break;
            }

            int temp = heap.get(i);
            heap.set(i, heap.get(largestChild));
            heap.set(largestChild, temp);

            i = largestChild;
        }
    }
}
