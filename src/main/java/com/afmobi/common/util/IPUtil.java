package com.afmobi.common.util;

import com.google.common.primitives.Ints;
import sun.net.util.IPAddressUtil;

/**
 * ClassName:   IPUtil
 * Date:        2019-10-09 19:03
 *
 * @author Vincent
 */
public class IPUtil {
    public static boolean bInMask(String ip, String... masks) {
        for (String mask : masks) {
            String[] maskArr = mask.split("/");
            if (maskArr.length != 2) {
                continue;
            }
            String mIP = maskArr[0];
            String mBit = maskArr[1];
            if (matchIPMask(ip, mIP, Ints.tryParse(mBit))) {
                return true;
            }
        }
        return false;
    }

    private static boolean matchIPMask(String ip, String subnet, int bit) {
        int mask = -1 << (32 - bit);
        return (ip2Int(subnet) & mask) == (ip2Int(ip) & mask);
    }


    private static int ip2Int(String ip) {
        byte[] b = IPAddressUtil.textToNumericFormatV4(ip);
        return ((b[0] & 0xFF) << 24) |
                ((b[1] & 0xFF) << 16) |
                ((b[2] & 0xFF) << 8) |
                ((b[3] & 0xFF) << 0);
    }
}
