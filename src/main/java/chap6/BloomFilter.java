package chap6;

import java.util.BitSet;
import java.util.Random;

public class BloomFilter {
    private final int size; // 过滤器bit长度
    private final BitSet bitSet;  // 位集
    private final int[] hashSeeds;  // 哈希种子数组
    private final int numHashFunctions;  // 哈希函数个数

    // 构造函数，初始化布隆过滤器
    public BloomFilter(int size, int numHashFunctions) {
        this.size = size;
        this.bitSet = new BitSet(size);
        this.numHashFunctions = numHashFunctions;
        this.hashSeeds = new int[numHashFunctions];
        initializeHashSeeds();
    }

    /**
     * 初始化哈希种子
     */
    private void initializeHashSeeds() {
        Random random = new Random();
        for (int i = 0; i < numHashFunctions; i++) {
            hashSeeds[i] = random.nextInt();
        }
    }

    /**
     * 添加元素到布隆过滤器
     * @param value 添加的字符串元素值
     */
    public void add(String value) {
        for (int i = 0; i < numHashFunctions; i++) {
            int hash = hash(value, hashSeeds[i]);
            bitSet.set(Math.abs(hash % size), true);
        }
    }

    /**
     * 检查元素是否存在于布隆过滤器
     * @param value 输入元素
     * @return 是否存在true/false
     */
    public boolean mightContain(String value) {
        for (int i = 0; i < numHashFunctions; i++) {
            int hash = hash(value, hashSeeds[i]);
            if (!bitSet.get(Math.abs(hash % size))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 简单的哈希函数
     * @param value 元素值
     * @param seed 种子值
     * @return 哈希值
     */
    private int hash(String value, int seed) {
        int result = 0;
        for (int i = 0; i < value.length(); i++) {
            result = result * seed + value.charAt(i);
        }
        return result;
    }
}
