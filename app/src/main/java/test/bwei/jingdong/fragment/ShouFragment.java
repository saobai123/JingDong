package test.bwei.jingdong.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import test.bwei.jingdong.R;
import test.bwei.jingdong.activity.FandActivity;
import test.bwei.jingdong.adapter.ShowAdapter;

/**
 * Created by 大白 on 2017/10/30.
 */

public class ShouFragment extends Fragment {

    private ImageView yuyin;
    private View view;
    private RecyclerView recycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.shou_item, null);

        initView();



        return view;
    }

    private void initView() {


        recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        ShowAdapter adapter =new ShowAdapter(getActivity());
        recycler.setAdapter(adapter);


        ImageView img_find = view.findViewById(R.id.img_find);
        img_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FandActivity.class);
                startActivity(intent);
            }
        });


    }


}
