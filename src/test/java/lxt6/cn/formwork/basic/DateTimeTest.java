package lxt6.cn.formwork.basic;

import lxt6.cn.formwork.basic.utils.DateTimeUtils;

import java.text.ParseException;
import java.util.Date;

public class DateTimeTest {

    public static void main(String[] args) throws ParseException {


        String date = "2020-01-01 00:00:00";
        Date defaultDate = DateTimeUtils.StrToDate(date, DateTimeUtils.yyyy_MM_dd_HH_mm_ss);

        for (int i = 0; i <= 1000; i++) {
            Date chanageDatetime = DateTimeUtils.getChanageDatetime(defaultDate, i, DateTimeUtils.EnumType.milliSecond);
            System.out.println(DateTimeUtils.DateToStr(chanageDatetime, DateTimeUtils.yyyy_MM_dd_HH_mm_ss));

        }


        if (1 == 1)
            return;
        // 当前时间字符格式
        System.out.println(DateTimeUtils.defualtDateTime());
        System.out.println(DateTimeUtils.nowDateToStr(DateTimeUtils.C_yyyy_MM_dd_HH_mm_ss));


        System.out.println(DateTimeUtils.StrToDate("2020年02月28日 17时00分24秒", DateTimeUtils.C_yyyy_MM_dd_HH_mm_ss));


        Date temp = DateTimeUtils.StrToDate("2018-12-01", DateTimeUtils.yyyy_MM_dd);

        System.out.println(DateTimeUtils.DateToStr(temp, DateTimeUtils.yyyy_MM_dd));

        Date date1 = DateTimeUtils.StrToDate("2018-01-01", DateTimeUtils.yyyy_MM_dd);


        Date date2 = DateTimeUtils.StrToDate("2019-01-01", DateTimeUtils.yyyy_MM_dd);

        System.out.println(DateTimeUtils.isTwoDevalueDay(date1, date2, DateTimeUtils.EnumType.Day));

    }
}
