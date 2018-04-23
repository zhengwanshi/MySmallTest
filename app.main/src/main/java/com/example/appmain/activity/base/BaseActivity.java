package com.example.appmain.activity.base;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.appmain.util.StatusBarUtil;


/**
 * @author: qndroid
 * @function: 所有Activity的基类，用来处理一些公共事件，如：数据统计
 * @date: 16/3/10
 */
public abstract class BaseActivity extends AppCompatActivity {

  public String TAG;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initUmeng();
    reverseStatusColor();
  }

  /**
   * 初始化友盟统计
   */
  private void initUmeng() {
    TAG = getComponentName().getShortClassName();
  }

  @Override protected void onResume() {
    super.onResume();
  }

  @Override protected void onStart() {
    super.onStart();
  }

  @Override protected void onPause() {
    super.onPause();
  }

  @Override protected void onStop() {
    super.onStop();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
  }

  /**
   * 整个android系统内存不足时,系统回调此方法,在此释放一些不必要的资源
   * 例如:缓存图片
   *
   * @param level 标志当前应用被回收的可能性,数值越大表示越容易被回收，最大值为80时,被回收的可能性最大。
   */
  @Override public void onTrimMemory(int level) {
    super.onTrimMemory(level);
  }

  /**
   * 申请指定的权限.
   */
  public void requestPermission(int code, String... permissions) {

    ActivityCompat.requestPermissions(this, permissions, code);
  }

  /**
   * 判断是否有指定的权限
   */
  public boolean hasPermission(String... permissions) {

    for (String permisson : permissions) {
      if (ContextCompat.checkSelfPermission(this, permisson) != PackageManager.PERMISSION_GRANTED) {
        return false;
      }
    }
    return true;
  }

  /**
   * 隐藏状态栏
   */
  public void hiddenStatusBar() {
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
  }

  /**
   * 改变状态栏颜色
   */
  public void changeStatusBarColor(@ColorRes int color) {
    StatusBarUtil.setStatusBarColor(this, color);
  }

  /**
   * 调整状态栏为亮模式，这样状态栏的文字颜色就为深模式了。
   */
  private void reverseStatusColor() {
    StatusBarUtil.statusBarLightMode(this);
  }
}
