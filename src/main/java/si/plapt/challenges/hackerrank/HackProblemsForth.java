package si.plapt.challenges.hackerrank;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class HackProblemsForth {

  int introTutorial(int v, int[] arr) {
    return Arrays.binarySearch(arr, v);
  }

  @Test
  public void testIntroTutorial() {

  /* @formatter:off */
  String input = "4\n"+
  "6\n"+
  "1 4 5 7 9 12";
  /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int v = scanner.nextInt();
    int n = scanner.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    System.out.println(introTutorial(v, arr));

    scanner.close();

  }

  void insertionSort1(int n, int[] arr) {
    int x = arr[n - 1];
    int i = 0;
    for (i = n - 2; i >= 0; i--) {
      if (arr[i] > x) {
        arr[i + 1] = arr[i];
        for (int j = 0; j < n; j++) {
          System.out.print(arr[j] + " ");
        }
        System.out.println();
      } else {
        break;
      }
    }

    arr[i + 1] = x;
    for (int j = 0; j < n; j++) {
      System.out.print(arr[j] + " ");
    }
    System.out.println();

  }

  @Test
  public void testInsertionSort1() {

  /* @formatter:off */
  String input = "10\n"+
  "2 3 4 5 6 7 8 9 10 1";
  /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    insertionSort1(n, arr);

    scanner.close();

  }

  int minimumNumber(int n, String password) {
    String numbers = "0123456789";
    String lower_case = "abcdefghijklmnopqrstuvwxyz";
    String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String special_characters = "!@#$%^&*()-+";

    boolean hasNumber = false;
    boolean hasLowerCase = false;
    boolean hasUpperCase = false;
    boolean hasSpecial = false;

    for (int i = 0; i < password.length(); i++) {
      if (numbers.lastIndexOf(password.charAt(i)) != -1) {
        hasNumber = true;
      } else if (lower_case.lastIndexOf(password.charAt(i)) != -1) {
        hasLowerCase = true;
      } else if (upper_case.lastIndexOf(password.charAt(i)) != -1) {
        hasUpperCase = true;
      } else if (special_characters.lastIndexOf(password.charAt(i)) != -1) {
        hasSpecial = true;
      }
    }

    int numChar = 0;
    if (!hasNumber) {
      numChar++;
    }

    if (!hasLowerCase) {
      numChar++;
    }

    if (!hasUpperCase) {
      numChar++;
    }

    if (!hasSpecial) {
      numChar++;
    }

    int dx = 6 - (password.length() + numChar);
    if (dx > 0) {
      numChar += dx;
    }

    return numChar;

  }

  @Test
  public void testMinimumNumber() {

 /* @formatter:off */
 String input = "3\n"+
 "Ab1";
 /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    String password = scanner.next();

    System.out.println(minimumNumber(n, password));

    scanner.close();

  }

  int alternate(String s) {

    Map<Character, Integer> charCounter = new HashMap<>();
    List<Character> list = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      char key = s.charAt(i);
      if (!charCounter.containsKey(key)) {
        list.add(key);
      }
      charCounter.merge(s.charAt(i), 1, (old, val) -> old + val);
    }

    int maxLength = 0;
    for (int i = 0; i < list.size() - 1; i++) {
      char ch1 = list.get(i);
      for (int j = i + 1; j < list.size(); j++) {
        char ch2 = list.get(j);
        if (ch1 != ch2) {
          char alt1 = ch1;
          char alt2 = ch2;
          int firstIndex = s.indexOf(alt1);

          boolean notValid = false;
          for (int k = firstIndex + 1; k < s.length(); k++) {
            if (s.charAt(k) == ch1 || s.charAt(k) == ch2) {
              if (s.charAt(k) == alt1) {
                notValid = true;
                break;
              } else {
                char tmp = alt1;
                alt1 = alt2;
                alt2 = tmp;
              }
            }
          }
          if (notValid) {
            continue;
          }

          int length = charCounter.get(ch1) + charCounter.get(ch2);
          if (length > maxLength) {
            maxLength = length;
          }

        }
      }
    }

    return maxLength;
  }

  @Test
  public void testAlternate() {

 /* @formatter:off */
 String input = "10\n"+
  "beabeefeab";
 /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    String s = scanner.next();

    System.out.println(alternate(s));

    scanner.close();

  }

  void printArray(int[] arr) {
    for (int j = 0; j < arr.length; j++) {
      System.out.print(arr[j] + " ");
    }
    System.out.println();
  }

  void insertionSort2(int n, int[] arr) {

    int k = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] <= arr[k]) {
        int x = arr[i];
        int j = 0;
        for (j = i - 1; j >= 0; j--) {
          if (arr[j] > x) {
            arr[j + 1] = arr[j];
          } else {
            break;
          }
        }
        arr[j + 1] = x;
      }
      k++;
      printArray(arr);
    }

  }

  @Test
  public void testInsertionSort2() {

  /* @formatter:off */
  String input = "6\n"+
  "1 4 3 5 6 2";
  /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    insertionSort2(n, arr);

    scanner.close();

  }

  String caesarCipher(String s, int k) {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    Map<Character, Integer> mapChar = new HashMap<>();
    for (int i = 0; i < alphabet.length(); i++) {
      mapChar.put(alphabet.charAt(i), i);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      boolean isUpper = Character.isUpperCase(ch);
      if (isUpper) {
        ch = Character.toLowerCase(ch);
      }
      if (Character.isLetter(ch)) {
        int index = mapChar.get(ch);
        index = (index + k) % 26;
        char newCh = alphabet.charAt(index);
        if (isUpper) {
          newCh = Character.toUpperCase(newCh);
        }
        sb.append(newCh);
      } else {
        sb.append(ch);
      }

    }

    return sb.toString();

  }

  @Test
  public void testCaesarCipher() {

  /* @formatter:off */
  String input = "11\n"+
  "middle-Outz\n"+
  "2";
  /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    String s = scanner.next();
    int k = scanner.nextInt();

    System.out.println(caesarCipher(s, k));

    scanner.close();
  }

  int marsExploration(String s) {

    int changed = 0;
    String sos = "SOS";
    for (int i = 0; i < s.length(); i += 3) {
      for (int j = 0; j < 3; j++) {
        if (sos.charAt(j) != s.charAt(i + j)) {
          changed++;
        }
      }
    }
    return changed;
  }

  @Test
  public void testMarsExploration() {

  /* @formatter:off */
  String input = "SOSSPSSQSSOR";
  /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    String s = scanner.next();

    System.out.println(marsExploration(s));

    scanner.close();
  }

  String hackerrankInString(String s) {
    String hr = "hackerrank";
    int i = 0;
    int j = 0;
    while (i < s.length() && j < hr.length()) {
      if (s.charAt(i) == hr.charAt(j)) {
        i++;
        j++;
      } else {
        i++;
      }
    }

    if (j < hr.length()) {
      return "NO";
    }

    /*
     * if (i<s.length()){ for (int k=i;k<s.length(); k++){ if (s.charAt(k) !=
     * s.charAt(i-1)){ return "NO"; } } }
     */

    return "YES";
  }

  @Test
  public void testHackerrankInString() {

  /* @formatter:off */
  String input = "10\n"+
  "knarrekcah\n"+
  "hackerrank\n"+
  "hackeronek\n"+
  "abcdefghijklmnopqrstuvwxyz\n"+
  "rhackerank\n"+
  "ahankercka\n"+
  "hacakaeararanaka\n"+
  "hhhhaaaaackkkkerrrrrrrrank\n"+
  "crackerhackerknar\n"+
  "hhhackkerbanker";
  
  /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    for (int i = 0; i < n; i++) {
      System.out.println(hackerrankInString(scanner.next()));
    }

    scanner.close();
  }

  String pangrams(String s) {
    Set<Character> charInAlpha = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (Character.isLetter(ch)) {
        charInAlpha.add(Character.toLowerCase(ch));
      }
    }
    if (charInAlpha.size() == 26) {
      return "pangram";
    } else {
      return "not pangram";
    }

  }

  @Test
  public void testPangrams() {

  /* @formatter:off */
  String input = "We promptly judged antique ivory buckles for the next prize";
  
  /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    System.out.println(pangrams(scanner.nextLine()));

    scanner.close();
  }

  String funnyString(String s) {
    StringBuilder sb = new StringBuilder(s);
    String sr = sb.reverse().toString();

    for (int i = 0; i < s.length() - 1; i++) {
      int diff = Math.abs(s.charAt(i) - s.charAt(i + 1));
      int diffRev = Math.abs(sr.charAt(i) - sr.charAt(i + 1));

      if (diff != diffRev) {
        return "Not Funny";
      }
    }

    return "Funny";

  }

  @Test
  public void testFunnyString() {

  /* @formatter:off */
  String input = "2\n"+
    "acxz\n"+
    "bcxz";
  
  /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    for (int i = 0; i < n; i++) {
      System.out.println(funnyString(scanner.next()));
    }

    scanner.close();
  }

  void separateNumbers(String s) {
   
    
    for (int k = 1; k <= s.length() /2 ; k++){
      long num1 = Long.parseLong(s.substring(0, k));
      long first = num1;
      String num2 = String.valueOf(++num1);
      int len = num2.length();

      int i=k;

      boolean isNotBeautiful = false;
      while (i < s.length() - len){
        if (!num2.equalsIgnoreCase(s.substring(i, i+len))){
          isNotBeautiful = true;
        }   
        i+=len;
        num2 = String.valueOf(++num1);  
        len = num2.length();
      }  
      if (isNotBeautiful){
        continue;
      } else {
        String lastNum = s.substring(i, s.length());
        if (!lastNum.isEmpty() && lastNum.equalsIgnoreCase(num2)){
          System.out.println("YES " + first);
          return;
        }
      }

    }

    System.out.println("NO ");

  }

  @Test
  public void testSeparateNumbers() {

  /* @formatter:off */
  String input = "1\n"+
  "10001001100210031004100510061007";
  
  /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    for (int i = 0; i < n; i++) {
      String s = scanner.next();
      separateNumbers(s);
    }

    scanner.close();
  }

}