package edu.uwp.appfactory.tow.routes;

import edu.uwp.appfactory.tow.controllers.PDAdminController;
import edu.uwp.appfactory.tow.controllers.UserController;
import edu.uwp.appfactory.tow.entities.PDAdmin;
import edu.uwp.appfactory.tow.requestObjects.PDAdminRequest;
import edu.uwp.appfactory.tow.webSecurityConfig.security.jwt.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * this class is responsible for registering and retrieving PD admin information.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/pdadmins")
public class PDAdminRoutes {

    private final UserController userController;
    private final JwtUtils jwtUtils;
    private final PDAdminController pdAdminController;

    public PDAdminRoutes(UserController userController, JwtUtils jwtUtils, PDAdminController pdAdminController) {
        this.userController = userController;
        this.jwtUtils = jwtUtils;
        this.pdAdminController = pdAdminController;
    }

    /**
     * This route retrieves information about a requested police department admin
     * @param jwtToken the PDAdmins token so we can locate using the UUID
     * @return returns an object that contains only the necessary information about the admin.
     */
    @GetMapping("")
    @PreAuthorize("hasRole('PDADMIN')")
    public ResponseEntity<PDAdmin> get(@RequestHeader("Authorization") final String jwtToken) {
        String userId = jwtUtils.getUUIDFromJwtToken(jwtToken);
        PDAdmin data = pdAdminController.get(UUID.fromString(userId));
        if (data != null) {
            return ResponseEntity.ok(data);
        } else {
            return ResponseEntity.status(BAD_REQUEST).build();
        }
    }


    /**
     * Registers a new admin in the system. Will need to be safeguarded in the future somehow. perhaps a godfather admin for
     * both other types of admins.
     */
    @PostMapping("")
    public ResponseEntity<?> register(@RequestBody PDAdminRequest pdAdminRequest) {
        return pdAdminController.register(pdAdminRequest);
    }


}
