package id.midnightminer.newstech.ui.error

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import id.midnightminer.newstech.R
import id.midnightminer.newstech.util.CommonUtils

class ErrorFragment : Fragment() {

    lateinit var binding : FragmentErrorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_error, container, false)
        binding.btnRetry.setOnClickListener{
            if (CommonUtils.isInternetWorking()){
                activity!!.onBackPressed()
            }
        }
        return binding.root
    }


}
