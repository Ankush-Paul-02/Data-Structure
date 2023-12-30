package String;
public class String_Longest_Palindromic_SubString {

    public static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "babad";

        int n = str.length(), max = 1, startIndex = 0;

        for (int i = 1; i < n; i++) {
            //? even length
            int left = i-1, right = i;
            while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
                if(right-left+1 > max) {
                    max = left- right+1;
                    startIndex = left;
                }
                left--;
                right++;
            }
            //? odd length
            left = i-1;
            right = i+1;

            while(left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
                if(right-left+1 > max) {
                    max = right-left+1;
                    startIndex = left;
                } 
                left--;
                right++;
            }
        }

        System.out.println(str.substring(startIndex, max));

    }
}
