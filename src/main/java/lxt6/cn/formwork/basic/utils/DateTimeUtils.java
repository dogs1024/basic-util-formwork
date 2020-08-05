package lxt6.cn.formwork.basic.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 主要用于处理日期与时间转换的工具类
 *
 * @author lxt_team on 2020-03-13 09:36:00
 */
public class DateTimeUtils {

    public final static String yyyyMMddHHmmSSSSS = "yyyyMMddHHmmssSSS";
    public final static String yyyyMMddHHmmSS = "yyyyMMddHHmmss";
    public final static String yyMMddHHmmSS = "yyMMddHHmmss";
    public final static String yyMMddHHmm = "yyMMddHHmm";

    public final static String yyyyMMdd = "yyyyMMdd";
    public final static String yyMMdd = "yyMMdd";
    public final static String yyyyMM = "yyyyMM";
    public final static String yyyy = "yyyy";
    public final static String yy = "yy";
    public final static String MM = "MM";
    public final static String dd = "dd";
    public final static String MMdd = "MMdd";

    public final static String HHmmss = "HHmmss";
    public final static String HHmm = "HHmm";
    public final static String HH = "HH";
    public final static String mm = "mm";
    public final static String ss = "ss";


    public final static String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    public final static String yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";
    public final static String yyyy_MM_dd = "yyyy-MM-dd";
    public final static String yyyy_MM = "yyyy-MM";
    public final static String MM_dd = "MM-dd";

    public final static String MM_dd_HH_mm = "MM-dd HH:mm";
    public final static String HH_mm_ss = "HH:mm:ss";
    public final static String HH_mm = "HH:mm";

    public final static String C_yyyy_MM_dd_HH_mm_ss = "yyyy年MM月dd日 HH时mm分ss秒";
    public final static String C_yyyy_MM_dd_HH_mm = "yyyy年MM月dd日 HH时mm分";
    public final static String C_yyyy_MM_dd = "yyyy年MM月dd日";
    public final static String C_yyyy_MM = "yyyy年MM月";


    private static final ZoneId zoneId = ZoneId.systemDefault();

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(yyyy_MM_dd_HH_mm_ss);


    /**
     * 按yyyy-MM-dd HH:mm:ss 格式，返回数据
     *
     * @return 返回现在时间默认时间格式化字符串
     */
    public static String defualtDateTime() {
        return LocalDateTime.now().format(DATE_TIME_FORMATTER);
    }

    /**
     * 按默认格式将一个字符串时间转换为日期时间数据
     *
     * @param strDate 待转换的时间字符串值，必须按默认yyyy-MM-dd HH:mm:ss格式
     * @return 返回日期Date格式
     * @throws DateTimeParseException 如果所给的字符串不能被解析抛异常
     */
    public static Date StrToDate(String strDate) throws DateTimeParseException {
        return LocalDateTimeToDate(LocalDateTime.parse(strDate, DATE_TIME_FORMATTER));
    }


