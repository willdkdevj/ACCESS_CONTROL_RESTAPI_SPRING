package br.com.supernova.accesscontrol.controller.implement;

import br.com.supernova.accesscontrol.exception.CategoriaUsuarioException;
import br.com.supernova.accesscontrol.model.CategoriaUsuario;
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

@Api("Interface to abstract Controller layer methods - User Category")
public interface CategoriaUsuarioInt {

    @ApiOperation(value = "Operation to list Category User in management")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category User catalog successfully returned")
    })
    public ResponseEntity<List<CategoriaUsuario>> returnCategoryUserList();

    @ApiOperation(value = "Operation to record category user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Category User successfully registered"),
            @ApiResponse(code = 400, message = "It was not possible to register the informed Category User")
    })
    public ResponseEntity<CategoriaUsuario> createCategoryUser(@Valid @RequestBody CategoriaUsuario categoria);

    @ApiOperation(value = "Operation to locate Category User")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category User found successfully"),
            @ApiResponse(code = 404, message = "Could not find Category User reported")
    })
    public ResponseEntity<CategoriaUsuario> findCategoryUserById(@PathVariable Long id) throws CategoriaUsuarioException;

    @ApiOperation(value = "Updating of registration data of a successful Category User")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category User data updated successfully"),
            @ApiResponse(code = 404, message = "The Category User could not be found to update the data")
    })
    public ResponseEntity<CategoriaUsuario> updateCategoryUserForget(@PathVariable Long id, @Valid @RequestBody CategoriaUsuario categoria) throws CategoriaUsuarioException;

    @ApiOperation(value = "Operation to exclude Category User")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Category User registration successfully deleted"),
            @ApiResponse(code = 404, message = "Could not find the Category User registration for deletion")
    })
    public ResponseEntity<Map<String, Boolean>> deleteById(@PathVariable Long id) throws CategoriaUsuarioException;
}
