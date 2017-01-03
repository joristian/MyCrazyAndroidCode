package exmaple.com.helloword;

/**
 * Created by joris.tian on 2016/7/26.
 */

import android.content.Context;
import android.telephony.TelephonyManager;

import java.lang.reflect.Method;

public class CommonUtil {
    /**
     * 获取设备型号 如:MICKY
     *
     * @return
     */
    public static String getModel() {
        return android.os.Build.MODEL;
    }



    /**
     * 获取手机号码
     *
     * @param context
     * @return
     */
    public static String getPhoneNum(Context context) {
        //获取手机号码
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String deviceid = tm.getDeviceId();//获取智能设备唯一编号
        String te1 = tm.getLine1Number();//获取本机号码
        String imei = tm.getSimSerialNumber();//获得SIM卡的序号
        String imsi = tm.getSubscriberId();//得到用户Id
        return te1;
    }

    /**
     * 获取手机imsi
     *
     * @param context
     * @return
     */
    public static String getPhoneImsi(Context context) {
        //获取手机imsi
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String deviceid = tm.getDeviceId();//获取智能设备唯一编号
//         String te1  = tm.getLine1Number();//获取本机号码
        String imei = tm.getSimSerialNumber();//获得SIM卡的序号
        String imsi = tm.getSubscriberId();//得到用户Id
        return imsi;
    }

    /**
     * 获取设备CSN号
     *
     * @return
     */
    public static String getDSN() {
        String csn = "";
        String psntocsn = "";
        try {
            //获得QcNvItems类
            Class nvItems = Class.forName("com.android.qualcomm.qcnvitems.QcNvItems");
            //获得QcNvItems类的实例
            Object object = nvItems.newInstance();
            Method getMethod = nvItems.getMethod("getNvFactoryData1", null);
            byte[] bytes = (byte[]) getMethod.invoke(object, null);
            //NV 2497的0～29位是PCB S/N号
            //NV 2497的30～59位是Device S/N号，也就是MDM的PSN号，PSN固定长度为18
            //NV 2497的60～89位是Customer S/N号，供客户自定义设备号，韵达SN号固定长度为14
            byte[] psnData = new byte[4];
            System.arraycopy(bytes, 44, psnData, 0, psnData.length);
            boolean isPsnValid = isSnDataValid(psnData);
            //String str = new String(psnData);
            String pstr = bytesToAscii(psnData, 0, psnData.length);
            if (isPsnValid) {
                //psntocsn = "50112999"+pstr;
                psntocsn = "5011299999" + pstr;//先用14位测试
            }

            byte[] csnData = new byte[18];
            System.arraycopy(bytes, 30, csnData, 0, csnData.length);
            boolean isCsnValid = isSnDataValid(csnData);
            //String str = new String(psnData);
            String cstr = bytesToAscii(csnData, 0, csnData.length);
            if (isCsnValid) {
                csn = cstr;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } catch (Error e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        if (csn.equals("")) {
           /// return "50112000000011";
            return psntocsn;
        }
        //return csn;
        return "50112000000011 ";
        //return "50112000000012";//这个是错误的csn号，用来测试登录返回值
        //return "50112999990401";
        //return "50112999990403";
        //return "50112999990410";
    }

    public static String bytesToAscii(byte[] bytes, int offset, int dateLen) {
        if (bytes == null || bytes.length == 0 || offset < 0 || dateLen <= 0) {
            return null;
        }
        if (offset >= bytes.length || (bytes.length - offset) < dateLen) {
            return null;
        }

        String asciiStr = null;
        byte[] data = new byte[dateLen];
        System.arraycopy(bytes, offset, data, 0, dateLen);

        try {
            asciiStr = new String(data, "ISO8859-1");
        } catch (java.io.UnsupportedEncodingException e) {
        }

        return asciiStr;
    }

    public static String bytesToAscii(byte[] bytes, int dateLen) {
        return bytesToAscii(bytes, 0, dateLen);
    }

    public static String bytesToAscii(byte[] bytes) {
        return bytesToAscii(bytes, 0, bytes.length);
    }

    public static String bytesToHexString(byte[] bytes, int offset, int len) {
        if (bytes == null) return "null!";

        int b;
        StringBuilder ret = new StringBuilder(2 * len);

        for (int i = 0; i < len; i++) {
            b = 0x0f & (bytes[offset + i] >> 4);
            ret.append("0123456789abcdef".charAt(b));
            b = 0x0f & bytes[offset + i];
            ret.append("0123456789abcdef".charAt(b));
        }

        return ret.toString();
    }

    public static String bytesToHexString(byte[] bytes, int len) {
        return (bytes == null ? "null!" : bytesToHexString(bytes, 0, len));
    }

    public static String bytesToHexString(byte[] bytes) {
        return (bytes == null ? "null!" : bytesToHexString(bytes, bytes.length));
    }

    private static boolean isSnDataValid(byte[] snData) {
        if (!isDigit(snData[0]) && !isLetter(snData[0]) && !isSymbol(snData[0])) {
            return false;
        }
        return true;
    }

    private static boolean isDigit(byte ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isLetter(byte ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isSymbol(byte ch) {
        if (ch == '-' || ch == '_' || ch == ':' || ch == '*' || ch == '#'
                || ch == '@' || ch == '$' || ch == '&' || ch == '~') {
            return true;
        } else {
            return false;
        }
    }
}


