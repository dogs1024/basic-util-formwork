package lxt6.cn.formwork.basic.utils;


/**
 * 用于处理金额字符处理工具类
 *
 * @author lxt_team on 2020-03-13 10:07:00
 */
public class MoneyUtils {


    /**
     * 根据分钱转换为字符形式的元  例如:  6分=0.06  115分=1.15
     * @param centVal 需要转换的分钱值
     * @return 返回元的形式。
     */
    public static String getYuanString(long centVal) {
        boolean isNegative = false;
        // 小于零
        if (centVal < 0) {
            isNegative = true;
        }
        String temp_val = String.valueOf(Math.abs(centVal));
        String yuanString = "";
        // 1位数
        if (1 == temp_val.length()) {
            yuanString = "0.0" + temp_val;
        }
        // 2位数
        else if (2 == temp_val.length()) {
            yuanString = "0." + temp_val;
        }
        // 大于2位时，则显示方式
        else {
            yuanString = temp_val.substring(0, temp_val.length() - 2) + "." + temp_val.substring(temp_val.length() - 2);
        }

        if (isNegative)
            return "-" + yuanString;
        return yuanString;
    }

    /**
     * 将金钱转换为分钱形式
     * 即0.22元换成22分
     * <pre>
     * getFenByYuanString("1.24")  = 124
     * getFenByYuanString("1.246")  = 0
     * getFenByYuanString("-1.24")  = -124
     * getFenByYuanString("-1.246")  = 0
     * </pre>
     * @param  money 需要转换的元
     * @return 返回分钱long型数据
     */
    public static long getFenByYuanString(String money) {
        if (money == null || money.equals(""))
            return 0;

        boolean isNegative = false;
        String temp = money;
        // 负数
        if (money.charAt(0) == '-') {
            isNegative = true;
            temp = money.substring(1, money.length());
        }
        String[] ss = temp.split("\\.");
        Long result = 0L;
        if (ss.length == 1) {
            result = Long.valueOf(money) * 100;
        } else if (ss.length == 2) {
            if (ss[1].length() == 2) {
                result = Long.valueOf(ss[0]) * 100 + Long.valueOf(ss[1]);
            } else if (ss[1].length() == 1) {
                result = Long.valueOf(ss[0]) * 100 + Long.valueOf(ss[1]) * 10;
            }
        }
        if (isNegative) {
            return 0 - result;
        }
        return result;
    }


}
