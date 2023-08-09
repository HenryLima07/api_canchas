package hl.booking_app.booking.repository;

import hl.booking_app.booking.entities.NpoPaquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaqueteRepository extends JpaRepository<NpoPaquete, Integer> {
}
