package lxt6.cn.formwork.basic.safety;

import lxt6.cn.formwork.basic.utils.ByteUtils;
import lxt6.cn.formwork.basic.safety.utils.des.DesUtils;


public class DesUtilsTest {

    public static void main(String[] args) throws Exception {


        DesUtils des = new DesUtils();
        String source = "1122334455667788";
        String key = "1122334455667788";
        String pass = des.DES_1(source, key, 0);
        System.out.println(pass);
        String m = des.DES_1(pass, key, 1);
        System.out.println(m);
        if (1==1)
            return ;


        for (long i = 0; i <= 9223372036854775807L; i++) {
            source = ByteUtils
                    .BytesToHexString(ByteUtils.longToByteArray(i, 8));

            pass = des.DES_1(source, key, 0);

            m = des.DES_1(pass, key, 1);
            if (false == source.equals(m))
                System.out.println("source:" + source + " m:" + m);

            //System.out.println("num:" + (i + 1));
        }
    }
}
