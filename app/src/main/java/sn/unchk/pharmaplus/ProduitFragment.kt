package sn.unchk.pharmaplus

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ProduitFragment : Fragment() {

    companion object {
        fun newInstance() = ProduitFragment()
    }

    private lateinit var viewModel: ProduitViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_produit, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProduitViewModel::class.java)
        // TODO: Use the ViewModel
    }

}