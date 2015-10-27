package de.hdm.thies.matrix;

/**
 * Exxception-Klasse, die inkompatible Matrixdimensionen signalisieren soll.
 * @author Prof. Dr. Peter Thies
 */
public class IncompatibleDimException extends Exception {

    public IncompatibleDimException() {
        super();
    }

    public IncompatibleDimException(String s) {
        super(s);
    }
}
