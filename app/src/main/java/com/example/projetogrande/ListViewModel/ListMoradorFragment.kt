package com.example.projetogrande.ListViewModel

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetogrande.Adapters.RecViewMoradorAdapter
import com.example.projetogrande.R
import com.example.projetogrande.database.AppDb
import kotlinx.android.synthetic.main.fragment_list_morador.*

class ListMoradorFragment : Fragment() {

    private var columnCount = 1
    private lateinit var listViewModel : ListViewMoradorModel
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
                .get(ListViewMoradorModel::class.java)

        return inflater.inflate(R.layout.fragment_list_morador, container, false)

    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var recycleListView = listViewMorador
        recycleListView.adapter = RecViewMoradorAdapter(listViewModel.all(AppDb.getInstance(requireContext())))
        recycleListView.layoutManager = LinearLayoutManager(requireContext())

        btn_retroceder_morador.setOnClickListener {
            findNavController().navigate(R.id.action_listMoradorFragment_to_menuFragment)
        }
        btn_create_morador.setOnClickListener {
            findNavController().navigate(R.id.action_listMoradorFragment_to_moradorFragment)
        }
    }

    companion object {
        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ListMoradorFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}