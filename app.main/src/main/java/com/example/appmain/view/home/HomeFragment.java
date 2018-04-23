package com.example.appmain.view.home;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appmain.R;
import com.example.appmain.view.BaseFragment;

import net.wequick.small.Small;

/**
 * *******************************************************
 *
 * @文件名称：HomeFragment.java
 * @文件作者：renzhiqiang
 * @创建时间：2015年10月2日 下午2:56:50
 * @文件描述：完全是普通的Fragment
 * @修改历史：2015年10月2日创建初始版本 ********************************************************
 */
public class HomeFragment extends BaseFragment
    implements View.OnClickListener, AdapterView.OnItemClickListener {

  private static final int REQUEST_QRCODE = 0x01;
  /**
   * UI
   */
  private View mContentView;
  private ListView mListView;
  private TextView mQRCodeView;
  private TextView mCategoryView;
  private TextView mSearchView;
  private ImageView mLoadingView;

  public HomeFragment() {
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    mContext = getActivity();
    mContentView = inflater.inflate(R.layout.fragment_home_layout, container, false);
    initView();
    return mContentView;
  }

  private void initView() {
    mQRCodeView = (TextView) mContentView.findViewById(R.id.qrcode_view);
    mQRCodeView.setOnClickListener(this);
    mCategoryView = (TextView) mContentView.findViewById(R.id.category_view);
    mCategoryView.setOnClickListener(this);
    mSearchView = (TextView) mContentView.findViewById(R.id.search_view);
    mSearchView.setOnClickListener(this);
    mListView = (ListView) mContentView.findViewById(R.id.list_view);
    mListView.setOnItemClickListener(this);
    mLoadingView = (ImageView) mContentView.findViewById(R.id.loading_view);
    AnimationDrawable anim = (AnimationDrawable) mLoadingView.getDrawable();
    anim.start();
  }

  @Override public void onClick(View v) {
    switch (v.getId()) {
      case R.id.search_view:
        Small.setUp(getActivity(), new Small.OnCompleteListener() {
          @Override
          public void onComplete() {
            Small.openUri("search", getActivity());
          }
        });
        break;
    }
  }

  @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
  }
}