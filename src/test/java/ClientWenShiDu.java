import com.signv.utils.ByteUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientWenShiDu {

    /**
     * Socket客户端
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        Socket socket= null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        try {
            //创建Socket对象
            socket = new Socket("47.106.128.44",8877);
//            socket = new Socket("127.0.0.1",8877);



        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] data = new byte[9];
        data[0] = (byte) 0xBB;
        data[1] = (byte) 0x01;
        data[2] = (byte) 0x03;
        data[3] = (byte) 0x03;

        data[4] = (byte) 0x00;
        data[5] = (byte) 0x33;
        data[6] = (byte) 0x66;

        data[7] = (byte) 0x60;
        data[8] = (byte) 0x7E;
//        String message = new String("BB037E".getBytes());
        int i = 0;
        outputStream=socket.getOutputStream();//获取一个输出流，向服务端发送信息
        InputStream inputStream=socket.getInputStream();//获取一个输入流，接收服务端的信息
        byte[] serverInfo1 = new byte[128];
//        while (i<10){
            outputStream.write(data);
//            int x = i+1;
//            System.out.println("第"+ x + "次发送");
//            i++;
            new Thread().sleep(6000);
        inputStream.read(serverInfo1);
        String info1 = ByteUtils.byte2hex(serverInfo1);
        System.out.println(info1);
//        }
        System.out.println("发送数据完成！");
//        while (i < 7){
//            //根据输入输出流和服务端连接
////            printWriter=new PrintWriter(outputStream);//将输出流包装成打印流
////            printWriter=new PrintWriter(new DataOutputStream(outputStream));//将输出流包装成打印流
//            if(i == 6){
////                    printWriter.write(data[i]);
//                outputStream.write(data[i]);
//                int x = i+1;
//                    System.out.println("发送了" + x +"次");
//                System.out.println("客户端发送信息结束！");
//                }else {
//                outputStream.write(data[i]);
////                    printWriter.write(data[i]);
//                    int x = i+1;
//                    System.out.println("发送了" + x + "次");
//                    System.out.println("socket客户端已发送信息！");
//                }
//            outputStream.flush();
//            i++;
//        }


        try {
            socket.shutdownOutput();
//            InputStream inputStream=socket.getInputStream();//获取一个输入流，接收服务端的信息
//            byte[] serverInfo1 = new byte[128];
//            inputStream.read(serverInfo1);
//            String info1 = ByteUtils.byte2hex(serverInfo1);
//            System.out.println(info1);
//            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);//包装成字符流，提高效率
//            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);//缓冲区
//            String info="";
//            String temp=null;//临时变量
//            while((temp=bufferedReader.readLine())!=null){
//                info+=temp;
//                System.out.println("客户端接收服务端发送信息："+info);
//            }
            System.out.println("客户端socket通信已完成！");
            //关闭相对应的资源
//            printWriter.close();
            outputStream.close();

//            bufferedReader.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}