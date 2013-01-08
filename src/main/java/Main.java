
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;


public class Main {
	static final int BUFFER = 2048;
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MD5Utils md5 = new MD5Utils();
		System.out.println("MD5: " + md5.getMD5Value("tcis-test.zip"));
		ZIPUtils zip = new ZIPUtils();
		if (zip.extractZipFile("tcis-test.zip", "E:\\test\\"))
		{
			System.out.println("extract success!!");
		}
	}
}
