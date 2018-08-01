package example.practise.kevin.androidvlctextureview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.videolan.libvlc.LibVLC;

import java.util.ArrayList;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {

    private LibVLC libvlc;
    private Context context;

    List<String> urls = new ArrayList<>();
    private LayoutInflater mInflater;

    VideoAdapter(Context context, List<String> urls) {
        this.mInflater = LayoutInflater.from(context);
        this.urls = urls;
        this.context = context;
        configVLC();
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new VideoViewHolder(view, libvlc);
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        holder.bind(urls.get(position));
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    public void configVLC(){
        //新增vlc comment line 內碼
        ArrayList<String> options = new ArrayList<>();
//            options.add("--subsdec-encoding <encoding>");
//            options.add("--aout=opensles");
        options.add("--no-audio-time-stretch"); // time stretching
        options.add("-vvv"); // verbosity
        //options.add("--aout=none");

        options.add("--no-sub-autodetect-file");
        options.add("--swscale-mode=0");
        options.add("--network-caching=60000");
        options.add("--avcodec-hw=any");
//        options.add("--rtsp-mcast");
//        options.add("--rtsp-kasenna");
        options.add("--rtsp-tcp");
        options.add("--no-skip-frames");
        options.add("--no-drop-late-frames");
        options.add("--no-skip-frames");
        options.add("--http-continuous");
        options.add("--repeat");
        options.add("--loop");
        options.add("-R");
        options.add("--http-reconnect");
//            if (BuildConfig.DEBUG) {
//                options.add("-vvv"); // verbosity
//            }

        //new libVLC
        libvlc = new LibVLC(options);
//            libvlc = new LibVLC();
    }
}
