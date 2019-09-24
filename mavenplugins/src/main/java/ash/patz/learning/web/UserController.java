package ash.patz.learning.web;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;

/**
 * Created by APatil on 5/23/2017.
 */
@RestController
@RequestMapping("/v1/users")
public final class UserController {

    @ApiOperation(value = "Find users", notes = "Find users")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity find() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @ApiOperation(value = "Find a user", notes = "Find a user with the provided name")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "User Name", required = true, dataType = "string", paramType = "path")})
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{username}", method = RequestMethod.GET)
    public ResponseEntity<Void> findByName(@PathVariable("username") String username) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @ApiOperation(value = "Create a user")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Void> create(HttpServletRequest request)
            throws URISyntaxException {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @ApiOperation(value = "Update a user", notes = "Update a user")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "User Name", required = true, dataType = "string", paramType = "path")})
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{username}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable("username") String usernamer) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @ApiOperation(value = "Delete a user", notes = "Delete a user")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "User Name", required = true, dataType = "string", paramType = "path")})
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{username}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("username") String username) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}