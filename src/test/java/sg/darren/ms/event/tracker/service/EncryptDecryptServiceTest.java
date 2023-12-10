package sg.darren.ms.event.tracker.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sg.darren.ms.event.tracker.util.AesUtil;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

class EncryptDecryptServiceTest {

    @Test
    void givenString_whenEncrypt_thenSuccess() throws Exception {
        String password = "postgrespassword";
        SecretKey secretKey = AesUtil.generateSecretKey();
        IvParameterSpec ivParameterSpec = AesUtil.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";
        String encryptedPassword = new EncryptDecryptService().encrypt(algorithm, password, secretKey, ivParameterSpec);

        SecretKey originalKey = AesUtil.getSecretKey(AesUtil.encodeToString(secretKey.getEncoded()));
        IvParameterSpec originalIvParameterSpec = AesUtil.getIv(AesUtil.encodeToString(ivParameterSpec.getIV()));
        String plainText = new EncryptDecryptService().decrypt(algorithm, encryptedPassword, originalKey, originalIvParameterSpec);

        Assertions.assertEquals(password, plainText);
    }

}