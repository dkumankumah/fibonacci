package nl.kumankumah.fibonacci_vr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nl.kumankumah.fibonacci_vr.databinding.ItemSequenceBinding

class FibonacciAdapter(private var sequence: List<Int>) : RecyclerView.Adapter<FibonacciAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemSequenceBinding.bind(itemView)

        fun databind(number: Int) {
            binding.tvItem.text = number.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_sequence, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return sequence.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(sequence[position])
    }

}