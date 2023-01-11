package com.example.mylove.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mylove.Adapters.Adapters
import com.example.mylove.Adapters.UserAdapter
import com.example.mylove.R
import com.example.mylove.databinding.FragmentFavroiteBinding
import com.example.project_contact.DataBase.AppDataBase
import com.example.project_contact.DataBase.UserDatas
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.sheetdialog.*
import java.text.FieldPosition


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FavroiteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavroiteFragment : Fragment() {
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

    private lateinit var binding: FragmentFavroiteBinding
    private lateinit var userList: ArrayList<UserDatas>
    private lateinit var appDataBase: AppDataBase
    private lateinit var userAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavroiteBinding.inflate(inflater, container, false)
        appDataBase = AppDataBase.getInstance(requireContext())

        binding.btnBacks.setOnClickListener {
            findNavController().navigate(R.id.action_favroiteFragment_to_mainFragment)
        }
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
        userAdapter = UserAdapter(userList, { it, position ->
            appDataBase.userDao().deletUser(it)
            Toast.makeText(requireContext(), "Sevimlidan o`chirildi!", Toast.LENGTH_SHORT).show()
            userList.removeAt(position)
            userAdapter.notifyItemRemoved(position)
            userAdapter.notifyItemRangeChanged(position, userList.size - position)
        })
        binding.Reycy.adapter = userAdapter
        return binding.root
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FavroiteFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavroiteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}