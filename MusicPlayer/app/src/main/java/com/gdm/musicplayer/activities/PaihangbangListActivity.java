package com.gdm.musicplayer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gdm.musicplayer.R;
import com.gdm.musicplayer.adapter.PHBListAdapter;
import com.gdm.musicplayer.bean.Music;
import com.gdm.musicplayer.bean.PaiHangBang;
import com.gdm.musicplayer.service.MyService;

import java.util.ArrayList;

public class PaihangbangListActivity extends AppCompatActivity {
    private ListView listView;
    private PaiHangBang paiHangBang;
    private PHBListAdapter adapter;
    private ArrayList<Music> musics=new ArrayList<>();
    private int[] imgs={R.drawable.bobolevel21,R.drawable.bobolevel22,R.drawable.bobolevel23};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paihangbang_list);
        getIntentData();
        initView();
        getData();
        setAdapter();
    }

    private void getData() {

    }

    private void setAdapter() {
        addHeader();
        adapter=new PHBListAdapter(PaihangbangListActivity.this,musics,imgs);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new MyItemListener());
    }

    private void addHeader() {
        View view = LayoutInflater.from(PaihangbangListActivity.this).inflate(R.layout.yinyuebang_header, null);
        ImageView imgBack= (ImageView) view.findViewById(R.id.img_bangdan_back);
        TextView bdName = (TextView) view.findViewById(R.id.tv_bangdan_name);
        RelativeLayout rlAdd= (RelativeLayout) view.findViewById(R.id.rl_phb_add);
        RelativeLayout rlLike= (RelativeLayout) view.findViewById(R.id.rl_phb_like);
        RelativeLayout rlShare= (RelativeLayout) view.findViewById(R.id.rl_phb_share);
        RelativeLayout rlDown= (RelativeLayout) view.findViewById(R.id.rl_phb_down);
        TextView tvAddCount = (TextView) view.findViewById(R.id.tv_bangdan_collect_count);
        TextView tvLikeCount = (TextView) view.findViewById(R.id.tv_bangdan_like_count);
        TextView tvShareCount = (TextView) view.findViewById(R.id.tv_bangdan_share_count);
        TextView tvDownCount = (TextView) view.findViewById(R.id.tv_bangdan_down_count);
        listView.addHeaderView(view);
    }

    private void initView() {
        listView= (ListView) findViewById(R.id.listview);
    }

    private void getIntentData() {
        paiHangBang= (PaiHangBang) getIntent().getSerializableExtra("data");
    }

    private class MyItemListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MyService.mAction);
            intent.putExtra("cmd","chose_pos");
            intent.putExtra("pos",position-1);
            intent.putExtra("data",musics);
            sendBroadcast(intent);

            Intent intent1 = new Intent(PaihangbangListActivity.this, PlayActivity.class);
            intent1.putExtra("data",musics);
            intent1.putExtra("position",position-1);
            intent1.putExtra("anim","start");
            startActivity(intent1);
            finish();

//            MyApplication ap= (MyApplication) getApplication();
//            ap.setMusics(list);

        }
    }
}