package cn.kc.trainman_apply.server;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import cn.kc.trainman_apply.R;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFrame;

import java.util.List;
import java.util.Map;

/**
 * 作者： Abel .
 * 日期：2019/9/5
 * 说明：
 */
public class WsListener extends WebSocketAdapter {
    private Context mContext;
    private MediaPlayer mediaPlayer = null;

    public WsListener(Context context) {
        this.mContext = context;
    }

    @Override
    public void onTextMessage(WebSocket websocket, String text) throws Exception {
        super.onTextMessage(websocket, text);
        Log.e("msg", "接收数据=" + text);
        if (!text.isEmpty()) {
            videoPlay();
        }
    }

    /**
     * 播放提示声音
     */
    public void videoPlay() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(mContext, R.raw.msg);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.start();
                mediaPlayer.setLooping(true);
            }
        });
    }

    @Override
    public void onConnected(WebSocket websocket, Map<String, List<String>> headers)
            throws Exception {
        super.onConnected(websocket, headers);
        Log.e("msg", "连接成功");
    }

    @Override
    public void onConnectError(WebSocket websocket, WebSocketException exception)
            throws Exception {
        super.onConnectError(websocket, exception);
        Log.e("msg", "连接错误" + exception.getMessage());
    }

    @Override
    public void onDisconnected(WebSocket websocket, WebSocketFrame serverCloseFrame, WebSocketFrame clientCloseFrame, boolean closedByServer)
            throws Exception {
        super.onDisconnected(websocket, serverCloseFrame, clientCloseFrame, closedByServer);
        Log.e("msg", "断开连接");
    }

    public void exitThread() {
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}

