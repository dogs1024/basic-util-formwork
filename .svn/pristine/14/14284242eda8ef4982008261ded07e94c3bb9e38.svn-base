package lxt6.cn.formwork.basic;


import lxt6.cn.formwork.basic.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtilsTest {

    public static void main(String[] args) {

        String msg=" 中国人== ";
        long start=System.currentTimeMillis();
        for(int i=0;i<10000000;i++)
            StringUtils.spaceReplaceLR(msg);
        System.out.println((System.currentTimeMillis()-start)+":ms");

        if (1==1)
            return;

        System.out.println(StringUtils.isContainsGBKStr("123"));
        msg="abcdefghijk";
        System.out.println(StringUtils.left(msg,3));
        System.out.println(StringUtils.right(msg,3));
        System.out.println(StringUtils.mid(msg,2,8));


        msg = "account=13858134334#?password=1#?platform=Android#?version=1.0#?deviceId=862163020184183#?relogin=false";
        String[] arry = StringUtils.getSplitArray(
                "account=13858134334#?password=1#?platform=Android#?version=1.0#?deviceId=862163020184183#?relogin=false",
                "#?");

        for (String temp : arry)
            System.out.println(temp);

        System.out.println("==========");
        Map<String, String> ParameterMap = new HashMap<String, String>();
        StringUtils.getParameterMap(ParameterMap, msg, "#?");

        for (Map.Entry<String, String> entry : ParameterMap.entrySet()) {
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            System.out.println(mapKey + ":" + mapValue);
        }


        Random rand1 = new Random();
        for (int i = 0; i < 4; i++) {
            System.out.println(rand1.nextInt(4));
        }

        //if (1 == 1)
        //    return;

        System.out.println(StringUtils.isHexStr("0ABCDEF"));
        System.out.println(StringUtils.isByteStr("0ABCDEF"));

        for (int i = 0; i < 17; i++) {
            System.out.println(StringUtils.getHexByInteger(i));

            System.out.println("empty:" + StringUtils.isEmpty(StringUtils.getHexByInteger(i)));
        }


        String regex = "^[a-zA-Z0-9-_-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher("YSP2019123175214701_A4780E");
        System.out.println(match.matches());

        String reg = "[\u4e00-\u9fa5]";
        Pattern pat = Pattern.compile(reg);
        Matcher m = pat.matcher("YSP20191231下午75436281_C5F251");
        System.out.println(m.replaceAll(""));

    }
}
