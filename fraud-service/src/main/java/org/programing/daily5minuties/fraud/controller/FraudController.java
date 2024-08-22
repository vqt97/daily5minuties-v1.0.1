package org.programing.daily5minuties.fraud.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.programing.daily5minuties.fraud.response.FraudCheckResponse;
import org.programing.daily5minuties.fraud.service.FraudCheckService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
@RequiredArgsConstructor
public class FraudController {
    private final FraudCheckService fraudService;

    @GetMapping("{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Long cusomerId) {
        boolean isFraudsterCustomer = fraudService.isFraudsterCustomer(cusomerId);
        log.info("fraud check request for customer {}", isFraudsterCustomer);
        return new FraudCheckResponse(isFraudsterCustomer);
    }
}
