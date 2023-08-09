package hl.booking_app.booking.repository;

import hl.booking_app.booking.entities.NpoReservasCancha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservasCanchaRepository extends JpaRepository<NpoReservasCancha, Integer> {
}
