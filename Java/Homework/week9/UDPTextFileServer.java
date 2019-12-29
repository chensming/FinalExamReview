//服务器端 
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
 
public class UDPTextFileServer
{
	public static void main(String[] args)
	{
		DatagramSocket ds=null;
		try
		{
			ds=new DatagramSocket(1000);
			System.out.println("在1000端口监听...");
			
			byte[] b=new byte[1024];
			DatagramPacket dp=new DatagramPacket(b,0,b.length);
 
			ds.receive(dp);
			byte[] data=dp.getData();


			//判断是客户端想上传还是想下载
			//start
			String temp = data.toString();
			boolean IsDownload = temp.startsWith("/*Download from Server*/");
			if(IsDownload){
				String[] buff = temp.split(",");
				String fileName = buff[1];
			}
			else{
				
			}
			//end

			OutputStream os=null;
			os=new FileOutputStream(new File("D:/Desktop/vscodeProject/javaProject/java/Homework/week9/Server/output.txt"));
			os.write(data, 0, dp.getLength());
			System.out.println("文件接收成功");






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
				os.close();
				ds.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			
		}
	}
}
 
 
 
