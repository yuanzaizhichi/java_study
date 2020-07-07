package com.cxf.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpDemo {
    public static void main(String[] args) {
        String url = "http://autobuild.1357.cn/App/SaasThirdOrg/company";
        String json = "[{\"originId\":\"1\",\"parentOriginId\":\"6wvxpxm08upe57s43zqm89gladvuckzz\",\"name\":\"test\",\"shortName\":\"test\",\"remark\":\"备注\"}]";
        HttpPost httpPost = null;
        String result = null;
        try {
            HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
            // HttpClient
            CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
            httpPost = new HttpPost(url);

            long time = System.currentTimeMillis() / 1000;
            String sign = DigestUtils.sha1Hex("QWHHJEY4vbPy2B5IDG0AF6Q8gNSti43QVzCYhkMlajNDL68sVIp6" + time);
            //请求头
            httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
            httpPost.setHeader("accessId", "QWHHJEY4vbPy2B5IDG0A");
            httpPost.setHeader("time", "" + time);
            httpPost.setHeader("sign", sign);
            httpPost.setHeader("Accept", "appliction/json");

            StringEntity stringEntity = new StringEntity(json, Charset.forName("UTF-8"));
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json;charset=utf-8");//发送json数据需要设置contentType
            httpPost.setEntity(stringEntity);

            HttpResponse response = closeableHttpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, "UTF-8");
                    System.out.println(unicodeStr2String(result));
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String unicodeStr2String(String unicodeStr) {
        int length = unicodeStr.length();
        int count = 0;
        //正则匹配条件，可匹配“\\u”1到4位，一般是4位可直接使用 String regex = "\\\\u[a-f0-9A-F]{4}";
        String regex = "\\\\u[a-f0-9A-F]{1,4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(unicodeStr);
        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            String oldChar = matcher.group();//原本的Unicode字符
            String newChar = unicode2String(oldChar);//转换为普通字符
            // int index = unicodeStr.indexOf(oldChar);
            // 在遇见重复出现的unicode代码的时候会造成从源字符串获取非unicode编码字符的时候截取索引越界等
            int index = matcher.start();

            sb.append(unicodeStr.substring(count, index));//添加前面不是unicode的字符
            sb.append(newChar);//添加转换后的字符
            count = index + oldChar.length();//统计下标移动的位置
        }
        sb.append(unicodeStr.substring(count, length));//添加末尾不是Unicode的字符
        return sb.toString();
    }

    /**
     * unicode 转字符串
     *
     * @param unicode 全为 Unicode 的字符串
     * @return
     */
    public static String unicode2String(String unicode) {
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");

        for (int i = 1; i < hex.length; i++) {
            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);
            // 追加成string
            string.append((char) data);
        }

        return string.toString();
    }
}
