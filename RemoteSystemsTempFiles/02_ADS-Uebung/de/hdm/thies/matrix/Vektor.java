package de.hdm.thies.matrix;

/**
 * Realisierung eines einfachen Spaltenvektors als Spezialfall einer Matrix
 * (einspaltige Matrix). Diese Realisierung ist nicht für Zeilenvektoren ausgelegt!
 * @author Prof. Dr. Peter Thies
 */
public class Vektor extends Matrix {

    /**
     * Konstruktor mit Angabe der Zeilenanzahl des Vektors.
     * @param m
     */
    public Vektor(int m) {
        // Einspaltige Matrix mit m Zeilen
        super(m, 1);
    }

    /**
     * Setzen von Vektorelementen.
     * @param i
     *          Zeilenadresse
     * @param element
     *          in Zeile i zu setzender Wert
     * @throws ArrayIndexOutOfBoundsException
     */
    public void setElementAt(int i, double element)
            throws ArrayIndexOutOfBoundsException {

        super.setElementAt(i, 0, element);
    }

    // Hier folgt Ihr Code!!!
}
