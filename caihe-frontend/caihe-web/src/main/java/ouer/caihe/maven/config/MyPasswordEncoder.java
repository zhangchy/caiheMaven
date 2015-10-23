package ouer.caihe.maven.config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

import sun.misc.BASE64Encoder;

public class MyPasswordEncoder extends MessageDigestPasswordEncoder {
	public MyPasswordEncoder() {
		super("MD5");
	}

	@Value("${login.password.key}")
	String passwordKey;
	
	@Override
    public String encodePassword(String rawPass, Object salt) {
    	MessageDigest md;
    	String result = "";
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(rawPass.getBytes());
			result = "{MD5}"+new BASE64Encoder().encode(md.digest());
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		return result;
        /*String saltedPass = mergePasswordAndSalt(rawPass, salt, false);

        MessageDigest messageDigest = getMessageDigest();

        byte[] digest = messageDigest.digest(Utf8.encode(saltedPass));

        // "stretch" the encoded value if configured to do so
        for (int i = 1; i < iterations; i++) {
            digest = messageDigest.digest(digest);
        }

        if (getEncodeHashAsBase64()) {
            return Utf8.decode(Base64.encode(digest));
        } else {
            return new String(Hex.encode(digest));
        }*/
    }
}
