package daniel.lop.io.marvelappstarter.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import daniel.lop.io.marvelappstarter.data.model.comic.ComitModel
import daniel.lop.io.marvelappstarter.databinding.ItemComicBinding

class ComicAdapter : RecyclerView.Adapter<ComicAdapter.ComicViewHolder>() {

    //ItemCharacterBinding -> item que o nosso ViewBinding cria para cada item do Adapter
    inner class ComicViewHolder(val binding: ItemComicBinding) :
        RecyclerView.ViewHolder(binding.root)

    //utilitario de diferença de 2 listas para atualizar a lista que vai ser exibida na nossa RV
    private val differCallback = object : DiffUtil.ItemCallback<ComitModel>() {
        override fun areItemsTheSame(oldItem: ComitModel, newItem: ComitModel): Boolean {
            return oldItem.hashCode() == newItem.hashCode();
        }

        override fun areContentsTheSame(oldItem: ComitModel, newItem: ComitModel): Boolean {
            return oldItem.id == newItem.id
                    && oldItem.title == newItem.title
                    && oldItem.description == newItem.description
                    && oldItem.thumbnailModel.path == newItem.thumbnailModel.path
                    && oldItem.thumbnailModel.extension == newItem.thumbnailModel.extension
        }

    }

    private val differ = AsyncListDiffer(this, differCallback)

    var comics: List<ComitModel>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        return ComicViewHolder(
            ItemComicBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = comics.size

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val comic = comics[position]
        holder.binding.apply {
            tvNameComic.text = comic.title
            tvDescriptionComic.text = comic.description

            Glide.with(holder.itemView.context)
                .load(comic.thumbnailModel.path + "." + comic.thumbnailModel.extension)
                .into(imgComic)
        }
    }
}