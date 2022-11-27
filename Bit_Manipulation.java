public class Bit_Manipulation {

    public static void oddOrEven(int n) {
        int bitMask = 1;
        if((n & bitMask) == 0) {
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }
    }

    public static boolean isPowerOfTwo(int n) {
        return (n & (n-1)) == 0;
    }

    public static int getIthBit(int n, int i) {
        int bitMask = 1 << i;
        if((n & bitMask) == 0) {
            return 0;
        }
        return 1;
    }


    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        if(newBit == 0) {
            return clearIthBit(n, i);
        } else {
            return setIthBit(n, i);
        }

        // n = clearIBits(n, i);
        // int bitMask = newBit << i;
        // return n | bitMask;
    }

    public static int clearLastIBits(int n, int i) {
        int bitMask = ~(0) << i;
        return n & bitMask;
    }

    public static int clearRangeBits(int n, int i, int j) {
        int a = (~0) << (j+1);
        int b = (1 << i)-1;
        int bitMask = a | b;
        return n & bitMask;
    }


    

    public static int countSetBits(int n) {
        int count = 0;
        while(n > 0) {
            if((n & 1) != 0) {  // check LSB
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    

    public static int fastExpo(int a, int n) {
        int ans = 1;

        while(n > 0) {
            if((n & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(5 & 6); // binary and
        System.out.println(5 | 6); // binary or
        System.out.println(5 ^ 6); // binary xor
        System.out.println(~0); // binary 1's complement
        System.out.println(5 << 2); // binary left shift
        System.out.println(6 >> 1); // binary right shift

        oddOrEven(3);
        oddOrEven(14);

        System.out.println(isPowerOfTwo(8));

        System.out.println("Ith bit is: " + getIthBit(10, 3));
        System.out.println("set bit is: " + setIthBit(10, 2));
        System.out.println("clear bit is: " + clearIthBit(10, 1));
        System.out.println("update bit is: " + updateIthBit(10, 2, 1));
        System.out.println("clear i bit is: " + clearLastIBits(15, 2));
        System.out.println("clear range bits is: " + clearRangeBits(10, 2, 4));
        System.out.println("Total set bits: " +  countSetBits(15));

        System.out.println(fastExpo(3, 5));

    }
}
