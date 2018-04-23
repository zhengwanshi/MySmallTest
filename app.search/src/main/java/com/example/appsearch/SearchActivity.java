package com.example.appsearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author renzhiqiang
 * @description 产品搜索页面
 * @date 2017年5月19日
 */
public class SearchActivity extends AppCompatActivity
    implements OnClickListener, OnItemClickListener {
  private static final int MAX_HISTORY_RECORD = 10;
  /**
   * 公共UI
   */
  private EditText inputEditText;
  private TextView cancelView;
  /**
   * 历史记录相关UI
   */
  private TextView clearHistoryView;
  private LinearLayout historyLayout;
  private ListView historyListView;
  /**
   * 既没有历史纪绿，也没有开始搜索，空间面
   */
  private LinearLayout emptyLayout;
  /**
   * 正在搜索界面
   */
  private LinearLayout searchingLayout;
  private ListView searchingListView;
  private LinearLayout searchingEmptyLayout;
  private TextView searchNoView;

  /**
   * data
   */

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_layout);
    initView();
  }

  @Override protected void onResume() {
    super.onResume();
  }

  private void initView() {

    inputEditText = (EditText) findViewById(R.id.fund_search_view);
    cancelView = (TextView) findViewById(R.id.cancel_view);
    historyLayout = (LinearLayout) findViewById(R.id.fund_history_layout);
    clearHistoryView = (TextView) historyLayout.findViewById(R.id.delect_histroy_view);
    historyListView = (ListView) historyLayout.findViewById(R.id.history_list_view);
    historyListView.setOnItemClickListener(this);
    // 空间面View
    emptyLayout = (LinearLayout) findViewById(R.id.empty_layout);
    // 正在搜索View
    searchingLayout = (LinearLayout) findViewById(R.id.fund_search_layout);
    searchingListView = (ListView) searchingLayout.findViewById(R.id.fund_list_view);
    searchingEmptyLayout =
        (LinearLayout) searchingLayout.findViewById(R.id.fund_search_empty_layout);
    searchNoView = (TextView) searchingEmptyLayout.findViewById(R.id.seach_no_fund_info);
    searchingListView.setEmptyView(searchingEmptyLayout);
    searchingListView.setOnItemClickListener(this);
    cancelView.setOnClickListener(this);
    clearHistoryView.setOnClickListener(this);
    inputEditText.addTextChangedListener(watcher);

    decideWhichMode();
  }

  private TextWatcher watcher = new TextWatcher() {
    @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override public void afterTextChanged(Editable s) {
    }
  };

  @Override public void onClick(View v) {
    switch (v.getId()) {
      case R.id.cancel_view:
        finish();
        break;
      case R.id.delect_histroy_view:
        break;
    }
  }

  @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
  }

  /**
   * decide to which mode
   */
  private void decideWhichMode() {

  }
}