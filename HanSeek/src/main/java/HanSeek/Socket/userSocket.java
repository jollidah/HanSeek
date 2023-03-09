package HanSeek.Socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class userSocket {

    public static class SocketClient {
        public static void main(String[] args) {
            BufferedReader in = null; // 데이터를 읽어들이기 위한 입력스트림
            BufferedWriter out = null; // 서버로 내보내기 위한 출력 스트림
            InetAddress ia = null;

            boolean keep_connection = true;
            int port = 9999;


            try{
                ia = InetAddress.getLocalHost();
                Socket socket = new Socket(ia, port);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // BufferedReader 선언
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 이하 동문
                while(keep_connection){

                }


            } catch (IOException e) {
                System.out.println("IOException at Socket");
                e.printStackTrace();
            }
        }
    }
}
