package kattis.virtualfriends;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class testcase {

	public static void main(String[] args) throws IOException {
		File fout = new File("/home/ant/test");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

		bw.write("1");
		bw.newLine();
		bw.write("100000");
		bw.newLine();
		String data = "";
		for (int i = 0; i < 100000; i++) {
			if (i % 100 == 0)
				data = (100001 + i) + " " + (90000 + i % 100);
			else
				data = i + " " + (i + 1 % 100);
			bw.write(data);
			bw.newLine();
			System.out.println(i);
		}
		bw.close();

	}

}
