package me.sithiramunasinghe.services.dexaddress.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DexWalletStoreFundsRequest {
    @JsonProperty("wallet_id")
    private String walletId;

    @JsonProperty("amount")
    private Float amount;
}
