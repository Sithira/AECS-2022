package me.sithiramunasinghe.services.dexaddress.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DexWalletDetails {
    @JsonProperty("wallet_address")
    private String walletAddress;

    @JsonProperty("base_currency")
    private String baseCurrency;
}
