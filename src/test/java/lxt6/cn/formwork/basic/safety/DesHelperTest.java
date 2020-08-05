package lxt6.cn.formwork.basic.safety;


import lxt6.cn.formwork.basic.safety.utils.des.DesHelper;


public class DesHelperTest {


    /**
     * 将指定HEX字符串，以每两个字符分割转换为16进制形式 如："2B44EFD9" to byte[]{0x2B, 0x44, 0xEF,
     * 0xD9}
     *
     * @param src String 需要转换的HEX字符串
     * @return byte[] 返回字节数组
     */
    public static byte[] HexStringToBytes(String src) {
        if (src == null || src.equals(""))
            return null;
        byte[] ret = new byte[src.length() / 2];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (byte) Integer.parseInt(src.substring(i * 2, i * 2 + 2), 16);
        }
        return ret;
    }

    /**
     * 将字节数组，返回HEX字符串格式  例如：byte[]{0x2B, 0x44, 0xEF,0xD9} to "2B44EFD9"
     *
     * @param b byte[] 字节数组
     * @return 返回HEX字符串形式。
     */
    public static String BytesToHexString(byte[] b) {
        String ret = "";
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            //0x0B&0xFF 0x0B Integer.toHexString(0x0B&0xFF)* &与(两个相应位都为1 则为1，否为0)
            //若高位有零，得值为b,则高位补0为0B;
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {

        DesHelper dh = new DesHelper();
        String source="";
        String key ="";

        key="0001020304050607";
        source="8866133E40456688";
        System.out.println(dh.DES_1(source,key,0));
        source = "1234567812345678";
        key = "0123456789ABCDEF0123456789ABCDEF";
        System.out.println(dh.DES_3(source,key,1));
        //String pass = dh.PBOC_3DES(source, key, 0);
        String mac = dh.PBOC_3DES_MAC(source, key, 0);
        //System.out.println(pass);
        System.out.println(mac);

        key = "000102030405060708090A0B0C0D0E0F";
        String cardserial = "133E4045";
        String soure = "8866" + cardserial + "6688";
        soure+=soure+"000102030405060708090A0B0C0D0E0F";
        System.out.println(dh.PBOC_3DES(soure,key,0));
        String pass = dh.PBOC_3DES_8(soure, key, 0);

        byte[] all = new byte[16];
        byte[] temp = HexStringToBytes(pass);
        for (int i = 0; i < 8; i++) {
            all[i] = temp[i];
        }
        all[8] = 0x26;
        all[9] = 0x08;
        all[10] = 0x13;
        all[11] = 0x20;
        temp = HexStringToBytes(cardserial);
        all[12] = (byte) ~temp[0];
        all[13] = (byte) ~temp[1];
        all[14] = (byte) ~temp[2];
        byte sum = 0x00;
        for (int i = 0; i < 15; i++) {
            sum += all[i];
        }
        all[15]=(byte)~sum;

        System.out.println("pass:" + BytesToHexString(all));


    }
}
