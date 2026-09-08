package com.hulkhiretech.payments.Entity;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "merchant_payment_request")
public class MerchantPaymentRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "end_user_id", length = 100)
    private String endUserId;
    @Column(name = "merchant_txn_reference", nullable = false, unique = true, length = 100)
    private String merchantTxnReference;
    @Column(name = "transaction_request", columnDefinition = "TEXT")
    private String transactionRequest;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}