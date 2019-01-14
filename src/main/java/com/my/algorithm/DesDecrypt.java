package com.my.algorithm;

import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

public class DesDecrypt {

    private final static String DES = "DES";

    public static String decrypt(String data, String key) throws Exception {
        if (data == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decrypt(buf, key.getBytes("utf-8"));
        return new String(bt);
    }

    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    public static void main(String[] args) {
//        System.out.print("daldj");
        //测试懒人听书电信免流秘钥
        /*
        明文：UjUloMR6e7E94n9gzCW0QfsPm7Lx9bIqSx7xfUt/5Eq0RRid0uh8cA==
        秘钥：)VpqkIE9>)1r<Wi
         */
        try {
            System.out.print(decrypt("+GOnHuOexrVRxk5IWcQ0T+M+Ke1Guh1BaGeevx8RPdEZblUvWHdQxw==", ")VpqkIE9>)1r<Wi"));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
