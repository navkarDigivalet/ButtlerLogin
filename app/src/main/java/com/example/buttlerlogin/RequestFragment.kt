package com.example.buttlerlogin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.buttlerlogin.databinding.FragmentRequestBinding


class RequestFragment : Fragment() {

    private var binding1 : FragmentRequestBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_request, container, false)
    }


    }
