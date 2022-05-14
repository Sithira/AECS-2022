package me.sithiramunasinghe.services.exchangeservice.services.impl;

import lombok.extern.slf4j.Slf4j;
import me.sithiramunasinghe.services.exchangeservice.dto.DexWalletDetails;
import me.sithiramunasinghe.services.exchangeservice.dto.DexWalletStoreFundsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
//@Transactional
public class DexExchangeServiceImpl implements DexExchangeService {

    private final RestTemplate restTemplate;

    @Autowired
    public DexExchangeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void exchange(DexExchangeRequest dexExchangeRequest) {
        final String url = "http://dex-address-service/address/v1/api/address/fetch-wallet/" + dexExchangeRequest.getToWalletAddress();

        DexWalletDetails toWalletAddress = this.restTemplate.getForObject(url, DexWalletDetails.class);

        if (toWalletAddress == null) {
            throw new RuntimeException("Wallet not found");
        }

        if (!dexExchangeRequest.getToCurrency().equals(toWalletAddress.getBaseCurrency())) {
            throw new RuntimeException("Base currency does not match");
        }

        final Float transferValue = dexExchangeRequest.getAmount() - (dexExchangeRequest.getAmount() / 20.F);

        final String storeFundsUrl = "http://dex-address-service/address/v1/api/address/store-funds";

        DexWalletStoreFundsRequest storeFundsRequest = new DexWalletStoreFundsRequest();
        storeFundsRequest.setAmount(transferValue);
        storeFundsRequest.setWalletId(dexExchangeRequest.getToWalletAddress());

        this.restTemplate.postForEntity(storeFundsUrl, storeFundsRequest, Void.class);
    }
}
