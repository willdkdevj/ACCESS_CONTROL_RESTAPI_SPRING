package br.com.supernova.accesscontrol.controller;

import br.com.supernova.accesscontrol.exception.JornadaTrabalhoException;
import br.com.supernova.accesscontrol.model.JornadaTrabalho;
import br.com.supernova.accesscontrol.service.AccessControlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/workday")
@RequiredArgsConstructor
public class AccessControlImpl implements AccessControl{

    private final AccessControlService service;

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<JornadaTrabalho>> returnWorkdayList() {
        List<JornadaTrabalho> allWorkday = service.returnAllWorkday();
        return ResponseEntity.ok().body(allWorkday);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<JornadaTrabalho> createWorkday(@Valid @RequestBody JornadaTrabalho jornada) {
        JornadaTrabalho workday = service.registerWorkday(jornada);
        return ResponseEntity.ok().body(workday);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<JornadaTrabalho> findWorkdayById(@PathVariable Long id) throws JornadaTrabalhoException {
        JornadaTrabalho byWorkday = service.findByWorkday(id);
        return ResponseEntity.ok().body(byWorkday);
    }

    @Override
    @PutMapping("/up/{id}")
    public ResponseEntity<JornadaTrabalho> updateWorkdayForget(@PathVariable Long id, @Valid @RequestBody JornadaTrabalho jornada) throws JornadaTrabalhoException {
        JornadaTrabalho updateWorkday = service.updateById(id, jornada);
        return ResponseEntity.ok().body(updateWorkday);
    }

    @Override
    @DeleteMapping("/del/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Map<String, Boolean>> deleteById(@PathVariable Long id) throws JornadaTrabalhoException {
        Map<String, Boolean> map = service.deleteById(id);
        return ResponseEntity.ok().body(map);
    }
}
