package groovy

import com.conlin.service.IRule
import com.conlin.service.TestRecordService
import com.conlin.service.impl.TestRecordServiceImpl
import com.conlin.units.SpringApplicationContextUtil
import groovy.sql.GroovyRowResult
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired

/**
 * Groovy文件方式
 */
//@Component
class GroovyFileRule extends BaseGroovySQL implements IRule {
    private Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    TestRecordService testRecordService;

    @Override
    public int getType() {
        return GROOVY_FILE_TYPE;
    }

    @Override
    public void printInfo() {
        log.info("这是一段来自Groovy文件的代码的代码");
        //数据库查询
        sql.eachRow("select * from ut_testrecord") { println "=============Groovy数据库查询：" + it.id + " ${it.AppCode}" }
        List<GroovyRowResult> testList = sql.rows("select * from ut_testrecord")
        for (GroovyRowResult row : testList) {
            println row
        }
        sql.close();
        println("===================注入SpringBean数据库查询=============================");
        TestRecordService testRecordService = SpringApplicationContextUtil.getBean(TestRecordServiceImpl.class);
        def records = testRecordService.list();
        println(records);
    }
}
