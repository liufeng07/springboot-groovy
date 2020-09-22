package com.conlin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseEntity implements Serializable {
    /**
     * 自增主键
     */
    @TableId(value = "Id", type = IdType.ID_WORKER_STR)
    private String Id;

    /**
     * 新增日期
     */
    @TableField("AddDate")
    private LocalDateTime AddDate;

    /**
     * 修改日期
     */
    @TableField("ModDate")
    private LocalDateTime ModDate;
}
