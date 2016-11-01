import java.util.LinkedList;

/**
 * Created by ousmane on 10/30/16.
 */
public class Compress {

    public static String compress(String input) {
        if(input.length() == 1 || input.isEmpty()) return input;
        else {
            String result = "";
            String count= "";
            LinkedList<String> stack = new LinkedList<>();
            for(String ch : input.split("")) {
                if(stack.isEmpty() || stack.peek().equals(ch)) {
                    stack.push(ch);
                }else {
                    result += stack.peek() + "" + stack.size();
                    count += stack.peek();
                    while(!stack.isEmpty()) stack.pop();
                    stack.push(ch);
                }
            }
            result += stack.peek() + "" + stack.size();
            count += stack.peek();
            if(count.equals(input) || result.length() <= 2) return input;
            return result;
        }
    }


    public static void main(String[] args) {
        System.out.println(Compress.compress("aabcccccaaa")); // This prints a2b1c5a3
        System.out.println(Compress.compress("abc")); //This prints abc
        System.out.println(Compress.compress("abccc")); //This prints a1b1c3
        System.out.println(Compress.compress("aaa")); // This prints aaa instead of a3
        System.out.println(Compress.compress("bb")); // This print bb insted of b2
    }
}
