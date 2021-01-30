package Leetcode.BitManipulation;

// Count 1 in a bit number
//
// For example, 9 = 1001, output: 2

public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(countWithAnd(9));
        System.out.println(countWithXor(9));

        System.out.println(Integer.toBinaryString(-13));
        System.out.println(countWithAnd(-13));
        System.out.println(countWithXor(-13));
    }

    static int brutalCount(int N) {
        int count = 0;
        while (N != 0) {
            if ((N & 1) != 0) {
                count ++;
            }
            // 考虑负数符号位，最终变成 0xFFFFFFFF 而死循环
            N = N >> 1;
        }
        return count;
    }

    static int countWithXor(int N) {
        int count = 0;
        while (N != 0) {
            int rightOne = N & (~N + 1);
            count ++;

            // 抹掉最右侧的 1
            // 不可 N = N - rightOne，考虑负数
            N = N ^ rightOne;
        }
        return count;
    }

    static int countWithAnd(int N) {
        int count = 0;
        while (N != 0) {
            count ++;
            // 抹掉最右侧的1及后续位置
            N = N & (N - 1);
        }
        return count;
    }

    static int count(int N) {
        return Integer.bitCount(N);
    }
}
