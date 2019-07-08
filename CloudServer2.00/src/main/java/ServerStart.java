import java.net.InetAddress;
import java.net.UnknownHostException;

public class ServerStart {

    public static void main(String ... args) {
        Server server= new Server(8889);
        server.start();

        InetAddress adress= null;
        try {
            InetAddress.getByName("198.224.43.11");
        } catch (UnknownHostException e) {


        }
        int port =9998;
        server.send( new byte[]{1,0,1},adress,port);

    }
}
