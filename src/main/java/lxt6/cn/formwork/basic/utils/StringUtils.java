package lxt6.cn.formwork.basic.utils;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 主要用于处理字符与字符串处理工具类
 *
 * @author lxt_team on 2020-03-13 10:20:00
 */
public class StringUtils {


    /**
     * 用于判断是否为全部数字串
     *
     * @param str 需要解析的数字串
     * @return 返回结果
     */
    public static boolean isNumericStr(final String str) {
        return Pattern.compile("^[0-9]+$").matcher(str).matches();
    }


    /**
     * 用于判断字符串全部是否为a-z,A-Z字母串
     *
     * @param str 需要解析的字母
     * @return 返回结果
     */
    public static boolean isLetterStr(final String str) {
        return Pattern.compile("^[A-Za-z]+$").matcher(str).matches();
    }

    /**
     * 用于判断字符串全部是否为A-Z字母串
     *
     * @param str 需要解析的字母
     * @return 返回结果
     */
    public static boolean isUpperCaseStr(final String str) {
        return Pattern.compile("^[A-Z]+$").matcher(str).matches();
    }

    /**
     * 用于判断字符串全部是否为a-z字母串
     *
     * @param str 需要解析的字母
     * @return 返回结果
     */
    public static boolean isLowerCaseStr(final String str) {
        return Pattern.compile("^[a-z]+$").matcher(str).matches();
    }


    /**
     * 用于判断字符串全部是否为a-z,A-Z,0-9字母串
     *
     * @param str 需要解析的字母
     * @return 返回结果
     */
    public static boolean isAlphanumericStr(final String str) {
        return Pattern.compile("^[A-Za-z0-9]+$").matcher(str).matches();
    }

    /**
     * 用于判断字符串全部是否为中文汉字字符串
     *
     * @param str 需要解析的字母
     * @return 返回结果
     */
    public static boolean isGBKStr(final String str) {
        return Pattern.compile("^[\\u4e00-\\u9fa5]+$").matcher(str).matches();
    }

    /**
     * 用于判断字符串是否包含中文汉字字符串
     *
     * @param str 需要解析的字母
     * @return 返回结果
     */
    public static boolean isContainsGBKStr(final String str) {
        return Pattern.compile("[\\u4e00-\\u9fa5]").matcher(str).find();
    }


    /**
     * 用于判断字符串是否为0...9,A...F HEX码字符串
     *
     * @param str 需要解析的字符
     * @return 返回结果
     */
    public static boolean isHexStr(final String str) {
        return Pattern.compile("^[A-F0-9]+$").matcher(str).matches();
    }

    /**
     * 用于判断字符串是为0...9,A...F,全部是字节的HEX码字符串
     *
     * @param str 需要解析的字母,需要大写并且能被2整除。
     * @return 返回结果
     */
    public static boolean isByteStr(final String str) {
        return isHexStr(str) && str.length() % 2 == 0;
    }


    /***
     * 验证字符串是否是指定格式
     * @param str 待验证的字符串
     * @param patternS 正则表达式
     * @return 返回结果
     */
    public boolean matcher(final String str, String patternS) {
        return Pattern.compile(patternS).matcher(str).matches();
    }

    /**
     * 将十进制数字，转换成十六进制的一个Hex字符
     *
     * @param values 需要转换的十进制数
     * @return 返回一个HEX码
     */
    public static String getHexByInteger(int values) {
        if (values > 15 || values < 0)
            return null;
        String temp = String.valueOf(values);
        if (temp.length() == 1) {
            return String.valueOf(temp);
        } else if (temp.equals("10"))
            return "A";
        else if (temp.equals("11"))
            return "B";
        else if (temp.equals("12"))
            return "C";
        else if (temp.equals("13"))
            return "D";
        else if (temp.equals("14"))
            return "E";
        else if (temp.equals("15"))
            return "F";
        return null;
    }

    /**
     * 将一个Hex字符，转换成十进制数
     *
     * @param values 需要转换的HEX
     * @return 返回十进制数形式
     */
    public static Integer getIntByHexStr(final String values) {

        if (false == isHexStr(values))
            return null;
        if (1 != values.length())
            return null;
        if (values.equals("A"))
            return 10;
        else if (values.equals("B"))
            return 11;
        else if (values.equals("C"))
            return 12;
        else if (values.equals("D"))
            return 13;
        else if (values.equals("E"))
            return 14;
        else if (values.equals("F"))
            return 15;
        return Integer.valueOf(values);

    }


