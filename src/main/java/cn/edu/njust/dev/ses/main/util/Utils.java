package cn.edu.njust.dev.ses.main.util;

import org.jetbrains.annotations.Contract;

final public class Utils {
    private Utils(){}
    public static boolean isValidEmail(String email){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    @Contract(value = "null -> false", pure = true)
    public static boolean isValidPwd(String password){
        return password != null&& password.length() >= 6;
    }

}
