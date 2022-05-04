package me.sithiramunasinghe.services.exchangeservice.services.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DexExchangeRequest {
    @JsonProperty("from_currency")
    private String fromCurrency;

    @JsonProperty("to_currency")
    private String toCurrency;

    private Float amount;

    @JsonProperty("to_wallet_address")
    private String toWalletAddress;
}
