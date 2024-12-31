package com.iqbal.poin_of_sale.repository;

import com.iqbal.poin_of_sale.model.grn.GrnItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrnItemRepository extends JpaRepository<GrnItem, Long> {
}
