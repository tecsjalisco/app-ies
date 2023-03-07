/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.core.util;

public class CoreException extends Exception {

    public static final long serialVersionUID = 700L;
    
    public CoreException() {
    }

    public CoreException(String code) {
        super(code);
    }
}
