package hl.booking_app.booking.service;

import hl.booking_app.booking.dto.CanchaDto;
import hl.booking_app.booking.entities.NpoCancha;

import java.util.List;

public interface CanchasService {
    //Adm services
    public String addCancha(NpoCancha req);
    public NpoCancha updateCanchaById(NpoCancha req);
    public CanchaDto deleteCanchaById(Integer id);
    //General services
    public List<NpoCancha> getAllCanchas();
    public NpoCancha getCanchaById(Integer id);
}
