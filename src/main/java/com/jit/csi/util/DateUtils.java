package com.jit.csi.util;

import java.util.Date;
import java.sql.Timestamp;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:46
 */
public class DateUtils {

    public static Timestamp toSqlDate(){
        Date date=new Date();
        return new Timestamp(date.getTime());
    }
}
