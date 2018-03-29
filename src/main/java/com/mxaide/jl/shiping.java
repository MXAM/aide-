package com.mxaide.jl;
import android.app.*;
import android.os.*;
import android.support.v4.app.*;
import android.view.*;
import android.widget.*;
import java.util.*;

import android.support.v4.app.Fragment;
import android.widget.AdapterView.*;
import android.content.*;

public class shiping
extends Fragment
{
	ListView lv;

	View view;
	ProgressDialog progressDialog;
	List<String> list = new ArrayList<String>();
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{

		View view =inflater.inflate(R.layout.shiping,null);

	lv=(ListView) view.findViewById(R.id.shipingListView1);

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
			list.add("第一版");
			list.add("第二版");
			list.add("第三版");
			list.add("第四版");
			list.add("第五版");
			list.add("第六版");
			list.add("第七版");
			lv.setOnItemClickListener(new OnItemClickListener(){

					@Override
					public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
					{
						if(list.get(p3).equals("第一版")){
							Intent intent =new Intent(getActivity(), list.class);
							String jichu = "第一版";
//                创建意图
							// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
							intent.putExtra("jichu",jichu);
							startActivity(intent);

						}
						else if(list.get(p3).equals("第二版")){
							Intent intent =new Intent(getActivity(), list.class);
							String  jichu= "第二版";
//                创建意图
							// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
							intent.putExtra("jichu",jichu);
							startActivity(intent);

						}
						else if(list.get(p3).equals("第三版")){
							Intent intent =new Intent(getActivity(), list.class);
							String  jichu= "第三版";
//                创建意图
							// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
							intent.putExtra("jichu",jichu);
							startActivity(intent);

						}


						if(list.get(p3).equals("第四版")){
							Intent intent =new Intent(getActivity(), list.class);
							String jichu = "第四版";
//                创建意图
							// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
							intent.putExtra("jichu",jichu);
							startActivity(intent);

						}
						else if(list.get(p3).equals("第五版")){
							Intent intent =new Intent(getActivity(), list.class);
							String  jichu= "第五版";
//                创建意图
							// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
							intent.putExtra("jichu",jichu);
							startActivity(intent);

						}
						else if(list.get(p3).equals("第六版")){
							Intent intent =new Intent(getActivity(), list.class);
							String  jichu= "第六版";
//                创建意图
							// 通过putExtra来传递数据 arg1: 键:用于后面从intent中取值  arg2: 真正的数据
							intent.putExtra("jichu",jichu);
							startActivity(intent);

						}



						if(list.get(p3).equals("第七版")){
							Intent intent =new Intent(getActivity(), list.class);
							String jichu = "第七版";
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


