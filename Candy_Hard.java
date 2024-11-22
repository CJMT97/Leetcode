import java.util.*;

class Candy_Hard {
    public static void main(String[] args) {
        int[] arr = { 1, 9, 3, 2, 5, 4, 5, 2, 1 };
        System.out.println(candy(arr));
    }

    public static int candy(int[] ratings) {
        int nCandies = ratings.length;
        int[] newArr = new int[ratings.length];
        boolean notFinished = true;
        while (notFinished) {
            notFinished = false;
            for (int i = 0; i < ratings.length; i++) {
                int left = -1;
                int right = -1;
                int leftVal = -1;
                int rightVal = -1;
                if (i > 0) {
                    left = ratings[i - 1];
                    leftVal = newArr[i - 1];
                }
                if (i < ratings.length - 1) {
                    right = ratings[i + 1];
                    rightVal = newArr[i + 1];
                }
                if ((ratings[i] > left && left != -1)) {
                    if (!(newArr[i] > leftVal)) {
                        newArr[i] = leftVal + 1;
                        notFinished = true;
                    }
                }
                if ((ratings[i] > right && right != -1)) {
                    if (!(newArr[i] > rightVal)) {
                        newArr[i] = rightVal + 1;
                        notFinished = true;
                    }
                }
            }
        }

        int sumArr = 0;
        for (int i = 0; i < newArr.length; i++) {
            sumArr += newArr[i];
            newArr[i] += 1;
        }
        System.out.println(Arrays.toString(newArr));
        return nCandies + sumArr;
    }
}