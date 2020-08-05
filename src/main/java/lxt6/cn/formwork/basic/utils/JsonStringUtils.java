package lxt6.cn.formwork.basic.utils;


/**
 * 将公司内部的字符拼接串转成标准Json的工具类
 *
 * @author lxt_team on 2020-03-13 10:07:00
 */
public class JsonStringUtils {

    /**
     * 把字符串转换为标准json字符串
     * <p>
     * 例：studentid=140000000000389509*_typeid=6*_schoolid=1#?managerflag=0*_machineid=9912120600000339*_machinetypeid=02
     * 转换后 {"studentid":"140000000000389509","typeid":"6","schoolid":"1","managerflag":"0","machineid":"9912120600000339","machinetypeid":"02"}
     * </p>
     *
     * @param data 需要处理字符串数据
     * @return Json 数据格式
     */
    public static String getJsonString(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        data = data.replaceAll("\\*_", "\",\"").replaceAll("#\\?", "\",\"").replaceAll("=", "\":\"");
        data = "\"" + data + "\"";
        if (!data.startsWith("{")) {
            data = "{" + data;
        }
        if (!data.endsWith("}")) {
            data += "}";
        }
        return data;
    }

}
