package com.mxaide.jl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.support.v4.app.*;
import android.view.*;
import android.os.*;
import android.app.*;
import android.support.v4.app.Fragment;

 public class gongju extends Fragment implements HttpGetDataListener,
		OnClickListener {
	View view;
	ProgressDialog progressDialog;
	private HttpData httpData;
	private List<ListData> lists;
	private ListView lv;
	private EditText sendtext;
	private Button send_btn;
	private String content_str;
	private TextAdapter adapter;
	private String[] welcome_array;
	private double currentTime=0, oldTime = 0;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{

		View view =inflater.inflate(R.layout.gongju,null);
		lv = (ListView) view.findViewById(R.id.lv);

		if(getView()==null){progressDialog = new ProgressDialog(getActivity());
			progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			progressDialog.setTitle("AIDE精灵");
			progressDialog.setMessage("加载中...");
			progressDialog.setCancelable(false); // 能够返回
			progressDialog.setCanceledOnTouchOutside(false); // 点击外部返回
			progressDialog.show();
			Handler a=new Handler();
			runn b=new runn();
			a.postDelayed(b,700);
		
		
		
		sendtext = (EditText) view.findViewById(R.id.sendText);
		send_btn = (Button) view.findViewById(R.id.send_btn);
			send_btn.setOnClickListener(this);
	
		}return view;
	}
	class runn implements Runnable
	{

		@Override
		public void run()
		{
			lists = new ArrayList<ListData>();
			
			adapter = new TextAdapter(lists, getActivity());
			lv.setAdapter(adapter);
			ListData listData;
			listData = new ListData(getRandomWelcomeTips(), ListData.RECEIVER,
									getTime());
			lists.add(listData);
			
	
			progressDialog.dismiss();
			//	Toast.makeText(getActivity(),"加载成功",3000).show();
		}		
		// TODO: Implement this method
	}
	

		


	private String getRandomWelcomeTips() {
		String welcome_tip = null;
		welcome_array = this.getResources()
				.getStringArray(R.array.welcome_tips);
		int index = (int) (Math.random() * (welcome_array.length - 1));
		welcome_tip = welcome_array[index];
		return welcome_tip;
	}

	@Override
	public void getDataUrl(String data) {
		// System.out.println(data);
		parseText(data);
	}

	public void parseText(String str) {
		try {
			JSONObject jb = new JSONObject(str);
			// System.out.println(jb.getString("code"));
			// System.out.println(jb.getString("text"));
			ListData listData;
			listData = new ListData(jb.getString("text"), ListData.RECEIVER,
					getTime());
			lists.add(listData);
			adapter.notifyDataSetChanged();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View v) {
		getTime();
		content_str = sendtext.getText().toString();
		sendtext.setText("");
		String dropk = content_str.replace(" ", "");
		String droph = dropk.replace("\n", "");
		ListData listData;
		listData = new ListData(content_str, ListData.SEND, getTime());
		lists.add(listData);
		if (lists.size() > 30) {
			for (int i = 0; i < lists.size(); i++) {
				lists.remove(i);
			}
		}
		adapter.notifyDataSetChanged();
		httpData = (HttpData) new HttpData(
				"http://www.tuling123.com/openapi/api?key=6af9822f5491fadfc142b53818bbd63a&info="
						+ droph, this).execute();
	}

	private String getTime() {
		currentTime = System.currentTimeMillis();
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		Date curDate = new Date();
		String str = format.format(curDate);
		if (currentTime - oldTime >= 500) {
			oldTime = currentTime;
			return str;
		} else {
			return "";
		}

	}
}
