package browserstack;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CapabelitiesFactory {
    private static final String CONFIG_FILE = "browserstack.json";

    @SuppressWarnings("unchecked")
    public static List<DesiredCapabilities> getCapabilities() throws Exception {
        // Load the JSON configuration file
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> config = mapper.readValue(new File(CONFIG_FILE), Map.class);

        // Extract platforms array from the configuration
        List<Map<String, String>> platforms = (List<Map<String, String>>) config.get("platforms");

        // Generate DesiredCapabilities for each platform
        List<DesiredCapabilities> capabilitiesList = new ArrayList<>();
        for (Map<String, String> platform : platforms) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("os", platform.get("os"));
            capabilities.setCapability("os_version", platform.get("osVersion"));
            capabilities.setCapability("browser", platform.get("browserName"));
            capabilities.setCapability("browser_version", platform.get("browserVersion"));

            // Add additional capabilities from the common settings
            capabilities.setCapability("project", config.get("projectName"));
            capabilities.setCapability("build", config.get("buildName"));
            capabilities.setCapability("name", platform.get("browserName") + " Test");
            capabilities.setCapability("browserstack.debug", config.get("debug"));
            capabilities.setCapability("browserstack.networkLogs", config.get("networkLogs"));
            capabilities.setCapability("browserstack.console", config.get("consoleLogs"));

            // Add BrowserStack credentials
            capabilities.setCapability("browserstack.user", config.get("userName"));
            capabilities.setCapability("browserstack.key", config.get("accessKey"));

            // Add BrowserStack Local support if enabled
            if ((Boolean) config.get("browserstackLocal")) {
                capabilities.setCapability("browserstack.local", true);
            }

            capabilitiesList.add(capabilities);
        }

        return capabilitiesList;
    }
}
