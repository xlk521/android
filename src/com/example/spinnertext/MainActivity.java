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

	// ������Դ��ͼƬ(������������) id������
	int[] drawableIds = { R.drawable.football, R.drawable.basketball,R.drawable.volleyball ,R.drawable.volleyball};
	// ������Դ�ַ��� (������������) id������
	int[] msgIds = { R.string.zp, R.string.lq, R.string.pq };
	//ģ�����ָı�
	private ArrayList<String> text = null;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//��������Ƴ�ȡ���ݿ��е���������д������б�
		text = new ArrayList<String>();
		text.add(0, "��ѡ��");
		text.add(1, "����001");
		text.add(2, "����002");
		text.add(3, "����003");
		Spinner sp = (Spinner) findViewById(R.id.Spinner01);
		//����������
		BaseAdapter ba = new BaseAdapter() {
		
			public int getCount() {
				// һ������ѡ��
				return text.size();
			}
		
			public Object getItem(int position) {
				return null;
			}
		
			public long getItemId(int position) {
				return 0;
			}
			//�˺�����������ʾitem�е������Դ��
			@SuppressLint("ResourceAsColor")
			public View getView(int position, View convertView, ViewGroup parent) {
				// ��̬����ÿ���������Ӧ��View��ÿ��������View��LinearLayout
				// �а���һ��ImageView��һ��TextView����
				// ��ʼ��LinearLayout
				LinearLayout ll = new LinearLayout(MainActivity.this);
				//�����м��
				ll.setOrientation(LinearLayout.HORIZONTAL);
				// ��ʼ��ImageView
				ImageView ii = new ImageView(MainActivity.this);
				//������Ҫ��ʾ��ͼƬ
				ii.setImageDrawable((getResources().getDrawable(drawableIds[position])));
				//��ͼƬ����ʾ������ӵ����ֵ���
				ll.addView(ii);
				// ��ʼ��TextView
				TextView tv = new TextView(MainActivity.this);
//				tv.setText(" " + getResources().getText(msgIds[position]));
				//�˴���ʹ��string�е�id�滻Ϊʹ��string�б�ķ�ʽ����ʾ����
				tv.setText(text.get(position));
				tv.setTextColor(R.color.black);
				tv.setTextSize(24);
				ll.addView(tv);
				return ll;
			}
		};
		// ΪSpinner�������������
		sp.setAdapter(ba);
		//ΪSpinner����¼���Ӧ
		sp.setOnItemSelectedListener(new OnItemSelectedListener() {
			//�˴��ǵ�ѡ��itemʱ����Ӧ�ĸı�ָ���������Ϣ
			public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
				// ��ȡ������TextView
				TextView tv = (TextView) findViewById(R.id.TextView01);
				// ��ȡ��ǰѡ��ѡ���Ӧ��LinearLayout
				LinearLayout ll = (LinearLayout) view;
				// ��ȡ���е�TextView
				TextView tvn = (TextView) ll.getChildAt(1);
				// ��StringBuilder��̬������Ϣ
				StringBuilder sb = new StringBuilder();
				sb.append(getResources().getText(R.string.ys));
				sb.append(":");
				sb.append(tvn.getText());
				// ��Ϣ���ý�ס����
				tv.setText(sb.toString());
			}
			public void onNothingSelected(AdapterView<?> parent) {}
		});
	}
}
