package org.example.Store.Repositories;

import org.aspectj.weaver.ast.Var;
import org.example.Store.Models.Variation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariationRepository extends JpaRepository<Variation, Long> {
    Variation findByName(String name);
}
