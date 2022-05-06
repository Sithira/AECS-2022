package me.sithiramunasinghe.services.dexaddress.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface DexAddressRepository extends JpaRepository<DexAddress, Long> {
    @Query("select d from DexAddress d where d.userId = :userId")
    Optional<DexAddress> findByUserId(@NonNull Long userId);

    @Query("select d from DexAddress d where d.walletAddress = :walletAdr")
    Optional<DexAddress> findByWalletAddress(@NonNull String walletAdr);
}
