package com.hulkhiretech.payments.Repository;

import com.hulkhiretech.payments.Entity.ValidationRule;
import com.hulkhiretech.payments.Entity.ValidationRuleParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ValidationRuleRepository extends JpaRepository<ValidationRule, Long> {

//    @Query("SELECT v.validatorName " +
//            "FROM ValidationRuleParam " +
//            "v WHERE v.active = true " +
//            "ORDER BY v.priority " + "ASC")
//    List<String> findActiveValidatorNamesOrderByPriority();

    List<ValidationRule> findByIsActiveTrueOrderByPriorityAsc();

}