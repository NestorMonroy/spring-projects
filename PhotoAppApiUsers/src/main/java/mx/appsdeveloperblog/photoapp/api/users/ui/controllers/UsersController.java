package mx.appsdeveloperblog.photoapp.api.users.ui.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/users")
public class UsersController {

    @GetMapping("/status/check")
    public String status() {
        return "Working "  ;
    }
}
