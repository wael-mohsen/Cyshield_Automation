package Configuration;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfig {

    public Map<String, String> defaultHeaders() {
        Map<String, String> defalutHeaders = new HashMap<String, String>();
        defalutHeaders.put("Content-Type", "application/json");
        //defalutHeaders.put("Referer", "https://reqres.in/");
        //defalutHeaders.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        return defalutHeaders;
    }
}
