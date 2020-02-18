package ash.patz.learning.random;

import java.util.HashMap;
import java.util.Map;

public class OneAway {

    public static void main(String[] args) {
        System.out.println(check("pale","ple")); //true
        System.out.println(check("pales","pale")); //true
        System.out.println(check("pale","bale")); //true
        System.out.println(check("pale","bae")); //false
    }

    static boolean check(String a, String b) {
        char[] achars = a.toCharArray();
        char[] bchars = b.toCharArray();
        boolean oneDifferenceFound = false;
        Map<Character, Integer> charCounts = new HashMap<>();

        for(char aChar : achars) {
            if(!charCounts.containsKey(aChar)) {
                charCounts.put(aChar, 1);
            } else {
                int aCount = charCounts.get(aChar);
                charCounts.put(aChar, ++aCount);
            }
        }

        for(char bChar : bchars) {
            if(!charCounts.containsKey(bChar)) {
                if(oneDifferenceFound) {
                    return false;
                } else {
                    oneDifferenceFound = true;
                }
            } else {
                int bCount = charCounts.get(bChar);
                charCounts.put(bChar, --bCount);
                if(bCount == 0) {
                    charCounts.remove(bChar);
                }
            }
        }

        return (oneDifferenceFound && charCounts.size() == 0) ||
                charCounts.size() == 1 || charCounts.size() == 0 ;
    }
}

