package be.businesstraining.repository;

import be.businesstraining.domain.Flat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatsRepository extends JpaRepository<Flat, String> {
}
