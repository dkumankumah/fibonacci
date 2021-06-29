package nl.kumankumah.fibonacci_vr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import nl.kumankumah.fibonacci_vr.databinding.FragmentFibonacciBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FibonacciFragment : Fragment() {

    private var _binding: FragmentFibonacciBinding? = null
    private val binding get() = _binding!!

    private lateinit var fibonacciAdapter: FibonacciAdapter
    private var sequence = arrayListOf<Int>()

    var f0 = 0
    var f1 = 0
    var result = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFibonacciBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fibonacciAdapter = FibonacciAdapter(sequence)
        initViews()

        binding.btnNext.setOnClickListener{
            result = when (sequence.size){
                0 -> 0
                1 -> 1
                else -> fibonacciSequence()
            }
            binding.tvResult.text = getString(R.string.result, result)
            sequence.add(result)
            fibonacciAdapter.notifyDataSetChanged()
        }
    }

    private fun initViews() {
        binding.rvFibonacci.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvFibonacci.adapter = fibonacciAdapter
    }

    fun fibonacciSequence(): Int {
        f0 = f1
        f1 = result
        return f0 + f1
    }
}