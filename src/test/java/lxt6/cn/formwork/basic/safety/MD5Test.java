package lxt6.cn.formwork.basic.safety;

import lxt6.cn.formwork.basic.safety.utils.MD5;

public class MD5Test {


    public static void main(String[] args) {

        try {
            String msg = "RTVCODM2QUMyQjI3NDEzMjg2QTU1Nzk4OUE3QzY1RkY3N0IyMDE3MDBGMTU0RTg2M0Q2Q0RGQ0U0OUEwRTk3MjA0NzcxMjRFQkRFMTlFMTkwQ0Y3NTAyMzdFMUQwNzMwRUQ1MjhFRDFFNkQ5MDlDODRFRDBGMDZCQ0I3NkU3QjBDODgwRUE2MDc2QjgxNDJCMUUyREVGQUM4NzREQUFERTRBN0JDMEREQzNCNzJBNjk3MDVFNjVBNkFFOEE0MTQ2MUY0QkIzM0VBOThEMzg4NjRFQUM5RjJCMUIyRDM5OEZCRTIzQTMyNDMyRDI2RTI3N0ZCOERBOEI3MTQ3RDg4QjcxQUYzMkJCNTU3NENBRkFFNDc5M0JFNjg4OUFEMzg1MjVDNTZDNTAwODVGNTUwRDQwMkFGNDY1RjMzRDQ3QzM1NEZCM0UxOEEyOUFFMEM5NTA1RTYwRkVFRjM3NzFBQkNBNUY5M0MzRDRGRTIxQUZBRTMwMUE2MDlDMUNDMENEQTdDREQwRDc2RDZDNDFEOTU0M0M2QzdDOUQzRjNGNEI=";
            System.out.println(MD5.md5("ykt#!@16" + msg));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}