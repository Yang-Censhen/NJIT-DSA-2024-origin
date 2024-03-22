package oy.tol.tra;

public class Algorithms {

    private Algorithms() {
        // Empty
    }

    public static int binarySearch(int result, Integer[] array, int fromIndex, int toIndex){
        while (fromIndex <= toIndex){
            int middle = (fromIndex + toIndex)/2;
            if (array[middle]==result)
                return middle;
            else if (array[middle]<result)
                fromIndex = middle+1;
            else
                toIndex = middle-1;
        }
        return -1;
    }

    public static void sort(Integer[] array){
        boolean swapped;
        int n=array.length;
        do {
            swapped=false;
            for (int i=1;i<n;i++){
                if (array[i-1]>array[i]){
                    int temp=array[i-1];
                    array[i-1]=array[i];
                    array[i]=temp;
                    swapped=true;
                }
            }
            n--;
        }while(swapped);
    }

    public static int binarySearch(String value, String[] array, int fromIndex, int toIndex){
        while (fromIndex<=toIndex){
            int middle=(fromIndex + toIndex)/2;
            int cpdd=value.compareTo(array[middle]);
            if (cpdd==0)
                return middle;
            else if (cpdd<0)
                toIndex=middle-1;
            else
                fromIndex=middle+1;
        }
        return -1;
    }

    public static void sort(String[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(String[] array,int head,int tail){
        if (head<tail){
            int bond = partition(array, head, tail);
            quickSort(array, head, bond-1);
            quickSort(array, bond+1, tail);
        }
    }

    private static int partition(String[] array, int head, int tail) {
        String htzx=array[tail];
        int i=head-1;
        for (int j=head;j<tail;j++) {
            if (array[j].compareTo(htzx)<0) {
                i++;
                String yxjlm=array[i];
                array[i]=array[j];
                array[j]=yxjlm;
            }
        }
        String yxjlm=array[i+1];
        array[i+1]=array[tail];
        array[tail]=yxjlm;
        return i+1;
    }
}