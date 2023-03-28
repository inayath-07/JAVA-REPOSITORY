import java.io.*;
    import java.net.*;
    public class MultiJabberServer{
    ServerSocket providerSocket;
    Socket connection = null;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message;
    MultiJabberServer(){}
    void run()
{
    try{
        //1. creating a server socket
        providerSocket = new ServerSocket(2004, 10);
        //2. Wait for connection
        System.out.println("Waiting for connection");
        connection = providerSocket.accept();
        System.out.println("Connection received from " + connection.getInetAddress().getHostName());
        //3. get Input and Output streams
        out = new ObjectOutputStream(connection.getOutputStream());
        out.flush();
        in = new ObjectInputStream(connection.getInputStream());
        sendMessage("Connection successful");

        //4. The two parts communicate via the input and output streams
        do{
            try{
                message = (String)in.readObject();

                System.out.println(message);
                if (message.equals("byee"))
                sendMessage("Wosil");
        }
        catch(ClassNotFoundException classnot){
            System.err.println("Data received in unknown format");
        }
    }while(true);
}
catch(IOException ioException){
    ioException.printStackTrace();
}
finally{
    //4: Closing connection
    try{
        in.close();
        out.close();
        providerSocket.close();
    }
    catch(IOException ioException){
        ioException.printStackTrace();
    }
  }
}
void sendMessage(String msg)
{
    try{
        out.writeObject(msg);
        out.flush();
        System.out.println("Zame-Server>" + msg);
    }
    catch(IOException ioException){
        ioException.printStackTrace();
    }
}
public static void main(String args[])
{
    MultiJabberServer server = new MultiJabberServer();
    while(true){
        server.run();
        }
    }
}