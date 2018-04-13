package com.fragment.even.setfragmentdemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.plus.PlusOneButton;

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * {@link PlusTwoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlusTwoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlusTwoFragment extends Fragment {
    private View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.fragment_plus_two, container, false);
        return mView;
    }
}
