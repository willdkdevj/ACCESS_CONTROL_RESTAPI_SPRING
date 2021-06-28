package br.com.supernova.accesscontrol.controller;

import br.com.supernova.accesscontrol.model.JornadaTrabalho;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

public interface AccessControl {


    public ResponseEntity<List<JornadaTrabalho>> returnWorkdayList();


    public ResponseEntity<JornadaTrabalho> createWorkday(@Valid @RequestBody JornadaTrabalho jornada);


    public ResponseEntity<JornadaTrabalho> findWorkdayById(@PathVariable Long id);

    public ResponseEntity<JornadaTrabalho> updateWorkdayForget(@PathVariable Long id, @Valid @RequestBody JornadaTrabalho jornada);

    public ResponseEntity<Map<String, Boolean>> deleteById(@PathVariable Long id);
}
