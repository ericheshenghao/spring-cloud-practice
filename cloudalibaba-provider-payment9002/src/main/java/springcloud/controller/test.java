
import java.net.InetAddress;
import java.net.UnknownHostException;

public class test {
    public static void main(String[] args) throws UnknownHostException {
        String res =InetAddress.getLocalHost().getHostAddress();
        System.out.println(res);

    }


}
