import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public static void main(String[] args) {
        try {
            StringBuffer inputText = new StringBuffer("Boys next door. Three hundred bucks is three hundred bucks. Boy Boy. Boyfriend come here. Boy. Boyfriend. Three bucks.");
            String[] words = {"Boy", "Three", "bucks"};

            processText(inputText, words);
        } catch (Exception e) {
            System.out.println("Виникла помилка: " + e.getMessage());
        }
    }

    public static void processText(StringBuffer inputText, String[] words) throws IllegalArgumentException {
        try {
            if (inputText == null || words == null || words.length == 0) {
                throw new IllegalArgumentException("Невірні вхідні дані");
            }

            Map<String, Integer> wordCountMap = new HashMap<>();

            // divide String Buffer into sentences
            int start = 0;
            for (int i = 0; i < inputText.length(); i++) {
                if (inputText.charAt(i) == '.') {
                    String sentence = inputText.substring(start, i).trim();
                    start = i + 1;

                    for (String word : words) {
                        if (sentence.matches(".*\\b" + word + "\\b.*")) {
                            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                        }
                    }
                }
            }

            System.out.println("Результати підрахунку:");
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                System.out.println("Слово \"" + entry.getKey() + "\": " + entry.getValue() + " входжень");
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("Помилка обробки тексту: " + e.getMessage());
        }
    }
}

