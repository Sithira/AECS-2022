package me.sithiramunasinghe.services.dexaddress;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DexWalletDetailsDto {

    private Float balance;

    @JsonProperty("wallet_address")
    private String walletAddress;

    @JsonProperty("base_currency")
    private String baseCurrency;
}
