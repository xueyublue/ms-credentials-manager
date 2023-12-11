package sg.darren.ms.credentials.manager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credentials")
public class CredentialsController {

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String encrypt(@RequestBody String password) {
        return password;
    }

}
