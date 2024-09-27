public class Immagine extends ElementoMultimediale {

    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        if (luminosita <= 0) {
            throw new IllegalArgumentException("Alza la luminosità!");
        } else {
            this.luminosita = luminosita;
        }
    }

    public void aumentaLum() {
        luminosita++;
    }
    public void abbassaLum() {
        luminosita--;
    }

    public void show() {
        System.out.println(titolo + " " + "*".repeat(luminosita));
    }
}
