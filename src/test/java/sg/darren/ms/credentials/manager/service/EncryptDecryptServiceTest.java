package sg.darren.ms.credentials.manager.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class EncryptDecryptServiceTest {

    @Autowired
    private EncryptDecryptService encryptDecryptService;

    @Test
    void givenString_whenEncrypt_thenSuccess() throws Exception {
        String password = "password";
        String encryptedPassword = encryptDecryptService.encrypt(password);
        String plainText = encryptDecryptService.decrypt(encryptedPassword);
        Assertions.assertEquals(password, plainText);
    }

}