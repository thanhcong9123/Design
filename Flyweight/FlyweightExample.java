package Flyweight;

import java.util.HashMap;
import java.util.Map;

// Flyweight class representing character formatting
class TextFormatting {
    private final String font;
    private final int size;
    private final String color;

    public TextFormatting(String font, int size, String color) {
        this.font = font;
        this.size = size;
        this.color = color;
    }

    public String getFont() {
        return font;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "TextFormatting{font='" + font + "', size=" + size + ", color='" + color + "'}";
    }
}

// Flyweight Factory to manage shared TextFormatting objects
class TextFormattingFactory {
    private final Map<String, TextFormatting> formattingPool = new HashMap<>();

    public TextFormatting getTextFormatting(String font, int size, String color) {
        String key = font + size + color;
        if (!formattingPool.containsKey(key)) {
            TextFormatting formatting = new TextFormatting(font, size, color);
            formattingPool.put(key, formatting);
        }
        return formattingPool.get(key);
    }

    public int getPoolSize() {
        return formattingPool.size();
    }
}

// Context class representing a text character
class TextCharacter {
    private final char character;
    private final TextFormatting formatting;

    public TextCharacter(char character, TextFormatting formatting) {
        this.character = character;
        this.formatting = formatting;
    }

    public char getCharacter() {
        return character;
    }

    public TextFormatting getFormatting() {
        return formatting;
    }

    @Override
    public String toString() {
        return "TextCharacter{character=" + character + ", formatting=" + formatting + "}";
    }
}

// Client code
public class FlyweightExample {
    public static void main(String[] args) {
        TextFormattingFactory formattingFactory = new TextFormattingFactory();

        // Creating characters with shared formatting
        TextCharacter c1 = new TextCharacter('H', formattingFactory.getTextFormatting("Arial", 12, "Black"));
        TextCharacter c2 = new TextCharacter('e', formattingFactory.getTextFormatting("Arial", 12, "Black"));
        TextCharacter c3 = new TextCharacter('l', formattingFactory.getTextFormatting("Arial", 12, "Black"));
        TextCharacter c4 = new TextCharacter('l', formattingFactory.getTextFormatting("Arial", 12, "Black"));
        TextCharacter c5 = new TextCharacter('o', formattingFactory.getTextFormatting("Arial", 12, "Black"));

        // Changing formatting for a different character
        TextCharacter c6 = new TextCharacter('!', formattingFactory.getTextFormatting("Times New Roman", 14, "Red"));

        // Displaying characters
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);

        // Displaying the size of the formatting pool
        System.out.println("Number of unique TextFormatting objects: " + formattingFactory.getPoolSize());
    }
}
