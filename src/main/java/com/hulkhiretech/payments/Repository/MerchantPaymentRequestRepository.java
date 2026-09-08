package com.hulkhiretech.payments.Repository;

import com.hulkhiretech.payments.Entity.MerchantPaymentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantPaymentRequestRepository extends JpaRepository<MerchantPaymentRequest, Long> {

//    <Optional>String findByEndUserId(String endUserId);
//
//    MerchantPaymentRequest findByEndUserIdAndMerchantTxnReference(String endUserId, String merchantTxnRef);
//
//     MerchantPaymentRequest existsFirstBy(String merchantTxnRef);

    boolean existsByMerchantTxnReference(String merchantTxnRef);
}