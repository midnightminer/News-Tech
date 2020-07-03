package id.midnightminer.newstech.ui.newsDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import id.midnightminer.newstech.R
import id.midnightminer.newstech.databinding.FragmentNewsDetailBinding
import id.midnightminer.newstech.util.CommonUtils

class NewsDetailFragment : Fragment() {
    lateinit var binding: FragmentNewsDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_news_detail, container, false)
        var url = requireArguments().getString("urlNews")
        setupWebview(url!!)
        return binding.root
    }

    fun setupWebview(url: String){
        val settings = binding.webivew.settings
        settings.javaScriptEnabled = true
        val webview = binding.webivew
        webview.loadUrl(url)
    }

    override fun onResume() {
        super.onResume()
        if(!CommonUtils.isInternetWorking()){
            findNavController().navigate(R.id.detailToError)
        }
    }

}
