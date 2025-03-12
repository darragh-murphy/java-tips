import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

public class URLBuilder {
    public static String buildUrl(String baseUrl, Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return baseUrl;
        }
        
        String queryString = params.entrySet().stream()
                .map(entry -> String.format("%s=%s", 
                        URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8),
                        URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8)))
                .collect(Collectors.joining("&"));
        
        return baseUrl + "?" + queryString;
    }
    
    public static void main(String[] args) {
        Map<String, String> params = Map.of(
            "search", "java encoding",
            "page", "1",
            "sort", "desc"
        );
        
        String url = buildUrl("https://example.com/api", params);
        System.out.println(url);
    }
}
