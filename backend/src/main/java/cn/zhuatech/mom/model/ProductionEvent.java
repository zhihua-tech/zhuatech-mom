/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.mom.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity
@Table(name = "production_events", uniqueConstraints = @UniqueConstraint(columnNames = "eventKey"),
       indexes = @Index(name = "idx_production_event_order", columnList = "productionOrderId"))
public class ProductionEvent {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long productionOrderId;

    @Column(nullable = false, length = 80)
    private String eventKey;

    @Column(nullable = false, length = 24)
    private String eventType;

    @Column(nullable = false)
    private int goodQuantity;

    @Column(nullable = false)
    private int scrapQuantity;

    @Column(nullable = false, length = 40)
    private String equipmentCode;

    @Column(nullable = false, length = 30)
    private String shiftCode;

    @Column(length = 80)
    private String reasonCode;

    @Column(nullable = false, length = 50)
    private String operatorName;

    @Column(nullable = false)
    private LocalDateTime occurredAt;

    private LocalDateTime createdAt;

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected ProductionEvent() {}

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public ProductionEvent(Long productionOrderId, String eventKey, String eventType, int goodQuantity,
            int scrapQuantity, String equipmentCode, String shiftCode, String reasonCode,
            String operatorName, LocalDateTime occurredAt) {
        this.productionOrderId = productionOrderId;
        this.eventKey = eventKey;
        this.eventType = eventType;
        this.goodQuantity = goodQuantity;
        this.scrapQuantity = scrapQuantity;
        this.equipmentCode = equipmentCode;
        this.shiftCode = shiftCode;
        this.reasonCode = reasonCode;
        this.operatorName = operatorName;
        this.occurredAt = occurredAt;
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PrePersist
    void createTime() { createdAt = LocalDateTime.now(); }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Long getId() { return id; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Long getProductionOrderId() { return productionOrderId; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getEventKey() { return eventKey; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getEventType() { return eventType; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public int getGoodQuantity() { return goodQuantity; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public int getScrapQuantity() { return scrapQuantity; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getEquipmentCode() { return equipmentCode; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getShiftCode() { return shiftCode; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getReasonCode() { return reasonCode; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getOperatorName() { return operatorName; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public LocalDateTime getOccurredAt() { return occurredAt; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public LocalDateTime getCreatedAt() { return createdAt; }
}
