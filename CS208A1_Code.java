import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class InsertionSort {

    public static void main(String ars[]) {
        int length = 5;

        InsertionSort ob = new InsertionSort();
        for(int i = 0; i < 5; i++) {
            System.out.println("Best case for n = " + length);
            int arr1[] = generageBestCase(length);
            print(arr1);
            ob.sort(arr1);
            System.out.println("_______________________________");

            for(int j = 0; j < 5; j++) {
            System.out.println("Random case" + (j+1) + " for n = " + length);
                int arr2[] = generageRandCase(length);
                print(arr2);
                ob.sort(arr2);
                System.out.println("_______________________________");
            }

            System.out.println("Worst case for n = " + length);
            int arr3[] = generageWorstCase(length);
            print(arr3);
            ob.sort(arr3);
            System.out.println("_______________________________");
            length = length*4;
        }

    }

    private static int[] generageBestCase(int length) {
        int[] bc = new int[length];
        int j = 0;
        for (int i = 0; i < length; i++ ) {
            bc[i] = j;
            j++;
        }
        return bc;
    }

    private static int[] generageWorstCase(int length) {
            int[] wc = new int[length];
            int j = length;
            for (int i = 0; i < length; i++) {
                wc[i] = j;
                j--;
            }
            return wc;
        }

        private static int[] generageRandCase(int length) {
            int[] rc = new int[length];

            for (int i = length-1; i > 0; i-- ) {
                rc[i] = i;
            }

            Random r = ThreadLocalRandom.current();
            for (int i = rc.length-1; i > 0; i--) {
                int index = r.nextInt(i + 1);
                int j = rc[index];
                rc[index] = rc[i];
                rc[i] = j;
            }
        return rc;
    }

    private void sort(int[] arr) {
        int compCount = 0;
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;

            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
                compCount++;
            }
            if(j >= 0) {
                compCount++;
            }
            arr[j+1] = key;
        }
        System.out.println("The comparason count is: " + compCount);
    }
    static void print(int[] arr)
    {
        int n = arr.length;

        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();

    }
    }
