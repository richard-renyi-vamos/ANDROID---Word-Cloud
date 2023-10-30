import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordCloudGenerator {

    public static void main(String[] args) {
        String url = "https://example.com"; // Replace with the website you want to analyze
        try {
            // Fetch website content using Jsoup
            Document doc = Jsoup.connect(url).get();
            String text = doc.text();

            // Tokenize the text into words
            StringTokenizer tokenizer = new StringTokenizer(text);
            Map<String, Integer> wordFrequency = new HashMap<>();

            // Count word frequency
            while (tokenizer.hasMoreTokens()) {
                String word = tokenizer.nextToken().toLowerCase(); // Normalize to lowercase
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }

            // Here, you can use a library like WordCloud or implement your own visualization.
            // You may choose to display the results or export the word cloud as an image.

            // For simplicity, let's print the word frequencies for now
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
