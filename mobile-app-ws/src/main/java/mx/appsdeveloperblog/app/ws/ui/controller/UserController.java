package mx.appsdeveloperblog.app.ws.ui.controller;

import mx.appsdeveloperblog.app.ws.exceptions.UserServiceException;
import mx.appsdeveloperblog.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import mx.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import mx.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import mx.appsdeveloperblog.app.ws.userservice.UserService;
import mx.appsdeveloperblog.app.ws.userservice.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

    Map<String, UserRest> users;

    @Autowired
    UserService userService;

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit,
                           @RequestParam(value = "sort",defaultValue = "desc",required = false) String sort
                          ){

        return "get users" + page +"limit" + limit + "sort" + sort;
    }


    @GetMapping(path = "/{userId}", produces = {
            MediaType.APPLICATION_ATOM_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){

        if (true) throw new UserServiceException("A user service exception is throw");
        String firstName = null;

        int firstNameLength = firstName.length();

        if(users.containsKey(userId)){
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping(consumes = {
                MediaType.APPLICATION_ATOM_XML_VALUE,
                MediaType.APPLICATION_JSON_VALUE
            }, produces = {
                MediaType.APPLICATION_ATOM_XML_VALUE,
                MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

        UserRest returnValue = userService.createUser(userDetails);
        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}",consumes = {
            MediaType.APPLICATION_ATOM_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    }, produces = {
            MediaType.APPLICATION_ATOM_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails){

        UserRest storedUserDetails =  users.get(userId);

        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());

        users.put(userId, storedUserDetails);

        return  storedUserDetails;
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity  deleteUser(@PathVariable String userId){
        users.remove(userId);

        return ResponseEntity.noContent().build();
    }
}
