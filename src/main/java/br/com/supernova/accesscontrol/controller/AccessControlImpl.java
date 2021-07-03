package br.com.supernova.accesscontrol.controller;

import br.com.supernova.accesscontrol.controller.implement.JornadaTrabalhoInt;
import br.com.supernova.accesscontrol.exception.JornadaTrabalhoException;
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
public class AccessControlImpl implements JornadaTrabalhoInt {

    private final AccessControlService service;

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<br.com.supernova.accesscontrol.model.JornadaTrabalho>> returnWorkdayList() {
        List<br.com.supernova.accesscontrol.model.JornadaTrabalho> allWorkday = service.returnAllWorkday();
        return ResponseEntity.ok().body(allWorkday);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<br.com.supernova.accesscontrol.model.JornadaTrabalho> createWorkday(@Valid @RequestBody br.com.supernova.accesscontrol.model.JornadaTrabalho jornada) {
        br.com.supernova.accesscontrol.model.JornadaTrabalho workday = service.registerWorkday(jornada);
        return ResponseEntity.ok().body(workday);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<br.com.supernova.accesscontrol.model.JornadaTrabalho> findWorkdayById(@PathVariable Long id) throws JornadaTrabalhoException {
        br.com.supernova.accesscontrol.model.JornadaTrabalho byWorkday = service.findByWorkday(id);
        return ResponseEntity.ok().body(byWorkday);
    }

    @Override
    @PutMapping("/up/{id}")
    public ResponseEntity<br.com.supernova.accesscontrol.model.JornadaTrabalho> updateWorkdayForget(@PathVariable Long id, @Valid @RequestBody br.com.supernova.accesscontrol.model.JornadaTrabalho jornada) throws JornadaTrabalhoException {
        br.com.supernova.accesscontrol.model.JornadaTrabalho updateWorkday = service.updateById(id, jornada);
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
