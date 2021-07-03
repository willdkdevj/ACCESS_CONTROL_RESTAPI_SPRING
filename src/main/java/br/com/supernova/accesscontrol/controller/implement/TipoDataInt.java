package br.com.supernova.accesscontrol.controller.implement;

import br.com.supernova.accesscontrol.exception.TipoDataException;
import br.com.supernova.accesscontrol.model.TipoData;
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
public interface TipoDataInt {

    @ApiOperation(value = "Operation to list Date Type in management")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Date Type catalog successfully returned")
    })
    public ResponseEntity<List<TipoData>> returnDateTypeList();

    @ApiOperation(value = "Operation to record Date Type")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Date Type successfully registered"),
            @ApiResponse(code = 400, message = "It was not possible to register the informed Date Type")
    })
    public ResponseEntity<TipoData> createDateType(@Valid @RequestBody TipoData tipo);

    @ApiOperation(value = "Operation to locate Date Type")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Date Type found successfully"),
            @ApiResponse(code = 404, message = "Could not find Date Type reported")
    })
    public ResponseEntity<TipoData> findDateTypeById(@PathVariable Long id) throws TipoDataException;

    @ApiOperation(value = "Updating of registration data of a successful Date Type")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Date Type data updated successfully"),
            @ApiResponse(code = 404, message = "The Date Type could not be found to update the data")
    })
    public ResponseEntity<TipoData> updateDateTypeForget(@PathVariable Long id, @Valid @RequestBody TipoData tipo) throws TipoDataException;

    @ApiOperation(value = "Operation to exclude Date Type")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Date Type registration successfully deleted"),
            @ApiResponse(code = 404, message = "Could not find the Date Type registration for deletion")
    })
    public ResponseEntity<Map<String, Boolean>> deleteByTypeId(@PathVariable Long id) throws TipoDataException;
}
