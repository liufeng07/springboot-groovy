package groovy

import groovy.sql.Sql

class BaseGroovySQL {
    def sql = Sql.newInstance("jdbc:mysql://192.168.0.65:33063/uppv2?useUnicode=true&characterEncoding=UTF-8&useSSL=false", "root",
            "Conlin2020", "com.mysql.jdbc.Driver")
}
