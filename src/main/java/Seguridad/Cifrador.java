/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seguridad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author orell
 */
public class Cifrador {
    private static final String algoritmo="AES";
    private static final String transformacion = "AES/ECB/PKCS5Padding";
    
    
    
    
    public static String cifrar(String texto, String claveSecreta) throws GeneralSecurityException {
        SecretKey clave = generarClaveSecreta(claveSecreta);
        Cipher cifrador = Cipher.getInstance(transformacion);
        cifrador.init(Cipher.ENCRYPT_MODE, clave);
        byte[] bytesCifrados = cifrador.doFinal(texto.getBytes());
        return Base64.getEncoder().encodeToString(bytesCifrados);
    }
    
    private static SecretKey generarClaveSecreta(String claveSecreta) throws GeneralSecurityException {
        SecretKeyFactory fabrica = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec especificacion = new PBEKeySpec(claveSecreta.toCharArray(), claveSecreta.getBytes(), 65536, 128);
        SecretKey claveParcial = fabrica.generateSecret(especificacion);
        return new SecretKeySpec(claveParcial.getEncoded(), algoritmo);
    }

    
   
    
   
}
