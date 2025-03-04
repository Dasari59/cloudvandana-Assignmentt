import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
       
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();
        
        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();
        
       
        boolean result = areAnagrams(str1, str2);
        
        
        System.out.println("Are the two strings anagrams? " + result);
        
        scanner.close();
    }

    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        
        int[] frequency = new int[256]; // ASCII character set
        
        for (char c : str1.toLowerCase().toCharArray()) frequency[c]++;
        for (char c : str2.toLowerCase().toCharArray()) frequency[c]--;
        
        for (int count : frequency) {
            if (count != 0) return false;
        }
        return true;
    }
}