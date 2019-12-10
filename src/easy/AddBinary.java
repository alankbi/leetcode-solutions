package easy;

/**
 * Problem 67: Add Binary
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;

        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            int num = carry;
            if (i < a.length() && a.charAt(a.length() - i - 1) == '1') {
                num++;
            }
            if (i < b.length() && b.charAt(b.length() - i - 1) == '1') {
                num++;
            }
            carry = num / 2;
            result.append(num % 2);
        }

        if (carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String result = new AddBinary().addBinary("11", "1");
        System.out.println(result);
    }
}
