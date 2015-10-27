package de.hdm.thies.matrix;

/**
 * Realisierung einer Einheitsmatrix (quadratische Matrix mit Einsen auf der
 * Hauptdiagonale, sonst Nullen).
 * @author Prof. Dr. Peter Thies
 */
public class EinheitsMatrix extends Matrix {

    /**
     * Konstruktor mit Angabe der Zeilen- bzw. Spaltenanzahl der Matrix.
     * EInheitsmatrizen sind quadratisch. Daher wird nur eine Angabe zur Dimension
     * benötigt.
     * @param m
     *          Dimension
     */
    public EinheitsMatrix(int m) {
        // Einspaltige Matrix mit m Zeilen
        super(m, m);

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < m; i++) {
                // Hauptdiagonalenelement
                if (i == k) {
                    this.data[i][k] = 1;
                } else {
                    // alle anderen Elemente
                    this.data[i][k] = 0;
                }
            }
        }
    }
}
