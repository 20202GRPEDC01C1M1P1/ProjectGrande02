package com.example.projetogrande.ListViewModel

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.projetogrande.Adapters.RecViewContaAdapter
import com.example.projetogrande.ListViewModel.ListMoradorFragment.Companion.ARG_COLUMN_COUNT
import com.example.projetogrande.R
import com.example.projetogrande.ViewModels.ContaViewmodel
import com.example.projetogrande.database.AppDb
import com.example.projetogrande.models.Conta
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_list_conta_.*

class ListContaFragment : Fragment(){

     var columnCount = 1
     lateinit var listViewModel : ListViewContaModel
     lateinit var listViewModelFactory : ListViewModelFactory
     lateinit var contaViewmodel: ContaViewmodel


    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        listViewModelFactory = ListViewModelFactory()

        listViewModel =
            ViewModelProvider(this, listViewModelFactory)
                .get(ListViewContaModel::class.java)

        contaViewmodel =
            ViewModelProvider(requireActivity())
                .get(ContaViewmodel::class.java)


        return inflater.inflate(R.layout.fragment_list_conta_, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            listViewModel
            .all()
            .addSnapshotListener { querySnapshot, error ->
                if (error != null) {
                } else if (querySnapshot != null) {
                    var listaContas = querySnapshot.toObjects(Conta::class.java)
                    if (!listaContas.isNullOrEmpty() && listViewConta != null) {
                        listViewConta.adapter = RecViewContaAdapter(listaContas) {
                            var conta = it
                            contaViewmodel.conta = conta
                            findNavController().navigate(R.id.createconta)

                        }
                        listViewConta.layoutManager = LinearLayoutManager(requireContext())
                    }
                }
            }

       /* var db = FirebaseFirestore.getInstance()
        var task = db
            .collection("contas")
            .get()
        task
            .addOnSuccessListener {
                val listaContas = it.toObjects(Conta::class.java)
                var recycleListView = listViewConta
                recycleListView.layoutManager = LinearLayoutManager(requireContext())
                recycleListView.adapter = RecViewContaAdapter(listaContas)
            }
            .addOnFailureListener {
                Toast.makeText(
                    requireContext(),
                    it.message,
                    Toast.LENGTH_LONG
                ).show()
            }
            .addOnCompleteListener{
                Toast.makeText(
                    requireContext(),
                    "Sucesso",
                    Toast.LENGTH_LONG
                ).show()
            }*/

        btn_retroceder.setOnClickListener {
            findNavController().navigate(R.id.action_listContaFragment_to_menuFragment)
        }
        btn_list_create.setOnClickListener {
            findNavController().navigate(R.id.action_listContaFragment_to_createconta)
        }


    }
}