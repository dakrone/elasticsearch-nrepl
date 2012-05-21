package org.writequit.elasticsearch.plugin.nrepl;

import org.elasticsearch.monitor.jvm.JvmInfo;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

/**
 * @author dakrone
 */
public class Version {

    public static String number() {
        return "0.0.1";
    }

}