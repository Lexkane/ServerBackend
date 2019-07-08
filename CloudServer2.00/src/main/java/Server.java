import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {

    private int port;
    private DatagramSocket socket=null;
    private Thread listen;
    private boolean running;

    public Server (int port){
        this.port=port;
    }

    public void start (){
        running=true;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        listen=new Thread(()->listen());
        listen.start();

    }

    public void process(){
    //socket.receive();
    }
    private void listen(){
        while (running){
            process();
        }
    }

    private void scale(){

    }
    private void recover(){

    }

    public void  send(byte [] data, InetAddress adress, int port){
            DatagramPacket packet= new DatagramPacket(data, data.length,adress,port);
        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
