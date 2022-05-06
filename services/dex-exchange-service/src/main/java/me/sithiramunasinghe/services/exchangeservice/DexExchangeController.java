package me.sithiramunasinghe.services.exchangeservice;

import me.sithiramunasinghe.services.exchangeservice.services.impl.DexExchangeRequest;
import me.sithiramunasinghe.services.exchangeservice.services.impl.DexExchangeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/exchange/")
public class DexExchangeController {
    private final DexExchangeService dexExchangeService;

    public DexExchangeController(DexExchangeService dexExchangeService) {
        this.dexExchangeService = dexExchangeService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "exchange", produces = "application/json")
    public ResponseEntity<Void> exchange(@RequestBody DexExchangeRequest dexExchangeRequest) {
        this.dexExchangeService.exchange(dexExchangeRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
