/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summit.qr;

/**
 *
 * @author justin
 */
public class SimpleQRException extends Exception {

    /**
     * Creates a new instance of
     * <code>SimpleQRException</code> without detail message.
     */
    public SimpleQRException() {
    }

    /**
     * Constructs an instance of
     * <code>SimpleQRException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public SimpleQRException(String msg) {
        super(msg);
    }

    public SimpleQRException(Throwable cause) {
        super(cause);
    }

    public SimpleQRException(String message, Throwable cause) {
        super(message, cause);
    }
}
