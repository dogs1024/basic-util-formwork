package lxt6.cn.formwork.basic.safety.utils.des;

/**
 * 用于处理PBOC的3DES和MAC算法
 *
 * @author lxt_team on 2020-03-09 17:36:00
 */
public class DesHelper extends DesUtils {

    public DesHelper() {
        super();
    }


    /**
     * 计算MAC(hex) PBOC_3DES_MAC(16的整数补8000000000000000) 前n-1组使用单长密钥DES
     * 使用密钥是密钥的左8字节） 最后1组使用双长密钥3DES （使用全部16字节密钥）
     *
     * @param data 需要操作的原数据
     * @param key  密钥(32byte) 0123456789ABCDEF0123456789ABCDEF
     * @param type 0:encrypt 1:discrypt
     * @return mac 返回PBOC需要的MAC值
     */
    public String PBOC_3DES_MAC(String data, String key, int type) {
        String vector = "0000000000000000"; // 初始向量0000000000000000
        if (key.length() != 32) {
            return null;
        }
        int len = data.length();
        if (len % 16 == 0) {
            data += "8000000000000000";
        } else {
            data += "80";
            for (int i = 0; i < 15 - len % 16; i++) {
                data += "00";
            }
        }
        // 取补完数据算需要处理的数据和次数
        int arrLen = data.length() / 16;
        String[] D = new String[arrLen];
        for (int i = 0; i < arrLen; i++) {
            D[i] = data.substring(i * 16, i * 16 + 16);
        }

        // D0 Xor Vector
        String I = xOr(D[0], vector);
        String O = null;
        String kl = key.substring(0, 16);
        for (int i = 1; i < arrLen; i++) {
            O = DES_1(I, kl, 0);
            I = xOr(D[i], O);
        }
        I = DES_3(I, key, type);
        return I;
    }


    /**
     * 用于处理PBOC_3DES 算法
     *
     * @param data 长度不能被16整除则补数据，按80 00补
     * @param key  长度密码为32个HEX码
     * @param type 0:encrypt 1:discrypt
     * @return 返回3DES的结果值
     */
    public String PBOC_3DES(String data, String key, int type) {
        if (key.length() != 32) {
            return null;
        }
        int len = data.length();
        int arrLen = len % 16 == 0 ? len / 16 : len / 16 + 1;
        if (len % 16 == 0) {
            data += "8000000000000000";
        } else {
            data += "80";
            for (int i = 0; i < 15 - len % 16; i++) {
                data += "00";
            }
        }

        String[] D = new String[arrLen];
        for (int i = 0; i < arrLen; i++) {
            D[i] = data.substring(i * 16, i * 16 + 16);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arrLen; i++) {
            sb.append(DES_3(D[i], key, type));
        }
        return sb.toString();
    }

    /**
     * 用于处理PBOC_3DES_8 算法
     *
     * @param data 长度不能被16整除则补数据，按80 00补
     * @param key  长度密码为32个HEX码
     * @param type 0:encrypt 1:discrypt
     * @return 返回3DES的结果值
     */
    public String PBOC_3DES_8(String data, String key, int type) {
        if (key.length() != 32) {
            return null;
        }

        // 取补完数据算需要处理的数据和次数
        int arrLen = data.length() / 16;
        String[] D = new String[arrLen];
        for (int i = 0; i < arrLen; i++) {
            D[i] = data.substring(i * 16, i * 16 + 16);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arrLen; i++) {
            sb.append(DES_3(D[i], key, type));
        }
        return sb.toString();
    }

    /**
     * 用于处理PBOC_1DES 算法
     *
     * @param data 长度不能被16整除则补数据，按00 00补
     * @param key  长度密码为16个HEX码
     * @param type 0:encrypt 1:discrypt
     * @return 返回1DES的结果值
     */
    public String PBOC_1DES(String data, String key, int type)  {
        if (key.length() != 16) {
            return null;
        }
        int len = data.length();
        int arrLen = len % 16 == 0 ? len / 16 : len / 16 + 1;
        String[] D = new String[arrLen];
        if (len % 16 != 0) {
            for (int i = 0; i < 15 - len % 16; i++) {
                data += "00";
            }
        }
        for (int i = 0; i < arrLen; i++) {
            D[i] = data.substring(i * 16, i * 16 + 16);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < D.length; i++) {
            sb.append(DES_1(D[i], key, type));
        }
        return sb.toString();
    }


}
