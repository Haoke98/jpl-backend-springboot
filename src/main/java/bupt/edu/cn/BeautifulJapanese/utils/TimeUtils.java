package bupt.edu.cn.BeautifulJapanese.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间相关工具
 * @author 萨达木（sadam)
 * @date 2021/11/25 1:43
 */
public class TimeUtils {
    public static String getDateString(Date date){
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        if (date == null) {
            date = new Date();
        }
        return df.format(date);
    }
    public static String getDateTimeString(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        if (date == null) {
            date = new Date();
        }
        return df.format(date);
    }

    public static String getDateTimeStringWithSecond(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        if (date == null) {
            date = new Date();
        }
        return df.format(date);
    }
}
