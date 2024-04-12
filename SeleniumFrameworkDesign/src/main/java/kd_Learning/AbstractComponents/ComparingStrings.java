package kd_Learning.AbstractComponents;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.base.Function;

public class ComparingStrings {

	 
    public static void main(String[] args) {
        String str1 = "sai";
        String str2 = "deepak";
        
        System.out.println("Character counts for string \"" + str1 + "\":");
        printCharacterCounts(str1,str2);
        System.out.println("Character counts for string \"" + str2 + "\":");

        printCharacterCounts2(str1,str2);
        
        
       
    }
    
    // Function to count characters in a string using nested loops
    public static void printCharacterCounts(String str1, String str2) {
    	int count;
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
             count = 0;
            
            // Count occurrences of current character
            for (int j = 0; j < str2.length(); j++) {
                if (str2.charAt(j) == ch) {
                    count++;
                }
                
            }
            
            System.out.println("'" + ch + "': " + count + " times");
            
           
            
        }
    }
    
    public static void printCharacterCounts1(String str1, String str2) {
    	int count;
        Set<Character> charSet = new HashSet<>();
        for (char ch : str2.toCharArray()) {
            charSet.add(ch);
        }

        for (int i = 0; i < str1.length(); i++) {
        	count=0;
            char ch = str1.charAt(i);
            if (charSet.contains(ch)) {
            	count++;
                System.out.println(count);
            } else {
                System.out.println(count);
            }
        }
    }
    
    
    public static void printCharacterCounts2(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            String replacedStr = str2.replace(String.valueOf(ch), "");
            int count = (str2.length() - replacedStr.length());
            System.out.println(count);
        }
    }

}
