public class Task1 {
    public boolean solution(int[] A) {
        int leftIndex = -1;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                while (i > 0 && A[i] == A[i - 1]) {
                    i--;
                }
                leftIndex = i;
                break;
            }
        }

        // Array is sorted
        if (leftIndex == -1)
            return true;

        int rightIndex = -1;
        for (int i = A.length - 1; i >= 1; i--) {
            if (A[i - 1] > A[i]) {
                while (i < A.length - 1 && A[i] == A[i + 1]) {
                    i++;
                }
                rightIndex = i;
                break;

            }
        }

        int temp = A[leftIndex];
        A[leftIndex] = A[rightIndex];
        A[rightIndex] = temp;

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
