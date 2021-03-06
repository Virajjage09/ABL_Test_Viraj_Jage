package com.virajjage.abl_test_viraj_jage.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.virajjage.abl_test_viraj_jage.R
import com.virajjage.abl_test_viraj_jage.models.User

class UserListAdapter(
    private val mContext: Context,
    userList: ArrayList<User>
) :
    RecyclerView.Adapter<UserListAdapter.UserListHolder>() {

    private var filteredUserList: ArrayList<User> = userList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_layout_user_list, parent, false)
        return UserListHolder(itemView)
    }

    override fun getItemCount(): Int {
        return filteredUserList.size
    }

    override fun onBindViewHolder(holder: UserListHolder, position: Int) {
        try {
            val user: User = filteredUserList[position]
            loadProfileImage(user.avatar_url, holder.imgProfileImage)
            holder.tvDisplayName.text = user.display_name
            holder.tvUserName.text = user.username
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    class UserListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgProfileImage: ImageView = itemView.findViewById(R.id.imgProfilePic)
        var tvDisplayName: TextView = itemView.findViewById(R.id.tvDisplayName)
        var tvUserName: TextView = itemView.findViewById(R.id.tvUserName)

    }

    private fun loadProfileImage(url: String, imageView: ImageView) {
        Glide.with(mContext)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageView)
    }

}