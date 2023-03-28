//first start server
import java.io.*;  
import java.net.*;  
public class Client_05
{  
public static void main(String[] args)
{  
try{      
Socket s=new Socket("localhost",1234);
DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
dout.writeUTF("asalamualaikum thoda mahar bani ");  
dout.flush();  
dout.close();  
s.close();  
}catch(Exception e){System.out.println(e);}  
} 
} 
