package me.sithiramunasinghe.services.dexaddress;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/api/address/")
public class DexAddressController {

    @RequestMapping(method = RequestMethod.GET, path = "status", produces = "application/json")
    public String status() {
        return "dex-address-service: RUNNING";
    }
}
