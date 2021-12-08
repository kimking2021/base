package priv.kimking.base.core.structure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.HashMap;

/**
 * @author kim
 * @date 2021/12/7
 */
public class HashMapDemo {

    private static final Logger log = LoggerFactory.getLogger(HashMapDemo.class);

    public static void main(String[] args) {

        fibonacciHash();

    }

    /**
     * 菲波那契散列法
     *
     * 0x61c88647 能让哈希码能均匀的分布在 2 的 N 次方的数组里
     *
     */
    public static void fibonacciHash() {
        // 黄金比例 0.618 * 2^32 = 0x61c88647

        // SecureRandom random = new SecureRandom();
        // // i 为常见的 32 位整数
        // int i = random.nextInt(100);
        for (int i = 1; i <= 100; i++) {
            log.info("随机值为：{}", i);
            final int HASH_INCREMENT = 0x61c88647;
            int hashCode = i * HASH_INCREMENT + HASH_INCREMENT;
            log.info("菲波那契散列值为：{}", hashCode);

            int idx = hashCode & ((1<<7) - 1);
            log.info("数组长度为{}的偏移量为：{}", 1<<7, idx);
        }

    }

    public static void computeIfAbsent() {
        // 创建一个 HashMap
        HashMap<String, Integer> prices = new HashMap<>();

        // 往HashMap中添加映射项
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        log.info("HashMap: {}", prices);

        // 计算 Shirt 的值
        int shirtPrice = prices.computeIfAbsent("Shirt", key -> 280);
        log.info("Price of Shirt: {}", shirtPrice);

        // 输出更新后的HashMap
        log.info("Updated HashMap: {}", prices);
    }

}
