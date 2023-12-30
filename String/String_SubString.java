package String;

public class String_SubString {

    public static String subString(String str, int si, int ei) {
        String subStr = "";
        for (int i = si; i < ei; i++) {
           subStr += str.charAt(i); 
        }
        return subStr;
    }
    public static void main(String[] args) {
        String str = "Ankush";
        System.out.println(str.substring(0, 3));;  // using inbuilt function
        System.out.println(subString(str, 0, 3)); // using user define function
    }
}
