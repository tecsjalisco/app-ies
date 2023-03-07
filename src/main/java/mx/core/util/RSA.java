/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.core.util;

/**
 *
 * @author luiscobian
 */
import java.io.InputStream;

import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class RSA {
	
	  
  
    /*public static byte[] readFileBytes(String filename) throws IOException{
        Path path = Paths.get(filename);
        byte datos[] = Files.readAllBytes(path);
        return Files.readAllBytes(path);        
    }*/
    
    public static String signSHARSA(InputStream file, String input) 
    {
        try{
        byte[] bytes = new byte[file.available()];
        file.read(bytes);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Signature privateSignature = Signature.getInstance("SHA256withRSA"); 
        privateSignature.initSign(keyFactory.generatePrivate(keySpec));
        privateSignature.update(input.getBytes());
        byte []s = privateSignature.sign();
        return Base64.getEncoder().encodeToString(s);
        }catch(Exception e){
            e.printStackTrace();
            return "NO SE PUDO";
        }
    }
   
		
}