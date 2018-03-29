package com.mxaide.jl;
import android.app.*;
import android.os.*;
import android.support.v7.app.*;
import android.content.*;
import android.util.*;
import android.widget.*;
import java.util.*;
import android.widget.AdapterView.*;
import android.view.*;

public class list extends AppCompatActivity
{
	private ListView lv;
	

	List<String> list = new ArrayList<String>();
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
		lv=(ListView) findViewById(R.id.listListView1);
	
		Intent intent = getIntent();
        // 通过intent 调用getStringExtra()方法,传入对应的键名,就可以得到对应的数据
        /*
		 *   如果传递的是字符串数据: 使用  getStringExtra();
		 *               整形数据:  getIntExtra();
		 *               布尔类型:  getBooleanExtra();
		 *
		 * */
        String jichu = intent.getStringExtra("jichu");
        if(jichu.equals("基础教程")){
			list.add("1.前言");
			list.add("2.工具的准备");
			list.add("3.了解AIDE");
			list.add("4.我们的第一个Android程序");
			list.add("5.项目文件的组成以及Activity");
			list.add("5.5.AIDE的复制粘贴");
			list.add("6.新建一个Activity");
			list.add("7.构建一个简单的用户界面");
			list.add("8.获取组建以及设置组建属性");
			list.add("9.一个简单的点击事件");
			list.add("10.初识intent");
			list.add("11.距离单位的了解");
			list.add("12.简单了解imageview");
			list.add("13.Toast介绍及小练习");
					}
		if(jichu.equals("进阶教程")){
			list.add("14.intent2 Activity之间数据传输");
			list.add("15.if语句介绍");
			list.add("16.Progressbar介绍");
			list.add("17.OptionsMenu介绍");
			list.add("18.Checkbox介绍");
			list.add("19.RadioGroup和RadioButton的介绍");
			
		}
		if(jichu.equals("高级实战")){
			list.add("哈哈哈哈，我是高级实战");
			list.add("略略略");
		}

		if(jichu.equals("第一版")){
			list.add("哈哈哈哈，我是高级实战");
			list.add("略略略");
		}
		

