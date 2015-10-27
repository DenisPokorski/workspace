package de.hdm.thies.matrix.test;

import de.hdm.thies.matrix.IncompatibleDimException;
import de.hdm.thies.matrix.Matrix;

public class MatrixMultiplikation {

    public static void main(java.lang.String[] args) {

        Matrix a = new Matrix(4, 3);
        Matrix b = new Matrix(3, 5);

        a.setElementAt(1, 1, 5);
        a.setElementAt(0, 2, 10);
        a.setElementAt(2, 2, 3);
        b.setElementAt(2, 0, 3);
        b.setElementAt(2, 2, 7);

        System.out.println(a.toString());
        System.out.println(b.toString());

        Matrix c = null;

        try {
            c = a.multiply(b);
        } catch (IncompatibleDimException ex) {
        }

        System.out.println(c.toString());

    }
}
