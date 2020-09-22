package com.conlin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 测试记录表
 *
 * @author conlin
 * @email
 * @date 2020-09-07 10:55:57
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("ut_testrecord")
public class TestRecord extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 测试记录Id
     */
    @TableField("RecoreId")
    private String RecoreId;
    /**
     * 用例Id
     */
    @TableField("CaseId")
    private String CaseId;
    /**
     * 用例名称
     */
    @TableField("CaseName")
    private String CaseName;
    /**
     * 应用Id
     */
    @TableField("AppCode")
    private String AppCode;
    /**
     * 交易渠道
     */
    @TableField("PayMode")
    private String PayMode;
    /**
     * 人员索引
     */
    @TableField("PeopleIndex")
    private String PeopleIndex;
    /**
     * 姓名
     */
    @TableField("CustomerName")
    private String CustomerName;
    /**
     * 支付订单号
     */
    @TableField("PayReqNo")
    private String PayReqNo;
    /**
     * 支付流水号
     */
    @TableField("PayResNo")
    private String PayResNo;
    /**
     * 支付金额
     */
    @TableField("PayAmount")
    private BigDecimal PayAmount;
    /**
     * 支付时间
     */
    @TableField("PayResDate")
    private Date PayResDate;
    /**
     * 交易状态
     */
    @TableField("State")
    private Integer State;
    /**
     * 订单信息
     */
    @TableField("OrderInfo")
    private String OrderInfo;
    /**
     * 聚合具体支付类型 银联：1  微信：2 支付宝：3
     */
    @TableField("PayType")
    private String PayType;
    /**
     * 退款订单号 多笔按,分隔
     */
    @TableField("RefundReqNo")
    private String RefundReqNo;
    /**
     * 退款流水号 多笔按,分隔
     */
    @TableField("RefundResNo")
    private String RefundResNo;
    /**
     * 退款金额 多笔按,分隔
     */
    @TableField("RefundAmount")
    private String RefundAmount;
    /**
     * 退款时间  多笔按,分隔
     */
    @TableField("RefundResDate")
    private String RefundResDate;
    /**
     * 退款总金额
     */
    @TableField("RefundTotalAmount")
    private BigDecimal RefundTotalAmount;
    /**
     * 测试结果    0 失败 1成功
     */
    @TableField("TestResult")
    private Integer TestResult;
    /**
     * 测试结果说明
     */
    @TableField("ResultExplain")
    private String ResultExplain;
    /**
     * 备注
     */
    @TableField("BizRemarks")
    private String BizRemarks;

}
