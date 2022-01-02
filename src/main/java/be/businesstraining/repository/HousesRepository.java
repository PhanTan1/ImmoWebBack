package be.businesstraining.repository;

import be.businesstraining.domain.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HousesRepository extends JpaRepository<House, String> {
}
