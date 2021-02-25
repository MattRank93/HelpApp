package edu.uwp.appfactory.tow.routes;

import edu.uwp.appfactory.tow.WebSecurityConfig.security.jwt.JwtUtils;
import edu.uwp.appfactory.tow.controllers.AuthController;
import edu.uwp.appfactory.tow.requestObjects.AdminRequest;
import edu.uwp.appfactory.tow.requestObjects.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthRoutes {

    private final AuthController authController;
    private final JwtUtils jwtUtils;

    public AuthRoutes(AuthController authController, JwtUtils jwtUtils) {
        this.authController = authController;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestHeader("Authorization") final String jwtToken) {
        String token = authController.refreshToken(jwtToken);
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(400).body("Error");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        return authController.authenticateUser(loginRequest);
    }

    @PostMapping("/admin")
    public ResponseEntity<?> registerAdmin(@RequestBody AdminRequest adminRequest) {
        return authController.registerAdmin(adminRequest)
                ? ResponseEntity.status(HttpStatus.NO_CONTENT).body(null)
                : ResponseEntity.status(400).body("Error");
    }

    @GetMapping("/verification")
    public ResponseEntity<?> verification(@RequestParam("token") final String token) {
        int status = authController.verification(token);
        return switch (status) {
            case 200 -> ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            case 410 -> ResponseEntity.status(410).body("User already verified");
            case 403 -> ResponseEntity.status(403).body("Link expired, account deleted");
            default -> ResponseEntity.status(404).body("Resource not found");
        };
    }
}


// TODO: The stuff below
// sign up, schedule an appointment by checking a calender and finding an open slot (30m/hour)
// up to 5 people can be schedule if 5 people have that time slot open

// worked on, no design, auth done, but no pieces come together
// when applicants arrive, they want to track people by 'checking them in'
// to generate metrics

