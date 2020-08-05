package lxt6.cn.formwork.basic.safety.utils.des;


/**
 * 用于处理1DES和3DES算法
 *
 * @author lxt_team on 2020-03-09 17:36:00
 */
public class DesUtils {

    /**
     * ***************************压缩替换S-Box*************************************
     * ************
     */
    private final int[][] s1 = {
            {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
            {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
            {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
            {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}};
    private final int[][] s2 = {
            {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
            {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
            {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
            {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}};
    private final int[][] s3 = {
            {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
            {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
            {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
            {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}};
    private final int[][] s4 = {
            {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
            {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
            {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
            {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}};
    private final int[][] s5 = {
            {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
            {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
            {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
            {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}};
    private final int[][] s6 = {
            {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
            {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
            {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
            {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}};
    private final int[][] s7 = {
            {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
            {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
            {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
            {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}};
    private final int[][] s8 = {
            {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
            {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
            {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
            {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}};
    private final int[] ip = {58, 50, 42, 34, 26, 18, 10, 2, 60, 52,
            44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48,
            40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35,
            27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31,
            23, 15, 7};
    private final int[] _ip = {40, 8, 48, 16, 56, 24, 64, 32, 39, 7,
            47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45,
            13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11,
            51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49,
            17, 57, 25};
    // 每次密钥循环左移位数
    private final int[] LS = {1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};


    /**
     * 三重DES算法(双长密32byte)) 密钥K1和K2 1、先用K1加密明文 2、接K2对上的结果进行解 3、然后用K1对上的结果进行加
     *
     * @param source 原数据
     * @param key    密码
     * @param type   0:encrypt 1:discrypt
     * @return 3DES操作结果值
     */
    public String DES_3(final String source, final String key, int type) {
        if (key.length() != 32 || source.length() != 16)
            return null;
        String temp = null;
        String K1 = key.substring(0, key.length() / 2);
        String K2 = key.substring(key.length() / 2);
        if (type == 0) {
            temp = encryption(source, K1);
            temp = discryption(temp, K2);
            temp = encryption(temp, K1);
            return temp;
        }
        if (type == 1) {
            temp = discryption(source, K1);
            temp = encryption(temp, K2);
            return discryption(temp, K1);
        }
        return null;
    }

    /**
     * 单长密钥DES(16byte)
     *
     * @param source 原数据
     * @param key    密码
     * @param type   0:encrypt 1:discrypt
     * @return 1DES结果值
     */
    public String DES_1(final String source, final String key, int type) {
        if (source.length() != 16 || key.length() != 16)
            return null;
        if (type == 0) {
            return encryption(source, key);
        }
        if (type == 1) {
            return discryption(source, key);
        }
        return null;
    }

    /**
     * DES解密对称密钥 解密算法与加密算法基本相同，不同之处仅在于轮子密钥的使用顺序逆序，即解密的第1 轮子密钥为加密的6 轮子密钥，解密的
     * 轮子密钥为加密的5 轮子密钥，…， 解密的第16 轮子密钥为加密的 轮子密钥
     *
     * @param source 需要解密的字符串
     * @param key    密码
     * @return 返回解密结果
     */
    private String discryption(final String source, final String key) {
        int[] data = charArrayHex2Binary(source.toCharArray());// 64bit
        if (data==null)
            return null;
        // 第一步初始置
        data = changeIP(data);
        int[] left = new int[32];
        int[] right = new int[32];
        int[] tmp;
        for (int j = 0; j < 32; j++) {
            left[j] = data[j];
            right[j] = data[j + 32];
        }
        int[][] subKey = setKey(key);// sub key ok
        for (int i = 16; i > 0; i--) {
            // 获取(48bit)的轮子密
            /** *******不同之处********* */
            int[] sKey = subKey[i - 1];
            tmp = left;
            // R1 = L0
            left = right;
            // L1 = R0 ^ f(L0,K1)
            int[] fTemp = f(right, sKey);// 32bit
            right = diffOr(tmp, fTemp);
        }
        // 组合的时候，左右调换**************************************************
        for (int i = 0; i < 32; i++) {
            data[i] = right[i];
            data[32 + i] = left[i];
        }
        data = changeInverseIP(data);
        return binaryInt2ASC(data);
    }

    /**
     * DES加密--->对称密钥 D = Ln(32bit)+Rn(32bit) 经过16轮置
     *
     * @param D (16byte)明文
     * @param K (16byte)轮子密钥
     * @return (16byte)密文
     */
    private String encryption(final String D, final String K) {
//		System.out.println("----------->D=" + D);
//		System.out.println("----------->K=" + K);

        int[] temp = new int[64];
        int[] data = charArrayHex2Binary(D.toCharArray());
        if (data==null)
            return null;
//		System.out.println("-----------data=" + printf(data));

        // 第一步初始置
        data = changeIP(data);
//		System.out.println("-----------changeIP=" + printf(data));

        int[][] left = new int[17][32];
        int[][] right = new int[17][32];
        for (int j = 0; j < 32; j++) {
            left[0][j] = data[j];
            right[0][j] = data[j + 32];
        }
        int[][] subKey = setKey(K);// sub key ok
        for (int i = 1; i < 17; i++) {
            // 获取(48bit)的轮子密
            int[] key = subKey[i - 1];
            // L1 = R0
            left[i] = right[i - 1];
            // R1 = L0 ^ f(R0,K1)
            int[] fTemp = f(right[i - 1], key);// 32bit
            right[i] = diffOr(left[i - 1], fTemp);
        }
        // 组合的时候，左右调换**************************************************
        for (int i = 0; i < 32; i++) {
            temp[i] = right[16][i];
            temp[32 + i] = left[16][i];
        }
        temp = changeInverseIP(temp);
        return binaryInt2ASC(temp);
    }


    /**
     * @param R (2bit)
     * @param K (48bit的轮子密
     * @return 32bit
     */
    private int[] f(int[] R, int[] K) {
        int[] dest;
        int[] temp;
        // 先将输入32bit扩展8bit
        int[] expendR = expend(R);// 48bit
        // 与轮子密钥进行异或运
        temp = diffOr(expendR, K);
        // 压缩2bit
        dest = press(temp);
        return dest;
    }

    /**
     * 8bit压缩2bit
     *
     * @param source (48bit)
     * @return R(32bit) B=E(R)⊕K，将48 位的B 分成8 个分组，B=B1B2B3B4B5B6B7B8
     */
    private int[] press(int[] source) {
        int[] ret;
        int[][] temp = new int[8][6];
        int[][][] s = {s1, s2, s3, s4, s5, s6, s7, s8};
        char[] char_temp = new char[8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                temp[i][j] = source[i * 6 + j];
            }
        }
        for (int i = 0; i < 8; i++) {
            // (16)
            int x = temp[i][0] * 2 + temp[i][5];
            // (2345)
            int y = temp[i][1] * 8 + temp[i][2] * 4 + temp[i][3] * 2
                    + temp[i][4];
            int val = s[i][x][y];
            try {
                char_temp[i] = int2Hex(val);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        ret = charArrayHex2Binary(char_temp);
        // printArr(ret);
        // 置换P
        ret = dataP(ret);
        return ret;
    }

    /**
     * 置换P(32bit)
     *
     * @param source 原数据
     * @return 置换后的P值
     */
    private int[] dataP(int[] source) {
        int[] dest = new int[32];
        int[] temp = {16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31,
                10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25};
        int len = source.length;
        for (int i = 0; i < len; i++) {
            dest[i] = source[temp[i] - 1];
        }
        return dest;
    }

    /**
     * 将int转换成Hex
     *
     * @param i 需要转换的整数
     * @return 返回HEX
     */
    private char int2Hex(int i) throws Exception {
        switch (i) {
            case 0:
                return '0';
            case 1:
                return '1';
            case 2:
                return '2';
            case 3:
                return '3';
            case 4:
                return '4';
            case 5:
                return '5';
            case 6:
                return '6';
            case 7:
                return '7';
            case 8:
                return '8';
            case 9:
                return '9';
            case 10:
                return 'A';
            case 11:
                return 'B';
            case 12:
                return 'C';
            case 13:
                return 'D';
            case 14:
                return 'E';
            case 15:
                return 'F';
            default:
                throw new Exception("int2Hex was wrong");
        }
    }

    /**
     * 2bit扩展8bit
     *
     * @param source 需要处理的原数组
     * @return 处理结果
     */
    private int[] expend(int[] source) {
        int[] ret = new int[48];
        int[] temp = {32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12,
                13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22,
                23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1};
        for (int i = 0; i < 48; i++) {
            ret[i] = source[temp[i] - 1];
        }
        return ret;
    }

    /**
     * IP-1逆置
     *
     * @param source 原数据
     * @return 处理结果数据
     */
    private int[] changeInverseIP(int[] source) {
        int[] dest = new int[64];
        for (int i = 0; i < 64; i++) {
            dest[i] = source[_ip[i] - 1];
        }
        return dest;
    }

    /**
     * 获取轮子密钥(48bit)
     *
     * @param source 原数据
     * @return 处理结果数据
     */
    private int[][] setKey(final String source) {
        int[][] subKey = new int[16][48];

        // 装换4bit
        int[] temp = charArrayHex2Binary(source.toCharArray());
        // 6bit均分成两部分
        int[] left = new int[28];
        int[] right = new int[28];
        // 经过PC-14bit转换6bit
        int[] temp1 = new int[56];
        temp1 = keyPC_1(temp);
        // printArr(temp1);
        // 将经过转换的temp1均分成两部分
        for (int i = 0; i < 28; i++) {
            left[i] = temp1[i];
            right[i] = temp1[i + 28];
        }
        // 经过16次循环左移，然后PC-2置换
        for (int i = 0; i < 16; i++) {
            left = keyLeftMove(left, LS[i]);
            right = keyLeftMove(right, LS[i]);
            for (int j = 0; j < 28; j++) {
                temp1[j] = left[j];
                temp1[j + 28] = right[j];
            }
            // printArr(temp1);
            subKey[i] = keyPC_2(temp1);
        }
        return subKey;
    }

    /**
     * 6bit的密钥转换成48bit
     *
     * @param source 原数据
     * @return 处理结果数据
     */
    private int[] keyPC_2(int[] source) {
        int[] dest = new int[48];
        int[] temp = {14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12,
                4, 26, 8, 16, 7, 27, 20, 13, 2, 41, 52, 31, 37, 47, 55, 30, 40,
                51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32};
        for (int i = 0; i < 48; i++) {
            dest[i] = source[temp[i] - 1];
        }
        return dest;
    }

    /**
     * 将密钥数组循环左移i
     *
     * @param source 二进制密钥数组
     * @param i      循环左移位数
     * @return 返回结果值
     */
    private int[] keyLeftMove(int[] source, int i) {
        int temp = 0;
        int len = source.length;
        int ls = LS[i];
        for (int k = 0; k < ls; k++) {
            temp = source[0];
            for (int j = 0; j < len - 1; j++) {
                source[j] = source[j + 1];
            }
            source[len - 1] = temp;
        }
        return source;
    }

    /**
     * 4bit的密钥转换成56bit
     *
     * @param source 原数据
     * @return 处理结果值
     */

    private int[] keyPC_1(int[] source) {
        int[] dest = new int[56];
        int[] temp = {57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18,
                10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55,
                47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53,
                45, 37, 29, 21, 13, 5, 28, 20, 12, 4};
        for (int i = 0; i < 56; i++) {
            dest[i] = source[temp[i] - 1];
        }
        return dest;
    }

    /**
     * IP初始置换
     *
     * @param source 原数据
     * @return 处理结果数据
     */
    private int[] changeIP(int[] source) {
        int[] dest = new int[64];
        for (int i = 0; i < 64; i++) {
            dest[i] = source[ip[i] - 1];
        }
        return dest;
    }

    /**
     * 将二进制整型数组转换成十六进制字符
     *
     * @param arr 原数据
     * @return 处理结果数据
     */
    private String binaryInt2ASC(final int[] arr) {
        int len = arr.length;
        // 不可能出现被4整除不了的情况
        if (len % 4 != 0)
            return null;
        // 每四位一个Hex码
        char[] char_msg = new char[len / 4];
        char[] temp = new char[4];
        try {
            for (int i = 0; i < len / 4; i++) {
                for (int j = 0; j < 4; j++) {
                    temp[j] = BinaryIntToChar(arr[i * 4 + j]);
                }
                // 每四位生成一个Hex码
                //char_msg[i] = int2Hex(Integer.parseInt(String.valueOf(temp), 2));
                //System.out.println(Integer.toHexString(Integer.parseInt(String.valueOf(temp), 2)));
                char_msg[i] = binary2Hex(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return String.valueOf(char_msg);
    }


    /**
     * s位长度的二进制字符串
     *
     * @param temp 原数据
     * @return 处理结果数据
     */
    private char binary2Hex(char[] temp) throws Exception {
        int value = 0;
        if (temp.length != 4)
            throw new Exception("binary2Hex was wrong");
        if (temp[3] == '1')
            value += 1;
        if (temp[2] == '1')
            value += 2;
        if (temp[1] == '1')
            value += 4;
        if (temp[0] == '1')
            value += 8;
        return int2Hex(value);

    }


    /**
     * 将字符串转换成二进制数组
     *
     * @param source_hex :16字节
     * @return 结果值
     */
    private int[] charArrayHex2Binary(char[] source_hex) {
        int len = source_hex.length;
        int[] dest = new int[len * 4];
        char[] str_char;
          for (int i = 0; i < len; i++) {
            try {
                str_char = getBinaryStrByChar(source_hex[i]);
            } catch (Exception e) {
                return null;
            }
            int k = i * 4 + 3;
            for (int j = 3; j >= 0; j--) {
                dest[k] = Integer.parseInt(String.valueOf(str_char[j]));
                k--;
            }
        }
        return dest;
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//            int t = 0;
//            try {
//                t = getIntByChar(arr[i]);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }`
//             这个代码在不同JDK中会出现str的值并不相同，str在JDK1.7中会为5个字符 JDK1.8中会为4个字符
//            String[] str = Integer.toBinaryString(t).split("");
//            int k = i * 4 + 3;
//            for (int j = str.length - 1; j > 0; j--) {
//                dest[k] = Integer.parseInt(str[j]);
//                k--;
//            }

    }


    /**
     * 将十六进制A--F转换成对应二进制字符数组
     *
     * @param ch 原数据
     * @return 结果数据值
     * @ 可能会出现处理异常
     */
    private char[] getBinaryStrByChar(char ch) throws Exception {
        char t = Character.toUpperCase(ch);
        char[] reVal = new char[4];
        switch (t) {
            case '0':
                reVal[0] = '0';
                reVal[1] = '0';
                reVal[2] = '0';
                reVal[3] = '0';
                return reVal;
            case '1':
                reVal[0] = '0';
                reVal[1] = '0';
                reVal[2] = '0';
                reVal[3] = '1';
                return reVal;
            case '2':
                reVal[0] = '0';
                reVal[1] = '0';
                reVal[2] = '1';
                reVal[3] = '0';
                return reVal;
            case '3':
                reVal[0] = '0';
                reVal[1] = '0';
                reVal[2] = '1';
                reVal[3] = '1';
                return reVal;
            case '4':
                reVal[0] = '0';
                reVal[1] = '1';
                reVal[2] = '0';
                reVal[3] = '0';
                return reVal;
            case '5':
                reVal[0] = '0';
                reVal[1] = '1';
                reVal[2] = '0';
                reVal[3] = '1';
                return reVal;
            case '6':
                reVal[0] = '0';
                reVal[1] = '1';
                reVal[2] = '1';
                reVal[3] = '0';
                return reVal;
            case '7':
                reVal[0] = '0';
                reVal[1] = '1';
                reVal[2] = '1';
                reVal[3] = '1';
                return reVal;
            case '8':
                reVal[0] = '1';
                reVal[1] = '0';
                reVal[2] = '0';
                reVal[3] = '0';
                return reVal;
            case '9':
                reVal[0] = '1';
                reVal[1] = '0';
                reVal[2] = '0';
                reVal[3] = '1';
                return reVal;
            case 'A':
                reVal[0] = '1';
                reVal[1] = '0';
                reVal[2] = '1';
                reVal[3] = '0';
                return reVal;
            case 'B':
                reVal[0] = '1';
                reVal[1] = '0';
                reVal[2] = '1';
                reVal[3] = '1';
                return reVal;
            case 'C':
                reVal[0] = '1';
                reVal[1] = '1';
                reVal[2] = '0';
                reVal[3] = '0';
                return reVal;
            case 'D':
                reVal[0] = '1';
                reVal[1] = '1';
                reVal[2] = '0';
                reVal[3] = '1';
                return reVal;
            case 'E':
                reVal[0] = '1';
                reVal[1] = '1';
                reVal[2] = '1';
                reVal[3] = '0';
                return reVal;
            case 'F':
                reVal[0] = '1';
                reVal[1] = '1';
                reVal[2] = '1';
                reVal[3] = '1';
                return reVal;
            default:
                // 需要在调用业务做判断,不可能执行到这里
                throw new Exception("getBinaryStrByChar was wrong");
        }
    }


    /**
     * 两个等长的数组做异或
     *
     * @param source1 参数值1
     * @param source2 参数值班
     * @return 返回处理结果
     */
    private int[] diffOr(int[] source1, int[] source2) {
        int len = source1.length;
        int[] dest = new int[len];
        for (int i = 0; i < len; i++) {
            dest[i] = source1[i] ^ source2[i];
        }
        return dest;

    }

    private char BinaryIntToChar(int temp) throws Exception {
        switch (temp) {
            case 0:
                return '0';
            case 1:
                return '1';
            default:
                throw new Exception("BinaryIntToChar was wrong");
        }
    }


    /**
     * 将s1和s2做异或，然后返回
     *
     * @param s1 参数1
     * @param s2 参数2
     * @return 处理结果值
     */
    protected String xOr(String s1, String s2) {
        int[] iArr = diffOr(charArrayHex2Binary(s1.toCharArray()), charArrayHex2Binary(s2.toCharArray()));
        return binaryInt2ASC(iArr);
    }


}
