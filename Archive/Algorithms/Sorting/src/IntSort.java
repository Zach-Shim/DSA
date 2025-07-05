import java.util.*;
public class IntSort
{
    private static final int MIN_SIZE = 4;
    public static void main(String[] args)
    {
        IntSort sorter = new IntSort();
        int arr1[] = {4, 36, -12, 85, 23, 69, -41, 7};
        
        System.out.println("Before Selection Sort" + Arrays.toString(arr1));
        sorter.selectionSort(arr1);
        System.out.println("After Selection Sort" + Arrays.toString(arr1));

        int arr2[] = {4, 36, -12, 85, 23, 69, -41, 7};

        System.out.println("Before Bubble Sort" + Arrays.toString(arr2));
        sorter.bubbleSort(arr2);
        System.out.println("After Bubble Sort" + Arrays.toString(arr2));

        
        int arr3[] = {4, 36, -12, 85, 23, 69, -41, 7};

        System.out.println("Before Insertion Sort" + Arrays.toString(arr3));
        sorter.insertionSort(arr3);
        System.out.println("After Insertion Sort" + Arrays.toString(arr3));

        int arr4[] = {4, 36, -12, 85, 23, 69, -41, 7};

        System.out.println("Before Merge Sort" + Arrays.toString(arr4));
        sorter.mergeSort(arr4);
        System.out.println("After Merge Sort" + Arrays.toString(arr4));

        int arr5[] = {4, 36, -12, 85, 23, 69, -41, 7};

        System.out.println("Before Quick Sort" + Arrays.toString(arr5));
        sorter.bubbleSort(arr5);
        System.out.println("After Quick Sort" + Arrays.toString(arr5));
    }

    public IntSort()
    {

    }

    /* Helpers */
    private void swap(int[] arr, int start, int end)
    {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    /* Selection Sort */
    private int findMinValueIndex(int[] arr, int startIndex)
    {
        int minValIndex = startIndex;
        for(int i = startIndex; i < arr.length; i++)
        {
            if(arr[i] < arr[minValIndex])
                minValIndex = i;
        }
        return minValIndex;
    }

    public void selectionSort(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            swap(arr, i, findMinValueIndex(arr, i));
        }
    }

    /* Bubble Sort */
    public void bubbleSort(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr.length - i - 1; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    /* Insertion Sort */
    public void insertionSort(int[] arr)
    {
        for(int i = 1; i < arr.length; i++)
        {
            int key = arr[i];
            int j = i;
            while(j > 0 && key < arr[j-1])
            {
                arr[j] = arr[j-1];
                --j;
            }
            arr[j] = key;
        }
    }

    /* Merge Sort */
    private void merge(int[] arr, int first, int mid, int last)
    {
        int[] merged = new int[last - first + 1];

        int first1 = first, last1 = mid;
        int first2 = mid+1, last2 = last;

        int index = 0;
        while((first1 <= last1) && (first2 <= last2))
        {
            if(arr[first1] <= arr[first2])
            {
                merged[index] = arr[first1];
                ++first1;
            }
            else
            {
                merged[index] = arr[first2];
                ++first2;
            }
            ++index;
        }

        while(first1 <= last1)
        {
            merged[index] = arr[first1];
            ++first1;
            ++index;
        }

        while(first2 <= last2)
        {
            merged[index] = arr[first2];
            ++first2;
            ++index;
        }

        for(int i = 0; i < merged.length; i++)
        {
            arr[first] = merged[i];
            ++first;
        }
    }

    private void mergeSortHelper(int[] arr, int first, int last)
    {
        if(first < last)
        {
            int mid = first + (last - first) / 2;
            mergeSortHelper(arr, first, mid);
            mergeSortHelper(arr, (mid + 1), last);
            merge(arr, first, mid, last);
        }
    }

    public void mergeSort(int[] arr)
    {
        mergeSortHelper(arr, 0, arr.length-1);
    }

    /* Quick Sort */
    private int median(int[] arr, int low, int high)
    {
        int mid = low + (high - low) / 2;
        if(arr[low] > arr[mid]) swap(arr, low, mid);
        if(arr[mid] > arr[high]) swap(arr, mid, high);
        if(arr[mid] > arr[low]) swap(arr, mid, low);
        swap(arr, mid, high-1);
        return arr[high-1];
    }

    private int partition(int[] arr, int low, int high)
    {
        int pivot = median(arr, 0, arr.length-1);
        int pivotIndex = high - 1;

        int indexFromLeft = low;
        int indexFromRight = high - 1;

        for(;;)
        {
            while(arr[++low] <= pivot);
            while(arr[--high] >= pivot);
            
            if(indexFromLeft < indexFromRight)
                swap(arr, indexFromLeft, indexFromRight);
            else
                break;
        }

        swap(arr, indexFromLeft, pivotIndex);
        pivotIndex = indexFromLeft;
        return pivotIndex;
    }

    private void quickSortHelper(int[] arr, int low, int high)
    {
        if(high - low + 1 > MIN_SIZE)
        {
            int pivotIndex = partition(arr, low, high);
            quickSortHelper(arr, low, pivotIndex-1);
            quickSortHelper(arr, pivotIndex+1, high);
        }
        else
        {
            insertionSort(arr);
        }
    }

    public void quickSort(int[] arr)
    {
        quickSortHelper(arr, 0, arr.length-1);
    }
}