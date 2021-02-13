package CodingInterview;

public class O15_BitManipulationPractice {

    public static void main(String[] args) {
        O15_BitManipulationPractice solution = new O15_BitManipulationPractice();
//        solution.testIsTwoToNthPower();
        solution.testChangeBitCount();
    }

    /**
     * 判断一个整数是不是2的整数次方。 如 2, 4, 8, ...
     * 注意边界条件，0和负数
     */
    public boolean isTwoToNthPower(int N) {
        // 2的整数次方，其二进制位上应该有且仅有位是1
        // 抹掉最后一位1，该数为0
        // 负数的符号位？一定大于等于 1 (2^0)
        return (N >= 1) && (((N - 1) & N) == 0);
    }

    public void testIsTwoToNthPower() {
        int[] nums = new int[] {0x80000000, 0xFFFFFFFF, 0, 1, 0x7FFFFFFF, -1, -8, 16, 1024, 1025};
        for (int N : nums) {
            System.out.println("N = " + N + ", bit = " + Integer.toBinaryString(N) + ", " + isTwoToNthPower(N));
        }
    }

    /**
     * 输入两个整数 M, N，计算需要改变 M 的几个二进制位才能得到 N
     * 如 10 = 1010，13 = 1101，需要改变3位
     */
    public int changeBitCount(int M, int N) {
        // 不同的二进制位 首先想到就是求异或
        // 然后统计异或结果的二进制位中，有多少个1
        int xor = M ^ N;
        // 一负一正的话，符号位的改变也是要算的上，因此不需要特殊处理
        int count = 0;
        while (N != 0) {
            count ++;
            N = N & (N - 1);
        }
        return count;
    }

    public void testChangeBitCount() {
        int[][] nums = new int[][] {
                {10, 13},
                {-9, 6},
                {0, 0},
                {-1, -13}
        };
        for (int[] pair : nums) {
            int M = pair[0];
            int N = pair[1];
            System.out.println("M = " + M + ", bit = " + Integer.toBinaryString(M));
            System.out.println("N = " + N + ", bit = " + Integer.toBinaryString(N));
            System.out.println("Change bit: " + changeBitCount(M, N));
            System.out.println();
        }
    }
}
