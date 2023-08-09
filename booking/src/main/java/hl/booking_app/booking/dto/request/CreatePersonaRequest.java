package hl.booking_app.booking.dto.request;

import hl.booking_app.booking.entities.NpoAlumno;
import hl.booking_app.booking.entities.NpoPaquetesComprado;
import hl.booking_app.booking.entities.NpoReservasCancha;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class CreatePersonaRequest {

    private String perNombres;

    private String perApellidos;

    private Date perFechaNac;

    private String perEstado = "ACT";

    private String perEmail;

    private String perTelefono;

    private String perClave;
}
