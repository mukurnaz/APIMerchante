package apiconfigs;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfig {
    public static Map<String, String> defaultHeaders(){
        Map<String, String> defaultHeaders = new HashMap<>();
        defaultHeaders.put("Content-Type","application/json");
        return defaultHeaders;
    }
}
