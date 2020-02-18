package ash.patz.learning.random;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(check("tactcoa")); //true
        System.out.println(check("jojoaa")); //true
        System.out.println(check("jojoba")); //false
    }

    static boolean check(String a) {
        Set<Character> charSet = new HashSet<>();

        char[] aChars = a.toCharArray();

        for (char aChar : aChars) {
            if (charSet.contains(aChar)) {
                charSet.remove(aChar);
            } else {
                charSet.add(aChar);
            }
        }

        if (aChars.length % 2 == 0) { //even
            return charSet.size() == 0;
        } else { //odd
            return charSet.size() == 1;
        }

    }
}
