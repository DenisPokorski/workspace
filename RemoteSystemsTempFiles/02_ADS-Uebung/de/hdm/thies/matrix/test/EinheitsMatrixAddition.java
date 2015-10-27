package de.hdm.thies.matrix.test;

import de.hdm.thies.matrix.*;

public class EinheitsMatrixAddition {

    public static void main(java.lang.String[] args) {

        EinheitsMatrix a = new EinheitsMatrix(3);
        Matrix b = new Matrix(3, 3);

        b.setElementAt(2, 0, 47);
        b.setElementAt(2, 2, 0.00001);

        System.out.println(a.toString());
        System.out.println(b.toString());

        Matrix c = null;

        try {
            c = a.add(b);
        } catch (IncompatibleDimException ex) {
        }

        System.out.println(c.toString());

    }
}
