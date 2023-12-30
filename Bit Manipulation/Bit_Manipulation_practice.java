public class Bit_Manipulation_practice {

    // Swap two number without using third variable
    public static void swap(int a, int b) {
        System.out.println("Before swaping a is : " + a + " and b is : " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After swaping a is : " + a + " and b is : " + b);        
    }

    // Convert Upper case character to lowercase character
    public static void upperCaseToLowerCase() {
        for(char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.println((char)(ch | ' '));
        }
    }

    public static void main(String[] args) {
        System.out.println(3 ^ 3);  // xor of x ^ x

        swap(1, 2);

        // Add 1 to an integer using bit manipulation(NOT)
        System.out.println(-~5);

        upperCaseToLowerCase();

        // this technique is used in upperCaseToLowerCase
        char ch = ' ';   // ' ' = 32 ~ 100000 in binary
        System.out.println((int)(ch));
    }
}
