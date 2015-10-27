package de.hdm.thies.matrix.test;

import de.hdm.thies.matrix.*;

public class MatrixVektorMultiplikation {

    public static void main(java.lang.String[] args) {

        Matrix m = new Matrix(4, 3);
        Vektor v = new Vektor(3);

        m.setElementAt(1, 1, 5);
        m.setElementAt(0, 2, 10);
        m.setElementAt(2, 2, 3);
        v.setElementAt(1, 3);
        v.setElementAt(2, 7);

        System.out.println(m.toString());
        System.out.println(v.toString());

        Matrix erg = null;

        try {
            erg = m.multiply(v);
        } catch (IncompatibleDimException ex) {
            ex.printStackTrace();
        }

        System.out.println(erg.toString());

    }
}
