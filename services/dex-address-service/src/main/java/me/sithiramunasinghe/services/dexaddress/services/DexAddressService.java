package me.sithiramunasinghe.services.dexaddress.services;

import me.sithiramunasinghe.services.dexaddress.DexWalletDetailsDto;
import me.sithiramunasinghe.services.dexaddress.dao.DexAddress;
import me.sithiramunasinghe.services.dexaddress.dao.DexWalletDetails;

public interface DexAddressService {
    DexWalletDetailsDto findWallet(String walletAddress);

    DexWalletDetails createWallet(Long userId, String currency);

    void storeFunds(String walletAddress, Float amount);
}
