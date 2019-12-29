//客户端 
 
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
 
public class UDPTextFileClient
{
	public upFile(String s){
		DatagramSocket ds = null;
		InputStream is = null;	
		try
		{
			ds=new DatagramSocket(2000);
			System.out.println("客户端在 2000 监听");
			
			s = "D:/Desktop/vscodeProject/javaProject/java/Homework/week9/Client/" + s;
			is=new FileInputStream(new File(s));
			
			byte[] b=new byte[is.available()];
			is.read(b);
			
			DatagramPacket dp=new DatagramPacket(b,0,b.length);
			dp.setPort(1000);
			dp.setAddress(InetAddress.getByName("127.0.0.1"));
			
			ds.send(dp);
			System.out.println("文件发送成功");
		} catch (SocketException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				is.close();
				ds.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			
		}
	}

	downFile(String s){
		
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String fileName;
		int mainLoop = 1;
		while(mainLoop){
			System.out.println("请输入您要进行的操作");
			System.out.println("1.上传文件   2.下载文件  0.退出");
			int Choose = in.nextInt();
			switch(case Choose){
				case 1:
					System.out.println("请输入要上传的文件名");
					fileName = in.nextLine();
					upFile(fileName);
					break;
				case 2:
					System.out.println("请输入要下载的文件名");
					filename = in.nextLine();
					downFile(fileName);
					break;
				case 0:
					mainLoop = 0;
					break;
			}
		}
		System.out.println("客户端已经退出");
	}
}