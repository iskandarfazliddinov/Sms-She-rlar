package com.example.mylove.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mylove.Adapters.Adapters
import com.example.mylove.Data.UserData
import com.example.mylove.R
import com.example.mylove.databinding.FragmentNewsBinding
import com.example.project_contact.DataBase.AppDataBase
import com.example.project_contact.DataBase.UserDatas
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.sheetdialog.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsFragment : Fragment() {
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
    private lateinit var binding: FragmentNewsBinding
    private lateinit var Adapter: Adapters
    private lateinit var UserList: ArrayList<UserData>
    private lateinit var appDataBase: AppDataBase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        appDataBase = AppDataBase.getInstance(requireContext())
        binding = FragmentNewsBinding.inflate(inflater,container,false)

        binding.apply {
            btnNewsBack.setOnClickListener {
                findNavController().navigate(R.id.action_newsFragment_to_mainFragment)
            }
        }

        val name = arrayOf(
            "Она!",
            "Дада",
            "ЧИДАБ БЕР ОНА",
            "ОНАСИНИ БЕРИБ ҚЎЙГАНЛАР"
        )
        val info = arrayOf(
            "Мени ўғил қилиб туғсанг бўларкан,\n" +
                    "Уй томин бошқатдан ёпиб берардим.\n" +
                    "Ишлаб, давлат топиб, ҳеч ким киймаган,\n" +
                    "Асл матолардан топиб берадим.\n" +
                    "\n" +
                    "Қиз бола бировнинг ҳасми...\n" +
                    "Палаҳмон,\n" +
                    "Узоқ-узоқларга отилиб кетдим.\n" +
                    "Ваъда этилгани ўша бир ҳирмон,\n" +
                    "Сариқ чақаларга сотилиб кетдим.\n" +
                    "\n" +
                    "Қара, қолиб кетди қарзлар узилмай,\n" +
                    "Сен йўқ остонани ялаб - юлқадим.\n" +
                    "Сени соғинсам ҳам қучиб суёлмай,\n" +
                    "Кимни  \"онажон\" деб тинмай алқадим.\n" +
                    "\n" +
                    "Она!\n" +
                    "Мени ўғил қилиб туғсанг бўларкан,\n" +
                    "Умрим ўтмасмиди етти букилиб.\n" +
                    "Менга деб бармоғинг тешилиб тиккан,\n" +
                    "Ёстуқ жилдларига кетдим тўкилиб.\n" +
                    "\n" +
                    "Қизинг қисматидан куйиб кетмасдинг,\n" +
                    "Эзилиб кетмасдинг мендан минг чандон.\n" +
                    "Етмишга букилиб кетмасди қаддинг,\n" +
                    "Негаям қиз қилиб туғдинг онажон!\n" +
                    "\n" +
                    "Кечир, кечиролсанг, мендан рози бўл,\n" +
                    "Сўлитган мен бўлдим гулдек юзингни!\n" +
                    "Оҳ, Она, шундаям дуо қиласан,\n" +
                    "Фақат қизларини ўйлар қизингни...",
            "Содда, беғуборлигим, \n" +
                    "Кўнгли оппоқ қорлигим, \n" +
                    "Армонлари борлигим, \n" +
                    "Дада, сизга ўхшайман.\n" +
                    "\n" +
                    "Энг покиза юрагим, \n" +
                    "Ҳаммамизга керагим, \n" +
                    "Мени ярим бўлагим, \n" +
                    "Дада, сизга ўхшайман.\n" +
                    "\n" +
                    "Мени йиққан бойлигим, \n" +
                    "Ўзимни чиройлигим, \n" +
                    "Жўшқин бўлган сойлигим, \n" +
                    "Дада, сизга ўхшайман. \n" +
                    "\n" +
                    "Ўзимни меҳрибоним, \n" +
                    "Гўзал, ёруғ жаҳоним, \n" +
                    "Сиз-ла, бахтиёр оним, \n" +
                    "Дада, сизга ўхшайман.\n" +
                    "\n" +
                    "Нур таралган изингиз,\n" +
                    "Маъноли ҳар сўзингиз,\n" +
                    "Порлаб турар кўзингиз,\n" +
                    "Дада, сизга ўхшайман.\n" +
                    "\n" +
                    "Аллоҳдан сўраганим,\n" +
                    "Шодликка ўраганим,\n" +
                    "Ўзимни ширин жоним,\n" +
                    "Дада, сизга ўхшайман.",
            "Жонимга жон берган садарайҳоним, \n" +
                    "Кўзимга нур берган нури жаҳоним, \n" +
                    "Бугун юрагимга сиғмайди оҳим, \n" +
                    "Энди эсим кирди, бўлай парвона, \n" +
                    "Фақат қаримасдан чидаб бер, она. \n" +
                    "\n" +
                    "Кўзларинг нурлари қайга кетмоқда, \n" +
                    "Кундан кун ажинлар асир этмоқда, \n" +
                    "Мендан нажот кутиб умринг ўтмоқда, \n" +
                    "Энди эсим кирди, бўлай парвона, \n" +
                    "Фақат қаримасдан чидаб бер она. \n" +
                    "\n" +
                    "Сочларинг оқлари хаёлга қорар, \n" +
                    "Эвоҳ, гулдай қаддинг кичрайиб борар, \n" +
                    "Тунлар жим йиғлашинг бағримни ёрар, \n" +
                    "Энди эсим кирди, бўлай парвона, \n" +
                    "Фақат қаримасдан чидаб бер, она. \n" +
                    "\n" +
                    "Мен сабаб эмасми босгани титроқ, \n" +
                    "Асабга чорлардим, кетардим йироқ, \n" +
                    "Энди юрагимда ёнмайди чироқ, \n" +
                    "Энди эсим кирди, бўлай парвона, \n" +
                    "Фақат қаримасдан чидаб бер, она. \n" +
                    "\n" +
                    "Қийин эмасдику битта гул узмоқ, \n" +
                    "Қалбинга мўралаб дардингни сезмоқ, \n" +
                    "Бугун керакмиди бағримни эзмоқ, \n" +
                    "Энди эсим кирди, бўлай парвона, \n" +
                    "Фақат қаримасдан чидаб бер, она. \n",
            "Юрагида шамчироғи йўқ,\n" +
                    "Ишонгани боғу роғи йўқ,\n" +
                    "Суянайин деса, тоғи йўқ\n" +
                    "Онасини бериб қўйганлар.\n" +
                    "\n" +
                    "Чўкиб қолар баланд бўйлари,\n" +
                    "Кўз ёшисиз ўтмас тўйлари,\n" +
                    "Ҳувиллаб қолади уйлари,\n" +
                    "Онасини бериб қўйганлар.\n" +
                    "\n" +
                    "Хуморлари тутган паллада,\n" +
                    "Зўрға турар жони танада,\n" +
                    "Йиғлаб юрар пана-панада,\n" +
                    "Онасини бериб қўйганлар.\n" +
                    "\n" +
                    "Ғам юзига иниб кетади,\n" +
                    "\"Она\" десанг, тиниб кетади.\n" +
                    "Бир зарб билан синиб кетади,\n" +
                    "Онасини бериб қўйганлар.\n" +
                    "\n" +
                    "Илинади ошу нонини,\n" +
                    "Бир кўришга берар жонини,\n" +
                    "Ҳидлаб юрар тўн, рўмолини,\n" +
                    "Онасини бериб қўйганлар.\n" +
                    "\n" +
                    "Ўлмайдилар оналар атай\n" +
                    "Қисматимиз шу экан нетай\n" +
                    "Сизни қандай қилиб юпатай\n" +
                    "Онасини бериб қўйганлар. "
        )

        UserList = ArrayList()
        var user: UserData? = null

        for(i in name.indices){
            user = UserData(name[i], info[i])
            UserList.add(user!!)
        }
        Adapter = Adapters(UserList, {
            bottomsheetDialog(it)
        })

        binding.ReycNews.adapter = Adapter
        Adapter.notifyDataSetChanged()
        return binding.root
    }


    private fun bottomsheetDialog(userData: UserData) {
        val dialogs = BottomSheetDialog(requireContext())
        dialogs.setContentView(R.layout.sheetdialog)
        dialogs.tvName.text = userData.textName
        dialogs.tvInfo.text = userData.textInfo

        dialogs.show()

        dialogs.btnSave.setOnClickListener {
            if(dialogs.tvName.text.isNotEmpty() && dialogs.tvInfo.text.isNotEmpty()){
                val obj = UserDatas(
                    0,
                    dialogs.tvName.text.toString(),
                    dialogs.tvInfo.text.toString()
                )
                appDataBase.userDao().addUser(obj)
                dialogs.dismiss()
                findNavController().navigate(R.id.action_newsFragment_to_favroiteFragment)
            }
        }




    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}