package com.dingnet.mobile.integration.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by jordan on 2015/12/7.
 */
public class ParamUtils {

    private final static char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    public static String md5(String str) {
        if(StringUtils.isBlank(str)){
            return StringUtils.EMPTY;
        }

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }

        byte[] mdbytes = md.digest(str.getBytes());

        int j = mdbytes.length;
        char chars[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = mdbytes[i];
            chars[k++] = hexDigits[byte0 >>> 4 & 0xf];
            chars[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(chars);
    }

    /**
     *
     * @param paramMap
     * @param key
     * @return
     */
    public static String map2SortString(Map<String,String> paramMap,String key){
        if(CollectionUtils.isEmpty(paramMap)){
            return StringUtils.EMPTY;
        }

        List<ParamEntry> paramEntryList = new ArrayList<ParamEntry>();
        for(Map.Entry<String,String> entry:paramMap.entrySet()){
            if(entry==null || StringUtils.isBlank(entry.getKey())){
                continue;
            }

            paramEntryList.add(new ParamEntry(entry.getKey(),entry.getValue()));
        }

        Collections.sort(paramEntryList, new Comparator<ParamEntry>() {
            public int compare(ParamEntry entry1, ParamEntry entry2) {
               return entry1.getKey().compareTo(entry2.getKey());
            }
        });

       StringBuilder sb = new StringBuilder();
        for(ParamEntry entry:paramEntryList){
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }

        if(sb.length()>1){
            sb.setLength(sb.length()-1);
            sb.append(key);
        }

        return sb.toString();
    }

    /**
     * 参数分录
     */
    static class ParamEntry{
        private String key;
        private String value;

        public ParamEntry() {
        }

        public ParamEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

//    public static void main(String[] args)   {
//        String s = "bid=guoling&ip_list=119.145.230.187,113.88.73.390971cbad3c07cbef724be8bc34f645f6";
//        String r = md5(s);
//        System.out.print(r);
//    }
}
