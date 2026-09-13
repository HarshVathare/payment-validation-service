package com.hulkhiretech.payments.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
        name = "validation_rules",
        schema = "validation"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "validator_name", nullable = false, length = 200)
    private String validatorName;

    @Column(name = "is_active", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isActive;

    @Column(name = "priority", nullable = false)
    private Integer priority;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(
            mappedBy = "validationRule",
            fetch = FetchType.LAZY
    )
    private List<ValidationRuleParam> params;
}