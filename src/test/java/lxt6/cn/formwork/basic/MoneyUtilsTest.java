package lxt6.cn.formwork.basic;


import lxt6.cn.formwork.basic.utils.MoneyUtils;

public class MoneyUtilsTest {

    public static void main(String[] args) {

        System.out.println(MoneyUtils.getYuanString(1234));
        System.out.println(MoneyUtils.getFenByYuanString("1.2"));

    }
}
