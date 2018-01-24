package com.phoenix.kotlin_dbflow_example

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iflytek.mobilecontroltvserver.dbflow.ItemRepository
import com.iflytek.mobilecontroltvserver.dbflow.UserItem
import kotlinx.android.synthetic.main.item_user.view.*

/**
 * Created by phoenix on 2018/1/24.
 */
class UserListAdapter : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {
    private val UserList: MutableList<UserItem>
    private val mOnclickListener: View.OnClickListener

    init {
        UserList = ItemRepository.getAll()
        mOnclickListener = View.OnClickListener { v ->
            val item = v.tag as UserItem
            item.delete()
            UserList.remove(item)
            notifyDataSetChanged()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = UserList[position]
        val id = item.id
        val name = item.name
        val sex = item.sex

        holder.id.text = id.toString()
        holder.name.text = name
        when (sex) {
            0 -> {
                holder.sex.text = "男"
                holder.container.setBackgroundColor(Color.BLUE)
            }
            1 -> {
                holder.sex.text = "女"
                holder.container.setBackgroundColor(Color.RED)
            }
        }

        with(holder.container) {
            tag = item
            setOnClickListener(mOnclickListener)
        }
    }

    override fun getItemCount(): Int {
        return UserList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_user, parent, false))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val container = view.container
        val id = view.tv_id
        val name = view.tv_name
        val sex = view.tv_sex
    }

    fun add(name: String, sex: Int) {
        val item = UserItem()
        item.name = name
        item.sex = sex

        UserList.add(item)
        item.save()
        notifyItemInserted(UserList.size - 1)
    }
}