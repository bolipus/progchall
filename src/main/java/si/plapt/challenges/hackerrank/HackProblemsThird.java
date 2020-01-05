
package si.plapt.challenges.hackerrank;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class HackProblemsThird {

  int minimumDistances(int[] a) {
    Map<Integer, Integer> map = new HashMap<>();
    int minDist = Integer.MAX_VALUE;
    for (int i = 0; i < a.length; i++) {
      if (map.containsKey(a[i])) {
        int dist = i - map.get(a[i]);
        if (dist < minDist) {
          minDist = dist;
        }
      } else {
        map.put(a[i], i);
      }

    }

    if (minDist == Integer.MAX_VALUE) {
      return -1;
    }

    return minDist;

  }

  @Test
  public void testEqualizeArray() {

    /* @formatter:off */
    String input = "6\n" +
        "7 1 3 4 1 7";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }

    System.out.println(minimumDistances(a));

    scanner.close();
  }

  int howManyGames(int p, int d, int m, int s) {
    int num = 0;

    if (p > s) {
      return 0;
    }

    while (p <= s) {
      s = s - p;
      p -= d;
      if (p <= m) {
        break;
      }
      num++;
    }

    if (p > s) {
      return num;
    }

    num += s / m + 1;

    return num;
  }

  @Test
  public void testhowManyGames() {

    /* @formatter:off */
    String input = "100 19 1 180";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int p = scanner.nextInt();
    int d = scanner.nextInt();
    int m = scanner.nextInt();
    int s = scanner.nextInt();

    System.out.println(howManyGames(p, d, m, s));

    scanner.close();
  }

  String dayOfProgrammer(int year) {

    String date = "";
    if (year == 1918) {
      date = "26.09." + year;
    }

    if (year < 1918) {
      if (year % 4 == 0) {
        date = "12.09." + year;
      } else {
        date = "13.09." + year;
      }
    }

    if (year > 1918) {
      if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
        date = "12.09." + year;
      } else {
        date = "13.09." + year;
      }
    }
    return date;
  }

  @Test
  public void testDayOfProgrammer() {

    /* @formatter:off */
    String input = "2017";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int year = scanner.nextInt();

    System.out.println(dayOfProgrammer(year));

    scanner.close();
  }

  String appendAndDelete(String s, String t, int k) {

    int common = 0;
    while (common < s.length() && common < t.length() && s.charAt(common) == t.charAt(common)) {
      common++;
    }

    int sr = s.length() - common;
    int tr = t.length() - common;

    String YES = "Yes";
    String NO = "No";

    boolean chkChars = false;

    if (sr > 0 && tr > 0) {
      if (sr + tr == k) {
        return YES;
      } else {
        chkChars = true;
      }
    } else if (sr == 0 && tr == 0) {
      chkChars = true;
    } else if (sr > 0 && tr == 0) {
      if (sr == k) {
        return YES;
      } else {
        chkChars = true;
      }

    } else if (sr == 0 && tr > 0) {
      if (tr == k) {
        return YES;
      } else {
        chkChars = true;
      }
    }

    if (chkChars) {

      k -= (sr + tr);
      if (k > 2 * common) {
        return YES;
      }

      if (k % 2 == 1 || k > common || k < 0) {
        return NO;
      }

      for (int i = 0; i < k; i++) {
        if (s.charAt(common - k + i) != t.charAt(i)) {
          return NO;
        }
      }
      return YES;
    }

    return NO;

  }

  @Test
  public void testAppendAndDelete() {

    /* @formatter:off */
    String input = "y\n"+
    "yu\n"+
    "2";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    String s = scanner.next();
    String t = scanner.next();
    int k = scanner.nextInt();

    System.out.println(appendAndDelete(s, t, k));

    scanner.close();
  }

  int[] acmTeam(String[] topic) {
    int maxNum = 0;
    int numWays = 0;
    for (int i = 0; i < topic.length - 1; i++) {
      for (int j = i + 1; j < topic.length; j++) {
        int num = 0;
        for (int k = 0; k < topic[i].length(); k++) {
          if (topic[i].charAt(k) == '1' || topic[j].charAt(k) == '1') {
            num++;
          }
        }
        if (num == maxNum) {
          numWays++;
        }
        if (num > maxNum) {
          numWays = 1;
          maxNum = num;
        }
      }
    }

    int[] result = { maxNum, numWays };
    return result;
  }

  @Test
  public void testAcmTeam() {

    /* @formatter:off */
    String input = "4 5\n"+
    "10101\n"+
    "11100\n"+
    "11010\n"+
    "00101";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    int m = scanner.nextInt();

    String[] topic = new String[n];

    for (int i = 0; i < n; i++) {
      String topicItem = scanner.next();
      topic[i] = topicItem;
    }

    int[] result = acmTeam(topic);

    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }

    scanner.close();
  }

  long taumBday(int b, int w, int bc, int wc, int z) {
    if (bc + z < wc && wc > bc) {
      return (long) w * (bc + z) + (long) b * bc;
    }
    if (wc + z < bc && bc > wc) {
      return (long) b * (wc + z) + (long) w * wc;
    } else {
      return (long) b * bc + (long) w * wc;
    }

  }

  @Test
  public void testTaumBday() {

    /* @formatter:off */
    String input = "5\n"+
    "10 10\n"+
    "1 1 1\n"+
    "5 9\n"+
    "2 3 4\n"+
    "3 6\n"+
    "9 1 1\n"+
    "7 7\n"+
    "4 2 1\n"+
    "3 3\n"+
    "1 9 2";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int tc = scanner.nextInt();
    for (int i = 0; i < tc; i++) {
      int b = scanner.nextInt();
      int w = scanner.nextInt();
      int bc = scanner.nextInt();
      int wc = scanner.nextInt();
      int z = scanner.nextInt();
      System.out.println(taumBday(b, w, bc, wc, z));
    }

    scanner.close();
  }

  void kaprekarNumbers(int p, int q) {
    int count = 0;
    for (int i = p; i <= q; i++) {
      long n2 = (long) i * i;
      int len = String.valueOf(i).length();
      long beta = (long) n2 % (long) Math.pow(10, len);
      long alfa = (n2 - beta) / (long) Math.pow(10, len);
      if (alfa + beta == i) {
        System.out.print(i + " ");
        count++;
      }
    }
    if (count == 0) {
      System.out.println("INVALID RANGE");
    }

  }

  @Test
  public void testKaprekarNumbers() {

    /* @formatter:off */
    String input = "1\n"+
    "99999";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int p = scanner.nextInt();
    int q = scanner.nextInt();

    kaprekarNumbers(p, q);

    scanner.close();
  }

  int beautifulTriplets(int d, int[] arr) {
    int count = 0;
    for (int i = 0; i < arr.length - 2; i++) {
      for (int j = i + 1; j < arr.length - 1; j++) {
        if (arr[j] - arr[i] != d) {
          continue;
        }
        for (int k = j + 1; k < arr.length; k++) {
          if (arr[k] - arr[j] == d) {
            count++;
          }
        }
      }
    }
    return count;

  }

  @Test
  public void testBeautifulTriplets() {

    /* @formatter:off */
    String input = "7 3\n"+
    "1 2 4 5 7 8 10";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    int d = scanner.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    System.out.println(beautifulTriplets(d, arr));

    scanner.close();
  }

  int chocolateFeast(int n, int c, int m) {

    int bars = n / c;
    int w = bars;
    while (w >= m) {
      int dw = w / m;
      bars += dw;
      w = w - dw * m + dw;
    }

    return bars;
  }

  @Test
  public void testChocolateFeast() throws FileNotFoundException {

    /* @formatter:off */
    String input = "4\n"+
    "14440 3 275\n"+
    "10 2 5\n"+
    "12 4 4\n"+
    "6 2 2";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    /*
     * FileInputStream is = new FileInputStream(
     * "/home/bogdan/Dropbox/Sluzba/Programiranje/ProgrammingChallenges"+
     * "/src/main/java/si/plapt/challenges/hackerrank/vp1.txt");
     */
    Scanner scanner = new Scanner(is);

    int t = scanner.nextInt();

    for (int i = 0; i < t; i++) {
      int n = scanner.nextInt();
      int c = scanner.nextInt();
      int m = scanner.nextInt();
      System.out.println(chocolateFeast(n, c, m));
    }

    scanner.close();
  }

  int[] serviceLane(int n, int[] width, int[][] cases) {
    int[] res = new int[cases.length];
    for (int i = 0; i < cases.length; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = cases[i][0]; j <= cases[i][1]; j++) {
        if (width[j] < min) {
          min = width[j];
        }
      }
      res[i] = min;
    }

    return res;

  }

  @Test
  public void testServiceLane() {

    /* @formatter:off */
    String input = "8 5\n"+
    "2 3 1 2 3 2 3 3\n"+
    "0 3\n"+
    "4 6\n"+
    "6 7\n"+
    "3 5\n"+
    "0 7";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    int t = scanner.nextInt();

    int[] width = new int[n];
    for (int i = 0; i < n; i++) {
      width[i] = scanner.nextInt();
    }

    int[][] cases = new int[t][2];
    for (int i = 0; i < t; i++) {
      for (int j = 0; j < 2; j++) {
        cases[i][j] = scanner.nextInt();
      }
    }

    int[] res = serviceLane(n, width, cases);

    for (int el : res) {
      System.out.println(el);
    }

    scanner.close();
  }

  int workbook(int n, int k, int[] arr) {
    int page = 1;
    int special = 0;
    for (int i = 0; i < n; i++) {
      int pagePerChap = (int) Math.ceil((double) arr[i] / k);

      int minProblem = 1;
      for (int j = 0; j < pagePerChap; j++) {
        int maxProblem = minProblem + k > arr[i] ? arr[i] + 1 : minProblem + k;
        if (page >= minProblem && page < maxProblem) {
          special++;
        }
        page++;
        minProblem += k;

      }

    }

    return special;

  }

  @Test
  public void testWorkbook() {

    /* @formatter:off */
    String input = "5 3\n" + 
    "4 2 6 1 10";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    int k = scanner.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    System.out.println(workbook(n, k, arr));

    scanner.close();
  }

  int flatlandSpaceStations(int n, int[] c) {
    int[] citiesDist = new int[n];
    for (int j = 0; j < n; j++) {
      citiesDist[j] = Integer.MAX_VALUE;
    }
    for (int i = 0; i < c.length; i++) {
      for (int j = 0; j < n; j++) {
        int dist = Math.abs(c[i] - j);
        if (dist < citiesDist[j]) {
          citiesDist[j] = dist;
        }
      }
    }

    int max = Integer.MIN_VALUE;
    for (int j = 0; j < n; j++) {
      if (citiesDist[j] > max) {
        max = citiesDist[j];
      }
    }
    return max;

  }

  @Test
  public void testFlatlandSpaceStations() {

    /* @formatter:off */
    String input = "6 6\n"+
    "0 1 2 4 3 5";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    int m = scanner.nextInt();

    int[] c = new int[n];
    for (int i = 0; i < m; i++) {
      c[i] = scanner.nextInt();
    }

    System.out.println(flatlandSpaceStations(n, c));

    scanner.close();
  }

  int fairRations(int[] b) {
    int loaves = 0;

    for (int i = 0; i < b.length - 1; i++) {
      if (b[i] % 2 == 1) {
        b[i] += 1;
        b[i + 1] += 1;
        loaves += 2;
      }
    }

    if (b[b.length - 1] % 2 == 1) {
      return -1;
    }

    return loaves;

  }

  @Test
  public void testFairRations() {

    /* @formatter:off */
    String input = "2\n"+
    "1 2";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      b[i] = scanner.nextInt();
    }

    System.out.println(fairRations(b));

    scanner.close();
  }

  String[] cavityMap(String[] grid) {

    int n = grid.length;

    String[] result = new String[n];
    for (int i = 0; i < n; i++) {
      result[i] = grid[i];
    }
    for (int i = 1; i < n - 1; i++) {
      for (int j = 1; j < n - 1; j++) {

        int up = Integer.valueOf(grid[i - 1].substring(j, j + 1));
        int down = Integer.valueOf(grid[i + 1].substring(j, j + 1));
        int left = Integer.valueOf(grid[i].substring(j - 1, j));
        int right = Integer.valueOf(grid[i].substring(j + 1, j + 2));
        int middle = Integer.valueOf(grid[i].substring(j, j + 1));

        if (middle > up && middle > down && middle > left && middle > right) {
          result[i] = result[i].substring(0, j) + "X" + result[i].substring(j + 1);
        }
      }
    }

    return result;

  }

  @Test
  public void testCavityMap() {

    /* @formatter:off */
    String input = "4\n"+
    "1112\n"+
    "1912\n"+
    "1892\n"+
    "1234";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();

    String[] grid = new String[n];

    for (int i = 0; i < n; i++) {
      String gridItem = scanner.next();
      grid[i] = gridItem;
    }

    String[] result = cavityMap(grid);

    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }

    scanner.close();
  }

  int[] stones(int n, int a, int b) {

    if (a < b) {
      int tmp = a;
      a = b;
      b = tmp;
    }

    Set<Integer> solution = new HashSet<>();
    for (int i = 0; i < n; i++) {
      solution.add(i * a + (n - i - 1) * b);
    }
    List<Integer> list = solution.stream().sorted().collect(Collectors.toList());
    int[] res = new int[list.size()];
    int i = 0;
    for (int el : list) {
      res[i++] = el;
    }
    return res;
  }

  @Test
  public void testStones() {

    /* @formatter:off */
    String input = "2\n"+
    "3\n"+
    "1\n"+
    "2\n"+
    "4\n"+
    "10\n"+
    "100";
    /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int t = scanner.nextInt();

    for (int i = 0; i < t; i++) {
      int n = scanner.nextInt();
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int[] result = stones(n, a, b);

      for (int j = 0; j < result.length; j++) {
        System.out.print(result[j] + " ");
      }
      System.out.println();
    }

    scanner.close();
  }

  String happyLadybugs(String b) {
    List<Character> list = new ArrayList<>();
    boolean canBeSorted = false;
    for (int i = 0; i < b.length(); i++) {
      if (b.charAt(i) != '_') {
        list.add(b.charAt(i));
      } else {
        canBeSorted = true;
      }

    }
    if (canBeSorted) {
      Collections.sort(list);
    }

    // System.out.println(list);

    boolean isHeapy = false;
    for (int i = 0; i < list.size(); i++) {
      char c = list.get(i);

      if (list.size() == 1) {
        isHeapy = false;
        break;
      }

      if (i == 0) {
        char next = list.get(i + 1);
        if (c == next) {
          isHeapy = true;
        } else {
          isHeapy = false;
          break;
        }
      } else if (i == list.size() - 1) {
        char prev = list.get(i - 1);
        if (c == prev) {
          isHeapy = true;
        } else {
          isHeapy = false;
          break;
        }
      } else {
        char prev = list.get(i - 1);
        char next = list.get(i + 1);
        if (c == prev || c == next) {
          isHeapy = true;
        } else {
          isHeapy = false;
          break;
        }
      }

    }

    if (isHeapy || list.isEmpty()) {
      return "YES";
    } else {
      return "NO";
    }

  }

  @Test
  public void testHappyLadybugs() throws FileNotFoundException {

  /* @formatter:off */
  String input = "4\n"+
  "7\n"+
  "JI_JWHSBIA__JHIWHII_KK__JIBHK__KBS_B\n"+
  "6\n"+
  "E__TZJTD_OYGFM__QKZD_LJL_TJ_YED__DETFFYGJQ_T_JJZDJFMQO___T_JTQGKDTT_ET\n"+
  "2\n"+
  "_PMBBIK_THVEQPN_RHSUP__BI_R_HP_PTEHPRHBKVBN_SQKNB_NVRB_PMBUNT\n"+
  "6\n"+
  "Q_ZEUKWDG_Q_VEE_Z_PDDDEEP_PVDVVGZUEU_Q_";
  /* @formatter:on */

    // InputStream is = new ByteArrayInputStream(input.getBytes())

    FileInputStream is = new FileInputStream("/home/bogdan/Dropbox/Sluzba/Programiranje/ProgrammingChallenges"
        + "/src/main/java/si/plapt/challenges/hackerrank/vp1.txt");

    Scanner scanner = new Scanner(is);

    int g = scanner.nextInt();
    for (int i = 0; i < g; i++) {
      int n = scanner.nextInt();
      String b = scanner.next();
      System.out.println(happyLadybugs(b));
    }

    scanner.close();
  }

  long strangeCounter(long t) {
    float val = (t + 2) / 3;
    long n = (int) Math.floor(Math.log(val) / Math.log(2));
    return 6 * (long) Math.pow(2, n) - t - 2;
  }

  @Test
  public void testStrangeCounter() {

  /* @formatter:off */
  String input = "10";
  /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    long n = scanner.nextLong();
    System.out.println(strangeCounter(n));
    scanner.close();
  }

  String superReducedString(String s) {

    StringBuilder sb = new StringBuilder();
    boolean isReduced = true;
    while (isReduced) {
      sb.setLength(0);
      isReduced = false;
      for (int i = 0; i < s.length(); i++) {
        if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
          i++;
          isReduced = true;
          continue;
        } else {
          sb.append(s.charAt(i));
        }
      }

      s = sb.toString();
      if (s.isEmpty()) {
        break;
      }
    }

    if (sb.length() == 0) {
      return "Empty String";
    } else {
      return sb.toString();
    }

  }

  @Test
  public void testSuperReducedString() {

  /* @formatter:off */
  String input = "aa";
  /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    String s = scanner.next();
    System.out.println(superReducedString(s));
    scanner.close();
  }

  int camelcase(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (Character.isUpperCase(s.charAt(i))) {
        count++;
      }
    }

    return count + 1;
  }

  @Test
  public void testCamelcase() {

  /* @formatter:off */
  String input = "saveChangesInTheEditor";
  /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    String s = scanner.next();
    System.out.println(camelcase(s));
    scanner.close();
  }

  String[] bigSorting(String[] unsorted) {


    Comparator<String> comp = new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
       if (s1.length() == s2.length()){
        for (int k = 0; k < s1.length(); k++) {
          if (s1.charAt(k) != s2.charAt(k)){
            return (int) s1.charAt(k) < (int) s2.charAt(k)? -1: 1;
          }
        }
       }
       return s1.length()-s2.length();      
      }
    };

    Map<String, Integer> map = new TreeMap<>(comp);

    for (String s : unsorted) {
      map.merge(s, 1, (old, val) -> old+ val);
    }

   
    
    String[] sorted = new String[unsorted.length];
    int index = 0;
    for (String s :  map.keySet()) {
      for (int i=0; i< map.get(s); i++){
        sorted[index++] = s;
      }
    }

    return sorted;
  
  }

  @Test
  public void testBigSorting() {

  /* @formatter:off */
  String input = "8\n"+
  "1\n"+
  "2\n"+
  "100\n"+
  "12303479849857341718340192371\n"+
  "3084193741082937\n"+
  "3084193741082938\n"+
  "111\n"+
  "200";
  /* @formatter:on */

    InputStream is = new ByteArrayInputStream(input.getBytes());

    Scanner scanner = new Scanner(is);

    int n = scanner.nextInt();
    String[] unsorted = new String[n];
    for (int i = 0; i < n; i++) {
      unsorted[i] = scanner.next();
    }

    String[] result = bigSorting(unsorted);
    for (String number : result) {
      System.out.println(number);
    }
    scanner.close();
  }
}
