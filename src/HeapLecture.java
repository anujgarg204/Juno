import java.util.Arrays;

public class HeapLecture {

static class Heap{
    int[] arr;
    int index;

    public Heap(){
        this.arr = new int[50];
        index = 1;
    }

    public void add(int val){
      arr[index] = val;
      upheapify(index);
      index++;
    }

    public void delete(){
        if(index == 1)return;

        System.out.println("Deleting : " + arr[1]);
        index--;
        arr[1] = arr[index];
        arr[index] = 0;
        
        downHeapify(1);
        
    }

    private void downHeapify(int i) {
        int largest = i;
        int l = 2*i;
        int r = 2*i+1;

        if(l < index && arr[l] > arr[largest]){
            largest = l;
        }

        if(r < index && arr[r] > arr[largest]){
            largest = r;
        }

        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            downHeapify(largest);
        }
    }

    public void upheapify(int i){
        if(i < 1)return;
        
        int parent = i/2;
        
        if(parent >= 1 && arr[parent] < arr[i]){
            int temp = arr[i];
            arr[i] = arr[parent];
            arr[parent] = temp;
            upheapify(parent);
        }
    }

}    


public static void main(String[] args) {
    Heap heap = new Heap();
    heap.add(10);
    heap.add(20);
    heap.add(15);
    heap.add(50);
    heap.add(5);
    heap.add(99);
    heap.add(53);
    heap.add(19);

    heap.delete();
    heap.delete();
    heap.delete();

    System.out.println(Arrays.toString(heap.arr));
}   


}

