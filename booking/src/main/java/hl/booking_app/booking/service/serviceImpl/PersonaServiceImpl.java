package hl.booking_app.booking.service.serviceImpl;

import hl.booking_app.booking.dto.PersonaDto;
import hl.booking_app.booking.entities.NpoPersona;
import hl.booking_app.booking.repository.PersonaRepository;
import hl.booking_app.booking.security.JwtGrantedAuthority;
import hl.booking_app.booking.service.PersonaService;
import hl.booking_app.booking.utils.DozerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    DozerMapper mapper;
    @Override
    public String savePersona(NpoPersona req) {
        personaRepository.save(req);
        return "successfully saved";
    }

    @Override
    public List<PersonaDto> getAllPersonas() {
        List<NpoPersona> personasList = personaRepository.findAll();
        return mapper.maplist(personasList, PersonaDto.class);
    }

    @Override
    public PersonaDto getPersonaById(Integer id) {
        Optional<NpoPersona> persona = personaRepository.findById(id);
        return mapper.map(persona.orElse(null), PersonaDto.class);
    }

    @Override
    public PersonaDto updatePersonaById(NpoPersona req) {
        Optional<NpoPersona> persona = personaRepository.findById(req.getId());
        if(persona.isPresent()){
            NpoPersona p = persona.get();
            p = req;
            personaRepository.save(p);
            return mapper.map(p, PersonaDto.class);
        }
        else return null;
    }

    @Override
    public PersonaDto deletePersonaById(Integer id) {
        Optional<NpoPersona> persona = personaRepository.findById(id);
        if(persona.isPresent()){
            personaRepository.deleteById(id);
            return mapper.map(persona.get(), PersonaDto.class);
        }
        else return null;
    }

    @Override
    //autenticacion jwt
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        NpoPersona persona = personaRepository.findByPerEmail(email);
        if(persona != null){
            JwtGrantedAuthority authority = new JwtGrantedAuthority("USER");
            authorities.add(authority);

            User user = new User(email, persona.getPerClave(), authorities);
            return user;
        }
        else throw new UsernameNotFoundException("No se encontró el usuario: " + email);
    }
}
