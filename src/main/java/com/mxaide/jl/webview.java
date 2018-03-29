package com.mxaide.jl;
import android.app.*;
import android.os.*;
import android.webkit.*;
import android.support.v7.app.*;
import android.content.*;

public class webview extends AppCompatActivity
{ 
WebView wb;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
	wb=(WebView) findViewById(R.id.webviewwebView1);
	
	//声明WebSettings子类
	WebSettings webSettings = wb.getSettings();

//如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
	webSettings.setJavaScriptEnabled(true);  

//支持插件
	//webSettings.setPluginsEnabled(true); 

//设置自适应屏幕，两者合用
	webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小 
	webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
	webSettings.setSupportZoom(true);
	webSettings.setBuiltInZoomControls(true);
	webSettings.setDisplayZoomControls(false);
	
	
	
	webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存 
	webSettings.setAllowFileAccess(true); //设置可以访问文件 
	webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口 
	webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
	webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
	Intent intent = getIntent();
	// 通过intent 调用getStringExtra()方法,传入对应的键名,就可以得到对应的数据
	/*
	 *   如果传递的是字符串数据: 使用  getStringExtra();
	 *               整形数据:  getIntExtra();
	 *               布尔类型:  getBooleanExtra();
	 *
	 * */
	String wjlj = intent.getStringExtra("wjlj");
	//优先使用缓存: 
    wb.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); 
	//缓存模式如下：
	//LOAD_CACHE_ONLY: 不使用网络，只读取本地缓存数据
	//LOAD_DEFAULT: （默认）根据cache-control决定是否从网络上取数据。
	//LOAD_NO_CACHE: 不使用缓存，只从网络获取数据.
	//LOAD_CACHE_ELSE_NETWORK，只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据。
	//方式2：加载apk包中的html页面
	wb.loadUrl(wjlj);
	
	
	
}


}
