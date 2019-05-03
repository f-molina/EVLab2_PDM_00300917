package com.example.evaluacion2.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.evaluacion2.R
import kotlinx.android.synthetic.main.fragment_button_fragment.view.*


val ARG_ACTION_1: String = "action_1"
val ARG_ACTION_2: String = "action_2"
val ARG_ACTION_3: String = "action_3"

class Buttonfragment : Fragment() {

    var listener: OnSelectOption? = null
    var action1: String? = null
    var action2: String? = null
    var action3: String? = null

    companion object {

        fun newInstace(action1: String, action2: String) =
                Buttonfragment().apply {
                    arguments  = Bundle().apply {
                        putString(ARG_ACTION_1,action1)
                        putString(ARG_ACTION_2,action2)
                        putString(ARG_ACTION_3, action3)
                    }
                }
    }

    interface OnSelectOption {
        fun onAction(id: Int)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnSelectOption) {
            listener = context
        } else {
            throw RuntimeException("Se necesita una implementación de  OnSelectOption")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            action1 = getString(ARG_ACTION_1)
            action2 = getString(ARG_ACTION_2)
            action3 = getString(ARG_ACTION_3)
        }
    }


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_button_fragment,
                    container, false).apply {
                btn_back.apply {
                    text = action1
                    setOnClickListener {
                        listener?.onAction(1)
                    }
                }
                btn_next.apply {
                    text = action2
                    setOnClickListener {
                        listener?.onAction(2)
                    }
                }

            }


    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
