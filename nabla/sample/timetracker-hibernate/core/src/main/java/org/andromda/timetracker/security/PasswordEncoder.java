package org.andromda.timetracker.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoder
{
    /**
     * @param plaintext
     * @return new sun.misc.BASE64Encoder().encode(raw)
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String getMD5Base64EncodedPassword(final String plaintext) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        final MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(plaintext.getBytes("UTF8"));
        final byte raw[] = md.digest();
        final String hash = new sun.misc.BASE64Encoder().encode(raw);
        return hash;
    }
}
