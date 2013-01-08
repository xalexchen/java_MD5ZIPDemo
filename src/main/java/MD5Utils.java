import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Utils {

	public String getMD5Value(String file)
	{
		MessageDigest digest;
		String output = null;
		try {
			digest = MessageDigest.getInstance("MD5");
			File f = new File(file);
			InputStream is = new FileInputStream(f);                
			byte[] buffer = new byte[8192];
			int read = 0;
			try {
				while( (read = is.read(buffer)) > 0) {
			    digest.update(buffer, 0, read);
			}       
			byte[] md5sum = digest.digest();
			BigInteger bigInt = new BigInteger(1, md5sum);
			output = bigInt.toString(16);
			}
			catch(IOException e) {
				throw new RuntimeException("Unable to process file for MD5", e);
			}
			finally {
				try {
					is.close();
				}
				catch(IOException e) {
					throw new RuntimeException("Unable to close input stream for MD5 calculation", e);
				}
			}
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return output; 
	}
}
