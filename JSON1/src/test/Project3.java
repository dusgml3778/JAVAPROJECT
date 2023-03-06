package test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Project3 {

	public static void main(String[] args) {

		String url = "https://sum.su.or.kr:8888/bible/today/Ajax/Bible/BodyMatter?qt_ty=QT1";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("入力してください yyyymmdd");
			String bible = br.readLine();
			url = url + "&Base_de=" + bible + "&bibleType=1";
			System.out.println("====================================");
			Document doc = Jsoup.connect(url).post();

			Element bibleinfo_box = doc.select(".bibleinfo_box").first();
			System.out.println(bibleinfo_box.text());

			Elements liList = doc.select(".body_list > li");

			OutputStream output = new FileOutputStream("C:/Users/dusgm/Desktop/비자/test.txt");

			for (Element li : liList) {
				String str = li.select(".num").first().text() + ":";
				str += li.select(".info").first().text() + "\n";
				byte[] by = str.getBytes();
				output.write(by);
			}

			Element tag0 = doc.select("source").first();
			String dPath1 = tag0.attr("src").trim();
			System.out.println(dPath1); // Mp3 Path 
			String fileNames = dPath1.substring(dPath1.lastIndexOf("/") + 1);

			extracted(dPath1, fileNames);
			
			Element tag = doc.select(".img > img").first();
			String dPath = "https://sum.su.or.kr:8888" + tag.attr("src").trim();
			System.out.println(dPath); // Mp3 Path
			String fileName = dPath.substring(dPath.lastIndexOf("/") + 1);
			extracted(dPath, fileName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void extracted(String dPath, String fileName) {
		Runnable r = new DownLoadBroker(dPath, fileName);
		Thread dLoad = new Thread(r);
		dLoad.start();

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("" + (i + 1));
		}

		System.out.println();
		System.out.println("-------------------------------------");
	}

}
