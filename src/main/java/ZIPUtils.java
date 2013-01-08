import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class ZIPUtils {
	static final int BUFFER = 2048;
	public boolean extractZipFile(String scrFile,String dscFolder)
	{
		boolean isError = false;
		try {
			ZipFile zipFile = new ZipFile(scrFile);
			Enumeration emu = zipFile.entries();
			int i=0;
			while(emu.hasMoreElements()){
				ZipEntry entry = (ZipEntry)emu.nextElement();
            if (entry.isDirectory())
            {
                new File(dscFolder + entry.getName()).mkdirs();
                continue;
            }
            BufferedInputStream bis = new BufferedInputStream(zipFile.getInputStream(entry));
            File file = new File(dscFolder + entry.getName());
            File parent = file.getParentFile();
            if(parent != null && (!parent.exists())){
                parent.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos,BUFFER);           
            
            int count;
            byte data[] = new byte[BUFFER];
            while ((count = bis.read(data, 0, BUFFER)) != -1)
            {
                bos.write(data, 0, count);
            }
            bos.flush();
            bos.close();
            bis.close();
			}
			zipFile.close();
			isError = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return isError;
	}
	
}
