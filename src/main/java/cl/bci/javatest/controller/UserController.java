package cl.bci.javatest.controller;

import cl.bci.javatest.dto.request.CreateUserRequestDTO;
import cl.bci.javatest.service.IUserService;
import cl.bci.javatest.util.BciHttpResponseBuilder;
import cl.bci.javatest.util.BciResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Log4j2
public class UserController {

    @Autowired
    private IUserService userService;

    @Operation(summary = "Create a new user")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @PostMapping(value = "/create")
    public ResponseEntity<BciResponse> createUser(@RequestBody CreateUserRequestDTO createUserRequestDTO) throws Exception {
        log.info(UserController.class + " ****** New request triggered on User Controller ****** ");
        log.info(UserController.class + " Starting createUser function... ");
        return BciHttpResponseBuilder.buildHttpResponse(this.userService.createUser(createUserRequestDTO));
    }

    @Operation(summary = "List all active users")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping(value = "/list")
    public ResponseEntity<BciResponse> listUsers() throws Exception {
        log.info(UserController.class + " ****** New request triggered on User Controller ****** ");
        log.info(UserController.class + " Starting listUsers function... ");
        return BciHttpResponseBuilder.buildHttpResponse(this.userService.listUsers());
    }
}
