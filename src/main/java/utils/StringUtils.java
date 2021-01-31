package utils;

public class StringUtils {
public static boolean isEmptyOrNull(String s) {
	if(s!=null)
		return s.isEmpty();
	return true;
}
}
