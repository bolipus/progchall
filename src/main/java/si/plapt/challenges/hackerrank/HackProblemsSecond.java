package si.plapt.challenges.hackerrank;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class HackProblemsSecond {

  @Test
  public void testTemplate() {

    String input = "";

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    scanner.close();
  }

  int beautifulDays(int i, int j, int k) {
    int count = 0;
    for (int m = i; m <= j; m++) {
      StringBuilder sb = new StringBuilder();
      sb.append(m);
      int iM = Integer.parseInt(sb.reverse().toString());

      int diff = (int) (Math.abs(m - iM));

      if (diff % k == 0) {
        count++;
      }
    }

    return count;

  }

  @Test
  public void testBeautifulDays() {

    String input = "20 23 6";

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int i = scanner.nextInt();
    int j = scanner.nextInt();
    int k = scanner.nextInt();

    System.out.println(beautifulDays(i, j, k));

    scanner.close();
  }

  int viralAdvertising(int n) {
    int shared = 5;
    int liked = Math.floorDiv(shared, 2);
    int cummulative = liked;
    for (int i = 0; i < n - 1; i++) {
      shared = liked * 3;
      liked = Math.floorDiv(shared, 2);
      cummulative += liked;
    }
    return cummulative;
  }

  @Test
  public void testViralAdvertising() {

    String input = "3";

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();

    System.out.println(viralAdvertising(n));

    scanner.close();
  }

  int saveThePrisoner(int n, int m, int s) {

    return (s + m - 2) % n + 1;
  }

  @Test
  public void testSaveThePrisoner() {

    String input = "2\n" + "7 19 2\n" + "3 7 3";

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int nc = scanner.nextInt();

    for (int i = 0; i < nc; i++) {
      int n = scanner.nextInt();
      int m = scanner.nextInt();
      int s = scanner.nextInt();

      System.out.println(saveThePrisoner(n, m, s));
    }

    scanner.close();
  }

  int[] circularArrayRotation(int[] a, int k, int[] queries) {

    int[] result = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int index = (queries[i] - k) % a.length;
      if (index < 0) {
        index += a.length;
      }
      result[i] = a[index];
    }
    return result;
  }

  @Test
  public void testCircularArrayRotation() throws FileNotFoundException {

    String input = "3 2 3\n" + "1 2 3\n" + "0\n" + "1\n" + "2";

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    int k = scanner.nextInt();
    int q = scanner.nextInt();

    int a[] = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }

    int[] queries = new int[q];

    for (int i = 0; i < q; i++) {
      queries[i] = scanner.nextInt();
    }

    int[] result = circularArrayRotation(a, k, queries);
    for (int el : result) {
      System.out.println(el);
    }

    scanner.close();
  }

  int[] permutationEquation(int[] p) {
    int[] map = new int[p.length];
    for (int i = 0; i < p.length; i++) {
      map[p[i] - 1] = i + 1;
      ;
    }
    int[] second = new int[p.length];
    for (int i = 0; i < p.length; i++) {
      int k = map[i] - 1;
      second[i] = map[k];
    }

    return second;
  }

  @Test
  public void testPermutationEquation() throws FileNotFoundException {

    String input = "5\n" + "5 2 1 3 4";

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    int[] p = new int[n];
    for (int i = 0; i < n; i++) {
      p[i] = scanner.nextInt();
    }

    int[] result = permutationEquation(p);

    for (int x : result) {
      System.out.println(x);
    }

    scanner.close();
  }

  int findDigits(int n) {
    int count = 0;
    int x = n;
    while (x > 0) {
      int d = x % 10;
      if (d > 0 && n % d == 0) {
        count++;
      }
      x = x / 10;
    }

    return count;

  }

  @Test
  public void testFindDigits() {

    String input = "2\n" + "12\n" + "1201\n";

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int nc = scanner.nextInt();
    for (int i = 0; i < nc; i++) {
      System.out.println(findDigits(scanner.nextInt()));
    }

    scanner.close();
  }

  int jumpingOnClouds(int[] c, int k) {
    int e = 100;
    int index = 0;
    do {
      e -= 1;
      if (c[index] == 1) {
        e -= 2;
      }
      index = (index + k) % c.length;

    } while (index > 0);

    return e;

  }

  @Test
  public void testJumpingOnClouds() {

    String input = "8 2\n" + "0 0 1 0 0 1 1 0";

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    int k = scanner.nextInt();
    int[] c = new int[n];
    for (int i = 0; i < n; i++) {
      c[i] = scanner.nextInt();
    }

    System.out.println(jumpingOnClouds(c, k));

    scanner.close();
  }

  int squares(int a, int b) {
    int lower = (int) Math.sqrt(a);
    int higher = (int) Math.sqrt(b);
    // System.out.println(lower);
    // System.out.println(higher);
    while (lower * lower < a) {
      lower++;
    }

    while (higher * higher > b) {
      higher--;
    }

    return higher - lower + 1;
  }

  @Test
  public void testSquares() {

    /* @formatter:off */
    String input = "2\n" + 
    "3 9\n" + "17 24";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    for (int i = 0; i < n; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      System.out.println(squares(a, b));
    }

    scanner.close();
  }

  int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
    if (y1 > y2) {
      return 10000;
    } else if (y1 == y2) {
      if (m1 > m2) {
        return 500 * (m1 - m2);
      } else if (m1 == m2) {
        if (d1 > d2)
          return 15 * (d1 - d2);
        else
          return 0;
      } else {
        return 0;
      }
    } else {
      return 0;
    }

  }

  @Test
  public void testLibraryFine() {

    /* @formatter:off */
    String input = "2 5 2015\n"+
    "30 5 2015";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int d1 = scanner.nextInt();
    int m1 = scanner.nextInt();
    int y1 = scanner.nextInt();

    int d2 = scanner.nextInt();
    int m2 = scanner.nextInt();
    int y2 = scanner.nextInt();

    System.out.println(libraryFine(d1, m1, y1, d2, m2, y2));

    scanner.close();
  }

  int[] cutTheSticks(int[] arr) {

    Arrays.sort(arr);
    int count = arr.length;
    List<Integer> ans = new ArrayList<>();
    ans.add(count);
    int index = 0;
    while (count > 0){
      int smallest = arr[index];
      for (int i=index; i< arr.length; i++){
        arr[i] -= smallest;
        if (arr[i] == 0){
          index++;
          count--;        
        }
      }
      if (count > 0)
        ans.add(count);
    }

    int[] res2 = new int[ans.size()];
    for (int i=0; i< ans.size(); i++){
      res2[i] = ans.get(i);
    }

    return res2;

  }

  @Test
  public void testCutTheSticks() {

    /* @formatter:off */
    String input = "8\n"+
    "1 2 3 4 3 3 2 1";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    int[] arr = new int[n];
    for (int i=0; i< n; i++){
      arr[i] = scanner.nextInt();
    }
    
    int[] res = cutTheSticks(arr);
    for (int i=0;i<res.length; i++){
      System.out.println(res[i]);
    }

    scanner.close();
  }

  long repeatedString(String s, long n) {
    long num = n / (long)s.length();
    long rem = n % (long) s.length();
    
    int perString = 0;
    int perRem = 0;
    for(int i=0; i < s.length(); i++){
      if (s.charAt(i) == 'a'){
        perString++;
        if (i<rem){
          perRem++;
        }
      }
    }

    return num*perString + perRem;

  }


  @Test
  public void testRepeatedString() {

    /* @formatter:off */
    String input = "aba\n"+
    "10";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    String s = scanner.next();
    int n = scanner.nextInt();

    System.out.println(repeatedString(s, n));
    scanner.close();
  }

  int jumpingOnCloudsExt(int[] c) {
    int jumps = 0;
    int pos = 0;
    int n = c.length;
    while (pos < n-1){
      if (pos+2 < n && c[pos+2] != 1){
        pos+=2;
      } else if (pos+1 < n){
        pos++;
      }
      jumps++;
    }

    return jumps;

  }



  @Test
  public void testJumpingOnCloudsExt() {

    /* @formatter:off */
    String input = "7\n"+
    "0 0 1 0 0 1 0";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();

    int[] c = new int[n];
    for (int i=0;i< n; i++){
      c[i] = scanner.nextInt();
    }

    System.out.println(jumpingOnCloudsExt(c));
    scanner.close();
  }
  
  
  int equalizeArray(int[] arr) {
	  Map<Integer, Integer> map = new HashMap<>();
	  for(int i=0; i< arr.length; i++) {
      Integer counter = map.getOrDefault(arr[i], 0);
      counter++;
		  map.put(arr[i], counter);		  
	  }
	  
	  List<Integer> countings = map.values().stream().collect(Collectors.toList());
	  
	  Collections.sort(countings, Collections.reverseOrder());
	  
	  return arr.length-countings.get(0);
  }
  
  
  @Test
  public void testEqualizeArray() {

    /* @formatter:off */
    String input = "5\n" + 
    		"3 3 2 1 3";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    int[] arr = new int[n];
    for (int i=0;i<n; i++) {
    	arr[i] = scanner.nextInt();
    }
    
    System.out.println(equalizeArray(arr));
    
   
    scanner.close();
  }
  
  
  
  
  
  
  
  


}