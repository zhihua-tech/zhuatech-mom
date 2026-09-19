/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.mom.repository;

import cn.zhuatech.mom.model.ProductionOrder;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface ProductionOrderRepository extends JpaRepository<ProductionOrder, Long> {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    Optional<ProductionOrder> findByOrderNo(String orderNo);
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    List<ProductionOrder> findAllByOrderByPriorityDescPlannedEndDateAsc();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select item from ProductionOrder item where item.id = :id")
    Optional<ProductionOrder> findLockedById(@Param("id") Long id);
}
