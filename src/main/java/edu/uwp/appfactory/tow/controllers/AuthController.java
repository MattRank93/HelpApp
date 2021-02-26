package edu.uwp.appfactory.tow.controllers;

import edu.uwp.appfactory.tow.WebSecurityConfig.models.ERole;
import edu.uwp.appfactory.tow.WebSecurityConfig.payload.response.JwtResponse;
import edu.uwp.appfactory.tow.WebSecurityConfig.payload.response.MessageResponse;
import edu.uwp.appfactory.tow.WebSecurityConfig.repository.UsersRepository;
import edu.uwp.appfactory.tow.WebSecurityConfig.security.jwt.JwtUtils;
import edu.uwp.appfactory.tow.WebSecurityConfig.security.services.UserDetailsImpl;
import edu.uwp.appfactory.tow.entities.Users;
import edu.uwp.appfactory.tow.repositories.PDAdminRepository;
import edu.uwp.appfactory.tow.requestObjects.AdminRequest;
import edu.uwp.appfactory.tow.requestObjects.LoginRequest;
import edu.uwp.appfactory.tow.services.AsyncEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Controller
public class AuthController {

    //access tokens expire quickly
    //clients ask for new one based on their refresh token
    //if refresh token is expired, re-auth
    //logout route
    //JSON WEB TOKEN NPM

    private final AuthenticationManager authenticationManager;
    private final UsersRepository usersRepository;
    private final PDAdminRepository pdAdminRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;
    private final AsyncEmail sendEmail;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UsersRepository usersRepository, PDAdminRepository pdAdminRepository, PasswordEncoder encoder, JwtUtils jwtUtils, AsyncEmail sendEmail) {
        this.authenticationManager = authenticationManager;
        this.usersRepository = usersRepository;
        this.pdAdminRepository = pdAdminRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
        this.sendEmail = sendEmail;
    }

    public String refreshToken(String jwtToken) {
        return jwtUtils.refreshJwtToken(jwtUtils.getUUIDFromJwtToken(jwtToken));
    }

    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        Optional<Users> usersOptional = usersRepository.findByUsername(loginRequest.getEmail());

        //todo: when not testing, uncomment code
        if (userDetails.getRole().equals(loginRequest.getPlatform())) {
            if (usersOptional.isPresent()) {
                Users user = usersOptional.get();
                return user.getVerEnabled() ?
                        ResponseEntity.ok(new JwtResponse(
                                jwt,
                                userDetails.getId(),
                                userDetails.getUsername(),
                                userDetails.getEmail(),
                                userDetails.getFirstname(),
                                userDetails.getLastname(),
                                userDetails.getRole())
                        ) :
                        ResponseEntity.badRequest().body(new MessageResponse("User not verified"));
            } else {
                return ResponseEntity
                        .status(494)
                        .body(new MessageResponse("User does not exist"));
            }
        } else {
            return ResponseEntity
                    .status(401)
                    .body(new MessageResponse("User is not permitted to use this dashboard"));
        }
    }

    public boolean registerAdmin(AdminRequest adminRequest) {
        if (!usersRepository.existsByEmail(adminRequest.getEmail())) {
            Users user = new Users(adminRequest.getEmail(),
                    adminRequest.getEmail(),
                    encoder.encode(adminRequest.getPassword()),
                    adminRequest.getFirstname(),
                    adminRequest.getLastname(),
                    adminRequest.getPhone(),
                    ERole.ROLE_ADMIN.name());
            user.setVerEnabled(true);

            usersRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    public int verification(String token) {
        Optional<Users> usersOptional = usersRepository.findByVerifyToken(token);
        if (usersOptional.isPresent()) {

            Users user = usersOptional.get();
            LocalDate userVerifyDate = LocalDate.parse(user.getVerifyDate());
            Period periodBetween = Period.between(userVerifyDate, LocalDate.now());

            if (periodBetween.getDays() < 8) {
                if (user.getVerifyToken().equals(token) && !user.getVerEnabled()) {
                    usersRepository.updateUserEmailVerifiedByUUID(user.getId(), true);
                    return 200; // success
                } else {
                    return 410; // user already verified
                }
            } else {
                usersRepository.deleteByEmail(user.getEmail());
                return 403; // expired, account deleted
            }
        } else {
            return 404; // token doesnt exist
        }
    }
}