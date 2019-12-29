//第五题
import java.io.*;
import java.util.Scanner;

public class CopyFile {
	static StringBuffer delComm(String s) {
		int index = s.indexOf("//");
		StringBuffer sBuffer = new StringBuffer(s);
		if(index != -1) {
			sBuffer.delete(index, s.length());
		}
		return sBuffer;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入您要读取的文件");
		String readPathName = in.nextLine();
		System.out.println("请输入您要输出的文件");
		String writePathName = in.nextLine();
		try (FileReader reader = new FileReader(readPathName);
				BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
				) {
			try (FileWriter writer = new FileWriter(writePathName);
					BufferedWriter out = new BufferedWriter(writer)
					) {
				//				out.write("我会写入文件啦1\r\n"); // \r\n即为换行
				//				out.write("我会写入文件啦2\r\n"); // \r\n即为换行
				String line;
				StringBuffer delLine;
				
				while ((line = br.readLine()) != null) {
					// 一次读入一行数据
					delLine = delComm(line);
					if(delLine != null && delLine.length() != 0) {
						//用于测试
                        // System.out.println(delLine);
						out.write(delLine + "\n");
					}	
				}
				out.flush(); // 把缓存区内容压入文件
                System.out.println("read and save successfully!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		in.close();
	}
}