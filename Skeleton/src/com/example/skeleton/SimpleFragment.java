package com.example.skeleton;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class SimpleFragment extends Fragment {

    String text;

    public SimpleFragment(String string) {
        text = string;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment, container, false);
        TextView textview = (TextView) root.findViewById(R.id.textView1);
        textview.setText(text);
        return root;
    }

}