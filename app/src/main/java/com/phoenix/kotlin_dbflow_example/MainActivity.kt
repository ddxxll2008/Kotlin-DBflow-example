package com.phoenix.kotlin_dbflow_example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var listAdapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(rv_user) {
            setHasFixedSize(true)
            layoutManager = android.support.v7.widget.LinearLayoutManager(this@MainActivity)
            listAdapter = UserListAdapter()
            adapter = listAdapter
        }

        btn_add.setOnClickListener(View.OnClickListener { v ->
            listAdapter.add(et_name.text.toString().trim(), if (rb_male.isChecked) 0 else 1)
        })
    }
}
