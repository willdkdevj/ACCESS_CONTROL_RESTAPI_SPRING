package br.com.supernova.accesscontrol.service;

import br.com.supernova.accesscontrol.exception.JornadaTrabalhoException;
import br.com.supernova.accesscontrol.model.JornadaTrabalho;
import br.com.supernova.accesscontrol.repository.AccessControlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccessControlService {

    private final AccessControlRepository repository;

    public JornadaTrabalho registerWorkday(JornadaTrabalho jornada) {
        JornadaTrabalho savedJornada = repository.save(jornada);
        return savedJornada;
    }

    public JornadaTrabalho findByWorkday(Long id) throws JornadaTrabalhoException {
        JornadaTrabalho jornadaTrabalho = repository.findById(id).orElseThrow(() -> new JornadaTrabalhoException(id));
        return jornadaTrabalho;
    }

    public List<JornadaTrabalho> returnAllWorkday(){
        List<JornadaTrabalho> repositoryAll = repository.findAll();
        return repositoryAll;
    }

    public JornadaTrabalho updateById(Long id, JornadaTrabalho jornada) throws JornadaTrabalhoException {
        JornadaTrabalho findJornada = repository.findById(id).orElseThrow(() -> new JornadaTrabalhoException(id));
        jornada.setId(findJornada.getId());
        JornadaTrabalho updateJornada = repository.save(jornada);
        return updateJornada;
    }

    public Map<String, Boolean> deleteById(Long id) throws JornadaTrabalhoException {
        JornadaTrabalho findJornada = repository.findById(id).orElseThrow(() -> new JornadaTrabalhoException(id));
        Map<String, Boolean> mapDelete = new HashMap<>();
        mapDelete.put(findJornada.getDescricao(), true);
        return mapDelete;
    }
}
