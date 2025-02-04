import java.util.HashMap;
import java.util.Scanner;

public class TextToMorse {

    private static final HashMap<Character, String> morseCodeMap = new HashMap<>();
    private static final HashMap<String, Character> textMap = new HashMap<>();

    static {
        // Bygga upp morsekod-tabellen
        morseCodeMap.put('A', ".-");
        morseCodeMap.put('B', "-...");
        morseCodeMap.put('C', "-.-.");
        morseCodeMap.put('D', "-..");
        morseCodeMap.put('E', ".");
        morseCodeMap.put('F', "..-.");
        morseCodeMap.put('G', "--.");
        morseCodeMap.put('H', "....");
        morseCodeMap.put('I', "..");
        morseCodeMap.put('J', ".---");
        morseCodeMap.put('K', "-.-");
        morseCodeMap.put('L', ".-..");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-.");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', ".--.");
        morseCodeMap.put('Q', "--.-");
        morseCodeMap.put('R', ".-.");
        morseCodeMap.put('S', "...");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('U', "..-");
        morseCodeMap.put('V', "...-");
        morseCodeMap.put('W', ".--");
        morseCodeMap.put('X', "-..-");
        morseCodeMap.put('Y', "-.--");
        morseCodeMap.put('Z', "--..");
        morseCodeMap.put('1', ".----");
        morseCodeMap.put('2', "..---");
        morseCodeMap.put('3', "...--");
        morseCodeMap.put('4', "....-");
        morseCodeMap.put('5', ".....");
        morseCodeMap.put('6', "-....");
        morseCodeMap.put('7', "--...");
        morseCodeMap.put('8', "---..");
        morseCodeMap.put('9', "----.");
        morseCodeMap.put('0', "-----");
        morseCodeMap.put(' ', "/");

        // Bygga upp tabell för att omvandla morsekod till text
        for (var entry : morseCodeMap.entrySet()) {
            textMap.put(entry.getValue(), entry.getKey());
        }
    }

    // Konvertera text till morsekod
    public static String convertToMorse(String text) throws IllegalArgumentException {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Texten får inte vara tom.");
        }

        StringBuilder morseCode = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            String morseChar = morseCodeMap.get(c);
            if (morseChar != null) {
                morseCode.append(morseChar).append(" ");
            } else {
                throw new IllegalArgumentException("Ogiltigt tecken: " + c);
            }
        }
        return morseCode.toString().trim();
    }

    // Konvertera morsekod till text
    public static String convertToText(String morse) throws IllegalArgumentException {
        if (morse == null || morse.isEmpty()) {
            throw new IllegalArgumentException("Morsekoden får inte vara tom.");
        }

        StringBuilder text = new StringBuilder();
        String[] morseWords = morse.split(" / ");
        for (String word : morseWords) {
            for (String morseChar : word.split(" ")) {
                Character character = textMap.get(morseChar);
                if (character != null) {
                    text.append(character);
                } else {
                    throw new IllegalArgumentException("Ogiltig morsekod: " + morseChar);
                }
            }
            text.append(" ");
        }
        return text.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Välj ett alternativ:");
        System.out.println("1. Text till morsekod");
        System.out.println("2. Morse till text");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Rensa buffer

        switch (choice) {
            case 1:
                System.out.println("Skriv in text att konvertera till morsekod:");
                String inputText = scanner.nextLine();
                try {
                    String morseCode = convertToMorse(inputText);
                    System.out.println("Morsekod: " + morseCode);
                } catch (IllegalArgumentException e) {
                    System.out.println("Fel: " + e.getMessage());
                }
                break;

            case 2:
                System.out.println("Skriv in morsekod att konvertera till text:");
                String inputMorse = scanner.nextLine();
                try {
                    String text = convertToText(inputMorse);
                    System.out.println("Text: " + text);
                } catch (IllegalArgumentException e) {
                    System.out.println("Fel: " + e.getMessage());
                }
                break;

            default:
                System.out.println("Ogiltigt val. Programmet avslutas.");
        }
    }
}