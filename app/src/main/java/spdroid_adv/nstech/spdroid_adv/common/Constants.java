package spdroid_adv.nstech.spdroid_adv.common;

/**
 * Created by webwerks on 26/4/17.
 */

public class Constants {
    public static final String SPACE = " ";
    public static final String EMPTY_TEXT = "";
    public static final String COMMA = ", ";
    public static final String BRACKET_OPEN = "(";
    public static final String BRACKET_CLOSE = ")";
    public static final String PLUS = " + ";
    public static final String HYPHEN = " - ";
    public static final String SLASH = "/-";
    public static final String VERTICAL_SCORE = " || ";
    public static final String PERCENTAGE = "%";
    public static final String COLON = " : ";
    public static final String SELECT_ALL = "Select All";

    public interface HeaderKeys {
        String API_VERSION_CODE = "X-VERSION-CODE";
        String X_CLIENT = "X-Client";
        String CONTENT_TYPE = "Content-Type";
        String CACHE_CONTROL = "Cache-Control";
        String AUTHORIZATION = "Authorization";
        String X_SESSION = "X-Session";
    }

    public interface AppConstants {
        String PLATFORM = "Android";
        String CONTENT_FORMAT = "application/json";
        String NO_CACHE = "no-cache";
    }

}
