import java.io.*;  
import java.net.*;  
public class Server_05
{  
public static void main(String[] args) throws UnknownHostException
{  
try{  
ServerSocket ss=new ServerSocket(1234);  
Socket s = ss.accept();//establishes connection   
DataInputStream dis=new DataInputStream(s.getInputStream());  
String  str=(String)dis.readUTF();  
System.out.println(str+"ja kar di");  
ss.close();  
}catch(Exception e){System.out.println(e);}  
}  
}  