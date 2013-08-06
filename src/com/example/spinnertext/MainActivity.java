package com.example.spinnertext;

import java.util.ArrayList;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity {

	// 所有资源的图片(足球、篮球、排球) id的数组
	int[] drawableIds = { R.drawable.football, R.drawable.basketball,R.drawable.volleyball ,R.drawable.volleyball};
	// 所有资源字符串 (足球、篮球、排球) id的数组
	int[] msgIds = { R.string.zp, R.string.lq, R.string.pq };
	//模拟文字改变
	private ArrayList<String> text = null;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//这用来设计抽取数据库中的数据来填写下面的列表
		text = new ArrayList<String>();
		text.add(0, "请选择");
		text.add(1, "足球001");
		text.add(2, "篮球002");
		text.add(3, "排球003");
		Spinner sp = (Spinner) findViewById(R.id.Spinner01);
		//创建适配器
		BaseAdapter ba = new BaseAdapter() {
		
			public int getCount() {
				// 一共三个选项
				return text.size();
			}
		
			public Object getItem(int position) {
				return null;
			}
		
			public long getItemId(int position) {
				return 0;
			}
			//此函数是用来显示item中的添加资源的
			@SuppressLint("ResourceAsColor")
			public View getView(int position, View convertView, ViewGroup parent) {
				// 动态生成每个下拉项对应的View，每个下拉项View由LinearLayout
				// 中包含一个ImageView及一个TextView构成
				// 初始化LinearLayout
				LinearLayout ll = new LinearLayout(MainActivity.this);
				//设置列间距
				ll.setOrientation(LinearLayout.HORIZONTAL);
				// 初始化ImageView
				ImageView ii = new ImageView(MainActivity.this);
				//设置需要显示的图片
				ii.setImageDrawable((getResources().getDrawable(drawableIds[position])));
				//将图片的显示区域添加到布局当中
				ll.addView(ii);
				// 初始化TextView
				TextView tv = new TextView(MainActivity.this);
//				tv.setText(" " + getResources().getText(msgIds[position]));
				//此处将使用string中的id替换为使用string列表的方式来显示数据
				tv.setText(text.get(position));
				tv.setTextColor(R.color.black);
				tv.setTextSize(24);
				ll.addView(tv);
				return ll;
			}
		};
		// 为Spinner添加内容适配器
		sp.setAdapter(ba);
		//为Spinner添加事件响应
		sp.setOnItemSelectedListener(new OnItemSelectedListener() {
			//此处是当选择item时，对应的改变指定区域的信息
			public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
				// 获取主界面TextView
				TextView tv = (TextView) findViewById(R.id.TextView01);
				// 获取当前选中选项对应的LinearLayout
				LinearLayout ll = (LinearLayout) view;
				// 获取其中的TextView
				TextView tvn = (TextView) ll.getChildAt(1);
				// 用StringBuilder动态生成信息
				StringBuilder sb = new StringBuilder();
				sb.append(getResources().getText(R.string.ys));
				sb.append(":");
				sb.append(tvn.getText());
				// 信息设置进住界面
				tv.setText(sb.toString());
			}
			public void onNothingSelected(AdapterView<?> parent) {}
		});
	}
}
