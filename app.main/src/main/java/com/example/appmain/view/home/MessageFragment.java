package com.example.appmain.view.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.appmain.R;
import com.example.appmain.view.BaseFragment;


/**
 * @author: vision
 * @function: 消息Fragment
 * @date: 16/7/14
 */
public class MessageFragment extends BaseFragment implements OnClickListener {

    /**
     * UI
     */
    private View mContentView;
    private RelativeLayout mMessageLayout;
    private RelativeLayout mZanLayout;
    private RelativeLayout mImoocLayout;
    private TextView mTipView;
    private TextView mTipZanView;
    private TextView mTipMsgView;

    public MessageFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContentView = inflater.inflate(R.layout.fragment_message_layout, null, false);
        initView();
        return mContentView;
    }

    private void initView() {
        mMessageLayout = (RelativeLayout) mContentView.findViewById(R.id.message_layout);
        mImoocLayout = (RelativeLayout) mContentView.findViewById(R.id.imooc_layout);
        mZanLayout = (RelativeLayout) mContentView.findViewById(R.id.zan_layout);
        mTipView = (TextView) mContentView.findViewById(R.id.tip_view);
        mTipZanView = (TextView) mContentView.findViewById(R.id.zan_tip_view);
        mTipMsgView = (TextView) mContentView.findViewById(R.id.unread_tip_view);

        mImoocLayout.setOnClickListener(this);
        mZanLayout.setOnClickListener(this);
        mMessageLayout.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
    }
}
