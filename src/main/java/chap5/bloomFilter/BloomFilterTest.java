package chap5.bloomFilter;

public class BloomFilterTest {
    public static void main(String[] args) {
        // 创建一个布隆过滤器，大小为1000，使用5个哈希函数
        BloomFilter bloomFilter = new BloomFilter(1000, 5);

        // 添加一些元素
        bloomFilter.add("hello");
        bloomFilter.add("world");

        // 检查元素是否存在
        System.out.println(bloomFilter.mightContain("hello")); // 输出：true
        System.out.println(bloomFilter.mightContain("world")); // 输出：true
        System.out.println(bloomFilter.mightContain("OK")); // 输出：false (可能)
    }
}
