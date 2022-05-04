package me.sithiramunasinghe.services.dexaddress.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DexWalletCreateRequest {
    @JsonProperty("base_currency")
    private String baseCurrency;

    @JsonProperty("user_id")
    private Long userId;
}
