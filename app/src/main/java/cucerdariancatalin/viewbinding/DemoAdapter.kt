package cucerdariancatalin.viewbinding

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hoc081098.viewbindingdelegate.inflateViewBinding
import cucerdariancatalin.viewbinding.databinding.ItemRecyclerBinding
import cucerdariancatalin.viewbinding.databinding.ItemRecyclerMergeBinding

class DemoAdapter :
    ListAdapter<String, DemoAdapter.VH>(
        object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem
            override fun areContentsTheSame(oldItem: String, newItem: String) = oldItem == newItem
        }
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(parent inflateViewBinding false)

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(getItem(position))

    class VH(private val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        private val includeBinding = ItemRecyclerMergeBinding.bind(binding.root)

        fun bind(item: String) {
            binding.textView.text = "Title: $item"
            includeBinding.textViewSubtitle.text = "Subtitle: $item"
        }
    }
}
