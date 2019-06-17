package zipping.co;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFile {
	
	public static String sourceFile=ConfigurationUtility.getProperty("filePath");
	public static String outputFile = ConfigurationUtility.getProperty("zipOutputPath");
	
        public static void main(String[] args) throws IOException {  	
		try {
			FileOutputStream fos = new FileOutputStream(outputFile);
			ZipOutputStream zipOut = new ZipOutputStream(fos);
			File fileToZip = new File(sourceFile);
			FileInputStream fis = new FileInputStream(fileToZip);
			ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
			zipOut.putNextEntry(zipEntry);
			final byte[] bytes = new byte[1024];
			int length;
			while((length = fis.read(bytes)) >= 0) {
			    zipOut.write(bytes, 0, length);
			}
			zipOut.close();
			fis.close();
			fos.close();
		 } catch (Exception e) {
			System.out.println("Something went wrong while converting file!");
			e.printStackTrace();
	}
	System.out.println("File was successfully converted!");
    }
}
