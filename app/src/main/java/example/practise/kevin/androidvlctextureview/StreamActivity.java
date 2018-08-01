package example.practise.kevin.androidvlctextureview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class StreamActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> urls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        String URL = "rtsp://admin:12345678q@145.255.18.220:554/ISAPI/Streaming/channels/101";


        fillData();

        recyclerView = findViewById(R.id.recycler);
        //initLayout(URL);
        VideoAdapter adapter = new VideoAdapter(this, urls);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    private void fillData() {
        urls.add("rtsp://admin:12345678q@145.255.18.220:554/ISAPI/Streaming/channels/101");
        urls.add("rtsp://admin:12345678q@145.255.18.218:554/chID=00000003-0000-0000-0000-000000000000&streamType=main&linkType=tcp");
        urls.add("rtsp://admin:12345678q@145.255.18.220:554/ISAPI/Streaming/channels/301");
        urls.add("rtsp://admin:12345678q@145.255.18.220:554/ISAPI/Streaming/channels/201");
        urls.add("rtsp://admin:12345678q@145.255.18.218:554/chID=00000001-0000-0000-0000-000000000000&streamType=main&linkType=tcp");
        urls.add("rtsp://admin:12345678q@145.255.18.220:554/ISAPI/Streaming/channels/401");

    }


    private void initLayout(String url) {

        //new VLC
        // textureView = new TextureVlc(this);
        //textureView.setAudio(false);
        //textureView.setURL(url);

       /* RelativeLayout.LayoutParams textureView_params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        textureView_params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        textureView.setLayoutParams(textureView_params);
*/
        /*
        //outer layout
        RelativeLayout outer = new RelativeLayout(this);
        outer.setId(R.id.outer);
        RelativeLayout.LayoutParams outer_params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        outer_params.addRule(RelativeLayout.CENTER_IN_PARENT,RelativeLayout.TRUE);
        outer.addView(textureView);
        outer.setBackgroundColor(Color.BLACK);
        setContentView(outer, outer_params);
        */


    }

    @Override
    protected void onPause() {
        super.onPause();
       // if (textureView != null) textureView.releasePlayer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // if (textureView != null) textureView.releasePlayer();
    }
}
