package hl.booking_app.booking.service;

import hl.booking_app.booking.dto.CanchaDto;
import hl.booking_app.booking.entities.NpoCancha;
import hl.booking_app.booking.entities.NpoPaquete;

import java.util.List;

public interface PaqueteService {
    public List<NpoPaquete> getAllPaqueteAct();
    public NpoPaquete getPaqueteById(Integer id);

    //Adm services
    public String addPaquete(NpoPaquete req);
    public NpoPaquete updatePaqueteById(NpoPaquete req);
    public NpoPaquete deletePaqueteById(Integer id);
    public List<NpoPaquete> getAllPaquete();
}
