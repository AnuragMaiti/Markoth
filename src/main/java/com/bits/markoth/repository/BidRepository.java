package com.bits.markoth.repository;

import com.bits.markoth.domain.BidEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.ListCrudRepository;

public interface BidRepository extends JpaRepository<BidEntity, Long>,
        JpaSpecificationExecutor<BidEntity>,
        ListCrudRepository<BidEntity, Long> {
}