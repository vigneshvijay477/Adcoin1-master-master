package com.example.ramya.adkoin;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.facebook.accountkit.AccountKit;

/**
 * Created by ramya on 4/8/18.
 */

public class Bottomsheet extends BottomSheetDialogFragment {

    private BottomSheetListener mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bottomsheet, container, false);

        Button Invite_a_frd = v.findViewById(R.id.invite_a_frd);
        Button History = v.findViewById(R.id.history);
        Button Logout = v.findViewById(R.id.logout);

        Invite_a_frd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //mListener.onButtonClicked("Invite a frd clicked");
                dismiss();
            }
        });
        History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mListener.onButtonClicked("history clicked");
                dismiss();

            }
        });
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountKit.logOut();
                Intent intent = new Intent(getContext(), Success.class);
                startActivity(intent);
                //finish();

            }
        });

        return v;

    }




    public interface BottomSheetListener {

        void onButtonClicked(String text);
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        try {
//            mListener = (BottomSheetListener) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(mListener.toString() + "must implement bottom Sheet Listener");
//
//
//        }
//    }
}
