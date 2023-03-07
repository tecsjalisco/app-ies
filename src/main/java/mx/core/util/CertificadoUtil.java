/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.core.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.Base64.Encoder;

/**
 *
 * @author luiscobian
 */
public class CertificadoUtil {

    private static final int BUFFER_SIZE = 65535;

    /**
     *
     *
     * @param certificateFilePath
     * @return the base64 encoded array from given certificate content.
     *
     * @throws Exception
     */
    public static byte[] convertCertificateToByteArray(String certificateFilePath) throws Exception {
        if (certificateFilePath == null || certificateFilePath.isEmpty()) {
            throw new Exception("certificateFilePath should not be null or empty");
        }

        File file = new File(certificateFilePath);

        if (!file.exists()) {
            throw new Exception("File not exist : " + file.getAbsolutePath());
        }

        if (file.isDirectory()) {
            throw new Exception("File shouldn't be a directory : " + file.getAbsolutePath());
        }

        try (InputStream inputStream = new FileInputStream(file)) {

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[BUFFER_SIZE];
            int numberOfReadBytes;

            while ((numberOfReadBytes = inputStream.read(buffer)) > 0) {
                byteArrayOutputStream.write(buffer, 0, numberOfReadBytes);
            }

            byte[] certificateInBytes = byteArrayOutputStream.toByteArray();

            Encoder encoder = Base64.getEncoder();
            byte[] encodedBytes = encoder.encode(certificateInBytes);
            return encodedBytes;

        }
    }

    /**
     * Convert the certificate into base64 encoded string.
     *
     * @param certificateFilePath
     * @return
     * @throws Exception
     */
    public static String convertCertificateToString(String certificateFilePath) throws Exception {

        byte[] encodedBytes = convertCertificateToByteArray(certificateFilePath);
        String str = new String(encodedBytes);

        return str;

    }

}
