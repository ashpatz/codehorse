package ash.patz.learning.annotation.resources;

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
 * Created by APatil on 5/25/2017.
 */
@RestController
public class    TestController {

    @ApiOperation(value = "Find tests", notes = "Find tests")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET, value = "/v1/tests/")
    public ResponseEntity find() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @ApiOperation(value = "Find a test", notes = "Find a test with the provided name")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "test Name", required = true, dataType = "string", paramType = "path")})
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/v1/tests/{testname}", method = RequestMethod.GET)
    public ResponseEntity<Void> findByName(@PathVariable("testname") String testname) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @ApiOperation(value = "Create a test")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST, value = "/v1/tests/")
    public ResponseEntity<Void> create(HttpServletRequest request)
            throws URISyntaxException {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @ApiOperation(value = "Update a test", notes = "Update a test")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "test Name", required = true, dataType = "string", paramType = "path")})
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/v1/tests/{testname}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable("testname") String testnamer) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @ApiOperation(value = "Delete a test", notes = "Delete a test")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "test Name", required = true, dataType = "string", paramType = "path")})
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/v1/tests/{testname}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("testname") String testname) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
