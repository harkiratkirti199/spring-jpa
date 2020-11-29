package io.pragra.learning.repo;

import io.pragra.learning.domain.RefData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefDataRepo extends JpaRepository<RefData, Long> {
}
