package me.sithiramunasinghe.services.dexaddress.services.impl;

import lombok.extern.slf4j.Slf4j;
import me.sithiramunasinghe.services.dexaddress.DexWalletDetailsDto;
import me.sithiramunasinghe.services.dexaddress.dao.DexAddress;
import me.sithiramunasinghe.services.dexaddress.dao.DexAddressRepository;
import me.sithiramunasinghe.services.dexaddress.dao.DexWalletDetails;
import me.sithiramunasinghe.services.dexaddress.services.DexAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;


@Slf4j
@Service
@Transactional
public class DexAddressServiceImpl implements DexAddressService {

    private final DexAddressRepository dexAddressRepository;

    @Autowired
    public DexAddressServiceImpl(DexAddressRepository dexAddressRepository) {
        this.dexAddressRepository = dexAddressRepository;
    }

    @Override
    public DexWalletDetailsDto findWallet(String address) {
        Optional<DexAddress> dexAddress = this.dexAddressRepository.findByWalletAddress(address);

        if (dexAddress.isEmpty()) {
            throw new RuntimeException("No dex address found");
        }

        DexAddress dexAdr = dexAddress.get();
        DexWalletDetailsDto dexWalletDetails = new DexWalletDetailsDto();
        dexWalletDetails.setWalletAddress(dexAdr.getWalletAddress());
        dexWalletDetails.setBaseCurrency(dexAdr.getBaseCurrency());
        dexWalletDetails.setBalance(dexAdr.getBalance());

        return dexWalletDetails;
    }

    @Override
    public DexWalletDetails createWallet(Long userId, String currency) {
        Optional<DexAddress> dexAddress = this.dexAddressRepository.findByUserId(userId);
        if (dexAddress.isEmpty()) {
            DexAddress newDexWallet = new DexAddress();
            newDexWallet.setUserId(userId);
            newDexWallet.setWalletAddress(UUID.randomUUID().toString());
            newDexWallet.setBalance(0F);
            newDexWallet.setBaseCurrency(currency);
            newDexWallet = this.dexAddressRepository.save(newDexWallet);
            DexWalletDetails dexWalletDetails = new DexWalletDetails();
            dexWalletDetails.setWalletAddress(newDexWallet.getWalletAddress());
            dexWalletDetails.setBaseCurrency(currency);
            return dexWalletDetails;
        }
        return null;
    }


    @Override
    public void storeFunds(String walletAddress, Float amount) {
        Optional<DexAddress> dexAddress = this.dexAddressRepository.findByWalletAddress(walletAddress);

        if (dexAddress.isEmpty()) {
            throw new RuntimeException("No Wallet fund");
        }

        DexAddress toStoreFunds = dexAddress.get();
        toStoreFunds.setBalance(toStoreFunds.getBalance() + amount);
        this.dexAddressRepository.save(toStoreFunds);
    }
}
