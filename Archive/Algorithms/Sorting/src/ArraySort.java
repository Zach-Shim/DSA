public class ArraySort<E extends Comparable<? super E>> implements Sort<E> {
    
    public ArraySort() {}

    @Override
    public void selectionSort(E[] arr) {
        for(int i = 0; i < arr.length; i++) {
            swap(arr, i, findMin(arr, i));
        }
    }

    private void swap(E[] arr, int num1, int num2) {
        E temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }

    private int findMin(E[] arr, int start) {
        int min = start;
        E minVal = arr[start];
        for(int i = start; i < arr.length; i++) {
            if(arr[i] == null) continue;
            if(arr[i].compareTo(minVal) < 0) min = i; minVal = arr[i];
        }
        return min;
    }

    @Override
    public void bubbleSort(E[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j].compareTo(arr[j+1]) > 1) swap(arr, j, j+1);
            }
        }
    }

    @Override
    public void insertionSort(E[] arr) {
        for(int i = 1; i < arr.length; i++) {
            E key = arr[i];
            int j = i;
            while(j >= 0 && key.compareTo(arr[j-1]) < 0) {
                arr[i] = arr[i-1];
                j--;
            }
            arr[j] = key;
        }
        
    }

    @Override
    public void mergeSort(E[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);    
    }

    private void mergeSortHelper(E[] arr, int first, int last)
    {
        if(first < last)
        {
            int mid = first + (last - first) / 2;
            mergeSortHelper(arr, first, mid);
            mergeSortHelper(arr, (mid + 1), last);
            merge(arr, first, mid, last);
        }
    }

    @SuppressWarnings("unchecked")
    private void merge(E[] arr, int first, int mid, int last) {
        E[] merged = (E[]) new Object[last - first + 1];

        int h1 = first, s1 = mid;
        int h2 = mid+1, s2 = last;

        int index = 0;
        while(h1 <= s1 && h2 <= s2) {
            if(arr[h1].compareTo(arr[h2]) <= 0) {
                merged[index] = arr[h1];
                h1++;
            } else {
                merged[index] = arr[h2];
                h2++;
            }
            index++;
        }

        while(h1 <= s1) { merged[index++] = arr[h1++]; }
        while(h2 <= s2) { merged[index++] = arr[h1++]; }

        for(int i = 0; i < merged.length; i++)
        {
            arr[first] = merged[i];
            ++first;
        }
    }

    @Override
    public void quickSort(E[] arr) {
        quickSortHelper(arr, 0, arr.length-1);
    }

    private void quickSortHelper(E[] arr, int first, int last) {
        if(last - first + 1 <= 3) insertionSort(arr);
        int pivotIndex = partition(arr, first, last);
        quickSortHelper(arr, last, pivotIndex-1);
        quickSortHelper(arr, pivotIndex+1, first);
    }

    private int partition(E[] arr, int first, int last) {
        E pivot = median(arr, 0, arr.length-1);
        int pivotIndex = last - 1;

        int indexFromLeft = first + 1;
        int indexFromRight = last - 2;

        while(indexFromLeft < indexFromRight) {
            while(arr[first++].compareTo(pivot) <= 0);
            while(arr[last--].compareTo(pivot) >= 0);
        }

        swap(arr, indexFromLeft, indexFromRight);

        swap(arr, indexFromLeft, pivotIndex);
        pivotIndex = indexFromLeft;
        return pivotIndex;
    }
    
    private E median(E[] arr, int first, int last) {
        int mid = first + (last - first) / 2;
        if(arr[first].compareTo(arr[mid]) > 0) swap(arr, first, mid);
        if(arr[mid].compareTo(arr[last]) > 0) swap(arr, mid, last);
        if(arr[mid].compareTo(arr[first]) > 0) swap(arr, mid, first);
        swap(arr, mid, last-1);
        return arr[last-1];
    }



}