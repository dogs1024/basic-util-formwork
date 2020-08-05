package Demo;

import lxt6.cn.formwork.basic.io.utils.net.HttpUtils;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {
    static long num = 0;

    public static void main(String[] args) {
        Set<String> msgSet = new HashSet<String>();
        msgSet.add("2000000000140803140A35100120770B");
        msgSet.add("220201FA14070D093417010282717B8D");
        msgSet.add("2914080408191C0103E80DBA106B6243");
        msgSet.add("9014080408191C00130000012C206243");
        List<String> list = new ArrayList<String>();
        list.add("sign=7073270e9dfb204067bcc2ece8142d20&code=RTcyNzM3QTU2REE2MTYwODdBQzRBNTJBMkM4QjEyMkU2MDE5OUZBQUI3QjhBQjBERTJFNDU2NDQyRDIzOTZFQjJBQ0ZDOUI5MEM3MkVCM0EwODlGQzZEOURFMzU4MzVGQ0U2ODM2QUNEREI5NkQyODc0RTM5MDg1MTBCNDYzNkVCMERGMzQ3N0JFNzRCNDU4NTA3OUE2RUY4MjAxNzgyQkZENDk0NDM2RkZFMEUyMTY2RUY2MjYwODlBOTA0RTQzRTg5MzBCRjA0QjhGOUJFMTJFMzA3Nzg5RjJFQkI4RjU=&sid=C001");
        list.add("sign=c67f95a024d76157251353f6d242395a&code=RTcyNzM3QTU2REE2MTYwODdBQzRBNTJBMkM4QjEyMkUxOTM2QzdCM0UzNEI4RTczOUZCMTAxOERCNTZBQTY5NzRFRUYwNkVGNEEwQkU0NzQxNjgyNkQwQzhFRENENjVFRDQ3Nzk0NTFCODQ1NjQ1RUYyMTc1OUYwMTgwRUFFQ0Q5QUMwNUQzMTUwRkVFRjczQ0UwNkMyQ0JEMjhFNEFGQ0FGM0JBQTVCREEyQjVDRTVEMjlBMDdGNDY5NjUzNzk4OUUwQkZEQUE1OUVDMTI1MUQ2QzYwOUMyQzY4RTk4MkQ=&sid=C001");
        list.add("sign=0518b54e6a800668d54b98d887288dab&code=OTYzOENGRjBCNUVBOTBENTI4NDhDMzM5QkEyRUY3OEYyNjNBMEVBQjhEOUQ1OTFEQUIzMkU3NjlDMERDOTYwOTY5OTk1QzNBNTcwNTY3OEQ3NjQ0NDUwNjIzMzNDMjg0OTdDM0JFQjgxQjE1NzlGOEIzOEMwMzdDMUVEOTlENkRGQzYzQ0VFQjFCQzM5NjAxQzA0RTk1RjU4NzgwQjI2NzZBOTM1NUZBRTQ4NkVCNjJFQjYwNTdCNDA0OTk2QTRCNEJGQkFDMjNCM0UwRjJEMzI0RUUwOEFBMEY3RDNFQkY=&sid=C001");
        list.add("sign=0bb8d2621763ef5ae3f731e07c8f5dcf&code=RTcyNzM3QTU2REE2MTYwODdBQzRBNTJBMkM4QjEyMkVFNTUzRUUxRDRBODE4OEE4RDAwRjMyOTc0RUVGQUMwQ0E2QTMzQjQwMUIxQzI2M0NBQTI1MzAxMTIwRkRCNzMzRUYwMkIzMkM2ODA0MTk0RDEwOEU2MzE5MTI0NDI5NUUzNUQ1OTE0MjJBQkNFMDBFOTkxMDFFMUVCQUY3QjA2RTAwM0Q0MjAxN0QxMDI3QjI0REVFNDk5M0QwMTk2MDlDMTk2Njc1RjI2MjcwQzk2MDgwQkIzMUE3RTRBRTk5NDA=&sid=C001");
        // 解密失败
        //list.add("sign=7381f22b840937b387cb680e1082034e&code=MDdCMTNBRTVENTNFRUVGNzY4MDlBOTlDMzhBODIwNTRGNTA3REI0N0JCQzY0MzMxODQ5Q0U3QzY4NTA0QjEyRUU0RjI4RjVGNDlBNjU0MUUzNzM5NzVERkJBRUQyRkRDQzlFMDI3MTJDOTkyNkExNDBCNzcxRTQ1MDUyMTc3OTA0RjY0MDg0MzIwQjM3RDk1MTRDNTJBMDkyOEZCNzBFREFBODFDNzFGQzA5M0RFQkEwQUM3RjkzNDRFMTVFMUIxMThGODQ0RjlDRTk0NDMxNTM1OTRGMzVDOUU5RUIxQkM=&sid=C001");
        ExecutorService executorService = Executors.newFixedThreadPool(200);
        long startTime = System.currentTimeMillis();
        //String urlPath = "http://analysis.lexiaotong.cn:10088/DataPass/decodeUnifiedPassServiceV1?";
        //String urlPath = "http://www.testlexiaotong.cn:9090/DataPass/decodeUnifiedPassServiceV1?";
        String urlPath = "http://127.0.0.1:8093/jingjie/decodeUnifiedPassServiceV1?";

        // 执行五分钟
        while ((System.currentTimeMillis() - startTime) < 5 * 60 * 1000) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        int index = new Random().nextInt(4);
                        String param = list.get(index);
                        String msg = HttpUtils.DefaultRequest(urlPath, param, HttpUtils.RequestMethod.GET, false);

                        boolean isFind = false;
                        for (String str : msgSet) {
                            if (msg.contains(str)) {
                                isFind = true;
                                break;
                            }
                        }
                        if (false == isFind) {
                            System.out.println("msg:" + msg + "url" + urlPath + "?" + param + " 线程名称" + Thread.currentThread().getName());
                            return;
                        }
                        num++;
                        System.out.println("number:" + num + " index:" + index);

                        Thread.sleep(10);
                        //System.out.println("线程名称"+Thread.currentThread().getName()+"结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("开始关闭线程池，不再接受新任务");
        executorService.shutdown();
        System.out.println("===========");
        //等待所有线程执行完成
        while (!executorService.isTerminated()) {
        }
        System.out.println("线程池关闭完成");
    }
}
