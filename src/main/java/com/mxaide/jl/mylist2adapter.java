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
public class mylist2adapter extends BaseAdapter implements ListAdapter {
	private List<String> data;
	private int layout;
	private Context context2;
	private ImageView iv = null;
	private TextView tv = null;

	public mylist2adapter(List<String> data, int layout, Context context) {
		this.data = data;
		this.layout = layout;
		this.context2 = context;

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
			view = LayoutInflater.from(context2).inflate(layout, null);
			iv = (ImageView) view.findViewById(R.id.item2ImageView1);
			tv = (TextView) view.findViewById(R.id.item2TextView1);

			view.setTag(new ObjectClass(iv, tv));

		} else {
			ObjectClass objectclass = (ObjectClass) view.getTag();
			iv = objectclass.iv;
			tv = objectclass.text;

		}
		//if (data.get(arg0).equals("成功了，你妹的"))
			//iv.setImageResource(R.drawable.biu);

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
