/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.mom.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity
@Table(name = "production_orders", uniqueConstraints = @UniqueConstraint(columnNames = "orderNo"))
public class ProductionOrder {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private long version;

    @Column(nullable = false, length = 40)
    private String orderNo;

    @Column(nullable = false, length = 40)
    private String productCode;

    @Column(nullable = false, length = 120)
    private String productName;

    @Column(nullable = false, length = 30)
    private String plantCode;

    @Column(nullable = false, length = 30)
    private String lineCode;

    @Column(nullable = false)
    private int plannedQuantity;

    @Column(nullable = false)
    private int goodQuantity;

    @Column(nullable = false)
    private int scrapQuantity;

    @Column(nullable = false, length = 24)
    private String status;

    @Column(nullable = false)
    private int priority;

    @Column(nullable = false)
    private LocalDate plannedStartDate;

    @Column(nullable = false)
    private LocalDate plannedEndDate;

    @Column(nullable = false)
    private boolean materialReady;

    @Column(nullable = false)
    private boolean qualityReleased;

    @Column(nullable = false)
    private boolean andonOpen;

    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected ProductionOrder() {}

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public ProductionOrder(String orderNo, String productCode, String productName, String plantCode,
            String lineCode, int plannedQuantity, int priority, LocalDate plannedStartDate,
            LocalDate plannedEndDate) {
        this.orderNo = orderNo;
        this.productCode = productCode;
        this.productName = productName;
        this.plantCode = plantCode;
        this.lineCode = lineCode;
        this.plannedQuantity = plannedQuantity;
        this.priority = priority;
        this.plannedStartDate = plannedStartDate;
        this.plannedEndDate = plannedEndDate;
        this.status = "DRAFT";
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PrePersist
    void createTime() {
        createdAt = updatedAt = LocalDateTime.now();
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PreUpdate
    void updateTime() {
        updatedAt = LocalDateTime.now();
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void updateReadiness(boolean materialReady, boolean qualityReleased, boolean andonOpen) {
        this.materialReady = materialReady;
        this.qualityReleased = qualityReleased;
        this.andonOpen = andonOpen;
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void release() { status = "RELEASED"; }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void start() {
        status = "IN_PROGRESS";
        if (startedAt == null) startedAt = LocalDateTime.now();
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void pause() { status = "PAUSED"; }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void resume() { status = "IN_PROGRESS"; }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void report(int good, int scrap) {
        goodQuantity += good;
        scrapQuantity += scrap;
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void complete() {
        status = "COMPLETED";
        completedAt = LocalDateTime.now();
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public int accountedQuantity() { return goodQuantity + scrapQuantity; }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Long getId() { return id; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public long getVersion() { return version; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getOrderNo() { return orderNo; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getProductCode() { return productCode; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getProductName() { return productName; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getPlantCode() { return plantCode; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getLineCode() { return lineCode; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public int getPlannedQuantity() { return plannedQuantity; }
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
    public String getStatus() { return status; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public int getPriority() { return priority; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public LocalDate getPlannedStartDate() { return plannedStartDate; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public LocalDate getPlannedEndDate() { return plannedEndDate; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public boolean isMaterialReady() { return materialReady; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public boolean isQualityReleased() { return qualityReleased; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public boolean isAndonOpen() { return andonOpen; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public LocalDateTime getStartedAt() { return startedAt; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public LocalDateTime getCompletedAt() { return completedAt; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public LocalDateTime getCreatedAt() { return createdAt; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
