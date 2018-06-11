public class Task1 {
    public boolean solution(int[] A) {
        // Find the first element out of order from the beggining
        int leftIndex = -1;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                // If there are consecutive elements, we need to move back to the first one that is out of order
                while (i > 0 && A[i] == A[i - 1]) {
                    i--;
                }
                
                // We found it 
                leftIndex = i;
                break;
            }
        }

        // Array is sorted if there is no index out of order
        if (leftIndex == -1)
            return true;

        // Now find the very first element out of order from the end 
        int rightIndex = -1;
        for (int i = A.length - 1; i >= 1; i--) {
            if (A[i - 1] > A[i]) {
                // Again, if there are consecutive elements, we need to move forward to the first from the end
                while (i < A.length - 1 && A[i] == A[i + 1]) {
                    i++;
                }
                
                // We found it
                rightIndex = i;
                break;

            }
        }
        
        // Since we tested leftIndex = -1, it assured that rightIndex will not be -1, otherwise the
        // array would be already sorted

        // Swap the indexes that we just found, the first from the beggining and the first from the end
        int temp = A[leftIndex];
        A[leftIndex] = A[rightIndex];
        A[rightIndex] = temp;

        // Check if it is sorted after the swap operation
        return isSorted(A);
    }


    public boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }
  
}
