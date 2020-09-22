package groovy

import com.alibaba.fastjson.JSON
import com.alipay.api.AlipayClient
import com.alipay.api.DefaultAlipayClient
import com.alipay.api.request.AlipayTradeQueryRequest
import com.alipay.api.response.AlipayTradeQueryResponse
import com.conlin.entity.QueryReqEntity
import com.conlin.service.IRule2

/**
 * 模拟接口调用
 */
class GroovyFileRule2 implements IRule2 {

    @Override
    void query() {
        println("===================调用AliPaySDK =============================");
        String bizstr = "{\"amount\":\"0.01\",\"mchId\":\"\",\"operCode\":\"DBA\",\"reqNo\":\"2020082717000002\",\"payState\":3,\"addDate\":\"2020-08-27T17:15:12\",\"priKey\":\"MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCrmIt0Rdzo3J3VN8hUR0I/Mo+ciMtzSF8WPCbe0fXX/C2eCO5hGSWwBZFtRnqXNBJdIeBnviZZjs2a5eclA2vD1hKxH5D45Vva7v8xnzW24tQ/7/2qDmAZ9nTrzjEUBA4OqIXZHoxMjhrxaK2OcnvKcZoQ44ivP/kt0fwfVw8ruAbYM1AgTW7ELyOXjw6JfZ874idIVttObUWoNUhFd6qbO3TBfPoEezI6SIiowvUelB6XBJ8tqGS/hdH1av7iwD4nRJhcAiYAj7kvFQysYUHjvCLUbMpVvcd2Sbf0vyvaXVz4071BJN0OK67vr5iDtCkV9SqI7ZAXQ2TyAKZJMQ3tAgMBAAECggEAc0le0DSr8etfQ0RiHHVvxcPzhqjFf+OstuSc/PE1afIst9OqTKQ3lOZ4yWEjtfivKdE70peHbn4qFxrFTDHbMkzebBAYN5DpQNN3suATl5cYIQjddWaJHIhgD5mNkbQTubdxjekfO8PxyCWbDWxPTTk72IL2bz/c6vL8oBW+xJCZq1X23BVTJLm1I2vPv8KzrT7vQT+f1oK/JnnKW1kQZ3+9u2hbHwh4G4OJRskZhFuKtrl4hjM1eF4KT46EpuMEcKXPLYPEyitqX1mzdpA5K1Apxt1uB/PLttrMy2lYONCjOJkS8YdqmJ7k/HR0DIZ08UtU6dJ4TzrBu/Pm3ujqoQKBgQDkJPjPVpWbq7I4qEsknYk4UmhrJ0dPXwC/3bxjLAYmtIfOFFC0FBgl1W4+WoXcf7wftBumSWLttyN+wehEx7i0LicVnbIXluAift/Dw1FMkRZLSp009NjB/rXNwWtkbl6BFV0ppsroOaUZVRWf+glDOuD/I7nITHDGvh0vJo5DFQKBgQDAjA4rZusRkVWn7q8l06M3pk1Fi0LyzZaeWqf1/ouF6NolEWhChh0WMlSSxUA0d6CcOcEEMjjriy47kECLRVE1E+kz0Lht0oS613bkXC1fkPqL/Ww6KjbSWIuG8+yBadzStOtyu37SoC28XsWevUU8Yefk4BkiO2x58SIhb9A1eQKBgATfpVEIkHma2VvMfI5zrxK87+4aELPpW6K9oeCceCUrhhso4/B03W8xeAFs/Z8QO3yR5GVQ/AQH/YIfsk6F1bRDqCIWFE/csT0LaMxNx9bS4p8JIQKYmGjMgCW9FAY5NVuckTjqjzsWwCgiYSvhs4D0KQpKQRW+TEpylT0EndVhAoGAWxeneHcXTNdiG7G7IP0wIZrGwdjxkmcbE8212pZTMcYItjK3DYnfZunmww0Yo/nYfTCBlVehQCY3eCx1rK3djmveDwp2xlYrPy3CbKUDPkwbjHEXa6kfCIKld/IceNk5hGHdZgk4JbNsD8sSWVgX0kpLaCdxHJXaaxJeYE1CxpkCgYEAr6yKtLrWhM7hlzaDLonYFc6rcjhox9KohExVja2hwLuLqFL8GaT9af8wHdf/O/Sy4AWLF8rqvBjeZeWUrqKn1Fs3AeMsNOLTyIbIwPekzgeDVpXmTfe+pDN7HAZzleETsxkEtAP4yqc82Ro0Ku71/MKfUOhWp2v5waG+B0jqgh8=\",\"apiUrl\":\"https://openapi.alipay.com/gateway.do\",\"qrCode\":\"weixin://wxpay/bizpayurl?pr=mu43M9r\",\"appId\":\"2017041706771696\",\"pubKey\":\"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvDnTaBUFyg4pF8MywwvfbLSaNIOhXAulUbGOZN6iGHoGxXtnS4jchMFneTOiML+wdhgb3oEPeCqq+axP7N/Xd78HJucg4yPoyqUYnqL7nD82GK/q6wEP5N6TRJBDj1+THhB327tmh4f92pAeo1lALJhmDp9IesKYtJhSYJaZzLiScIRnEvnZ7G9e5EoGQkjfy3Ve2m7BOjHI3OWxzAyadEeuX7TvfrBU5Qhl5s2Zwq4zKa+BunWQgIVXB4LkY9ki/mGW61v1qJAgi3e2yhf8FXTBk0DCqq8BMM+bvwe31njXLBbsbOaTIF274J2thrDxSqo9U3bRXG1Qf7kVT9CeXQIDAQAB\",\"termCode\":\"A01\"}\n";
        QueryReqEntity biz = JSON.parseObject(bizstr, QueryReqEntity.class);
        AlipayClient alipayClient = new DefaultAlipayClient(
                "https://openapi.alipay.com/gateway.do",
                biz.getAppId(),
                biz.getPriKey(),
                "json",
                "UTF-8",
                biz.getPubKey(),
                "RSA2"
        );
        //创建查询请求
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        //设置请求参数
        Map<String, String> paramMap = new HashMap<>();
        if (biz.getReqNo() != null) {
            paramMap.put("out_trade_no", biz.getReqNo());
        } else {
            paramMap.put("trade_no", biz.getResNo());
        }
        String aliBizContent = getAliBizContent(paramMap);
        request.setBizContent(aliBizContent);

        AlipayTradeQueryResponse response = alipayClient.execute(request);
        String a = JSON.toJSONString(response);
        if (response.isSuccess()) {
            System.out.println("调用成功:" + a);
        } else {
            System.out.println("调用失败");
        }
    }

    private static String getAliBizContent(Map<String, String> map) {
        StringBuffer bizContent = new StringBuffer();
        bizContent.append("{");

        for (String key : map.keySet()) {
            bizContent.append("\"" + key + "\":\"" + map.get(key) + "\",");
        }
        bizContent.deleteCharAt(bizContent.lastIndexOf(","));
        bizContent.append("}");
        return bizContent.toString();
    }
}
