package com.dingnet.mobile.integration.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jordan on 2015/12/8.
 */
public class HttpClientUtils {

    public static String excuteGet(String url){
        return excute(url,"get");
    }

    public static String excutePost(String url){
        return excute(url,"post");
    }

    private static String excute(String url,String method){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpEntity entity = null;
        HttpRequestBase httpget = null;
        CloseableHttpResponse response = null;
        try {
            if(StringUtils.equals("get",method)) {
                httpget = new HttpGet(url);
            }else if(StringUtils.equals("post",method)){
                httpget = new HttpPost(url);
            }

            response = httpclient.execute(httpget);
            entity =  response.getEntity();
            return  EntityUtils.toString(entity);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            EntityUtils.consumeQuietly(entity);
            org.apache.http.client.utils.HttpClientUtils.closeQuietly(response);
            org.apache.http.client.utils.HttpClientUtils.closeQuietly(httpclient);
        }

        return StringUtils.EMPTY;
    }
}
