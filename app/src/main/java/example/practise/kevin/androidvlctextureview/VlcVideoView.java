package example.practise.kevin.androidvlctextureview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.videolan.libvlc.LibVLC;

public class VlcVideoView extends FrameLayout {

    TextureVlc textureVlc;

    TextView status;

    public VlcVideoView(@NonNull Context context) {
        super(context);
        init();
    }

    public VlcVideoView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VlcVideoView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.video_viewholder, this, true);
        textureVlc = findViewById(R.id.texture);
        status = findViewById(R.id.status);
        textureVlc.setOnVideoStatusListener(new OnVideoStatusListener() {
            @Override
            public void onConnectFailed() {
                status.setText("FAILED");
            }

            @Override
            public void onConnectPrepared() {
                status.setText("CONNECTING");
            }

            @Override
            public void onStreamLived() {
                status.setText("LIVE");
            }

            @Override
            public void onStreamBuffering() {
                status.setText("BUFFERING");
            }
        });
    }

    public void setLibVlC(LibVLC libVlC) {
        this.textureVlc.setLibVlC(libVlC);
    }

    public void setAudio(boolean audio) {
        this.textureVlc.setAudio(audio);
    }

    public void setURL(String URL) {
        this.textureVlc.setURL(URL);
    }

    public interface OnVideoStatusListener{
        void onConnectFailed();
        void onConnectPrepared();
        void onStreamLived();
        void onStreamBuffering();
    }
}
