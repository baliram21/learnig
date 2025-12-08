package org.nayan.common;

public class SwapAllWays {
    public static void main(String[] args) {

        int a = 10, b = 20;

        System.out.println("Original: a = " + a + ", b = " + b);

        // 1️⃣ Using a temporary variable
        int temp = a;
        a = b;
        b = temp;
        System.out.println("1) Temp Variable: a = " + a + ", b = " + b);

        // Reset
        a = 10; b = 20;

        // 2️⃣ Using + and -
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("2) + and - : a = " + a + ", b = " + b);

        // Reset
        a = 10; b = 20;

        // 3️⃣ Using * and /
        a = a * b;
        b = a / b;
        a = a / b;
        System.out.println("3) * and / : a = " + a + ", b = " + b);

        // Reset
        a = 10; b = 20;

        // 4️⃣ Using XOR
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("4) XOR Swap: a = " + a + ", b = " + b);

        // Reset
        a = 10; b = 20;

        // 5️⃣ One-liner trick
        b = (a + b) - (a = b);
        System.out.println("5) One-liner Swap: a = " + a + ", b = " + b);

        // Reset
        a = 10; b = 20;

        // 6️⃣ Using array (still using a & b only)
        int[] arr = {a, b};
        a = arr[1];
        b = arr[0];
        System.out.println("6) Array Swap: a = " + a + ", b = " + b);

        // Reset
        a = 10; b = 20;

        // 7️⃣ Using method return (still assigning to a & b)
        int[] swapped = swap(a, b);
        a = swapped[0];
        b = swapped[1];
        System.out.println("7) Method Swap: a = " + a + ", b = " + b);
    }

    private static int[] swap(int a, int b) {
        return new int[]{b, a};
    }
}