    /**
     * 将LocalDateTime转换为Date
     *
     * @param localDateTime 需要转换的LocalDateTime
     * @return 返回日期Date格式
     */
    public static Date LocalDateTimeToDate(final LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(zoneId).toInstant());
    }

    /**
     * 将 Date转换为LocalDateTime
     *
     * @param date 需要转换的Date
     * @return 返回LocalDateTime格式
     */
    public static LocalDateTime DateToLocalDateTime(final Date date) {
        return date.toInstant().atZone(zoneId).toLocalDateTime();
    }


    /**
     * 将日期数据转换为格式化日期或时间字符串。
     *
     * @param date    待格式化的日期
     * @param pattern 日期时间样式
     * @return 返回一个时间格式化字符串
     */
    public static String DateToStr(final Date date, String pattern) {
        if (date == null)
            return "";
        return LocalDateTime.ofInstant(date.toInstant(), zoneId)
                .format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 根据当前时间获取格式化时间字符串
     *
     * @param pattern 日期时间样式
     * @return 返回一个时间格式化字符串
     */
    public static String nowDateToStr(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }


    /**
     * 将一个字符串时间格式，转换为日期数据格式
     *
     * @param strDate 待转换的时间字符串值 注意：2018-13-01会抛异常
     * @param pattern 日期时间样式
     * @return 返回日期Date数据格式
     * @throws ParseException 如果所给的字符串不能被解析成一个日期抛异常
     */
    public static Date StrToDate(String strDate, String pattern)
            throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.CHINA);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        //默认为宽容，会把不符合规则的日期格式也转换。设为false将禁用，只有是实际存在的日期才能正确转换
        sdf.setLenient(false);
        return sdf.parse(strDate);
    }


    /**
     * 按给定日期样式判断给定字符串是否为合法日期数据
     *
     * @param strDate 要判断的日期字符
     * @param pattern 要判断日期字符的样式
     * @return true 如果是，否则返回false
     */
    public static boolean isDate(String strDate, String pattern) {
        try {
            /**
             * StrToDate(strDate, pattern) 例 2002-13-01会抛异常返回false;
             * DateToStr(strDate, pattern) 得到日期的字符和 strdate作比较，相同说明是日期！
             */
            if (strDate.equals(DateToStr(StrToDate(strDate, pattern), pattern)))
                return true;
            return false;
        } catch (ParseException pe) {
            return false;
        }
    }

    /**
     * 用于处理两日期时间差值的算法格式
     */
    public enum EnumType {
        // 按天计算
        Day,
        // 按小时计算
        Hour,
        //按分钟计算
        Minute
        // 按钞计算
        , Second
        // 按毫秒
        , milliSecond;

    }


    /**
     * 将一个时间向前或向后推迟或者前进后多少分钟处理后的时间
     *
     * @param date   原日期时间参数
     * @param number 需要处理的格式
     * @return 返回处理结果值
     */
    public static Date getChanageDatetimeByMinute(Date date, int number) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(calendar.MINUTE, calendar.get(calendar.MINUTE)
                    + number);
            return calendar.getTime();
        } catch (Exception ee) {
            return null;
        }
    }

    /**
     * 将一个时间向前或向后推迟或者前进后按指定格式处理后的时间
     * @param date   原日期时间参数
     * @param number 需要处理的格式
     * @param type 按天、小时、分钟、秒、毫秒
     * @return 返回处理结果值
     */
    public static Date getChanageDatetime(Date date, int number, EnumType type) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            switch (type) {
                case Day: {
                    calendar.set(calendar.DATE, calendar.get(calendar.DATE)
                            + number);
                    break;
                }
                case Hour: {
                    calendar.set(calendar.HOUR, calendar.get(calendar.HOUR)
                            + number);
                    break;
                }
                case Minute: {
                    calendar.set(calendar.MINUTE, calendar.get(calendar.MINUTE)
                            + number);
                    break;
                }
                case Second: {
                    calendar.set(calendar.SECOND, calendar.get(calendar.SECOND)
                            + number);
                    break;
                }
                case milliSecond: {
                    calendar.set(calendar.MILLISECOND, calendar.get(calendar.MILLISECOND)
                            + number);
                    break;
                }
            }


            return calendar.getTime();
        } catch (Exception ee) {
            return null;
        }
    }

    /**
     * 判断两个日期相差值,日期一比日期二时间晚的话获得正数，根据按时间单位返回值的大小。
     *
     * @param date1 日期时间参数1
     * @param date2 日期时间参数2
     * @param type  枚举
     * @return 返回相差值
     */
    public static long isTwoDevalueDay(final Date date1, final Date date2, EnumType type) {
        //默认按秒
        int Number = 1000;
        switch (type) {
            case Day: {
                Number = 3600 * 24 * 1000; // 天
                break;
            }
            case Hour: {
                Number = 3600 * 1000; // 小时
                break;
            }
            case Minute: {
                Number = 60 * 1000; // 分钟
                break;
            }
            case Second: {
                Number = 1000; // 秒
                break;
            }
            case milliSecond: {
                Number = 1; // 毫秒
                break;
            }
        }
        return (date1.getTime() - date2.getTime()) / Number;
    }


}
