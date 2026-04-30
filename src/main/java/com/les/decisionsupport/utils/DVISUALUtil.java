package com.les.decisionsupport.utils;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;
import com.les.decisionsupport.base.exception.ServiceException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;

/**
 * 数据工程工具类
 */
public class DVISUALUtil {


    public static String encode(String data, String secret) throws Exception{
        //aes 加密
        byte[] bb = aes_encrypt(data.getBytes(), secret);
        //base64 编码
        return Base64.getEncoder().encodeToString(bb);
    }

    public static byte[] aes_encrypt(byte[] content, String code) throws Exception {
        //生成key
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        //用随机数作为密钥，使用SHA1PRNG规则初始化密钥生成器
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        //设置种子数
        random.setSeed(code.getBytes());
        //固定长度
        kgen.init(128, random);
        //产生秘钥
        SecretKey secretKey = kgen.generateKey();
        //获取秘钥
        byte[] enCodeFormat = secretKey.getEncoded();
        //还原秘钥
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        //获取AES加密算法
        Cipher cipher = Cipher.getInstance("AES");
        //设置加密Key
        cipher.init(Cipher.ENCRYPT_MODE, key);
        //加密
        byte[] result = cipher.doFinal(content);

        return result;
    }

    public String getToken(boolean reload) throws Exception {

        String baseUrl = "http[s]://host[:port]";
        String appId = "yjdd";
        String secret = "1Gyp6uxTFVtVwIaO1r5ug8AokFrHdlV6";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("appid", appId);
        String time = System.currentTimeMillis() + "";
        String timeEncode = encode(time,secret);
        paramMap.put("time",timeEncode);

        String result= HttpUtil.get(baseUrl + "/api/auth", paramMap);
        JSONObject jsonObject = JSONObject.parseObject(result);
        if(jsonObject.getInteger("state")!=null && jsonObject.getInteger("state") == 200){
            return jsonObject.getString("token");
        }else {
            throw new ServiceException(jsonObject.getString("message"));
        }

    }

//    public static void main(String[] args) throws Exception {
////        https://g14.giisoo.com/api/auth/encodetest?secret=1Gyp6uxTFVtVwIaO1r5ug8AokFrHdlV6&time=1742198842344
////        yjdd
//        String secret = "1Gyp6uxTFVtVwIaO1r5ug8AokFrHdlV6";
//        String time = System.currentTimeMillis() + "";
//        String result = encode(time,secret);
//        System.out.println(time);
//        System.out.println(result);
//    }

}
