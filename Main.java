import java.util.Random;
import java.util.Scanner;

// @SuppressWarnings("UnusedReturnValue")

public class Main {

    public static void main(String[] args) {

        char[] PasswortBlanko = new char[GesamtzahlEingeben()];
        int Gesamtzahl = PasswortBlanko.length;
        int Sonderzeichen = AnzahlSonderzeichenEingeben(Gesamtzahl);
        int Grossbuchstaben = AnzahlGrossbuchstabenEingeben(Gesamtzahl);
        int Zahlen = AnzahlZeichenEingeben(Gesamtzahl);

        PasswortBefuellen(PasswortBlanko, Grossbuchstaben, Gesamtzahl, Sonderzeichen, Zahlen);
    }

    public static int GesamtzahlEingeben() {
        Scanner scanner = new Scanner(System.in);
        int Gesamtzahl;
        do {
            System.out.println("Wie viele Zeichen soll das Passwort haben? Erlaubt sind 8 - 30 Zeichen");
            Gesamtzahl = scanner.nextInt();

            if (Gesamtzahl < 8 || Gesamtzahl > 30) {
                System.out.println("Ungültige Eingabe, erlaubt sind 8 - 30 Zeichen");
            }
        } while (Gesamtzahl < 8 || Gesamtzahl > 30);
        return Gesamtzahl;
    }

    public static int AnzahlSonderzeichenEingeben(int Gesamtzahl) {
        Scanner scanner = new Scanner(System.in);
        int Sonderzeichen;
        do {
            System.out.println("Wie viele Sonderzeichen soll das Passwort mindestens enthalten? Erlaubt sind maximal " + (Gesamtzahl / 4 + " Zeichen. Weniger ist aber erlaubt"));
            Sonderzeichen = scanner.nextInt();

            if (Sonderzeichen < 0 || Sonderzeichen > (Gesamtzahl / 4)) {
                System.out.println("Ungültige Eingabe, erlaubt sind " + (Gesamtzahl / 4 + " Zeichen"));
            }
        } while (Sonderzeichen < 0 || Sonderzeichen > Gesamtzahl / 4);

        return Sonderzeichen;
    }

    public static int AnzahlGrossbuchstabenEingeben(int Gesamtzahl) {
        int Grossbuchstaben;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Wie viele Großbuchstaben soll das Passwort mindestens enthalten? Erlaubt sind maximal " + (Gesamtzahl / 4 + " Zeichen. Weniger ist aber erlaubt"));
            Grossbuchstaben = scanner.nextInt();
            if (Grossbuchstaben < 0 || Grossbuchstaben > (Gesamtzahl / 4)) {
                System.out.println("Ungültige Eingabe, erlaubt sind " + (Gesamtzahl / 4 + " Zeichen"));
            }
        } while (Grossbuchstaben < 0 || Grossbuchstaben > Gesamtzahl / 4);

        return Grossbuchstaben;
    }

    public static int AnzahlZeichenEingeben(int Gesamtzahl) {
        int Zahlen;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Wie viele Zahlen von 1-9 soll das Passwort mindestens enthalten? Erlaubt sind maximal " + (Gesamtzahl / 4 + " Zahlen. Weniger ist aber erlaubt"));
            Zahlen = scanner.nextInt();
            if (Zahlen < 0 || Zahlen > (Gesamtzahl / 4)) {
                System.out.println("Ungültige Eingabe, erlaubt sind " + (Gesamtzahl / 4 + " Zeichen"));
            }
        } while (Zahlen < 0 || Zahlen > Gesamtzahl / 4);
        return Zahlen;
    }

    public static String PasswortBefuellen(char[] PasswortBlanko, int Grossbuchstaben, int Gesamtzahl, int Sonderzeichen, int Zahlen) {

        while (Grossbuchstaben != 0) {
            Random random = new Random();
            int randomNumber = random.nextInt(PasswortBlanko.length);
            int randomGrossBuchstabe = random.nextInt(26) + 65;
            char c = (char) randomGrossBuchstabe;

            if (PasswortBlanko[randomNumber] == '\u0000') {
                PasswortBlanko[randomNumber] = c;
                Grossbuchstaben--;
                Gesamtzahl--;
            }
        }

        while (Sonderzeichen != 0) {
            Random random = new Random();
            int randomNumber = random.nextInt(PasswortBlanko.length);
            int randomSonderzeichen = random.nextInt(15) + 33;
            char c = (char) randomSonderzeichen;

            if (PasswortBlanko[randomNumber] == '\u0000') {
                PasswortBlanko[randomNumber] = c;
                Sonderzeichen--;
                Gesamtzahl--;
            }
        }

        while (Zahlen != 0) {
            Random random = new Random();
            int randomNumber = random.nextInt(PasswortBlanko.length);
            int randomZahl = random.nextInt(9) + 48;
            char c = (char) randomZahl;

            if (PasswortBlanko[randomNumber] == '\u0000') {
                PasswortBlanko[randomNumber] = c;
                Zahlen--;
                Gesamtzahl--;
            }
        }

        while (Gesamtzahl != 0) {
            for (int i = 0; i < (PasswortBlanko.length - Sonderzeichen - Grossbuchstaben - Zahlen); ) {
                if (PasswortBlanko[i] == '\u0000') {
                    Random random = new Random();
                    int randomFuellzeichen = random.nextInt(25) + 97;
                    PasswortBlanko[i] = (char) randomFuellzeichen;
                    Gesamtzahl--;
                    i++;
                } else {
                    i++;
                }
            }
        }
        String fertigesPasswort = new String(PasswortBlanko);
        System.out.println("Dein zufallsgeneriertes Passwort lautet: " + fertigesPasswort);

        return fertigesPasswort;
    }
}