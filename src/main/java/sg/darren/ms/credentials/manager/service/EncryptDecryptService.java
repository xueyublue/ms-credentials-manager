package sg.darren.ms.credentials.manager.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sg.darren.ms.credentials.manager.util.AesUtil;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

@Service
@RequiredArgsConstructor
@Slf4j
public class EncryptDecryptService {

    @Value(("${security.encrypt.encoded.key}"))
    private String encodedKey;
    @Value(("${security.encrypt.encoded.parameter}"))
    private String encodedParameter;
    @Value(("${security.encrypt.encoded.algorithm}"))
    private String algorithm;

    public String encrypt(String input) throws Exception {
        SecretKey secretKey = AesUtil.getSecretKey(encodedKey);
        IvParameterSpec ivParameterSpec = AesUtil.getIv(encodedParameter);
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        byte[] cipherText = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }

    public String decrypt(String cipherText) throws Exception {
        SecretKey secretKey = AesUtil.getSecretKey(encodedKey);
        IvParameterSpec ivParameterSpec = AesUtil.getIv(encodedParameter);
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(plainText);
    }

}
