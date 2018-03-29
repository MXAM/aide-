package com.mxaide.jl;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.*;
import android.graphics.*;

/**
 * @author Bri
 *@param data 用于动态添加字符的list数据集
 *@param context 上下文
 *@param layout 添加在listview中的布局
 */
public class MyListViewAdapter extends BaseAdapter implements ListAdapter {
	private List<String> data;
	private int layout;
	private Context context;
	private ImageView iv = null;
	private TextView tv = null;

	public MyListViewAdapter(List<String> data, int layout, Context context) {
		this.data = data;
		this.layout = layout;
		this.context = context;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return data.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View view, ViewGroup arg2) {
		if (view == null) {
			view = LayoutInflater.from(context).inflate(layout, null);
			iv = (ImageView) view.findViewById(R.id.iv);
			tv = (TextView) view.findViewById(R.id.tv);

			view.setTag(new ObjectClass(iv, tv));

		} else {
			ObjectClass objectclass = (ObjectClass) view.getTag();
			iv = objectclass.iv;
			tv = objectclass.text;

		}
		if (data.get(arg0).equals("基础教程"))
			iv.setImageResource(R.drawable.a1);
		else if (data.get(arg0).equals("进阶教程"))
			iv.setImageResource(R.drawable.a2);
		else if (data.get(arg0).equals("高级实战"))
			iv.setImageResource(R.drawable.a3);
		else if (data.get(arg0).equals("第一版"))
			iv.setImageResource(R.drawable.b1);
		else if (data.get(arg0).equals("第二版"))
			iv.setImageResource(R.drawable.b2);
		else if (data.get(arg0).equals("第三版"))
			iv.setImageResource(R.drawable.b3);
		else if (data.get(arg0).equals("第四版"))
			iv.setImageResource(R.drawable.b4);
		else if (data.get(arg0).equals("第五版"))
			iv.setImageResource(R.drawable.b5);
			
		else if (data.get(arg0).equals("第六版"))
			iv.setImageResource(R.drawable.b6);
		
		else if (data.get(arg0).equals("第七版"))
			iv.setImageResource(R.drawable.b7);
		
			
		tv.setText(data.get(arg0));
		return view;
	}

	private final class ObjectClass {

		ImageView iv = null;
		TextView text = null;

		public ObjectClass(ImageView iv, TextView text) {
			this.iv = iv;
			this.text = text;
		}
	}

}
