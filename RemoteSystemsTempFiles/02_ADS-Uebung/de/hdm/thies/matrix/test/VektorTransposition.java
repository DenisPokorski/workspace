package de.hdm.thies.matrix.test;

import de.hdm.thies.matrix.Matrix;
import de.hdm.thies.matrix.Vektor;

public class VektorTransposition {

    public static void main(java.lang.String[] args) {

        Vektor v = new Vektor(4);

        v.setElementAt(1, 5);
        v.setElementAt(2, 1);
        v.setElementAt(3, 2323);

        System.out.println(v.toString());

        Matrix b = v.trans();

        System.out.println(b.toString());

    }
}
