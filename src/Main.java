import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

       // Immagine img = new Immagine("Il mare e la luna");
       // Video vid = new Video("Saggio di danza 2024", 10);
       // RegistrazioneAudio reg = new RegistrazioneAudio("Conferenza Settembre 2024", 10, 15);

       // img.show();
       // vid.play();
       // reg.play();
        String titolo = "";
        int luminosita = 0;
        int durata = 0;
        int volume = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("Creazione dell'elemento multimediale " + (i + 1) + ":");
            System.out.println("Scegli il tipo di file (1: Immagine, 2: Audio, 3: Video): ");
            int scelta = scan.nextInt();
            scan.nextLine();

            switch (scelta) {

                    // IMMAGINE
                case 1:
                    System.out.println("Inserisci il titolo: ");
                    titolo = scan.nextLine();

                    while (true) {
                        try {
                            System.out.println("Inserisci la luminosità: ");
                            luminosita = scan.nextInt();
                            scan.nextLine();
                            elementi[i] = new Immagine(titolo, luminosita);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;


                    //AUDIO
                case 2:
                    System.out.println("Inserisci il titolo: ");
                    titolo = scan.nextLine();

                    while (true) {
                        try {
                            System.out.println("Inserisci la durata: ");
                            durata = scan.nextInt();
                            scan.nextLine();
                            if (durata <= 0) {
                                throw new IllegalArgumentException("Controlla la durata!");
                            }
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    while (true) {
                        try {
                            System.out.println("Inserisci il volume: ");
                            volume = scan.nextInt();
                            scan.nextLine();
                            if (volume <= 0) {
                                throw new IllegalArgumentException("Alza il volume!");
                            }
                            elementi[i] = new RegistrazioneAudio(titolo, durata, volume);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;


                    //VIDEO
                case 3:
                    System.out.println("Inserisci il titolo: ");
                    titolo = scan.nextLine();

                    while (true) {
                        try {
                            System.out.println("Inserisci la durata: ");
                            durata = scan.nextInt();
                            scan.nextLine();
                            if (durata <= 0) {
                                throw new IllegalArgumentException("Controlla la durata!");
                            }
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    while (true) {
                        try {
                            System.out.println("Inserisci il volume: ");
                            volume = scan.nextInt();
                            scan.nextLine();
                            if (volume <= 0) {
                                throw new IllegalArgumentException("Alza il volume!");
                            }
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    while (true) {
                        try {
                            System.out.println("Inserisci la luminosità: ");
                            luminosita = scan.nextInt();
                            scan.nextLine();
                            elementi[i] = new Video (titolo, durata, volume, luminosita);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    break;

                default:
                    System.out.println("Scelta non valida");
                    i--;
                    break;
            }
        }

        int scelta;
        do {
            System.out.println("Scegli l'elemento da riprodurre (1-5), oppure 0 per uscire: ");
            scelta = scan.nextInt();
            if (scelta > 0 && scelta <= 5) {
                ElementoMultimediale el = elementi [scelta - 1];

                if (el instanceof Riproduci) {
                    while (true) {
                        System.out.println("Vuoi modificare il volume prima di riprodurre? (1: Alza Volume, 2: Abbassa Volume, 3: Riproduci, 0: Annulla): ");

                        if (el instanceof Video) {
                            System.out.println("4: Aumenta Luminosità, 5: Abbassa Luminosità");
                        }
                        if (el instanceof Immagine) {
                            System.out.println("6: Aumenta Luminosità, 7: Abbassa Luminosità");
                        }

                        int azione = scan.nextInt();

                if (azione == 0) {
                    break;
                } else if (azione == 1) {
                    if (el instanceof Video) {
                        ((Video) el).alzaVolume();
                    } else if (el instanceof RegistrazioneAudio) {
                        ((RegistrazioneAudio) el).alzaVolume();
                    }
                } else if (azione == 2) {
                    if (el instanceof Video) {
                        ((Video) el).abbassaVolume();
                    } else if (el instanceof RegistrazioneAudio) {
                        ((RegistrazioneAudio) el).abbassaVolume();
                    }
                } else if (azione == 3) {
                    ((Riproduci) el).play();
                    break;
                } else if (azione == 4 && el instanceof Video) {
                    ((Video) el).aumentaLum();
                } else if (azione == 5 && el instanceof Video) {
                    ((Video) el).abbassaLum();
                } else {
                    System.out.println("Azione non valida.");
                }
                    }

        } else if (el instanceof Immagine) {
            ((Immagine) el).show();
        }

    }

        } while (scelta != 0);

        scan.close();
        System.out.println("Arrivederci");
    }
}