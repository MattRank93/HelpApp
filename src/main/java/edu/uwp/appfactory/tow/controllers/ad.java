//package edu.uwp.appfactory.tow.controllers.auth;
//
//import edu.uwp.appfactory.tow.entities.Dispatcher;
//import edu.uwp.appfactory.tow.entities.Driver;
//import edu.uwp.appfactory.tow.entities.Users;
//import edu.uwp.appfactory.tow.queryinterfaces.VerifyTokenInterface;
//import edu.uwp.appfactory.tow.services.AsyncEmail;
//import edu.uwp.appfactory.tow.services.EmailService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import edu.uwp.appfactory.tow.WebSecurityConfig.models.ERole;
//import edu.uwp.appfactory.tow.WebSecurityConfig.models.Role;
//import edu.uwp.appfactory.tow.WebSecurityConfig.payload.response.JwtResponse;
//import edu.uwp.appfactory.tow.WebSecurityConfig.payload.response.MessageResponse;
//import edu.uwp.appfactory.tow.WebSecurityConfig.repository.RoleRepository;
//import edu.uwp.appfactory.tow.WebSecurityConfig.repository.UsersRepository;
//import edu.uwp.appfactory.tow.WebSecurityConfig.security.jwt.JwtUtils;
//import edu.uwp.appfactory.tow.WebSecurityConfig.security.services.UserDetailsImpl;
//import org.springframework.transaction.TransactionSystemException;
//
//import javax.validation.ConstraintViolationException;
//import java.time.LocalDate;
//import java.time.Period;
//import java.util.Optional;
//import java.util.UUID;
//
//import static java.lang.String.format;
//
//@Controller
//public class AuthCsontroller {
//
//    //access tokens expire quickly
//    //clients ask for new one based on their refresh token
//    //if refresh token is expired, re-auth
//    //logout route
//    //JSON WEB TOKEN NPM
//
//    private final AuthenticationManager authenticationManager;
//    private final UsersRepository usersRepository;
//    private final RoleRepository roleRepository;
//    private final PasswordEncoder encoder;
//    private final JwtUtils jwtUtils;
//    private final EmailService sender;
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//    private final AsyncEmail sendEmail;
//
//    @Autowired
//    public AuthController(AuthenticationManager authenticationManager, UsersRepository usersRepository, RoleRepository roleRepository, PasswordEncoder encoder, JwtUtils jwtUtils, EmailService sender, AsyncEmail sendEmail) {
//        this.authenticationManager = authenticationManager;
//        this.usersRepository = usersRepository;
//        this.roleRepository = roleRepository;
//        this.encoder = encoder;
//        this.jwtUtils = jwtUtils;
//        this.sender = sender;
//        this.sendEmail = sendEmail;
//    }
//
//    public ResponseEntity<?> refreshToken(String jwtToken) {
//        return ResponseEntity.ok(jwtUtils.refreshJwtToken(jwtUtils.getUUIDFromJwtToken(jwtToken)));
//    }
//
//    public ResponseEntity<?> getUserByEmail(String email) {
//        Users user = usersRepository.findByEmail(email);
//        if (user == null) {
//            return ResponseEntity
//                    .status(500)
//                    .body(new MessageResponse("Error: User does not exist or does not have role of user!"));
//        }
//        user.setPassword("");
//        return ResponseEntity.ok(user);
//    }
//
//    public ResponseEntity<?> deleteUserById(String email) {
//        Users users = usersRepository.findByEmail(email);
//        if (users == null) {
//            return ResponseEntity
//                    .status(500)
//                    .body(new MessageResponse("Not successful!"));
//        } else {
//            usersRepository.delete(users);
//            return ResponseEntity
//                    .status(200)
//                    .body(new MessageResponse("Successful!"));
//        }
//    }
//
//    public ResponseEntity<?> authenticateUser(String email, String password) {
//        Authentication authentication = authenticationManager
//                .authenticate(new UsernamePasswordAuthenticationToken(email, password));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtUtils.generateJwtToken(authentication);
//
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//
//        Optional<Users> usersOptional = usersRepository.findByUsername(email);
//        if (usersOptional.isEmpty()) {
//            return ResponseEntity
//                    .status(494)
//                    .body(new MessageResponse("User does not exist"));
//        }
//        //todo: when not testing, uncomment code
////        Users user = usersOptional.get();
////        if (user.getVerEnabled()) {
//        return ResponseEntity.ok(new JwtResponse(
//                jwt,
//                userDetails.getUUID(),
//                userDetails.getUsername(),
//                userDetails.getEmail(),
//                userDetails.getFirstname(),
//                userDetails.getLastname(),
//                userDetails.getRole()
//        ));
////        } else {
////            return ResponseEntity
////                    .badRequest()
////                    .body(new MessageResponse("Error: Account not verified."));
////        }
//    }
//
//
//    public ResponseEntity<?> registerDriver(String email, String password, String firstname, String lastname, String phone) {
//        try {
//            if (usersRepository.existsByEmail(email)) {
//                return ResponseEntity
//                        .badRequest()
//                        .body(new MessageResponse("Error: Email is already in use!"));
//            }
//
//            // Create new user's account
//            Driver driver = new Driver(email,
//                    email,
//                    encoder.encode(password),
//                    firstname,
//                    lastname,
//                    phone,
//                    0,
//                    0,
//                    false);
//
//            Role role = roleRepository.findByName(ERole.ROLE_DRIVER)
//                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//
//            driver.setRoles(role.getName().toString());
//            driver.setVerifyToken(generateEmailUUID());
//            driver.setVerifyDate(String.valueOf(LocalDate.now()));
//            driver.setVerEnabled(false);
//            usersRepository.save(driver);
//
//            sendEmail.sendEmailAsync(driver);
//
//            return ResponseEntity
//                    .ok(new MessageResponse("Driver registered successfully!"));
//        } catch (ConstraintViolationException e) {
//            return ResponseEntity.status(498).body("Invalid Entries: " + e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(499).body("Error: " + e.getMessage());
//        }
//    }
//
//    public ResponseEntity<?> registerAdmin(String email, String password, String firstname, String lastname, String phone) {
//
//        if (usersRepository.existsByEmail(email)) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: Email is already in use!"));
//        }
//
//        // Create new user's account
//        Users user = new Users(email,
//                email,
//                encoder.encode(password),
//                firstname,
//                lastname,
//                phone);
//
//        Role role = roleRepository.findByName(ERole.ROLE_ADMIN)
//                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//
//        user.setRoles(role.getName().toString());
//        usersRepository.save(user);
//
//        return ResponseEntity.ok(new MessageResponse("Admin registered successfully!"));
//    }
//
//    public ResponseEntity<?> registerDispatcher(String email, String password, String firstname, String lastname, String phone, String precinct) {
//        try {
//            if (usersRepository.existsByEmail(email)) {
//                return ResponseEntity
//                        .badRequest()
//                        .body(new MessageResponse("Error: Email is already in use!"));
//            }
//
//            // Create new user's account
//            Dispatcher dispatcher = new Dispatcher(
//                    email,
//                    email,
//                    encoder.encode(password),
//                    firstname,
//                    lastname,
//                    phone,
//                    precinct);
//
//            Role role = roleRepository.findByName(ERole.ROLE_DISPATCHER)
//                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//
//            dispatcher.setRoles(role.getName().toString());
//            dispatcher.setVerifyToken(generateEmailUUID());
//            dispatcher.setVerifyDate(String.valueOf(LocalDate.now()));
//            dispatcher.setVerEnabled(false);
//            usersRepository.save(dispatcher);
//
//            sendEmail.sendEmailAsync(dispatcher);
//
//            return ResponseEntity
//                    .ok(new MessageResponse("Driver registered successfully!"));
//
//        } catch (TransactionSystemException | ConstraintViolationException e) {
//            return ResponseEntity.status(499).body("Invalid Entries");
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body("System Error");
//        }
//    }
//
//    public ResponseEntity<?> update(String jwtToken, Users user) {
//        try {
//            Optional<Users> usersOptional = usersRepository.findByUsername(user.getEmail());
//            if (usersOptional.isEmpty()) {
//                return ResponseEntity
//                        .status(500)
//                        .body(new MessageResponse("Not successful!"));
//            }
//
//            Users oldUser = usersOptional.get();
//            oldUser.setFirstname(user.getFirstname());
//            oldUser.setLastname(user.getLastname());
//            //oldUser.setPhoneNumber(user.getPhoneNumber);
//
//            usersRepository.save(oldUser);
//
//            return ResponseEntity
//                    .status(200)
//                    .body(new MessageResponse("Successful!"));
//
//        } catch (Exception e) {
//            return ResponseEntity.status(499).body("Error: " + e.getMessage());
//        }
//    }
//
//    public ResponseEntity<?> verification(String token) {
//        try {
//            Optional<VerifyTokenInterface> usersOptional = usersRepository.findByVerifyToken(token);
//            if (usersOptional.isEmpty()) {
//                return ResponseEntity
//                        .status(494)
//                        .body(new MessageResponse("Token does not exist"));
//            }
//
//            VerifyTokenInterface user = usersOptional.get();
//            LocalDate userVerifyDate = LocalDate.parse(user.getVerifyDate());
//            Period periodBetween = Period.between(userVerifyDate, LocalDate.now());
//
//            if (periodBetween.getDays() < 8) {
//                if (user.getVerifyToken().equals(token) && !user.getVerEnabled()) {
//                    usersRepository.updateUserEmailVerifiedByUUID(user.getUUID(), true);
//
//                    return ResponseEntity
//                            .status(200)
//                            .body(new MessageResponse("Successful!"));
//                } else {
//                    return ResponseEntity
//                            .status(496)
//                            .body(new MessageResponse("Different token, or user was already verified"));
//                }
//            } else {
//                usersRepository.deleteByEmail(user.getEmail());
//                return ResponseEntity
//                        .status(496)
//                        .body(new MessageResponse("Account has not verified within seven days, account deleted"));
//            }
//        } catch (ConstraintViolationException e) {
//            return ResponseEntity.status(498).body("Invalid Entries: " + e.getMessage());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return ResponseEntity.status(499).body("Error: " + e.getMessage());
//        }
//    }
//
//    private String generateEmailUUID() {
//        return UUID.randomUUID().toString().replace("-", "");
//    }
//}