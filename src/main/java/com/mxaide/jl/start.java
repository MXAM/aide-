package com.mxaide.jl;
import android.app.*;
import android.os.*;
import android.view.*;
import android.content.*;
import android.widget.*;
import java.io.*;
import android.view.View.*;
import android.util.*;
import android.content.DialogInterface.OnClickListener;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.io.File;



public class start extends Activity
{	public static final String ROOT_DIR = "/mnt/sdcard/mx";
	private final String TAG="MainActivity";
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
		String SHARE_APP_TAG = "阿淼";
		SharedPreferences setting = getSharedPreferences(SHARE_APP_TAG, 0);  
		Boolean user_first = setting.getBoolean("FIRST", true);  
		if(user_first){//第一次  
			setting.edit().putBoolean("FIRST", false).commit();  
			Toast.makeText(start.this, "第一次", Toast.LENGTH_LONG).show();  
			showDownLoadDialog();

			mopo();
		}else{  
			Toast.makeText(start.this, "不是第一次", Toast.LENGTH_LONG).show();  

			new Handler().postDelayed(new Runnable() {
					public void run() {
						Intent qs = new Intent(start.this,
											   MainActivity.class);
						start.this.startActivity(qs);
						start.this.finish();
					}
				},2000);
				}  
		

    }
	private boolean mopo() {
		String status = Environment.getExternalStorageState();
		if (status.equals(Environment.MEDIA_MOUNTED)) {
			file();
			return true;
		} else {
			new AlertDialog.Builder(start.this).setTitle("提示:")
				.setMessage("非常抱歉！\n您不能正常使用本软件，可能是以下原因所导致。\n⒈未检测到你手机里的存储卡设备。\n⒉软件经过其他人所修改导致安装文件时出错。\n\n按确定退出本软件！ ").setIcon(R.drawable.ic_launcher)
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						finish();
					}

				}).show();
		}

		return false;
	}

    /**
     * 创建文件夹
     */
	private void file() {
		File destDir = new File(ROOT_DIR);
		if (!destDir.exists()) {
			destDir.mkdirs();
		}
	}

	private void showDownLoadDialog(){
		new AlertDialog.Builder(this).setTitle("Aide精灵")
			.setMessage("首次加载需耗费5.23MB数据，是否继续")
			.setPositiveButton("是", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.d(TAG, "onClick 1 = "+which);
					doDownLoadWork();
				}
			})
			.setNegativeButton("否", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.d(TAG, "onClick 2 = "+which);
				}
			})
			.show();
	}

	public void showUnzipDialog(){
		new AlertDialog.Builder(this).setTitle("Aide精灵")
			.setMessage("是否继续?")
			.setPositiveButton("是", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.d(TAG, "onClick 1 = "+which);
					doZipExtractorWork();
				}
			})
			.setNegativeButton("否", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
				
				}
			})
			.show();
	}

	public void doZipExtractorWork(){
		//File oleFile = new File("/sdcard/mx/4b9c6d449f85e61a29ce76ece60a1e95.zip?st=OfvaB0WAhYgD273sOkhlSw&q=dem.zip&e=1522255257&ip=139.207.114.196&fi=2962339&up=" ); //要重命名的文件或文件夹
		//File newFile = new File("/sdcard/mx/mx.zip"); //重命名为zhidian1
		//	oleFile.renameTo(newFile); //执行重命名


		ZipExtractorTask task = new ZipExtractorTask("/mnt/sdcard/mx/4b9c6d449f85e61a29ce76ece60a1e95.zip?st=OfvaB0WAhYgD273sOkhlSw&q=dem.zip&e=1522255257&ip=139.207.114.196&fi=2962339&up=", "/mnt/sdcard/mx/", this, true);
		task.execute();
		new Handler().postDelayed(new Runnable() {
				public void run() {
					Intent qs = new Intent(start.this,
										   MainActivity.class);
					start.this.startActivity(qs);
					start.this.finish();
				}
			},2500);
	}

	private void doDownLoadWork(){
		DownLoaderTask task = new DownLoaderTask("https://development49.baidupan.com/2018032900bb/2018/03/28/4b9c6d449f85e61a29ce76ece60a1e95.zip?st=OfvaB0WAhYgD273sOkhlSw&q=dem.zip&e=1522255257&ip=139.207.114.196&fi=2962339&up=", "/mnt/sdcard/mx/", this);
		task.execute();
	}
	
}
