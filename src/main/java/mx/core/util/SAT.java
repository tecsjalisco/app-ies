/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.ssl.PKCS8Key;

public class SAT {
    
    public static String sing(InputStream file,String password, String toSign) throws UnsupportedEncodingException, SignatureException, NoSuchAlgorithmException, InvalidKeyException, GeneralSecurityException, IOException{
        String cad = "";
        PKCS8Key pkcs8Key = new PKCS8Key(file, password.toCharArray());
        PrivateKey privateKey = pkcs8Key.getPrivateKey();
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(toSign.getBytes("UTF-8"));
        cad = Base64.encodeBase64String(signature.sign());
        return cad;
    }
}
