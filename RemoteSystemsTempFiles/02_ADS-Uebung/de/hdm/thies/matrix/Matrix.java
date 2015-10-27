package de.hdm.thies.matrix;

/**
 * Einfache Klasse zur Demonstration einer Matrix-Implementierung. Sämtliche
 * Einträge der Matrix sind vom Typ double.<p>
 * 
 * <b>Hinweis:</b> Sämtliche Indices beginnen bei 0. Das heißt, dass bei einer
 * zweispaltigen Matrix der Index von 0 bis 1 läuft!
 * 
 * @author Prof. Dr. Peter Thies
 */
public class Matrix {

    // Dimensionen
    int m, n;

    // Daten
    double[][] data = null;

    /**
     * Konstruktor
     * 
     * @param m Anzahl der Zeilen
     * @param n Anzahl der Spalten
     */
    public Matrix(int m, int n) {
        // Setzen der Matrix-Dimensionen zu "m x n"
        this.m = m;
        this.n = n;

        // Allokation des erforderlichen Speichers
        data = new double[m][n];

        // Zusätzl. Initialisierung aller Matrixelemente mit 0
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < m; i++) {
                data[i][k] = 0;
            }
        }
    }

    /**
     * Auslesen des adressierten Matrixelements.
     * 
     * @param i Spalte (bei 0 beginnend)
     * @param k Spalte (bei 0 beginnend)
     * @return Matrixelement als double
     * @throws ArrayIndexOutOfBoundsException
     */
    public double getElementAt(int i, int k)
            throws ArrayIndexOutOfBoundsException {
        if (i < 0 || i >= m) {
            throw new ArrayIndexOutOfBoundsException(
                    "Zeilenindex außerhalb der Matrix");
        }

        if (k < 0 || k >= n) {
            throw new ArrayIndexOutOfBoundsException(
                    "Spaltenindex außerhalb der Matrix");
        }

        return data[i][k];
    }

    /**
     * Auslesen der Spaltenanzahl.
     * 
     * @return Spaltenanzahl
     */
    public int getColumns() {
        return n;
    }

    /**
     * Auslesen der Zeilenanzahl.
     * 
     * @return Zeilenanzahl
     */
    public int getRows() {
        return m;
    }

    /**
     * Setzen des durch i, k adressierten Elements.
     * 
     * @param i Zeile der Matrix (bei 0 beginnend)
     * @param k Spalte der Matrix (bei 0 beginnend)
     * @param element
     *            der neu zu setzende Wert bei i, k
     * @throws ArrayIndexOutOfBoundsException
     * @throws TypeMismatchException
     */
    public void setElementAt(int i, int k, double element)
            throws ArrayIndexOutOfBoundsException {
        if (i < 0 || i >= m) {
            throw new ArrayIndexOutOfBoundsException(
                    "Zeilenindex außerhalb der Matrix");
        }

        if (k < 0 || k >= n) {
            throw new ArrayIndexOutOfBoundsException(
                    "Spaltenindex außerhalb der Matrix");
        }

        data[i][k] = element;
    }

    /**
     * Ausgabe der Matrix als Zeichenkette.
     */
    public String toString() {

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < this.m; i++) {

            for (int k = 0; k < this.n; k++) {
                if (k > 0) {
                    result.append(",\t");
                }
                result.append(data[i][k]);
            }

            result.append("\n");
        }

        return result.toString();
    }

    /**
     * Transposition der Matrix (vertauschen der Zeilen und Spalten).
     * 
     * @return die transponierte Matrix.
     */
    public Matrix trans() {
        // Die Ergebnismatrix besitzt vertauschte Dimensionen von this.
        Matrix result = new Matrix(this.n, this.m);

        /*
         * Durchlaufen der Matrix und einfaches Vertauschen der Indices für
         * Spalte und Zeile.
         */
        for (int i = 0; i < this.m; i++) {
            for (int k = 0; k < this.n; k++) {
                try {
                    result.setElementAt(k, i, this.getElementAt(i, k));
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    /**
     * Addition zweier Matrizen.
     * 
     * @param matrix die zu addierende Matrix
     * @return die Ergebnismatrix
     * @throws IncompatibleMatrixDimensionsException
     */
    public Matrix add(Matrix matrix) throws IncompatibleDimException {

        if (this.m != matrix.m || this.n != matrix.n) {
            throw new IncompatibleDimException(
                    "Sie können nur Matrizen gleicher Dimension addieren! (" + this.m + "x" + this.n + ") != (" + matrix.m + "x" + matrix.n + ")!");
        }

        Matrix matrResult = new Matrix(m, n);

        // Elementweises Addieren
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                matrResult.data[i][k] = data[i][k] + matrix.data[i][k];
            }
        }
        return matrResult;
    }

    /**
     * Matrixmultiplikation. Achten Sie auf passende Dimension der beiden
     * Matrizen. Es können nur m x n und k x l Matrizen mit n == k multipliziert
     * werden!
     * 
     * @param matrix
     * @return Ergebnis der Multiplikation
     * @throws IncompatibleMatrixDimensionsException
     */
    public Matrix multiply(Matrix matrix) throws IncompatibleDimException {

        if (this.n != matrix.m) {
            throw new IncompatibleDimException("Matrizen der Dimensionen " + this.m + "x" + this.n + " und " + matrix.m + "x" + matrix.n + " können nicht multipliziert werden!");
        }


    // Hier folgt Ihr Code!!!


    }

    /**
     * Test, ob this eines Quadratische Matrix ist.
     * 
     * @return true, wenn Spaltenanzahl und Zeilenanzahl gleich sind.
     */
    public boolean isSquare() {
        return this.m == this.n;
    }

    /**
     * Matrixpotenzierung. Achtung: Potenzierung ist nur für quadratische
     * Matrizen zulässig.
     * 
     * @param power Exponent (muss >= 2 sein!)
     * @return bei Exponent <= 0 null, bei Exponent == 1 this, Ergebnismatrix
     *         sonst.
     * @throws IncompatibleMatrixDimensionsException
     */
    public Matrix pow(int power) throws IncompatibleDimException {

        if (!this.isSquare()) {
            throw new IncompatibleDimException(
                    "Quadratische Matrix erforderlich!");
        }

        // Exponent <= 0 macht keinen Sinn. Wir geben null zurück.
        if (power <= 0) {
            return null;
        }

        if (power == 1) {
            return this;
        }

        Matrix matrResult = this;

        for (int rep = 1; rep < power; rep++) {
            matrResult = matrResult.multiply(this);
        }

        return matrResult;
    }
}
