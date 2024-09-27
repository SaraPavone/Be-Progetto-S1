public class RegistrazioneAudio extends ElementoMultimediale implements Riproduci {

   private int durata;
   private int volume;

    private static final int MAX_VOLUME = 10;

    public RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo);
        setDurata(durata);
        setVolume(volume);
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

    public void abbassaVolume() {
        if (volume > 0) {
            volume--;
            System.out.println("Volume diminuito a: " + volume);
        } else {
            System.out.println("Il volume è già al minimo");
        }
    }

    public void alzaVolume() {
        if (volume < MAX_VOLUME) {
            volume++;
            System.out.println("Volume aumentato a: " + volume);
        } else {
            System.out.println("Il volume è già al massimo");
        }
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
        System.out.println(titolo + " " + "!".repeat(volume));
        }
    }

}
