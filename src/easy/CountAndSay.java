package easy;

/**
 * Problem 38: Count and Say
 */
public class CountAndSay {

    public String countAndSay(int n) {
        String s = "1";
        for (int i = 0; i < n - 1; i++) {
            int k = 0;
            int count = 0;
            char current = s.charAt(k);
            String newStr = "";

            while (k < s.length()) {
                if (s.charAt(k) == current) {
                    count++;
                } else {
                    newStr = newStr + count + "" + current;
                    current = s.charAt(k);
                    count = 1;
                }
                k++;
            }
            newStr = newStr + count + current;
            s = newStr;
        }
        return s;
    }

    public static void main(String[] args) {
        String result = new CountAndSay().countAndSay(1);
        System.out.println(result);
    }
}
