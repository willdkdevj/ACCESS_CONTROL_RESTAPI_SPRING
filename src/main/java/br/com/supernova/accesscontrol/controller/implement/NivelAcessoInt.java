package br.com.supernova.accesscontrol.controller.implement;

import br.com.supernova.accesscontrol.exception.NivelAcessoException;
import br.com.supernova.accesscontrol.model.NivelAcesso;
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

@Api("Interface to abstract Controller layer methods - Access Level")
public interface NivelAcessoInt {

    @ApiOperation(value = "Operation to list Access Level in management")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Access Level catalog successfully returned")
    })
    public ResponseEntity<List<NivelAcesso>> returnAccessLevelList();

    @ApiOperation(value = "Operation to record Access Level")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Access Level successfully registered"),
            @ApiResponse(code = 400, message = "It was not possible to register the informed Access Level")
    })
    public ResponseEntity<NivelAcesso> createAccessLevel(@Valid @RequestBody NivelAcesso nivel);

    @ApiOperation(value = "Operation to locate Access Level")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Access Level found successfully"),
            @ApiResponse(code = 404, message = "Could not find Access Level reported")
    })
    public ResponseEntity<NivelAcesso> findAccessLevelById(@PathVariable Long id) throws NivelAcessoException;

    @ApiOperation(value = "Updating of registration data of a successful Access Level")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Access Level data updated successfully"),
            @ApiResponse(code = 404, message = "The Access Level could not be found to update the data")
    })
    public ResponseEntity<NivelAcesso> updateAccessLevelForget(@PathVariable Long id, @Valid @RequestBody NivelAcesso nivel) throws NivelAcessoException;

    @ApiOperation(value = "Operation to exclude Access Level")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Access Level registration successfully deleted"),
            @ApiResponse(code = 404, message = "Could not find the Access Level registration for deletion")
    })
    public ResponseEntity<Map<String, Boolean>> deleteByLevelId(@PathVariable Long id) throws NivelAcessoException;
}
