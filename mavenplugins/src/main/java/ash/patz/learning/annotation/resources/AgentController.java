package ash.patz.learning.annotation.resources;

import com.elliemae.annotations.descriptor.*;
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
 * Created by APatil on 5/24/2017.
 */
@GwNamespace("frontdoor")
@RestController
@RequestMapping("/v1/agents")
public class AgentController {

    @ApiOperation(value = "Find agents", notes = "Find agents")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity find() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @GwExposure(path = "/v1/some/new/path/agents")
    @GwEntitlements()
    @GwAuthentication
    @GwClaim(name = "audience", value = "urn:elli:service:edelivery,urn:elli:service:ebs,urn:elli:service:avs")
    @GwInstanceProximity
    @ApiOperation(value = "Find a agent", notes = "Find a agent with the provided name")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "agent Name", required = true, dataType = "string", paramType = "path")})
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{agentname}", method = RequestMethod.GET)
    public ResponseEntity<Void> findByName(@PathVariable("agentname") String agentname) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @ApiOperation(value = "Create a agent")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Void> create(HttpServletRequest request)
            throws URISyntaxException {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @ApiOperation(value = "Update a agent", notes = "Update a agent")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "agent Name", required = true, dataType = "string", paramType = "path")})
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{agentname}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable("agentname") String agentnamer) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @ApiOperation(value = "Delete a agent", notes = "Delete a agent")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "agent Name", required = true, dataType = "string", paramType = "path")})
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{agentname}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("agentname") String agentname) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
