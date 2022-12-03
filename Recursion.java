public class Recursion {

    public static void printNumDec(int n) {
        if(n == 1) {
            System.out.println(1);
            return;
        }
        System.out.print(n + " ");
        printNumDec(n-1);
    }

    public static void printNumInc(int n) {
        if(n == 1) {
            System.out.print(1 + " ");
            return;
        }
        printNumInc(n-1);
        System.out.print(n + " "); 
    }

    public static int factorial(int n) {
        if(n == 0) {
            return 1;
        }
        int fnm1 = factorial(n-1);
        int fn = n * fnm1;
        return fn;
    }

    public static int naturalNumberSum(int n) {
        if(n == 1) {
            return 1;
        }
        int snm1 = naturalNumberSum(n-1);
        int sn = n + snm1;
        return sn;
    }

    public static int fibonacci(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        int fibnm2 = fibonacci(n-2);
        int fibnm1 = fibonacci(n-1);
        int fibn = fibnm1 + fibnm2;
        return fibn;
    }

    public static boolean isSortedArray(int arr[], int i) {
        if(i == arr.length-1) {
            return true;
        }
        if(arr[i] > arr[i+1]) {
            return false;
        }
        return isSortedArray(arr, i+1);
    }

    public static int firstOccurence(int arr[], int key, int i) {

        if(i == arr.length) {
            return -1;
        }
        if(arr[i] == key) {
            return i;
        }
        return firstOccurence(arr, key, i+1);
    }

    public static int lastOccurence(int arr[], int key, int i) {
        if(i == arr.length) {
            return -1;
        }
        int isFound = lastOccurence(arr, key, i+1);
        if(isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    public static int xToThePowerN(int x, int n) {
        if(n == 0) {
            return 1;
        }
        int xnm1 = xToThePowerN(x, n-1);
        return x * xnm1;
    }

    public static int optimizeXToThePowerN(int x, int n) {
        if(n == 0) {
            return 1;
        }
        int halfPower = optimizeXToThePowerN(x, n/2);
        int halfPowerSq = halfPower * halfPower;

        // n is odd
        if(n % 2 != 0) {
            halfPowerSq = x * halfPowerSq;
        }

        return halfPowerSq;
    }

    /*
        Titling problem  # Google
        Given a "2xn" floor and tiles of size "2x1", count the number of ways to the given floor using the 2x1 tiles.(A tile can either be placed horizontally or vertically)
    */

    public static int tilingProblem(int n) {    // 2 x n floor size

        // base case
        if(n == 0 || n == 1) {
            return 1;
        }

        // vertical choice
        int fnm1 = tilingProblem(n-1);
        // horizontal choice
        int fnm2 = tilingProblem(n-2);

        return fnm1+fnm2; // total ways
    } 

    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        
        // base case
        if(idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        // kamm
        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true) {
            // duplicate
            removeDuplicates(str, idx+1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicates(str, idx+1, newStr.append(currChar), map);
        }
    }

    /*
        Friends pairing problem:    # Goldman Sachs
        Given n friends, each one can remain single or can be paired up 
        with some other friend. Each friend can be paired only once. Find 
        out the total number of ways in which friends can remain single or 
        can be paired up.
    */

    public static int friendsPairing(int n) {

        // base case
        if(n == 1 || n == 2) {
            return n;
        }

        return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
    }

    /*
        Binary String problem   # Paytm 
        Print all binary Strings of size N without consecutive ones
     */

    public static void printBinaryString(int n, int lastPlace, String str) {
        // base case
        if(n == 0) {
            System.out.println(str);
            return;
        }
        // kamm
        printBinaryString(n-1, 0, str + "0");

        if (lastPlace == 0) {
            printBinaryString(n-1, 1, str + "1");
        }
    }

    public static void main(String[] args) {

        printNumDec(10);

        printNumInc(5);

        System.out.println(factorial(5));

        System.out.println(naturalNumberSum(5));

        System.out.println(fibonacci(6));

        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(isSortedArray(arr, 0));

        int arr1[] = {1, 2, 3, 4, 5};
        System.out.println(firstOccurence(arr1, 4, 0));

        int arr2[] = {1, 2, 3, 4, 5, 4, 6, 8};
        System.out.println(lastOccurence(arr2, 4, 0));

        System.out.println(xToThePowerN(5, 2));
        System.out.println(optimizeXToThePowerN(5, 2));

        System.out.println(tilingProblem(4));

        String str = "appnnacollege";
        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);

        System.out.println(friendsPairing(3));

        printBinaryString(3, 0, "");
    }
}
