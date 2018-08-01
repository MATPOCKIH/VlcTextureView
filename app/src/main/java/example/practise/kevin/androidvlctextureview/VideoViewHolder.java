package example.practise.kevin.androidvlctextureview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.videolan.libvlc.LibVLC;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    private LibVLC libVLC;
    private VlcVideoView vlcVideoView;

    public VideoViewHolder(View itemView, LibVLC libvlc) {
        super(itemView);
        this.vlcVideoView = itemView.findViewById(R.id.videoView);
        this.libVLC = libvlc;
    }

    public void bind(String url) {
        vlcVideoView.setLibVlC(libVLC);
        vlcVideoView.setAudio(false);
        vlcVideoView.setURL(url);
    }
}
