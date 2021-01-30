package ClassZuo.Basic;

public class SwapWithXor {
    void swap(int a, int b) {
        // 假设 a = x; b = y
        a = a ^ b;
        // 1. 交换后b不变，a = x ^ y; b = y
        b = a ^ b;
        // 2. 交换后a不变，a = x ^ y; b = (x ^ y) ^ y = x
        a = a ^ b;
        // 3. 交换后b不变，a = (x ^ y) ^ x = y; b = x
    }
}
