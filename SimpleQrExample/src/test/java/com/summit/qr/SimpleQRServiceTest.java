/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summit.qr;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author justin
 */
public class SimpleQRServiceTest {
    
    public SimpleQRServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Logger.getLogger(SimpleQRServiceTest.class.getName()).getParent().setLevel(Level.ALL);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private SimpleQRService simpleQRService;
    
    @Before
    public void setUp() {
        simpleQRService = new SimpleQRService();
    }
    
    @After
    public void tearDown() {
        simpleQRService = null;
    }

    /**
     * Test of encodeStringToQRFile method, of class SimpleQRService.
     */
    @Test
    public void testEncodeStringToQRFile() throws Exception {
        System.out.println("encodeStringToQRFile");
        final String testString = "1234567890MY_TEST_STRING";
        String stringToEncode = testString;
        int width = 640;
        int height = 640;
        
        String expResult = testString;
        String filePath = simpleQRService.encodeStringToQRFile(stringToEncode, width, height);
        
        String result = simpleQRService.decodeQRFileToString(filePath);
        
        assertEquals(expResult, result);
    }
}