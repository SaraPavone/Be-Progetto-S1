public class RegistrazioneAudio extends ElementoMultimediale implements Riproduci {

   private final int durata;
   private int volume;

    public RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo);
        if (volume <= 0) {
            throw new IllegalArgumentException("Alza il volume!");
         } else if (durata <= 0) {
        throw new IllegalArgumentException("Durata non valida!");
        } else {
            this.durata = durata;
            this.volume = volume;
        }
    }

    public void abbassaVolume() {
        if (volume > 0) {
            volume--;
        }
    }

    public void alzaVolume() {
        if (volume < 10) {
            volume++;
        }
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
        System.out.println(titolo + " " + "!".repeat(volume));
        }
    }

}
