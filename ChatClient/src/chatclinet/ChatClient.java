package chatclinet;
import java.io.*;
import java.net.*;

/**
 * Created by LiuToTo.365ime on 16/9/22.
 */
public class ChatClient {
    public  static  void  chat(){
        try{
            System.out.print("begin");
            Socket socket = new Socket("127.0.0.1",4700);
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

            PrintWriter socketWriter = new PrintWriter(socket.getOutputStream());

            BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String serverMessage;

            String myMessage;

            do {

                myMessage  = reader.readLine() +"\n";

                socketWriter.println(myMessage);
                socketWriter.flush();
                System.out.print("myMessage:"+myMessage);

                serverMessage = socketReader.readLine();

                System.out.print("server:"+serverMessage);
            }
            while (!serverMessage.equals("over"));
            reader.close();
            socketReader.close();
            socketWriter.close();
            socket.close();
        }catch (Exception e){

            System.out.print(e);
        }
    }
}
