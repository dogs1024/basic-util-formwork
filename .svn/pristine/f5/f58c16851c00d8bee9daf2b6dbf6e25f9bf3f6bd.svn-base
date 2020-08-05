package lxt6.cn.formwork.basic.safety;


import lxt6.cn.formwork.basic.safety.utils.aes.AESHelper;

public class AESHelpTest {

    public static void main(String[] args) {

        try {
            long start = System.currentTimeMillis();
            //String msg = "appId=1#?aliUserId=2088012378881314";
            String msg = "investorid=140000000000026001#?typeid=1#?cardtype=1#?alleywaytype=1#?studentid=1C9218DC#?moneynumber=200#?machineid=A2080001#?wxmachinedata=55A20800010001351552B2FA71207992AD09269300000000#?version=1";
            System.out
                    .println(AESHelper.encrypt(msg, "ykt_ZKDN_@%saw_nmwITSTYUIJhd200A"));

            long end = System.currentTimeMillis();

            System.out.println(end - start + ":ms");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
