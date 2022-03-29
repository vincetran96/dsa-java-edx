public class GCD {
    public static int gcd(int x, int y) {
        // Base case
        if (y == 0) {
            return x;
        }
        else {
            int remainder = x % y;
            return gcd(y, remainder);
        }
    }

    public static void main(String[] args) {
        System.out.println(gcd(1482, 819));
    }
}
