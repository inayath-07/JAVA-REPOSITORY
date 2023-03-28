//these program includes 3 inet classes
import java.net.*;
import java.util.*;
class finding_ip
{
    //decleration of variable
    static String website;
    static String website_01;
    static int i;
    static Scanner in;

    public static void main(String args[]) throws UnknownHostException
    {
        //SCR object 
        in = new Scanner(System.in);
       
        System.out.println("enter name of website");
        website = in.nextLine();

        //creating inet boject
        /**@5
         * the getLocalHost() used to return name
         * and ip address of your device 
         */
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("your ip is " + address);

        /*@5
         *the getbyName() is used to find ip 
         *address of website 
         */

        address = InetAddress.getByName(website); 
        System.out.println(address+"from getByName");

        //getAllByName()
        /*@5
        * the getAllByName() is use to find
        * how many sites are there by the same 
        * name
        */
        System.out.println("enter name of website that you want to put");
        System.out.println("in getAllByName()");

        website_01 = in.nextLine();

        InetAddress address_01[] = InetAddress.getAllByName(website_01);
        for(i = 0;i<address_01.length;i++)
        {
         System.out.println(address_01);  
        }
          
        in.close();
    }
}