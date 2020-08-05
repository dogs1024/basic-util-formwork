package lxt6.cn.formwork.basic.utils;

/**
 * 用于处理字节转换数据类型的工具类
 *
 * @author lxt_team on 2020-03-09 17:36:00
 */
public class ByteUtils {

    /**
     * 将字节数组，返回HEX字符串格式  例如：byte[]{0x2B, 0x44, 0xEF,0xD9} to "2B44EFD9"
     *
     * @param b byte[] 字节数组
     * @return 返回HEX字符串形式。
     */
    public static String BytesToHexString(byte[] b) {
        String ret = "";
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            //0x0B&0xFF 0x0B Integer.toHexString(0x0B&0xFF)* &与(两个相应位都为1 则为1，否为0)
            //若高位有零，得值为b,则高位补0为0B;
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
        }
        return ret;
    }

    /**
     * 将一个字节，返回2个HEX字符,例：0x0B to "0B"
     *
     * @param b byte 一个字节。
     * @return 返回HEX字符串形式。
     */
    public static String ByteToHexString(byte b) {
        String ret = "";

        String hex = Integer.toHexString(b & 0xFF);
        //0x0B&0xFF 0x0B Integer.toHexString(0x0B&0xFF)* &与(两个相应位都为1 则为1，否为0)
        //若高位有零，得值为b,则高位补0为0B;
        if (hex.length() == 1) {
            hex = '0' + hex;
        }
        ret += hex.toUpperCase();
        return ret;
    }

    /**
     * 将指定HEX字符串，以每两个字符分割转换为16进制形式 如："2B44EFD9" to byte[]{0x2B, 0x44, 0xEF,
     * 0xD9}
     *
     * @param src String 需要转换的HEX字符串
     * @return byte[] 返回字节数组
     */
    public static byte[] HexStringToBytes(String src) {
        if (src == null || src.equals(""))
            return null;
        byte[] ret = new byte[src.length() / 2];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (byte) Integer.parseInt(src.substring(i * 2, i * 2 + 2), 16);
        }
        return ret;
    }

    /**
     * 将指定两个HEX字符串转换为一个字节 以"2B" 转换为 0x2B 若 "2Z" 则报错。
     *
     * @param src 需要转换的HEX码
     * @return 返回一个字节
     */
    public static byte HexStringToByte(String src) {
        return (byte) Integer.parseInt(src.substring(0, 2), 16);
    }


    /**
     * 将一个Hex码转换为二进制字符串 例如: F=1111
     *
     * @param HexStr 需要转换的HEX码
     * @return 返回二进制字符形式。
     */
    public static String getBinaryStringByHex(String HexStr) {
        if (HexStr.equals("0"))
            return "0000";
        else if (HexStr.equals("1"))
            return "0001";
        else if (HexStr.equals("2"))
            return "0010";
        else if (HexStr.equals("3"))
            return "0011";
        else if (HexStr.equals("4"))
            return "0100";
        else if (HexStr.equals("5"))
            return "0101";
        else if (HexStr.equals("6"))
            return "0110";
        else if (HexStr.equals("7"))
            return "0111";
        else if (HexStr.equals("8"))
            return "1000";
        else if (HexStr.equals("9"))
            return "1001";
        else if (HexStr.equals("A"))
            return "1010";
        else if (HexStr.equals("B"))
            return "1011";
        else if (HexStr.equals("C"))
            return "1100";
        else if (HexStr.equals("D"))
            return "1101";
        else if (HexStr.equals("E"))
            return "1110";
        else if (HexStr.equals("F"))
            return "1111";
        return null;
    }

    /**
     * 将十六进制HEX字符字符串转换为二进制字符串 例如:"1A" "00011010"
     *
     * @param HexString 需要转换的HEX码
     * @return 返回二进制字符串形式
     */
    public static String HexStringToBinaryString(String HexString) {
        if (null == HexString || "".equals(HexString))
            return "";
        String BinaryString = "";
        for (int i = 0; i < HexString.length(); i++) {
            BinaryString += getBinaryStringByHex(String.valueOf(HexString.charAt(i)));
        }
        return BinaryString;
    }


    /**
     * 将数字转换为一个字节
     *
     * @param number 需要转换的整型数据
     * @return 返回一个字节
     */
    public static byte intTobyte(int number) {
        return (byte) (number & 0xFF);
    }

    /**
     * 单个字节改换为整型数字
     *
     * @param tmp 需要转换的一个字节
     * @return 返回一个整型数字
     */
    public static int byteToInt(byte tmp) {
        return tmp & 0xff;
    }

    /**
     * 将8位字节串异或，得到异或值
     *
     * @param b 需要处理的字节串 例： 0xA7^0x03^0x13=0xB7
     * @return 返回得到异或的值
     */
    public static byte XOr(byte[] b) {

        byte retVal = 0x00;
        // 如果字节串长度大于是，则改变初始化temp的值。
        if (b.length > 1)
            retVal = b[0];
            // 字节串为空时，直接返回
        else
            return retVal;
        int i = 1;
        // 字节串大于是时，才处理异或操作
        while (b.length > i) {
            // 执行异或
            retVal = (byte) (retVal ^ b[i]);
            i++;
        }
        return retVal;
    }

    /**
     * 获得按字节数组取累加和的结果值
     *
     * @param bytes 需要处理的字节数组
     * @param isNot 是否取非，若true 累加值取反。
     * @return 返回累加和的结果值
     */
    public static byte getBytesSum(byte[] bytes, boolean isNot) {

        byte sumtemp = bytes[0];
        // 如果字节串长度大于是，则改变初始化temp的值。
        if (bytes.length > 1)
            sumtemp = bytes[0];
            // 字节串只为1值
        else
            return sumtemp;

        int i = 1;
        // 字节串大于是时，才处理异或操作
        while (bytes.length > i) {
            // 执行或 &与 ｜或 ~非
            sumtemp = (byte) (sumtemp + bytes[i]);

            i++;
        }
        if (isNot)
            sumtemp = (byte) ~sumtemp;
        return sumtemp;
    }


    /**
     * 将字节数组颠倒,获得新的字节数组。例如: 0x0064 颠倒后 0x6400。
     *
     * @param b 需要处理的字节数据。
     * @return 返回颠倒字节数据结果。
     */
    public static byte[] getReversalByte(byte[] b) {
        if (b == null || b.length < 1)
            return b;
        byte[] temp = new byte[b.length];
        for (int i = b.length - 1; i >= 0; i--)
            temp[b.length - i - 1] = b[i];

        return temp;

    }


    /**
     * 将一个长整型，用16进制字节数组表示
     *
     * @param number 需要处理的原数据
     * @param max    取返回多少个字节的长度
     * @return 返回一个字节数组。
     */
    public static byte[] longToByteArray(long number, int max) {
        byte[] result = new byte[max];
        for (int i = 0; i < max; i++) {
            if (i != max - 1)
                result[i] = (byte) (number >> ((max - 1) - i) * 8 & 0xFF);
            else
                result[i] = (byte) (number & 0xFF);
        }

        return result;
    }


}
