package com.conlin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.conlin.dao.TestRecordDao;
import com.conlin.entity.TestRecord;
import com.conlin.service.TestRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestRecordServiceImpl extends ServiceImpl<TestRecordDao, TestRecord> implements TestRecordService {

    @Override
    public String getInfo(String str) {
        return "hello word " + str;
    }
}