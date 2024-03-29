package edu.uwp.appfactory.tow.controllers;

import edu.uwp.appfactory.tow.entities.TCAdmin;
import edu.uwp.appfactory.tow.mappers.TCMapper;
import edu.uwp.appfactory.tow.repositories.TCAdminRepository;
import edu.uwp.appfactory.tow.requestObjects.TCAdminRequest;
import edu.uwp.appfactory.tow.responseObjects.TCAdminResponse;
import edu.uwp.appfactory.tow.responseObjects.TestVerifyResponse;
import edu.uwp.appfactory.tow.services.AsyncEmail;
import edu.uwp.appfactory.tow.webSecurityConfig.models.ERole;
import edu.uwp.appfactory.tow.webSecurityConfig.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Controller
public class TCAdminController {

    private final TCAdminRepository tcAdminRepository;
    private final UsersRepository usersRepository;
    private final AsyncEmail sendEmail;
    private final PasswordEncoder encoder;
    private final TCMapper tcMapper;


    @Autowired
    public TCAdminController(TCAdminRepository tcAdminRepository, UsersRepository usersRepository, AsyncEmail sendEmail, PasswordEncoder encoder, TCMapper tcMapper) {
        this.tcAdminRepository = tcAdminRepository;
        this.usersRepository = usersRepository;
        this.sendEmail = sendEmail;
        this.encoder = encoder;
        this.tcMapper = tcMapper;
    }

    /**
     * GET
     */
    public TCAdminResponse get(UUID userId) {
        Optional<TCAdmin> user = tcAdminRepository.findById(userId);
        return user.map(tcMapper::map).orElse(null);
    }


    /**
     * POST
     */
    public ResponseEntity<?> register(TCAdminRequest tcAdminRequest) {
        if (!usersRepository.existsByEmail(tcAdminRequest.getEmail())) {
            TCAdmin tcAdmin = new TCAdmin(tcAdminRequest.getEmail(),
                    tcAdminRequest.getEmail(),
                    encoder.encode(tcAdminRequest.getPassword()),
                    tcAdminRequest.getFirstname(),
                    tcAdminRequest.getLastname(),
                    tcAdminRequest.getPhone(),
                    ERole.ROLE_TCADMIN.name(),
                    tcAdminRequest.getCompany());

            tcAdmin.setVerifyToken(generateEmailUUID());
            tcAdmin.setVerifyDate(String.valueOf(LocalDate.now()));
            tcAdmin.setVerEnabled(false);
            usersRepository.save(tcAdmin);
            sendEmail.sendEmailAsync(tcAdmin);
            TestVerifyResponse x = new TestVerifyResponse(tcAdmin.getVerifyToken());
            return ResponseEntity.ok(x);
        } else {
            return ResponseEntity.status(400).build(); //TODO:Not sure if .build is correct
        }
    }

    /**
     * PATCH
     */


    /**
     * DELETE
     */


    private String generateEmailUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
