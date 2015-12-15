package com.dingnet.mobile.integration.action;

import com.alibaba.fastjson.JSONObject;
import com.dingnet.mobile.integration.util.HttpClientUtils;
import com.dingnet.mobile.integration.util.ParamUtils;
import com.dingnet.mobile.integration.util.constants.SysConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jordan on 2015/12/8.
 */
@RequestMapping("/open_api")
@Controller
public class OpenApiAction {

    @RequestMapping(value = "/set_auth_ip_list",method ={ RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    Map<String,String> setAuthIpList(@RequestParam(value = "bid", required=true,defaultValue = "guoling") String bid,
                                     @RequestParam(value="ip_list",required=true,defaultValue="203.88.173.235")String ipList){
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("bid",bid);
        paramMap.put("ip_list",ipList);

        return process("set_auth_ip_list",paramMap);
    }

    @RequestMapping(value = "/set_tariff",method ={ RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    Map<String,String> setTariff(@RequestParam(value = "bid", required=true,defaultValue = "guoling") String bid,
                                     @RequestParam(value="call_type",required=true)String callType,
                                 @RequestParam(value="unit_fee",required=true)String unitFee){
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("bid",bid);
        paramMap.put("call_type",callType);
        paramMap.put("unit_fee",unitFee);

        return process("set_tariff",paramMap);
    }


    @RequestMapping(value = "/set_call_log_notify_ur",method ={ RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    Map<String,String> set_call_log_notify_ur(@RequestParam(value = "bid", required=true,defaultValue = "guoling") String bid,
                                 @RequestParam(value="notify_url",required=true)String notify_url ){
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("bid",bid);
        paramMap.put("notify_url",notify_url);

        return process("set_call_log_notify_ur",paramMap);
    }


    @RequestMapping(value = "/reg_account",method ={ RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    Map<String,String> reg_account(@RequestParam(value = "bid", required=true,defaultValue = "guoling") String bid,
                                              @RequestParam(value="uid",required=true)String uid,
                                               @RequestParam(value="password",required=true)String password,
                                               @RequestParam(value="is_display",required=true)String is_display,
                                              @RequestParam(value="phone",required=true)String phone ){
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("bid",bid);
        paramMap.put("uid",uid);
        paramMap.put("password",password);
        paramMap.put("is_display",is_display);
        paramMap.put("phone",phone);

        return process("reg_account",paramMap);
    }

    @RequestMapping(value = "/get_account_info",method ={ RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    Map<String,String> get_account_info(@RequestParam(value = "bid", required=true,defaultValue = "guoling") String bid,
                                   @RequestParam(value="uid",required=true)String uid){
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("bid",bid);
        paramMap.put("uid",uid);

        return process("get_account_info",paramMap,"phone","password","balance","is_display");
    }

    @RequestMapping(value = "/get_account_info_by_phone",method ={ RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    Map<String,String> get_account_info_by_phone(@RequestParam(value = "bid", required=true,defaultValue = "guoling") String bid,
                                        @RequestParam(value="phone",required=true)String phone){
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("bid",bid);
        paramMap.put("phone",phone);

        return process("get_account_info_by_phone",paramMap,"phone","password","balance","is_display");
    }

    @RequestMapping(value = "/recharge",method ={ RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    Map<String,String> recharge(@RequestParam(value = "bid", required=true,defaultValue = "guoling") String bid,
                                                 @RequestParam(value="uid",required=true)String uid,
                                @RequestParam(value="money",required=true)String money){
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("bid",bid);
        paramMap.put("uid",uid);
        paramMap.put("money",money);

        return process("recharge",paramMap,"balance" );
    }

    @RequestMapping(value = "/set_balance",method ={ RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    Map<String,String> set_balance(@RequestParam(value = "bid", required=true,defaultValue = "guoling") String bid,
                                @RequestParam(value="uid",required=true)String uid,
                                @RequestParam(value="money",required=true)String money){
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("bid",bid);
        paramMap.put("uid",uid);
        paramMap.put("money",money);

        return process("set_balance",paramMap,"balance" );
    }

    @RequestMapping(value = "/set_is_display",method ={ RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    Map<String,String> set_is_display(@RequestParam(value = "bid", required=true,defaultValue = "guoling") String bid,
                                   @RequestParam(value="uid",required=true)String uid,
                                   @RequestParam(value="is_display",required=true)String is_display){
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("bid",bid);
        paramMap.put("uid",uid);
        paramMap.put("is_display",is_display);

        return process("set_is_display",paramMap  );
    }

    @RequestMapping(value = "/query_is_display",method ={ RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    Map<String,String> query_is_display(@RequestParam(value = "bid", required=true,defaultValue = "guoling") String bid,
                                        @RequestParam(value="uid",required=true)String uid ){
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("bid",bid);
        paramMap.put("uid",uid);

        return process("query_is_display",paramMap,"phone" ,"is_display" );
    }

    @RequestMapping(value = "/bind_new_phone",method ={ RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    Map<String,String> bind_new_phone(@RequestParam(value = "bid", required=true,defaultValue = "guoling") String bid,
                                      @RequestParam(value="uid",required=true)String uid,
                                      @RequestParam(value="phone",required=true)String phone){
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("bid",bid);
        paramMap.put("uid",uid);
        paramMap.put("phone",phone);

        return process("bind_new_phone",paramMap );
    }

    @RequestMapping(value = "/call_back",method ={ RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    Map<String,String> call_back(@RequestParam(value = "bid", required=true,defaultValue = "guoling") String bid,
                                      @RequestParam(value="uid",required=true)String uid,
                                      @RequestParam(value="called",required=true)String called){
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("bid",bid);
        paramMap.put("uid",uid);
        paramMap.put("called",called);

        return process("call_back",paramMap,"caller" );
    }

    @RequestMapping(value = "/del_account_by_uid",method ={ RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    Map<String,String> del_account_by_uid(@RequestParam(value = "bid", required=true,defaultValue = "guoling") String bid,
                                 @RequestParam(value="uid",required=true)String uid){
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("bid",bid);
        paramMap.put("uid",uid);

        return process("del_account_by_uid",paramMap,"caller" );
    }

    @RequestMapping(value = "/del_account_by_phone",method ={ RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    Map<String,String> del_account_by_phone(@RequestParam(value = "bid", required=true,defaultValue = "guoling") String bid,
                                          @RequestParam(value="phone",required=true)String phone){
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("bid",bid);
        paramMap.put("phone",phone);

        return process("del_account_by_phone",paramMap,"caller" );
    }

    @RequestMapping(value = "/card_recharge",method ={ RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    Map<String,String> card_recharge(@RequestParam(value = "bid", required=true,defaultValue = "guoling") String bid,
                                            @RequestParam(value="uid",required=true)String uid,
                                     @RequestParam(value="card_pwd",required=true)String card_pwd){
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("bid",bid);
        paramMap.put("uid",uid);
        paramMap.put("card_pwd",card_pwd);

        return process("card_recharge",paramMap,"caller" );
    }

    private Map<String, String> process(String apiName,Map<String, String> paramMap,String... fields) {
        String orignal = ParamUtils.map2SortString(paramMap, SysConstants.KEY);
        String sign = ParamUtils.md5(orignal);
        paramMap.put("sign",sign);

        String queryStr = ParamUtils.map2SortString(paramMap,"");
        String reqUrl = "http://v3api.vishuo.cn/open_api/" + apiName + "?" + queryStr;

        Map<String,String> resultMap = new HashMap<>();
        String resp = HttpClientUtils.excuteGet(reqUrl);
        JSONObject json = JSONObject.parseObject(resp);
        resultMap.put("result",json.getString("result"));
        resultMap.put("reason",json.getString("reason"));

        for(String field:fields){
            resultMap.put(field,json.getString(field));
        }

        return resultMap;
    }
}
