package CodingSites.algoDaily.Day0.reverseAString;

public class ReverseAString {

    public static void main(String[] args) {
        String reverse = "palindrome";

        System.out.println("With StringBuilder: "+reverseWithStringBuilder(reverse));
        System.out.println("With StringBuilder Manually: "+reverseManually(reverse));
        System.out.println("With new String Manually: "+reverseManuallyWithString(reverse));
    }

    public static String reverseWithStringBuilder(String str1) {
        return new StringBuilder(str1)
                .reverse()
                .toString();
    }
        public static String reverseManually(String str1) {
            StringBuilder sb = new StringBuilder();
            for (int i = str1.length()-1; i >= 0 ; i--) {
                sb.append(str1.charAt(i));
            }
            return sb.toString();
        }

    public static String reverseManuallyWithString(String str1){
        String s1 = new String();

        for(int i=str1.length()-1; i>=0; i--){
            s1=s1+str1.charAt(i);

        }

        return s1;
    }

    }

