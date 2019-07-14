public class Solution {
    /**
     * @param num: a non-negative intege
     * @return: the maximum valued number
     */
    public int maximumSwap(int num) {
        // Write your code here

        //swap with the greatest digit
        char[] numArray = Integer.toString(num).toCharArray();
        int[] lastOcc = new int[10];

        //record the lastOccurence letter of some characters
        for (int i = 0; i < numArray.length; i++) {
            lastOcc[numArray[i] - '0'] = i;
        }

        for (int i = 0; i < numArray.length - 1; i++) {
            for (int k = 9; k > numArray[i] - '0'; k--) {
                //if the occurence of larger index at later part behind the i, we swap and return
                if (lastOcc[k] > i) {
                    char temp = numArray[i];
                    numArray[i] = numArray[lastOcc[k]];
                    numArray[lastOcc[k]] = temp;
                    return Integer.valueOf(new String(numArray));
                }
            }
        }

        return num;
    }
}