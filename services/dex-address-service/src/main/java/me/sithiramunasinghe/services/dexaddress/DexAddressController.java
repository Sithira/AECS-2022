package me.sithiramunasinghe.services.dexaddress;

import me.sithiramunasinghe.services.dexaddress.dao.DexAddress;
import me.sithiramunasinghe.services.dexaddress.dao.DexWalletDetails;
import me.sithiramunasinghe.services.dexaddress.dto.DexWalletCreateRequest;
import me.sithiramunasinghe.services.dexaddress.dto.DexWalletStoreFundsRequest;
import me.sithiramunasinghe.services.dexaddress.services.DexAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/api/address/")
public class DexAddressController {

    private final DexAddressService dexAddressService;

    @Autowired
    public DexAddressController(DexAddressService dexAddressService) {
        this.dexAddressService = dexAddressService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "status", produces = "application/json")
    public String status() {
        return "dex-address-service: RUNNING";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/fetch-wallet/{walletAddress}", produces = "application/json")
    public ResponseEntity<DexWalletDetailsDto> findWallet(@PathVariable String walletAddress) {
        return ResponseEntity.status(HttpStatus.OK).body(this.dexAddressService.findWallet(walletAddress));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/create-wallet", produces = "application/json")
    public ResponseEntity<DexWalletDetails> createWallet(@RequestBody DexWalletCreateRequest dexWalletCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.dexAddressService.createWallet(dexWalletCreateRequest.getUserId(), dexWalletCreateRequest.getBaseCurrency()));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/store-funds", produces = "application/json")
    public ResponseEntity<Void> storeFunds(@RequestBody DexWalletStoreFundsRequest storeFundsRequest) {
        this.dexAddressService.storeFunds(storeFundsRequest.getWalletId(), storeFundsRequest.getAmount());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
