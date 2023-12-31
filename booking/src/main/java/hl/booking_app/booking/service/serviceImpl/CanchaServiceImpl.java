package hl.booking_app.booking.service.serviceImpl;

import hl.booking_app.booking.dto.CanchaDto;
import hl.booking_app.booking.entities.NpoCancha;
import hl.booking_app.booking.repository.CanchaRepository;
import hl.booking_app.booking.service.CanchasService;
import hl.booking_app.booking.utils.DozerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CanchaServiceImpl implements CanchasService {

    @Autowired
    DozerMapper mapper;
    @Autowired
    CanchaRepository canchaRepository;

//    Adm services implementation
    @Override
    public String addCancha(NpoCancha req) {
        canchaRepository.save(req);
        return "Successfully added";
    }

    @Override
    public NpoCancha updateCanchaById(NpoCancha req) {
        Optional<NpoCancha> canchaOptional = canchaRepository.findById(req.getId());
        if(canchaOptional.isPresent()){
            NpoCancha _c = canchaOptional.get();
            _c = req;
            canchaRepository.save(_c);
            return canchaOptional.get();
        }
        else return null;
    }

    @Override
    public CanchaDto deleteCanchaById(Integer id) {
        Optional<NpoCancha> canchaOptional = canchaRepository.findById(id);
        if(canchaOptional.isPresent()){
            canchaRepository.deleteById(id);
            return mapper.map(canchaOptional.get(), CanchaDto.class);
        }
        else return null;
    }

//    General services implementation
    @Override
    public List<NpoCancha> getAllCanchas() {
        return canchaRepository.findAll();
    }

    @Override
    public NpoCancha getCanchaById(Integer id) {
        Optional<NpoCancha> canchaOptional = canchaRepository.findById(id);
        return canchaOptional.orElse(null);
    }
}
