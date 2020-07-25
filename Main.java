package fr.noctu.ayay;
import java.util.Base64;

import javax.crypto.spec.SecretKeySpec;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		byte[] bytes = Base64.getDecoder().decode(args[0]);
        SecretKeySpec key = new SecretKeySpec(bytes, "AES");
        ClassLoader loader = new CustomClassLoader(key);
        Class<?> cls = loader.loadClass("fr.noctu.ayay.EncMain");
        Runnable main = (Runnable) cls.newInstance();
        main.run();
	}
}	
