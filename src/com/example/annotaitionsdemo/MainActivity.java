package com.example.annotaitionsdemo;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ItemLongClick;
import org.androidannotations.annotations.ItemSelect;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {
	private List<String> list;
	private ArrayAdapter<String> adapter;
	@ViewById(R.id.lv_ann)
	ListView lv_ann;
	@ViewById(R.id.tv_ann)
	TextView tv_ann;

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

	@Click(R.id.tv_ann)
	public void tvOnclick() {
		tv_ann.append("text");
		Toast.makeText(this, "Click--tv", Toast.LENGTH_SHORT).show();
	}

	@ItemClick(R.id.lv_ann)
	public void myListItemClicked(int position) {
		Toast.makeText(this, "ItemClick--position:" + position,
				Toast.LENGTH_SHORT).show();
	}

	@ItemLongClick(R.id.lv_ann)
	public void myListItemLongClicked(int position) {
		Toast.makeText(this, "@ItemLongClick--position:" + position,
				Toast.LENGTH_SHORT).show();
	}

	@ItemSelect(R.id.lv_ann)
	public void myListItemSelectClicked(boolean selected, int position) {
		Toast.makeText(this, "@@ItemSelect--position:" + position,
				Toast.LENGTH_SHORT).show();
	}
}
