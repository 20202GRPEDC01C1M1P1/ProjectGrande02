package com.example.projetogrande.ListViewModel

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.projetogrande.Adapters.RecViewAdapter
import com.example.projetogrande.R
import com.example.projetogrande.database.RoomDatabase
import com.example.projetogrande.models.Conta
import kotlinx.android.synthetic.main.fragment_list_conta_.*

class ListContaFragment : Fragment() {

    private var columnCount = 1
    private lateinit var listViewModel : ListViewModel
    private lateinit var listViewModelFactory : ListViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        listViewModelFactory = ListViewModelFactory()

        listViewModel =
            ViewModelProvider(this, listViewModelFactory)
                .get(ListViewModel::class.java)

        return inflater.inflate(R.layout.fragment_list_conta_, container, false)

    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var recycleListView = listViewConta
        recycleListView.adapter = RecViewAdapter(lista)
        recycleListView.layoutManager = LinearLayoutManager(requireContext())

        btn_retroceder.setOnClickListener {
            findNavController().navigate(R.id.action_listContaFragment_to_menuFragment)
        }
        btn_list_create.setOnClickListener {
            findNavController().navigate(R.id.action_listContaFragment_to_createconta)
        }
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ListContaFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}