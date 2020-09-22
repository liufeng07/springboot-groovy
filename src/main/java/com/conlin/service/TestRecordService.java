package com.conlin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.conlin.entity.TestRecord;

/**
 * 测试记录表
 *
 * @author conlin
 * @email
 * @date 2020-09-07 10:55:57
 */
public interface TestRecordService extends IService<TestRecord> {

     String getInfo(String str);
}

