public class Video extends ElementoMultimediale implements Riproduci{
    private int durata;
    private int volume;
    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo);

        if (volume <= 0) {
            throw new IllegalArgumentException("Alza il volume!");
        } else if (durata <= 0) {
            throw new IllegalArgumentException("Durata non valida!");
        } else if (luminosita <= 0) {
            throw new IllegalArgumentException("Alza la luminosità!");
        } else {
            this.durata = durata;
            this.volume = volume;
            this.luminosita = luminosita;
        }
    }

    public void alzaVolume() {
        volume++;
    }

    public void abbassaVolume() {
        if (volume > 0) {
            volume--;
        }
    }

    public void aumentaLum() {
        luminosita++;
    }

    public void abbassaLum() {
        if (luminosita > 0) {
            luminosita--;
        }
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + " " + "!".repeat(volume) + " " + "*".repeat(luminosita));
        }

    }


}
