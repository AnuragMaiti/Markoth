package com.bits.markoth.controller;

import com.bits.markoth.domain.BidEntity;
import com.bits.markoth.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/markoth/bids")
public class BidController extends GenericController<BidEntity, Long> {
    @Autowired
    BidService bidService;

    @Autowired
    public BidController(BidService bidService) {
        super(bidService);
    }

}