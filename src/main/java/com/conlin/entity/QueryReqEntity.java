package com.conlin.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QueryReqEntity {

    private String appId;
    private String mchId;
    private String priKey;
    private String pubKey;
    private String key;
    //渠道的链路网关
    private String apiUrl;
    private String proxyHost;
    private String proxyPort;
    private String reqNo;
    private String resNo;
    private String tradeType;
    //操作工号
    private String operCode;
    //终端代码
    private String termCode;
    //金额
    private String Amount;
    //二维码地址
    private String QrCode;
    //证书地址 applink表的CertPath字段
    private String CertPath;
    //聚合支付类型
    private String PayType;
    //添加时间
    private LocalDateTime AddDate;
    //正记录的状态
    private Integer payState;
    //超时(单位:分钟)
    private String timeExpire;
}