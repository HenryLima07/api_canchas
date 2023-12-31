package hl.booking_app.booking.repository;

import hl.booking_app.booking.entities.NpoAlumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<NpoAlumno, Integer> {
}
