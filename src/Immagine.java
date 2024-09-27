public class Immagine extends ElementoMultimediale {
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        setLuminosita(luminosita);
    }

    public void setLuminosita(int luminosita) {
        if (luminosita <= 0) {
            throw new IllegalArgumentException("Alza la luminosità!");
        }
        this.luminosita = luminosita;
    }

    public void aumentaLum() {
        luminosita++;
    }

    public void abbassaLum() {
        if (luminosita > 0) {
            luminosita--;
        }
    }

    public void show() {
        System.out.println("Mostra immagine: " + titolo + " con luminosità " + luminosita);
    }
}