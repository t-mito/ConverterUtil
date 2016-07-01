package util.converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CaseConverter
 *
 * @author t-mito
 */
public class CaseConverter {

    /**
     * convert Camel case to Snake case
     *
     * @param value
     * @return
     */
    public static String camelToSnake(String value) {
        String convertedStr = value.replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2").replaceAll("([a-z])([A-Z])", "$1_$2");
        return convertedStr.toUpperCase();
    }

    /**
     * convert Snake case to Camel case
     *
     * @param value
     * @return
     */
    public static String snakeToCamel(String value) {

        Pattern pattern = Pattern.compile("_([a-z])");
        Matcher matcher = pattern.matcher(value.toLowerCase());

        StringBuffer sb = new StringBuffer(value.length());
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);

        return sb.toString();
    }
}
