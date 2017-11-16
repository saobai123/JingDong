package test.bwei.jingdong.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import test.bwei.jingdong.Api;
import test.bwei.jingdong.R;
import test.bwei.jingdong.activity.LoginActivity;
import test.bwei.jingdong.activity.PersonActivity;

/**
 * Created by 大白 on 2017/10/30.
 */

public class WoFragment extends Fragment {

    private ImageView img_login;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.wo_item, null);


        img_login = view.findViewById(R.id.img_login);
        img_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });


        ImageView set = view.findViewById(R.id.set);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PersonActivity.class);
                startActivity(intent);
            }
        });


        TextView name = view.findViewById(R.id.tv_name);
        String username = Api.preferences.getString("username", "");
        name.setText(username);




        return view;
    }
}
