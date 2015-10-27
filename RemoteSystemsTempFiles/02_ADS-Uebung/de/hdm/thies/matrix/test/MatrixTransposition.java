package de.hdm.thies.matrix.test;

import de.hdm.thies.matrix.Matrix;

public class MatrixTransposition {

    public static void main(java.lang.String[] args) {

        Matrix a = new Matrix(4, 3);

        a.setElementAt(1, 1, 5);
        a.setElementAt(0, 2, 10);
        a.setElementAt(2, 2, 3);

        System.out.println(a.toString());

        // Matrix b = null;

        Matrix b = a.trans();

        System.out.println(b.toString());

    }
}
