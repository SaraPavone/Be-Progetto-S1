public class Video extends ElementoMultimediale implements Riproduci{
    private int durata;
    private int volume;
    private int luminosita;

    private static final int MAX_VOLUME = 10;
    private static final int MAX_LUMINOSITA = 10;


    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo);
        setDurata(durata);
        setVolume(volume);
        setLuminosita(luminosita);
    }

    public void setDurata(int durata) {
        if (durata <= 0) {
            throw new IllegalArgumentException("Controlla la durata!");
        }
        this.durata = durata;
    }

    public void setVolume(int volume) {
        if (volume <= 0) {
            throw new IllegalArgumentException("Alza il volume!");
        }
        this.volume = volume;
    }

    public void setLuminosita(int luminosita) {
        if (luminosita <= 0) {
            throw new IllegalArgumentException("Alza la luminosità!");
        }
        this.luminosita = luminosita;
    }

    public void alzaVolume() {
        if (volume < MAX_VOLUME) {
            volume++;
            System.out.println("Volume alzato a: " + volume);
        } else {
            System.out.println("Volume massimo raggiunto");
        }
    }

    public void abbassaVolume() {
        if (volume > 0) {
            volume--;
            System.out.println("Volume diminuito a: " + volume);
        } else {
            System.out.println("Il volume è già al minimo");
        }
    }

    public void aumentaLum() {
        if (luminosita < MAX_LUMINOSITA) {
            luminosita++;
            System.out.println("Luminosità aumentata a: " + luminosita);
        } else {
            System.out.println("La luminosità è già al massimo");
        }
    }

    public void abbassaLum() {
        if (luminosita > 0) {
            luminosita--;
            System.out.println("Luminosità diminuita a: " + luminosita);
        } else {
            System.out.println("La luminosità è già al minimo");
        }
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + " " + "!".repeat(volume) + " " + "*".repeat(luminosita));
        }

    }


}
