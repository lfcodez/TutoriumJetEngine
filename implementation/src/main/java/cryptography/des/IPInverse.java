package cryptography.des;

public class IPInverse {
    private final int[][] finalPermutation;

    public IPInverse() {
        finalPermutation = new int[][]{
                {40, 8, 48, 16, 56, 24, 64, 32},
                {39, 7, 47, 15, 55, 23, 63, 31},
                {38, 6, 46, 14, 54, 22, 62, 30},
                {37, 5, 45, 13, 53, 21, 61, 29},
                {36, 4, 44, 12, 52, 20, 60, 28},
                {35, 3, 43, 11, 51, 19, 59, 27},
                {34, 2, 42, 10, 50, 18, 58, 26},
                {33, 1, 41, 9, 49, 17, 57, 25}
        };
    }

    public String permute(String bits) {
        char[] result = new char[64];

        for (int i = 0; i < result.length; i++) {
            result[i] = bits.charAt(finalPermutation[i / 8][i % 8] - 1);
        }

        return new String(result);
    }
}