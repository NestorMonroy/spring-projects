package mx.appsdeveloperblog.photoapp.api.users.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private Environment env;

    @GetMapping("/status/check")
    public String status() {
        return "Working on Port "+env.getProperty("local.server.port");
    }
}
