package id.rivaldy.githubuser.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.rivaldy.core.domain.model.User
import id.rivaldy.core.util.getDiffCallback
import id.rivaldy.githubuser.R
import id.rivaldy.githubuser.databinding.CardItemUserBinding

/** Created by github.com/im-o on 6/23/2023. */

class MainAdapter(
    private val listener: (User) -> Unit
) : ListAdapter<User, MainAdapter.ViewHolder>(getDiffCallback()) {

    inner class ViewHolder(private val binding: CardItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: User) {
            binding.apply {
                Glide.with(root.context)
                    .load(R.drawable.alternative_privacy)//.load(item.avatarUrl)
                    .placeholder(R.color.colorDividerHigh)
                    .into(imageIV)
                userNameTV.text = root.context.getString(R.string.username_, item.username)
                typeTV.text = root.context.getString(R.string.type_, item.type)
                root.setOnClickListener { listener(item) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }
}