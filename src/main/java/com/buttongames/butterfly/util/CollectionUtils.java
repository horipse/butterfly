package com.buttongames.butterfly.util;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Simple class with methods to interact with collections (mainly bytes).
 * @author skogaby (skogabyskogaby@gmail.com)
 */
public class CollectionUtils {

    /**
     * Convert an {@code ArrayList<Byte>} to a {@code byte[]}
     * @param list
     * @return
     */
    public static byte[] arrayListToArray(final ArrayList<Byte> list) {
        final byte[] ret = new byte[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }

        return ret;
    }

    /**
     * Converts a hex string into a byte array.
     * @param s
     * @return
     */
    public static byte[] hexStringToByteArray(final String s) {
        final int len = s.length();
        final byte[] data = new byte[len / 2];

        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }

        return data;
    }

    /**
     * Reads all the bytes in an input stream into a new byte array.
     * @param is The {@code InputStream} to read
     * @return A byte array containing everything read from the stream
     * @throws IOException
     */
    public static byte[] readInputStream(final InputStream is) throws IOException {
        return IOUtils.toByteArray(is);
    }
}
