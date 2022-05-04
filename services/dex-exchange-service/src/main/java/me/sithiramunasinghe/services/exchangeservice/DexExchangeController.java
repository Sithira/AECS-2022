package me.sithiramunasinghe.services.exchangeservice;

import me.sithiramunasinghe.services.exchangeservice.services.impl.DexExchangeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/exchange/")
public class DexExchangeController {
    private final DexExchangeService dexExchangeService;

    public DexExchangeController(DexExchangeService dexExchangeService) {
        this.dexExchangeService = dexExchangeService;
    }
}
