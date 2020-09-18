package groovy

import com.conlin.service.IRule
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 *  Spring实现Groovy
 */
class SpringGroovyRule implements IRule {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public int getType() {
        return GROOVY_SPRING_TYPE;
    }

    @Override
    public void printInfo() {
        log.info("这是一段Spring的Groovy代码");
        printInfoHigh();
    }

    public void printInfoHigh() {
        log.info("这是一段Spring的Groovy代码的代码");
    }
}
