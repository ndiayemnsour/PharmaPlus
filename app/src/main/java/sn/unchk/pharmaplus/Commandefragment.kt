package sn.unchk.pharmaplus

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Commandefragment : Fragment() {

    companion object {
        fun newInstance() = Commandefragment()
    }

    private lateinit var viewModel: CommandefragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_commande, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CommandefragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}