		if(jichu.equals("第二版")){
			list.add("1.AIDE使用方法");
			list.add("2.安卓软件的构成");
			list.add("3.main文件介绍");
			list.add("4.单机事件");
			list.add("5.Toast消息");
			list.add("6.使用MediaPlayer播放音乐");
			list.add("7.ListView的使用");
			list.add("8.菜单的使用方法");
			list.add("9.简单布局跳转");
			list.add("10.Intent初步");
			list.add("11.Intent数据传递");
			list.add("12.虚拟返回事件");
			list.add("13.对话框(dialog)的使用");
			list.add("14.Handler初步");
			list.add("15.HandlerMessage");
			list.add("16.线程(Thread)的使用");
			list.add("17.webview(1)");
			list.add("18.webview(2)");
			list.add("19.webview(3)");
			list.add("20.webview(4)");
			
			
			
			
			
		}
		if(jichu.equals("第三版")){
			list.add("A.LogCat调试(1)");
			list.add("B.LogCat调试(2)");
			list.add("C.进程杀死");
			list.add("D.MediaPlayer播放sd卡音乐");
			list.add("E.VideoView播放sd视频");
			list.add("F.http协议");
			list.add("F.http协议续集");
			list.add("G.Android取标题,全屏");
			list.add("H.Activity初步");
			list.add("I.Activity生命周期");
			list.add("J.Service生命周期");
			list.add("K.BroadcastReceiver");
			list.add("L.Intent两种启动");
			
			
			
		}
		if(jichu.equals("第四版")){
			list.add("A1.NDK编程");
			list.add("A2.发短信");
			list.add("A3.抓包分析");
			list.add("A4.Terminal IDE使用方法");
		
			
			
			
			
			
		}
		if(jichu.equals("第五版")){
			list.add("1.NDK-jni接口");
			list.add("2.类库使用_get方法");
			list.add("3.类库使用post提交");
			list.add("4.类库总结");

			
			
			
		}
		if(jichu.equals("第六版")){
			list.add("1.Linux命令");
			list.add("2.Linux命令");
			list.add("3.Linux命令");
			list.add("4.Runtime类-1");
			list.add("5.Runtime类-2");
			list.add("6.NDK执行命令");
			
			
			
			
			
			
		}
		if(jichu.equals("第七版")){
			list.add("1.网页POST");
			list.add("2.安卓POST");
			list.add("1.封包环境配置");
			list.add("2.封包环境配置");
			list.add("3.封包实战");
			list.add("4.封包测试");
			list.add("5.javadoc建立封包帮助文档");
			list.add("6.AutoCometeTextView使用");
			list.add("7.TabHost标签");
			list.add("8.assets资源文件操作");
			list.add("9.res资源文件操作");
		
			
			
			
		}
		lv.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
				{
					if(list.get(p3).equals("1.前言")){
		
						Intent intent =new Intent(list.this, webview.class);
						String wjlj ="file:///mnt/sdcard/mx/1.sh";
//                创建意图
						// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
						intent.putExtra("wjlj",wjlj);

						startActivity(intent);
	}
					else if(list.get(p3).equals("2.工具的准备")){

						Intent intent =new Intent(list.this, webview.class);
						String wjlj = "file:///mnt/sdcard/mx/2.html";
//                创建意图
						// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
						intent.putExtra("wjlj",wjlj);

						startActivity(intent);
}

					else if(list.get(p3).equals("3.了解AIDE")){

						Intent intent =new Intent(list.this, webview.class);
						String wjlj ="file:///mnt/sdcard/mx/3.html";
//                创建意图
						// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
						intent.putExtra("wjlj",wjlj);

						startActivity(intent);

					}
					else if(list.get(p3).equals("4.我们的第一个Android程序")){

						Intent intent =new Intent(list.this, webview.class);
						String wjlj = "file:///mnt/sdcard/mx/4.html";
//                创建意图
						// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
						intent.putExtra("wjlj",wjlj);

						startActivity(intent);

					}
					else if(list.get(p3).equals("5.项目文件的组成以及Activity")){

						Intent intent =new Intent(list.this, webview.class);
						String wjlj = "file:///mnt/sdcard/mx/5.html";
//                创建意图
						// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
						intent.putExtra("wjlj",wjlj);

						startActivity(intent);

					}
					else if(list.get(p3).equals("5.5.AIDE的复制粘贴")){

						Intent intent =new Intent(list.this, webview.class);
						String wjlj = "file:///mnt/sdcard/mx/5.5.html";
//                创建意图
						// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
						intent.putExtra("wjlj",wjlj);

						startActivity(intent);

					}
					else if(list.get(p3).equals("6.新建一个Activity")){

						Intent intent =new Intent(list.this, webview.class);
						String wjlj = "/storage/emulated/0/mx/6.html";
//                创建意图
						// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
						intent.putExtra("wjlj",wjlj);

						startActivity(intent);

					}
					else if(list.get(p3).equals("7.构建一个简单的用户界面")){

						Intent intent =new Intent(list.this, webview.class);
						String wjlj ="/storage/emulated/0/mx/7.html";
//                创建意图
						// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
						intent.putExtra("wjlj",wjlj);

						startActivity(intent);

					}
					else if(list.get(p3).equals("8.获取组建以及设置组建属性")){

						Intent intent =new Intent(list.this, webview.class);
						String wjlj = "/storage/emulated/0/mx/8.html";
//                创建意图
						// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
						intent.putExtra("wjlj",wjlj);

						startActivity(intent);

					}
					else if(list.get(p3).equals("9.一个简单的点击事件")){

						Intent intent =new Intent(list.this, webview.class);
						String wjlj = "/storage/emulated/0/mx/9.html";
//                创建意图
						// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
						intent.putExtra("wjlj",wjlj);

						startActivity(intent);

					}
					else if(list.get(p3).equals("10.初识intent")){

						Intent intent =new Intent(list.this, webview.class);
						String wjlj = "/storage/emulated/0/mx/10.html";
//                创建意图
						// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
						intent.putExtra("wjlj",wjlj);

						startActivity(intent);

					}
					else if(list.get(p3).equals("11.距离单位的了解")){

						Intent intent =new Intent(list.this, webview.class);
						String wjlj = "/storage/emulated/0/mx/11.html";
//                创建意图
						// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
						intent.putExtra("wjlj",wjlj);

						startActivity(intent);

					}
					else if(list.get(p3).equals("12.简单了解imageview")){

						Intent intent =new Intent(list.this, webview.class);
						String wjlj = "/storage/emulated/0/mx/12.html";
//                创建意图
						// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
						intent.putExtra("wjlj",wjlj);

						startActivity(intent);

					}
					else if(list.get(p3).equals("13.Toast介绍及小练习")){

						Intent intent =new Intent(list.this, webview.class);
						String wjlj = "/storage/emulated/0/mx/13.html";
//                创建意图
						// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
						intent.putExtra("wjlj",wjlj);

						startActivity(intent);

					}



}

}
);
		lv.setAdapter(new mylist2adapter(list, R.layout.item2,
										 list.this));


}




}