    /**
     * 获得字符串中指定左边多少个字符
     * <p>
     * 例 return 123 left("12345",3);
     * </p>
     *
     * @param msg    要分析的字符串
     * @param number 左边多少个字符
     * @return 返回截取结果字符串
     */
    public static String left(final String msg, int number) {
        if (msg == null)
            return null;
        if (msg.equals(""))
            return "";
        if (number <= 0)
            return "";
        return msg.substring(0, number);
    }

    /**
     * 获得字符串中指定右边多少个字符
     * <p>
     * 例 return 345 right("12345",3);
     * </p>
     *
     * @param msg    要分析的字符串
     * @param number 右边多少个字符
     * @return 返回截取结果字符串
     */
    public static String right(final String msg, int number) {
        if (msg == null)
            return null;
        if (msg.equals(""))
            return "";
        if (number <= 0)
            return "";
        if (number >= msg.length())
            return msg;
        return msg.substring(msg.length() - number);
    }


    /**
     * 获得字符串中的指定位置的字符串信息
     * <p>
     * 例：return 11 mid("00001123",4,2)
     * </p>
     *
     * @param msg        要分析的字符串
     * @param startIndex 开始字符下标位,当超出分析的字符串长度值返回空值。
     * @param number     从下标需要多少个字符数,当字符数超过分析的分长度时返回空值。
     * @return 返回截取结果字符串
     */
    public static String mid(final String msg, int startIndex, int number) {
        if (msg == null)
            return null;
        if (msg.equals(""))
            return "";
        if (startIndex < 0 || number <= 0)
            return "";
        if (startIndex > msg.length())
            return "";
        if (number > msg.length())
            return "";
        return msg.substring(startIndex, startIndex + number);
    }

    /**
     * 将字符串中的左右空格处理掉的新字符串
     * @param msg 需要处理的字符串
     * @return 返回处理后的结果值
     */
    public static String spaceReplaceLR(final String msg) {
        if (msg == null || msg.equals(""))
            return msg;
        char[] char_msg = msg.toCharArray();

        int left_space = 0;
        // 左边空格部分
        for (int i = 0; i < char_msg.length; i++) {
            // 是空格的处理过程
            if (char_msg[i] == ' ') {
                left_space++;
                continue;
            } else
                break;
        }
        // 右边空格部分
        int right_space = 0;
        for (int i = char_msg.length - 1; i >= 0; i--) {
            // 是空格的处理过程
            if (char_msg[i] == ' ') {
                right_space++;
                continue;
            } else
                break;
        }
        // 大部分情况下，认为是不需要取空格可以直接返回的
        if (left_space == 0 && right_space == 0)
            return msg;
        // 取需要获取的值
        char[] retVal = new char[msg.length() - (left_space + right_space)];

        //这种方式，个人理解应该是内存复制方式速度和效率最高，实测区别不大
        //System.arraycopy(char_msg, left_space, retVal, 0, retVal.length);

        // 这种写法没有问题，通用语言
        for (int i = 0; i < retVal.length; i++) {
            retVal[i] = char_msg[left_space + i];
        }


        return String.valueOf(retVal);
    }


    /**
     * 用于处理将字符集成改换成map
     *
     * @param ParameterMap 需要在外部创建ParameterMap
     * @param msg          需要做分隔的信息 例: msg="account=13858134334#?password=1#?platform=Android#?version=1.0#?deviceId=862163020184183#?relogin=false";
     * @param splitStr     分隔符
     * @return -1 参数异常 -2 运行异常 0 返回正常
     */
    public static int getParameterMap(Map<String, String> ParameterMap, String msg,
                                      String splitStr) {
        try {
            if (ParameterMap == null)
                return -1;
            String[] array = getSplitArray(msg, splitStr);
            if (array == null)
                return -1;
            for (String temp : array) {
                String[] key_val = temp.split("=");
                if (key_val.length < 2) {
                    ParameterMap.put(key_val[0], null);
                } else {
                    ParameterMap.put(key_val[0], key_val[1]);
                }
            }
            return 0;
        } catch (Exception e) {
            return -2;

        }
    }

