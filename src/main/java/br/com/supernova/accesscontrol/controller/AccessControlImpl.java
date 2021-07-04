package br.com.supernova.accesscontrol.controller;

import br.com.supernova.accesscontrol.controller.implement.CategoriaUsuarioInt;
import br.com.supernova.accesscontrol.controller.implement.JornadaTrabalhoInt;
import br.com.supernova.accesscontrol.controller.implement.NivelAcessoInt;
import br.com.supernova.accesscontrol.controller.implement.TipoDataInt;
import br.com.supernova.accesscontrol.model.CategoriaUsuario;
import br.com.supernova.accesscontrol.model.JornadaTrabalho;
import br.com.supernova.accesscontrol.model.NivelAcesso;
import br.com.supernova.accesscontrol.model.TipoData;
import br.com.supernova.accesscontrol.service.AccessControlService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class AccessControlImpl implements JornadaTrabalhoInt, CategoriaUsuarioInt, NivelAcessoInt, TipoDataInt {

    private final AccessControlService service;

    @Override
    @GetMapping("workday/all")
    public ResponseEntity<List<JornadaTrabalho>> returnWorkdayList() {
        List<JornadaTrabalho> allWorkday = (List<JornadaTrabalho>) service.returnAllObject(new JornadaTrabalho());
        return ResponseEntity.ok().body(allWorkday);
    }

    @Override
    @PostMapping("workday")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<JornadaTrabalho> createWorkday(@Valid @RequestBody JornadaTrabalho jornada) {
        JornadaTrabalho workday = (JornadaTrabalho) service.registerObject(jornada);
        return ResponseEntity.ok().body(workday);
    }

    @SneakyThrows
    @Override
    @GetMapping("workday/{id}")
    public ResponseEntity<JornadaTrabalho> findWorkdayById(@PathVariable Long id) {
        JornadaTrabalho byWorkday = (JornadaTrabalho) service.findByObject(id, new JornadaTrabalho());
        return ResponseEntity.ok().body(byWorkday);
    }

    @SneakyThrows
    @Override
    @DeleteMapping("workday/del/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Map<String, Boolean>> deleteById(@PathVariable Long id) {
        Map<String, Boolean> map = service.deleteByObjectId(id, new JornadaTrabalho());
        return ResponseEntity.ok().body(map);
    }

    @SneakyThrows
    @Override
    @PutMapping("workday/up/{id}")
    public ResponseEntity<JornadaTrabalho> updateWorkdayForget(@PathVariable Long id, @Valid @RequestBody JornadaTrabalho jornada) {
        JornadaTrabalho updateWorkday = (JornadaTrabalho) service.updateByObjectId(id, jornada);
        return ResponseEntity.ok().body(updateWorkday);
    }

    @Override
    @GetMapping("category/all")
    public ResponseEntity<List<CategoriaUsuario>> returnCategoryUserList() {
        List<CategoriaUsuario> allCategory = (List<CategoriaUsuario>) service.returnAllObject(new CategoriaUsuario());
        return ResponseEntity.ok().body(allCategory);
    }

    @Override
    @PostMapping("category")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CategoriaUsuario> createCategoryUser(@Valid @RequestBody CategoriaUsuario categoria) {
        CategoriaUsuario userCategory = (CategoriaUsuario) service.registerObject(categoria);
        return ResponseEntity.ok().body(userCategory);
    }

    @SneakyThrows
    @Override
    @GetMapping("category/{id}")
    public ResponseEntity<CategoriaUsuario> findCategoryUserById(@PathVariable Long id) {
        CategoriaUsuario userCategory = (CategoriaUsuario) service.findByObject(id, new CategoriaUsuario());
        return ResponseEntity.ok().body(userCategory);
    }

    @SneakyThrows
    @Override
    @DeleteMapping("category/del/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Map<String, Boolean>> deleteByCategoryId(@PathVariable Long id) {
        Map<String, Boolean> map = service.deleteByObjectId(id, new CategoriaUsuario());
        return ResponseEntity.ok().body(map);
    }

    @SneakyThrows
    @Override
    @PutMapping("category/up/{id}")
    public ResponseEntity<CategoriaUsuario> updateCategoryUserForget(@PathVariable Long id, @Valid @RequestBody CategoriaUsuario categoria) {
        CategoriaUsuario updatedCategory = (CategoriaUsuario) service.updateByObjectId(id, categoria);
        return ResponseEntity.ok().body(updatedCategory);
    }

    @Override
    @GetMapping("level/all")
    public ResponseEntity<List<NivelAcesso>> returnAccessLevelList() {
        List<NivelAcesso> allAccessLevel = (List<NivelAcesso>) service.returnAllObject(new NivelAcesso());
        return ResponseEntity.ok().body(allAccessLevel);
    }

    @Override
    @PostMapping("level")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<NivelAcesso> createAccessLevel(@Valid @RequestBody NivelAcesso nivel) {
        NivelAcesso accessLevel = (NivelAcesso) service.registerObject(nivel);
        return ResponseEntity.ok().body(accessLevel);
    }

    @SneakyThrows
    @Override
    @GetMapping("level/{id}")
    public ResponseEntity<NivelAcesso> findAccessLevelById(@PathVariable Long id) {
        NivelAcesso byLevel = (NivelAcesso) service.findByObject(id, new NivelAcesso());
        return ResponseEntity.ok().body(byLevel);
    }

    @SneakyThrows
    @Override
    @DeleteMapping("level/del/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Map<String, Boolean>> deleteByLevelId(@PathVariable Long id) {
        Map<String, Boolean> map = service.deleteByObjectId(id, new NivelAcesso());
        return ResponseEntity.ok().body(map);
    }

    @SneakyThrows
    @Override
    @PutMapping("level/up/{id}")
    public ResponseEntity<NivelAcesso> updateAccessLevelForget(@PathVariable Long id, @Valid @RequestBody NivelAcesso nivel) {
        NivelAcesso updatedLevel = (NivelAcesso) service.updateByObjectId(id, nivel);
        return ResponseEntity.ok().body(updatedLevel);
    }

    @Override
    @GetMapping("datetype/all")
    public ResponseEntity<List<TipoData>> returnDateTypeList() {
        List<TipoData> allDateType = (List<TipoData>) service.returnAllObject(new TipoData());
        return ResponseEntity.ok().body(allDateType);
    }

    @Override
    @PostMapping("datetype")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TipoData> createDateType(@Valid TipoData tipo) {
        TipoData dateType = (TipoData) service.registerObject(tipo);
        return ResponseEntity.ok().body(dateType);
    }

    @SneakyThrows
    @Override
    @GetMapping("datetype/{id}")
    public ResponseEntity<TipoData> findDateTypeById(Long id) {
        TipoData byType = (TipoData) service.findByObject(id, new TipoData());
        return ResponseEntity.ok().body(byType);
    }

    @SneakyThrows
    @Override
    @PutMapping("datetype/up/{id}")
    public ResponseEntity<TipoData> updateDateTypeForget(Long id, @Valid TipoData tipo) {
        TipoData updatedLevel = (TipoData) service.updateByObjectId(id, tipo);
        return ResponseEntity.ok().body(updatedLevel);
    }

    @SneakyThrows
    @Override
    @DeleteMapping("datetype/del/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Map<String, Boolean>> deleteByTypeId(Long id) {
        Map<String, Boolean> map = service.deleteByObjectId(id, new TipoData());
        return ResponseEntity.ok().body(map);
    }

}
