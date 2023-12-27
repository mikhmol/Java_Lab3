import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public static void main(String[] args) {
        try {
            processText("Boy next door. Three hundred bucks is three hundred bucks. Boy", new String[]{"Boy", "Three", "bucks"});
        } catch (Exception e) {
            System.out.println("Виникла помилка: " + e.getMessage());
        }
    }

    public static void processText(String inputText, String[] words) throws IllegalArgumentException {
        try {
            if (inputText == null || words == null || words.length == 0) {
                throw new IllegalArgumentException("Невірні вхідні дані");
            }

            StringBuffer stringBuffer = new StringBuffer(inputText);

            Map<String, Integer> wordCountMap = new HashMap<>();

            String[] sentences = stringBuffer.toString().split("\\.");

            for (String sentence : sentences) {
                for (String word : words) {
                    if (sentence.contains(word)) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
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
