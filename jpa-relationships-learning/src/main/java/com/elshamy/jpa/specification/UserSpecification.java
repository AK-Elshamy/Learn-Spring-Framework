package com.elshamy.jpa.specification;

import com.elshamy.jpa.model.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<User> hasName(String name) {

        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("name"), name);
    }

    public static Specification<User> nameContains(String name) {

        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(
                        root.get("name"),
                        "%" + name + "%"
                );
    }
}