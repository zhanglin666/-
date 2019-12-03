package cn.kc.trainman_apply.server;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 作者： Abel .
 * 日期：2019/10/14
 * 说明：测试程序  socket链接
 */
public class SocketServerText extends AppCompatActivity {

    private void getServer(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Socket socket = new Socket("192.168.1.103", 9080);
                    OutputStream os = socket.getOutputStream();
                    String s1 = new String("这里是你要发送到服务端的数据".getBytes(),"UTF-8");
                    os.write(s1.getBytes());
                    os.flush();
                    socket.shutdownOutput();
                    InputStream is = socket.getInputStream();
                    int lenght = 0;
                    byte[] buff = new byte[1024];
                    final StringBuffer sb = new StringBuffer();
                    while((lenght = is.read(buff)) != -1){
                        sb.append(new String(buff,0,lenght,"UTF-8"));
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //这里更新UI
                        }
                    });
                    //3、关闭IO资源（注：实际开发中需要放到finally中）
                    is.close();
                    os.close();
                    socket.close();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {

                }
            }
        }.start();
    }
}
