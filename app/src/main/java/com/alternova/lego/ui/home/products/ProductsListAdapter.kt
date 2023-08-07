package com.alternova.lego.ui.home.products

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alternova.lego.databinding.ItemListProductBinding
import com.alternova.lego.domain.model.ProductDomain
import com.bumptech.glide.Glide

class ProductsListAdapter() : ListAdapter<ProductDomain, ProductsListAdapter.ProductsListViewHolder >(DiffCallback){

    inner class ProductsListViewHolder(
        private val binding: ItemListProductBinding,
        private val context: Context
    ) : RecyclerView.ViewHolder(binding.root){

        fun bindItem(productDomain: ProductDomain) {
            binding.mtvTitle.text = productDomain.name
            Glide.with(context)
                .load( productDomain.image )
                .centerCrop()
                .into( binding.ivProduct )
            binding.mtvUnitPrice.text = productDomain.unitPrice.toString()
            binding.mtvStock.text = productDomain.stock.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsListViewHolder {
        val itemView = ItemListProductBinding.inflate( LayoutInflater.from(parent.context), parent, false )
        return ProductsListViewHolder(itemView, parent.context)
    }

    override fun onBindViewHolder(holder: ProductsListViewHolder, position: Int) {
        holder.apply {
            bindItem(getItem(position))
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ProductDomain>(){
        override fun areItemsTheSame(oldItem: ProductDomain, newItem: ProductDomain): Boolean {
           return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductDomain, newItem: ProductDomain): Boolean {
            return oldItem.id == newItem.id
        }
    }

}