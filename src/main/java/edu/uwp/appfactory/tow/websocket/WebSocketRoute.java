package edu.uwp.appfactory.tow.websocket;

import edu.uwp.appfactory.tow.controllers.FileController;
import edu.uwp.appfactory.tow.entities.File;
import edu.uwp.appfactory.tow.exceptions.InvalidExtensionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import edu.uwp.appfactory.tow.controllers.FileController;
import edu.uwp.appfactory.tow.entities.File;
import edu.uwp.appfactory.tow.exceptions.InvalidExtensionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.http.HttpStatus.*;

import java.io.IOException;

import static org.springframework.http.HttpStatus.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Websocket")
public class WebSocketRoute {
}


//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequestMapping("/images")
//public class FileRoutes {
//
//    private final FileController fileController;
//
//    public FileRoutes(FileController fileController) {
//        this.fileController = fileController;
//    }
//
//    @PostMapping("")
//    public ResponseEntity<File> upload(@RequestHeader("Authorization") final String jwtToken,
//                                       @RequestParam("file") MultipartFile file) {
//        try {
//            fileController.upload(file, jwtToken);
//            return ResponseEntity
//                    .status(OK)
//                    .build();
//        } catch (InvalidExtensionException | IOException e) {
//            return ResponseEntity.status(BAD_REQUEST).build();
//        } catch (Exception e) {
//            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
//        }
//
//    }
//
//    @GetMapping("")
//    public ResponseEntity<?> get(@RequestHeader("Authorization") final String jwtToken) {
//        return ResponseEntity.ok(fileController.get(jwtToken));
//    }
//}
