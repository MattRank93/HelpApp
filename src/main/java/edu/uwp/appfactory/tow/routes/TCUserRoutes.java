package edu.uwp.appfactory.tow.routes;

import edu.uwp.appfactory.tow.WebSecurityConfig.security.jwt.JwtUtils;
import edu.uwp.appfactory.tow.controllers.TCUserController;
import edu.uwp.appfactory.tow.controllers.UserController;
import edu.uwp.appfactory.tow.requestObjects.TCUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/tcuser")
public class TCUserRoutes {

    private final UserController userController;
    private final JwtUtils jwtUtils;
    private final TCUserController tcUserController;

    public TCUserRoutes(UserController userController, JwtUtils jwtUtils, TCUserController tcUserController) {
        this.userController = userController;
        this.jwtUtils = jwtUtils;
        this.tcUserController = tcUserController;
    }

    /**
     * GET
     */


    /**
     * POST
     */
    @PreAuthorize("hasRole('TCADMIN')")
    @PostMapping("/")
    public ResponseEntity<?> register(@RequestHeader("Authorization") final String jwtToken,
                                            @RequestBody TCUserRequest tcUserRequest) {
        UUID adminUUID = UUID.fromString(jwtUtils.getUUIDFromJwtToken(jwtToken));
        return tcUserController.register(tcUserRequest, adminUUID);
    }


    /**
     * PATCH
     */


    /**
     * DELETE
     */
}
