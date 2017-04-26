import java.io.*;
import java.util.*;
import java.util.stream.*;

public class MinCandies {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int numCandies = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ratings = new int[N];
        for(int i = 0; i < N; ratings[i++] = Integer.parseInt(br.readLine())){}
        br.close();
        numCandies = calculateCandies(ratings);
        System.out.println(numCandies);
    }

    public static int calculateCandies(int[] ratings) {
    if (ratings.length < 1) {
        return 0;
    }
    if (ratings.length == 1) {
        return 1;
    }

    int[] candies = calculateCandiesFromLeft(ratings);
    calculateCandiesFromRight(ratings, candies);

    int sum = 0;
    return IntStream.of(candies).sum();
    }

    private static int[] calculateCandiesFromLeft(int[] ratings) {
    int[] candies = new int[ratings.length];
    candies[0] = 1;

    for (int i = 1; i < ratings.length; i++) {
        if (ratings[i] > ratings[i - 1]) {
            candies[i] = candies[i - 1] + 1;
        } else {
            candies[i] = 1;
        }
    }
    return candies;
    }

    private static void calculateCandiesFromRight(int[] ratings, int[] candies) {
    for (int i = ratings.length - 2; i >= 0; i--) {
        if (ratings[i] > ratings[i + 1]) {
            candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }
    }
    }
}
