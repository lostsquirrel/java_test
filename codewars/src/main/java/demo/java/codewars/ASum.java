package demo.java.codewars;

/**
 * solution for http://www.codewars.com/kata/build-a-pile-of-cubes/train/java
 */
public class ASum {
    public static long findNb(long m) {
        // your code
        long n = 0;
        long sum = 0;

        while (true){
             n++;
             sum += n * n * n;
             if (sum >= m) break;
//             System.out.println(n);
//             System.out.println(Math.pow(n, 3));
//             System.out.println(sum);
        }
        System.out.println(sum);
        System.out.println(m);

        return sum == m ? n : -1;
    }

    public static long calVolume(long n) {
        long sum = 0;
        for(long x = 1; x <= n; x++){
            sum += x * x * x;
        }
        return sum;
    }
}
