package hl.booking_app.booking.repository;

import hl.booking_app.booking.entities.NpoClasesAlumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasesAlumnoRepository extends JpaRepository<NpoClasesAlumno, Integer> {
}