    /**
     * 用于处理字符串中多个分隔符的方法
     * @param msg      原始信息
     * @param splitStr 分隔字符串
     * @return 当输入参数错误时，会返回null;
     */
    public static String[] getSplitArray(String msg, String splitStr) {
        if (msg == null || msg.equals(""))
            return null;
        if (splitStr == null || splitStr.equals(""))
            return null;

        int cursor = 0;
        char[] compare = splitStr.toCharArray();
        ArrayList<String> matchList = new ArrayList<String>();
        StringBuffer result = new StringBuffer();
        while (cursor < msg.length()) {
            char nextChar = msg.charAt(cursor);
            int compareflag = 0;

            // //////////////////////////////////////////////////////////////////////////////////////////////////////////
            // 比较是否为相同的内容
            for (char temp : compare) {
                if (nextChar != temp)
                    break;
                else {
                    compareflag++;
                    // 需要获得数据内容
                    if (compare.length == compareflag) {
                        matchList.add(result.toString());

                        result = new StringBuffer();
                    }
                }
                cursor++;
                if (cursor >= msg.length())
                    break;

                nextChar = msg.charAt(cursor);
            }
            // ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            result.append(nextChar);
            cursor++;
        }
        // 最后一个分隔是不需要加分隔符的
        if (false == result.toString().equals(""))
            matchList.add(result.toString());

        String[] arrayResult = new String[matchList.size()];

        return matchList.toArray(arrayResult);
    }

    /**
     * 字符串首字母大写
     * @param str 需要处理的字符串
     * @return 返回处理后的结果
     */
    public static String upFirst(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        // 进行字母的ascii编码前移，效率要高于截取字符串进行转换的操作
        char[] cs = str.toCharArray();
        if (cs[0] >= 'a' && cs[0] <= 'z') {
            cs[0] -= 32;
            return String.valueOf(cs);
        } else {
            return str;
        }
    }

    // ////////////////////////////////////////////////////////////////////////////////////////////////////////
    // 以下为复用其它的功能方法

    /**
     * 由org.apache.commons.lang3.StringUtils复制，判断是否为空字符或者null。
     * <pre>
     * StringUtils.isEmpty(null)      = true
     * StringUtils.isEmpty("")        = true
     * StringUtils.isEmpty(" ")       = false
     * StringUtils.isEmpty("bob")     = false
     * StringUtils.isEmpty("  bob  ") = false
     * </pre>
     *
     * @param cs CharSequence本身是一个接口,Stirng类、StringBuffer类、StirngBuilder类都实现了这个接口
     * @return 返回是否为空
     */
    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * 由org.apache.commons.lang3.StringUtils复制，判断是否为非空字符。
     *
     * <pre>
     * StringUtils.isNotEmpty(null)      = false
     * StringUtils.isNotEmpty("")        = false
     * StringUtils.isNotEmpty(" ")       = true
     * StringUtils.isNotEmpty("bob")     = true
     * StringUtils.isNotEmpty("  bob  ") = true
     * </pre>
     *
     * @param cs CharSequence本身是一个接口,Stirng类、StringBuffer类、StirngBuilder类都实现了这个接口
     * @return 返回是否非空
     */
    public static boolean isNotEmpty(final CharSequence cs) {
        return !isEmpty(cs);
    }


    /**
     * 由org.apache.commons.lang3.StringUtils复制，判断是否为空白字符(空格、tab 键、换行符)或者null。
     *
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     *
     * @param cs CharSequence本身是一个接口,Stirng类、StringBuffer类、StirngBuilder类都实现了这个接口
     * @return 返回是否为空白字符
     */
    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            // isWhitespace() 方法用于判断指定字符是否为空白字符，空白符包含：空格、tab 键、换行符。
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * 由org.apache.commons.lang3.StringUtils复制，判断是否为非空白字符或者非null。
     *
     * <pre>
     * StringUtils.isNotBlank(null)      = false
     * StringUtils.isNotBlank("")        = false
     * StringUtils.isNotBlank(" ")       = false
     * StringUtils.isNotBlank("bob")     = true
     * StringUtils.isNotBlank("  bob  ") = true
     * </pre>
     *
     * @param cs CharSequence本身是一个接口,Stirng类、StringBuffer类、StirngBuilder类都实现了这个接口
     * @return 返回是否为非空白字符
     */
    public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }


}
