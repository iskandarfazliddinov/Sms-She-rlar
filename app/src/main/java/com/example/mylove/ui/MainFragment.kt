package com.example.mylove.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mylove.R
import com.example.mylove.databinding.FragmentMainBinding
import com.example.project_contact.DataBase.AppDataBase
import com.example.project_contact.DataBase.UserDatas


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var binding: FragmentMainBinding
    private lateinit var userList: ArrayList<UserDatas>
    private lateinit var appDataBase: AppDataBase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        appDataBase = AppDataBase.getInstance(requireContext())

        userList = ArrayList()
        val alluser = appDataBase.userDao().getAllUser()

        alluser.forEach {
            userList.add(
                UserDatas(
                    id = it.id,
                    textName = it.textName,
                    textInfo = it.textInfo
                )
            )
        }


        binding.apply {
            saveSize.text = "${userList.size} ta"
            btn1.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("keyss", "1")
                findNavController().navigate(R.id.action_mainFragment_to_homeFragment, bundle)
            }
            btn2.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("keyss", "2")
                findNavController().navigate(R.id.action_mainFragment_to_homeFragment, bundle)
            }
            btn3.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("keyss", "3")
                findNavController().navigate(R.id.action_mainFragment_to_homeFragment, bundle)
            }
            btn4.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("keyss", "4")
                findNavController().navigate(R.id.action_mainFragment_to_homeFragment, bundle)
            }
            btn5.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("keyss", "5")
                findNavController().navigate(R.id.action_mainFragment_to_homeFragment, bundle)
            }
            btn6.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("keyss", "6")
                findNavController().navigate(R.id.action_mainFragment_to_homeFragment, bundle)
            }
            btnSaves.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_favroiteFragment)
            }
            btnNews.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_newsFragment)
            }
        }

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}