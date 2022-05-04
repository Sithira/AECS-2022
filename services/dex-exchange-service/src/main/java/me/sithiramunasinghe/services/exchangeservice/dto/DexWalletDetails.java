package me.sithiramunasinghe.services.exchangeservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DexWalletDetails {
    @JsonProperty("base_currency")
    private String baseCurrency;
}
