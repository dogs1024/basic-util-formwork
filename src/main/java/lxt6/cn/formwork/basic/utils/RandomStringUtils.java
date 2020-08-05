package lxt6.cn.formwork.basic.utils;


import java.util.*;

/**
 * 主要用于生成随机数的工具类
 *
 * @author lxt_team on 2020-03-13 10:12:00
 */
public class RandomStringUtils {


    /**
     * 从0...9 a...z A...Z 中随机产生6位字符
     *
     * @return 返回6位随机字符
     */
    public static String getRandom6() {
        return getRandomString(6);
    }

    /**
     * 从0...9 a...z A...Z 中随机产生4位字符
     *
     * @return 返回4位随机字符
     */
    public static String getRandom4() {
        return getRandomString(4);
    }

    /**
     * 从0...9 a...z A...Z 中随机产生指定位数字符
     *
     * @param Number 需要产生的字符数量
     * @return 返回随机字符结果值
     */
    public static String getRandomString(int Number) {
        final char chr[] = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        return randomService(chr, Number);
    }

    /**
     * 从0...9 随机产生指定位数的字符串
     *
     * @param Number 产生的数量
     * @return 返回随机字符结果值
     */
    public static String getRandomNumString(int Number) {
        final char chr[] = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        return randomService(chr, Number);
    }

    /**
     * 从a...z 二十六个字母随机产生指定位数的字符串
     *
     * @param Number 产生的数量
     * @return 返回随机字符结果值
     */
    public static String getRandomLowercaseString(int Number) {
        final char chr[] = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        return randomService(chr, Number);
    }

    /**
     * 从A...Z 二十六个字母随机产生指定位数的字符串
     *
     * @param Number 产生的数量
     * @return 返回随机字符结果值
     */
    public static String getRandomCapitalString(int Number) {
        final char chr[] = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        return randomService(chr, Number);
    }

    /**
     * 从0...9,A...F 从HEX码中产生指定位数的字符
     *
     * @param Number 产生的数量
     * @return 返回随机字符结果值
     */
    public static String getByteMaxString(int Number) {
        final char chr[] = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        return randomService(chr, Number);


    }


    /**
     * 用于在字符集中产生指定位数的处理方式
     *
     * @param initArray 字符数组
     * @param Number    需要产生的数量
     * @return 返回随机字符结果值
     */
    public static String randomService(final char initArray[], int Number) {
        if (Number <= 0)
            return "";
        char[] Rands_char = new char[Number];
        // 不重复字符集索引位
        Set<Integer> randSet = null;
        Random rand1 = new Random();
        // 生成的数量值
        int char_num = 0;
        while (char_num < Number) {
            int index = rand1.nextInt(initArray.length);
            // 不重复字符生成方式
            if (Number <= initArray.length) {
                if (randSet == null)
                    randSet = new HashSet<Integer>();
                boolean isOk = randSet.add(index);
                if (isOk) {
                    Rands_char[char_num] = initArray[index];
                    char_num++;
                }

            }
            // 重复字符串生成方式
            else {
                Rands_char[char_num] = initArray[index];
                char_num++;
            }
        }
        return String.valueOf(Rands_char);
    }

}
