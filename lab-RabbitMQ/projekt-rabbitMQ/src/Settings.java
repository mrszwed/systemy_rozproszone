import java.util.HashMap;
import java.util.Map;

public class Settings {
    static final String CONSUMER_EXCHANGE_NAME = "consumer-exchange";
    static final String AGENCY_EXCHANGE_NAME = "agency-exchange";
    static final String ADMIN_EXCHANGE_NAME = "admin-exchange";
    static final String AGENCY_TOPIC = "agency";
    static final String CONSUMER_TOPIC = "consumer";
    static Map<String, String> otypeToQueue = new HashMap<>();
    static {
        otypeToQueue.put("po","po_queue");
        otypeToQueue.put("pl","pl_queue");
        otypeToQueue.put("us","us_queue");
    }

}
