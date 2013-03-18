/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summit.qr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GlobalHistogramBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author justin
 */
public class SimpleQRService {

    static final Logger logger = Logger.getLogger(SimpleQRService.class.getName());
    public static final String DEFAULT_IMAGE_FORMAT = "png";
    
    public String encodeStringToQRFile(String stringToEncode, int width, int height, boolean deleteFileOnExit, String format) throws SimpleQRException {
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix;
        
        try {
            File tempFile = File.createTempFile("qrcode", "." + format);
            if (deleteFileOnExit) {
                tempFile.deleteOnExit();
            }
            logger.log(Level.FINER, "Encoding to file: {0}", tempFile.getAbsolutePath());
            bitMatrix = writer.encode(stringToEncode, BarcodeFormat.QR_CODE, width, height);
            MatrixToImageWriter.writeToFile(bitMatrix, format, tempFile);
            return tempFile.getAbsolutePath();
        } catch (WriterException ex) {
            throw new SimpleQRException(ex);
        } catch (IOException ex) {
            throw new SimpleQRException(ex);
        }
    }
    public String encodeStringToQRFile(String stringToEncode, int width, int height, boolean deleteFileOnExit) throws SimpleQRException {
        return encodeStringToQRFile(stringToEncode, width, height, deleteFileOnExit, DEFAULT_IMAGE_FORMAT);
    }

    public String encodeStringToQRFile(String stringToEncode, int width, int height) throws SimpleQRException {
        return encodeStringToQRFile(stringToEncode, width, height, false);
    }

    public String decodeQRFileToString(String filePath) throws SimpleQRException {
        QRCodeReader reader = new QRCodeReader();
        try {
            File file = new File(filePath);
            BufferedImage qrImage = ImageIO.read(file);
            return reader.decode(new BinaryBitmap(new GlobalHistogramBinarizer(new BufferedImageLuminanceSource(qrImage)))).getText();
        } catch (NotFoundException ex) {
            throw new SimpleQRException(ex);
        } catch (ChecksumException ex) {
            throw new SimpleQRException(ex);
        } catch (FormatException ex) {
            throw new SimpleQRException(ex);
        } catch (IOException ex) {
            throw new SimpleQRException(ex);
        }
    }
}
