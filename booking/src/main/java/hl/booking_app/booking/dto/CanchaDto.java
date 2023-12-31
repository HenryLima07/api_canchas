package hl.booking_app.booking.dto;

import hl.booking_app.booking.entities.NpoClasesGrupal;
import hl.booking_app.booking.entities.NpoHorariosCancha;
import hl.booking_app.booking.entities.NpoReservasCancha;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
public class CanchaDto {
    private String canNombre;

    private String canEstado;

    private String canDireccion;

    private Integer canFoto;

    private List<NpoClasesGrupal> clasesGrupales = new ArrayList<>();

    @OneToMany(mappedBy = "can")
    private List<NpoHorariosCancha> horariosCanchas = new ArrayList<>();

    @OneToMany(mappedBy = "cancha")
    private List<NpoReservasCancha> reservasCanchas = new ArrayList<>();
}
