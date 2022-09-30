import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @ClassName LoginUser
 * @Descriptiron TODO
 * @Author lenovo
 * @Date 2022/6/15 22:05
 * @Version 1.0
 **/
public class LoginUser {
    private Socket client;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    public LoginUser(){
        try{
            client = new Socket("47.99.104.211",8080);
            System.out.println("a");
            FileInputStream is = new FileInputStream("D:\\code\\test2022041\\src\\1.txt");
            input = new ObjectInputStream(is);
            output = new ObjectOutputStream(client.getOutputStream());
            System.out.println("b");
            Object u = new Object();
            InputStream a = client.getInputStream();


            System.out.println(a);

            System.out.println("c");
        }catch (Exception e){
            System.out.println("连接服务器失败");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LoginUser();
    }


}
