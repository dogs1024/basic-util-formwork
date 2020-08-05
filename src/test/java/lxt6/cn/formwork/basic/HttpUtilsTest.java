package lxt6.cn.formwork.basic;


import lxt6.cn.formwork.basic.io.utils.net.HttpUtils;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class HttpUtilsTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        String urlPath = "http://test.lexiaotong.cn:8089/app/EWallet/GetStudentApplication?";


        String param = "code=QUI5QTFERThENUM3RkQzMzhEOEI2Mzc3MEIzMTYzQ0RBNTE4MTYzNDI3QjVEREI0QjRDQTU3Q0MyODVDMTM2RjkzMEU1RkU5NTBDOUVCMDJDMEQ1RDhCODU1NTY5MkE0MkJDRjg3M0UwODdGNjI4NjM1NEJBNjc2OTFDMjg2REI=&sign=4dcf10176638126ca2ea1529778b925e&Token=4SvycAq110jwcJ8UNeRQp7x4tDtf8Co";
        //urlPath = "http://119.23.64.162:10088//DataPass/SysPosServiceV1?";
        //param = "code=MTg0MjY5MzM3QUQyRDZGRDlGNTkzNDYxMTAwOUM5NTU1QjBCNDNBMDFGMUQ1OUEzRjcwNUQ1RDY5OEZBMUIyRjA0NEU4QjNDNDg5NEMxQTREMjdBOTY0RkMzNTdCODNFODEwNERFMDU2MUVDNjQ3NjhEMTlFMTRCRjY3NTE2NzVEMDQ0MDc4QTVDQzcwRDMxMUJGQzhBNTYwNEJEOTEwMkYxNjgyMjYxOUU2NTQxRDVBQ0M3QzJDNDlGQTlGNjFBMzU2QTY2QUIzQjUwNDk3QTA4MjU1QkMzRTk4RkNFRUM5N0ExNzI5RUJCRUE3Q0MzMERFOUM2QUNBNTM5MTI3Nzk3QTdCNUIzNDMwRkE3QkU5QTQ0RUU0REE2QkU4NThGRTdDNTYzMUFEQUY5NzE3RTNCQTlBQjcwOTdGQ0M2QzU0MjRGOUU4QzM0MTQ4MTBGRTZFNTJCQUJEMUY1RjY2REFFRUQ2OEM4RUYzOTdGMDk4NUM2MzE1NzUyMzNFRDkwNDFCMzQzMEYwNjI5M0E2OUYxMTBFMEVCM0IzQkY2RkM=&sign=b642d2e84f2e27b36be25c74eb0629aa&sid=00000000000001";


        System.out.println(HttpUtils.DefaultRequest(urlPath, param, HttpUtils.RequestMethod.GET));


        ExecutorService executorService = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String urlPath = "http://testpass.gzzhongka.cn:9090/DataPass/SysPosServiceV1?";
                        String param = "code=NUExNUEyMzlDNjVGOEQ2ODIzQkE2QkFCN0NFNEZDNTBDRkUwMjY3NjY5QzAzNTgyRUQ4Mzc0MTMyMDE1NzE4NTA0NEU4QjNDNDg5NEMxQTREMjdBOTY0RkMzNTdCODNFODEwNERFMDU2MUVDNjQ3NjhEMTlFMTRCRjY3NTE2NzUwNEQ0MTc3RjMwQjYxNjFFRjZFNDdGRThDRDc1OTNBQzNGQUY5MDE1NEIwMzM2QzIzMTFFNjBDNUNCMkRBREJGMzU2QTY2QUIzQjUwNDk3QTA4MjU1QkMzRTk4RkNFRUM3MkNGNTRGOUQ5MjFBMkRDQjgxOTYzMzIzQUYyNTNGQUQ4Mjc5NUJBOUE4RUZDNkEzNEM1RDYyMkM1QTBFNUJFRDA0QkQ5MzJGQ0UyMzVCRTgzQkZEN0FCNDBFQkU3NkZGNzk3NTRBREYwN0ZBRDQ3OUMxRTQ1ODUzRjFBNzRGMUMyRkJCMDYwODY1MkE3NEI5OUVDMUMwMTExQTA5RkZGODQ1RjJBRDZCMkQ1NjAxMjk4MEY2QkZBQTRBMDZEQTA=&sign=d515503061f3c408a6a67a68becbeac8&sid=00000000000001";
                        //sleep(1000*1);
                        System.out.println(HttpUtils.DefaultRequest(urlPath, param, HttpUtils.RequestMethod.GET, true));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("开始关闭线程池，不再接受新任务");
        //Thread.sleep(1000*3);
        executorService.shutdown();
        System.out.println("===========");
        //等待所有线程执行完成
        while (!executorService.isTerminated()) {
        }
        System.out.println("线程池关闭完成,用时:" + (System.currentTimeMillis() - start) + " ms");
    }

}
