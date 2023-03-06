package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownLoadBroker implements Runnable {
	private String address;
	private String fileName;

	public DownLoadBroker(String address, String fileName) {
		super();
		this.address = address;
		this.fileName = fileName;
	}

	@Override
	public void run() {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			URL url = new URL(address);
			InputStream is = url.openStream();
			BufferedInputStream input = new BufferedInputStream(is);

			Path target = Paths.get("C:\\Users\\dusgm\\Desktop\\비자", fileName);
			
			int data;

			while ((data = input.read()) != -1) {

				bos.write(data);

			}

			Files.copy(is, target);
			
			bos.close();
			input.close();
			System.out.println("download complete!");
			System.out.println(fileName);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
