package br.com.supernova.accesscontrol.controller.implement;

import br.com.supernova.accesscontrol.exception.CategoriaUsuarioException;
import br.com.supernova.accesscontrol.exception.JornadaTrabalhoException;
import br.com.supernova.accesscontrol.exception.NivelAcessoException;
import br.com.supernova.accesscontrol.exception.TipoDataException;
import br.com.supernova.accesscontrol.model.JornadaTrabalho;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Api("Interface to abstract Controller layer methods ")
public interface JornadaTrabalhoInt {

    @ApiOperation(value = "Operation to list Working Hours in management")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Working Hours catalog successfully returned")
    })
    public ResponseEntity<List<JornadaTrabalho>> returnWorkdayList();

    @ApiOperation(value = "Operation to record working hours")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Working Hours successfully registered"),
            @ApiResponse(code = 400, message = "It was not possible to register the informed Working Hours")
    })
    public ResponseEntity<JornadaTrabalho> createWorkday(@Valid @RequestBody JornadaTrabalho jornada);

    @ApiOperation(value = "Operation to locate Working Hours")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Working Hours found successfully"),
            @ApiResponse(code = 404, message = "Could not find Working Hours reported")
    })
    public ResponseEntity<JornadaTrabalho> findWorkdayById(@PathVariable Long id) throws JornadaTrabalhoException, CategoriaUsuarioException, NivelAcessoException, TipoDataException, Exception;

    @ApiOperation(value = "Updating of registration data of a successful Working Hours")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Working Hours data updated successfully"),
            @ApiResponse(code = 404, message = "The Working Hours could not be found to update the data")
    })
    public ResponseEntity<JornadaTrabalho> updateWorkdayForget(@PathVariable Long id, @Valid @RequestBody JornadaTrabalho jornada) throws JornadaTrabalhoException;

    @ApiOperation(value = "Operation to exclude Working Hours")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Working Hours registration successfully deleted"),
            @ApiResponse(code = 404, message = "Could not find the Working Hours registration for deletion")
    })
    public ResponseEntity<Map<String, Boolean>> deleteById(@PathVariable Long id) throws JornadaTrabalhoException;
}
