//program to know iip address  of your computer (local host)
import java.net.*;
public class ip_address 
{
    public static void main(String args[]) throws UnknownHostException
    {
        //creating InetAddress object
        InetAddress my_ip = InetAddress.getLocalHost();
        System.out.println(my_ip);

    }
}
