package citynetwork;

import java.util.regex.*;

public class Utils {

    public static boolean isValidCode(String _cityName, String _cityCode) {
        String cityName = _cityName.toUpperCase().trim();
        Pattern cityNameRegex = Pattern.compile("^[A-Z ]*$");
        Matcher cityNameMatcher = cityNameRegex.matcher(cityName);
        if (!cityNameMatcher.matches()) {
            throw new IllegalArgumentException(
                    "City name must match pattern: '^[A-Z ]*$'");
        }
        String cityCode = _cityCode.toUpperCase().trim();
        Pattern cityCodeRegex = Pattern.compile("^[A-Z][A-Z][A-Z]$");
        Matcher cityCodeMatcher = cityCodeRegex.matcher(cityCode);
        if (!cityCodeMatcher.matches()) {
            return false; // Invalid city code format
        }

        int codeIdx = 0;
        for (int cityIdx = 0; cityIdx < cityName.length(); cityIdx++) {
            if (cityName.charAt(cityIdx) == cityCode.charAt(codeIdx)) {
                // Matches letter
                codeIdx++;
                if (codeIdx >= cityCode.length()) break;
            }
        }

        return codeIdx == 3;
    }

}
