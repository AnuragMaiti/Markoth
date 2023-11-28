package com.bits.markoth.service;

import com.bits.markoth.domain.BidEntity;
import com.bits.markoth.repository.BidRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BidService extends GenericService<BidEntity, Long> {
    @Autowired
    BidRepository BidRepository;

    @Autowired
    BidService(final BidRepository repository) {
        super(repository);
    }
}