package com.hulkhiretech.payments.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "validation_rule_params",
        schema = "validation"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidationRuleParam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "validation_rule_id",
            nullable = false
    )
    private ValidationRule validationRule;

    @Column(name = "param_name", nullable = false, length = 200)
    private String paramName;

    @Column(name = "param_value", nullable = false, length = 200)
    private String paramValue;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}