package lxt6.cn.formwork.basic.io.utils.net;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * 用于处理http协议的request请求
 *
 * @author lxt_team on 2020-03-13 10:20:00
 */
public class HttpUtils {

    /**
     * 请求方法的类型枚举
     */
    public enum RequestMethod {
        GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
    }


    /**
     * Http协议请求地址使用的方法
     *
     * @param urlPath       地址
     * @param param         参数
     * @param requestMethod 类型
     * @param isSocketClose 默认长连接使用false;
     * @return 返回请求结果值
     * @throws IOException 可能会抛IO异常
     */
    public static String DefaultRequest(final String urlPath, final String param,
                                        final RequestMethod requestMethod, boolean isSocketClose) throws IOException {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            connection = (HttpURLConnection) new URL(urlPath + param).openConnection();
            connection.setRequestMethod(requestMethod.name());
            connection.setConnectTimeout(10 * 1000);
            connection.setReadTimeout(10 * 1000);
            connection.setUseCaches(false);
            connection.setDefaultUseCaches(false);


            //设置参数类型是json格式
            connection.setRequestProperty("Content-Type", "text/html;charset=UTF-8");
            // 不使用长连接，拿完数据关闭Socket。
            if (isSocketClose) {
                connection.setRequestProperty("Connection", "close");
            } else {
                // 长连接方式
                connection.setRequestProperty("Connection", "Keep-Alive");
                //connection.setRequestProperty("Keep-Alive", "10");
            }


            //

            if (RequestMethod.POST.equals(requestMethod)) {
                // 虽然目标接口是 POST, 但参数还是在 URL上
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Length", "0");
                DataOutputStream os = new DataOutputStream(connection.getOutputStream());
                os.write("".getBytes("UTF-8"), 0, 0);
                os.flush();
                os.close();
            }
            connection.connect();
            // 获取所有响应头
            //Map<String, List<String>> map = connection.getHeaderFields();
            //for (String key : map.keySet()) {
            //    System.out.println(key + "=" + map.get(key));
            //}
            //System.out.println(connection.getContentType());

            inputStream = connection.getInputStream();
            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } finally {

            if (reader != null)
                reader.close();
            if (inputStream != null)
                inputStream.close();
            // 关闭连接方式
            if (connection != null && isSocketClose) {
                connection.disconnect();
            }
        }
    }

    /**
     * Http协议请求地址实际连接TCP的Socket长连接方式。
     *
     * @param urlPath       地址
     * @param param         参数
     * @param requestMethod 类型
     * @return 返回请求结果值
     * @throws IOException  可能会抛IO异常
     */
    public static String DefaultRequest(final String urlPath, final String param,
                                        final RequestMethod requestMethod) throws IOException {
        return DefaultRequest(urlPath, param, requestMethod, false);
    }


}
