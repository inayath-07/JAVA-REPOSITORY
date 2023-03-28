// this the copied version of program and nead internet connection 

import java.net.InetAddress;
import java.net.UnknownHostException;

public class net_package
{
    public static void main(String args[]) throws UnknownHostException
    {
        //local host = local computer or my computer 
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
        
        //getByName if for a specific website or website having only one name
        try
        {
            address = InetAddress.getByName("www.youtube.com");
            System.out.println(address);

            //for 10000 of websites having same name
            InetAddress sw[] = InetAddress.getAllByName("www.google.com");
            for (int i=0;i<sw.length;i++)
            System.out.println(sw[i]);
        }catch(UnknownHostException UHE)
        {
            System.out.println("there is no intenet to proceed further");
        }
        finally 
        {
            System.out.println("please try after you get internet connection ");
        }
    }    
}
