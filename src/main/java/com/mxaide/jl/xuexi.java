package com.mxaide.jl;
import android.app.*;
import android.content.*;
import android.os.*;
import android.support.v4.app.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;
import com.mxaide.jl.*;
import java.util.*;

import android.support.v4.app.Fragment;

public class xuexi
extends Fragment
{

	View view;
	ProgressDialog progressDialog;
ListView lv;
	public Handler mHandler=new Handler()  ;
	List<String> list = new ArrayList<String>();
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		
	
		View view =inflater.inflate(R.layout.xuexi,null);
lv=(ListView) view.findViewById(R.id.xuexiListView1);

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
			
	}


		return view;
		
	}
	class runn implements Runnable
	{

		@Override
		public void run()
		{
			list.add("基础教程");
			list.add("进阶教程");
			list.add("高级实战");

			lv.setOnItemClickListener(new OnItemClickListener(){

					@Override
					public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
					{
						if(list.get(p3).equals("基础教程")){
							Intent intent =new Intent(getActivity(), list.class);
						String jichu = "基础教程";
//                创建意图
							// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
							intent.putExtra("jichu",jichu);
							startActivity(intent);

						}
						else if(list.get(p3).equals("进阶教程")){
							Intent intent =new Intent(getActivity(), list.class);
							String  jichu= "进阶教程";
//                创建意图
							// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
							intent.putExtra("jichu",jichu);
							startActivity(intent);

						}
						else if(list.get(p3).equals("高级实战")){
							Intent intent =new Intent(getActivity(), list.class);
							String  jichu= "高级实战";
//                创建意图
							// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
							intent.putExtra("jichu",jichu);
							startActivity(intent);

						}
						
						
						
						
						
						
						
						
						// TODO: Implement this method
					}
				});
			lv.setAdapter(new MyListViewAdapter(list, R.layout.item,
												getActivity()));
			
				progressDialog.dismiss();
			//	Toast.makeText(getActivity(),"加载成功",3000).show();
			}		
			// TODO: Implement this method
		}

	
	}

