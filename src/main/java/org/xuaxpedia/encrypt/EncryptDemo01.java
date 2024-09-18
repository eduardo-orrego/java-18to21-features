package org.xuaxpedia.encrypt;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

// In Java 21, the java.security API (Application Programming Interface) has been enhanced to optimize cryptography
// and key management. New interfaces like KeyManagerFactorySpi for custom providers have been introduced,
// and classes such as Key, KeyStore, SecretKey, Cipher, and KeyPairGenerator have been updated to improve
// performance and security in key generation, storage, encryption, and decryption.

public class EncryptDemo01 {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {

        //Generate Asymmetric Key Pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        //Print Asymmetric Key Pair
        byte[] keyPairPublicBytes = keyPair.getPublic().getEncoded();
        byte[] keyPairPrivateBytes = keyPair.getPublic().getEncoded();
        System.out.printf("Asymmetric Key Pair Public:%n%s%n%n",
                Base64.getEncoder().encodeToString(keyPairPublicBytes));
        System.out.printf("Asymmetric Key Pair Private:%n%s%n%n",
                Base64.getEncoder().encodeToString(keyPairPrivateBytes));

        //Generate Symmetric Key
        KeyGenerator keyGen2 = KeyGenerator.getInstance("AES");
        keyGen2.init(256);
        SecretKey symmetricKey = keyGen2.generateKey();

        //Print Symmetric Key
        byte[] symmetricKeyBytes = symmetricKey.getEncoded();
        System.out.printf("Symmetric Key:%n%s%n%n",
                Base64.getEncoder().encodeToString(symmetricKeyBytes));

        //Encrypt Key
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedKey = cipher.doFinal(symmetricKey.getEncoded());

        //Print Encrypt Key
        System.out.printf("Encrypted Symmetric Key:%n%s%n%n",
                Base64.getEncoder().encodeToString(encryptedKey));

        //Decrypt Key
        Cipher cipher2 = Cipher.getInstance("RSA");
        cipher2.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedKey = cipher2.doFinal(encryptedKey);

        //Print Decrypted Key
        System.out.printf("Decrypted Symmetric Key:%n%s%n%n",
                Base64.getEncoder().encodeToString(decryptedKey));

        //Verify result
        if (java.util.Arrays.equals(symmetricKey.getEncoded(), decryptedKey)) {
            System.out.println("Generate, Encrypt and decrypt key successful!.");
        } else {
            System.out.println("Generate, Encrypt and decrypt key failed!.");
        }

    }

}
