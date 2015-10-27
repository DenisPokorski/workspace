package de.hdm.thies.matrix.test;

import de.hdm.thies.matrix.IncompatibleDimException;
import de.hdm.thies.matrix.Matrix;

public class MatrixPotenzierung {

    public static void main(java.lang.String[] args) {

        Matrix a = new Matrix(4, 4);

        a.setElementAt(0, 1, 1);
        a.setElementAt(1, 2, 1);
        a.setElementAt(2, 0, 1);
        a.setElementAt(2, 3, 1);
        a.setElementAt(3, 1, 1);

        System.out.println(a.toString());

        Matrix b = null;
        Matrix c = null;

        try {
            b = a.pow(1);
            c = a.pow(2);

            System.out.println(b.toString());
            System.out.println(c.toString());
        } catch (IncompatibleDimException e) {
            e.printStackTrace();
        }


    }
}
