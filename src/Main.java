import java.util.Scanner;

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Välj ett alternativ:");
    System.out.println("1. Konvertera text till morsekod");
    System.out.println("2. Konvertera morsekod till text");
    int choice = scanner.nextInt();
    scanner.nextLine(); // Rensa newline

    if (choice == 1) {
        System.out.println("Skriv in text att konvertera till morsekod:");
        String inputText = scanner.nextLine();

        String morseCode = TextToMorse.convertToMorse(inputText);

        System.out.println("Morsekod:");
        System.out.println(morseCode);
    } else if (choice == 2) {
        System.out.println("Skriv in morsekod att konvertera till text (använd '/' mellan ord):");
        String inputMorse = scanner.nextLine();

        String text = TextToMorse.convertToText(inputMorse);

        System.out.println("Text:");
        System.out.println(text);
    } else {
        System.out.println("Ogiltigt val. Avslutar.");
    }
}
