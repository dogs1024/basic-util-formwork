package lxt6.cn.formwork.basic;


import lxt6.cn.formwork.basic.utils.ByteUtils;

public class ByteUtilsTest {

    public static void main(String[] args) {

        String byteStr="0123456789ABCDEF";
        for(int i=0;i<16;i++) {
            System.out.print(ByteUtils.ByteToHexString(ByteUtils.intTobyte(i)));
        }
        System.out.println("");
        System.out.println(ByteUtils.ByteToHexString(ByteUtils.XOr(ByteUtils.HexStringToBytes("E1E2"))));
        System.out.println(ByteUtils.ByteToHexString(ByteUtils.HexStringToByte("E1")));
        String temp= ByteUtils.HexStringToBinaryString("01");
        System.out.println(temp);
        System.out.println("HexString:"+ByteUtils.BytesToHexString(ByteUtils.longToByteArray(100,3)));


    }
}
