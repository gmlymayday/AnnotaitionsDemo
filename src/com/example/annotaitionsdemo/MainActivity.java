package com.example.annotaitionsdemo;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {
	private List<String> list;
	private ArrayAdapter<String> adapter;
	@ViewById(R.id.lv_ann)
	ListView lv_ann;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@AfterViews
	public void initListData() {
		list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list.add("µÚ" + i + "¸ö");
		}
	}

	@AfterViews
	public void initAdapter() {
		adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
				list);
		lv_ann.setAdapter(adapter);
	}

	@ItemClick(R.id.lv_ann)
	public void myListItemClicked(int position) {
		Toast.makeText(this, "position:" + position, Toast.LENGTH_SHORT).show();
	}
}
