package com.aloysius.rest.specification;



import com.aloysius.rest.dto.CustomerSearchDTO;
import com.aloysius.rest.entity.Customer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class CustomerSpecification {
    public static Specification<Customer> getspecification (CustomerSearchDTO customerSearchDTO) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (customerSearchDTO.getCustomerFullName() != null) {
                Predicate customerFullName = criteriaBuilder.like
                        (criteriaBuilder.lower(root.get("fullName")), "%" + customerSearchDTO.
                                getCustomerFullName().toLowerCase() + "%");

                predicates.add(customerFullName);
            }
            if (customerSearchDTO.getCustomerAddress() != null) {
                Predicate customerAddress = criteriaBuilder.like
                        (criteriaBuilder.lower(root.get("address")), "%" + customerSearchDTO.
                                getCustomerAddress().toLowerCase() + "%");

                predicates.add(customerAddress);

            }


            if (customerSearchDTO.getCustomerBirthDate()!=null){
                Expression<String> dates = criteriaBuilder.function("TO_CHAR", String.class, root.get("birthDate"),
                criteriaBuilder.literal("yyyy-MM-dd"));
                Predicate customerBirthDate = criteriaBuilder
                        .like(criteriaBuilder.lower(dates), "%" + customerSearchDTO.getCustomerBirthDate() + "%");
                predicates.add(customerBirthDate);
            }



            Predicate[]predicates1 = predicates.toArray(new Predicate[predicates.size()]);
            return criteriaBuilder.and(predicates1);
        };
    };
}
