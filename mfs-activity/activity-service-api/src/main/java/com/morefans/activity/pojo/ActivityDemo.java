package com.morefans.activity.pojo;

import com.morefans.basic.core.base.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 活动示例实体类
 * @author tanxw
 * @date 2020/6/2
 */
@Table(name = "activity_demo")
@Data
@EqualsAndHashCode(callSuper=true)
public class ActivityDemo extends BasePojo {

    /**
     * 活动示例
     */
    @Id
    @Column(name="id")
    private Long id;

    /**
     * 个数
     */
    @Column(name = "diamond")
    private Integer diamond;

    /**
     * 票数
     */
    @Column(name = "ticket")
    private Integer ticket;

    /**
     * 消息
     */
    @Column(name = "message")
    private String message;

}
