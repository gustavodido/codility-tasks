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

    private int findRightIndex(int[] input) {
        for (int i = input.length - 1; i >= 1; i--) {
            if (input[i - 1] > input[i]) {
                while (i < input.length - 1 && input[i] == input[i + 1]) {
                    i++;
                }
                return i;
            }
        }
        return -1;
    }

    public boolean yourFunction(int[] A) {
        int[] input = A;
        int leftIndex = findLeftIndex(input);
        int rightIndex = findRightIndex(input);
        if (leftIndex == rightIndex || leftIndex == -1 || rightIndex == -1)
            return false; // check these edge cases just to be on safe side.

        int temp = A[leftIndex];
        A[leftIndex] = A[rightIndex];
        A[rightIndex] = temp;


        return isSorted(input);
    }

    private int findLeftIndex(int[] input) {
        for (int i = 0; i < (input.length - 1); i++) {
            if (input[i] > input[i + 1]) {
                while (i > 0 && input[i] == input[i - 1]) {
                    i--;
                }
                return i;
            }
        }
        return -1;
    }
}
