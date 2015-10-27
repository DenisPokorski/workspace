package de.hdm.thies.matrix.test;

import de.hdm.thies.matrix.*;

public class VektorNorm {

    public static void main(java.lang.String[] args) {

        Vektor v = new Vektor(4);

        v.setElementAt(1, 5);
        v.setElementAt(2, 1);
        v.setElementAt(3, 2);

        System.out.println(v.toString());

        double laenge = v.norm();

        System.out.println("Länge=" + laenge);

    }
}
