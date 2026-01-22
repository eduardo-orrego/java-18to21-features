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

/*
 * This class demonstrates a basic hybrid cryptography workflow using the
 * Java Cryptography Architecture (JCA). It combines asymmetric and symmetric
 * cryptography to securely exchange a symmetric key.
 *
 * Functionality:
 * - Generates an RSA asymmetric key pair (2048 bits) using KeyPairGenerator
 * - Generates an AES symmetric key (256 bits) using KeyGenerator
 * - Encrypts the AES symmetric key using the RSA public key
 * - Decrypts the AES symmetric key using the RSA private key
 * - Displays all generated and processed keys using Base64 encoding
 *
 * Cryptographic concepts demonstrated:
 * - Asymmetric cryptography for secure key exchange (RSA)
 * - Symmetric cryptography for efficient data encryption (AES)
 * - Hybrid encryption model commonly used in secure systems
 *
 * Java 21 relevance:
 * - This example relies on the Java Cryptography Architecture (JCA),
 *   whose internal implementations have been enhanced in Java 21
 *   for improved performance, stronger security checks, and better
 *   provider handling.
 * - Classes such as KeyPairGenerator, KeyGenerator, Cipher, Key,
 *   SecretKey, and related SPI-based mechanisms benefit from these
 *   internal improvements without requiring API changes.
 * - The code demonstrates how existing cryptographic APIs continue
 *   to work unchanged while leveraging the optimized and hardened
 *   cryptographic infrastructure provided by Java 21.
 *
 * Notes:
 * - This example encrypts only a symmetric key, not application data.
 * - Intended for educational purposes to illustrate cryptographic
 *   concepts and Java security architecture behavior.
 */
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
