package com.example.mylove.ui

import android.app.Dialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.fragment.findNavController
import com.example.mylove.Adapters.Adapters
import com.example.mylove.Data.UserData
import com.example.mylove.R
import com.example.mylove.databinding.FragmentHomeBinding
import com.example.project_contact.DataBase.AppDataBase
import com.example.project_contact.DataBase.UserDatas
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.sheetdialog.*
import java.nio.file.Files.size

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var change: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            change = it.getString("keyss")
        }
    }

    private lateinit var binding: FragmentHomeBinding
    private lateinit var Adapter: Adapters
    private lateinit var UserList: ArrayList<UserData>
    private lateinit var appDataBase: AppDataBase


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        appDataBase = AppDataBase.getInstance(requireContext())
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        val name = arrayOf(
            "Oshiq derlar meni",
            "Go'zal qizcha",
            "O`ylab ko'ring",
            "Moda",
            "Erta tongda"
        )
        val info = arrayOf(
            "Ko’zlarim ko’r bo’lsa, ko’rmasdim seni,\n" +
                    "Yuragim tosh bo’lsa, sevmasdim seni,\n" +
                    "Mayli xijron azobi qiynasin meni,\n" +
                    "O’lsam ham baribir sevaman seni! ",
            "O'sha sizmi go'zal qizcha! \n" +
                    " Bo'ylaringiz xuddi bizcha. \n" +
                    " Gaplarimga quloq soling, \n" +
                    " Aytganlarim yodlab oling.",
            "Shunday ekan o'ylab ko'ring \n" +
                    " Shoshilmang er qilishga. \n" +
                    " Ko'nsangiz gar shu shartga. \n" +
                    " Man roziman xotin qilishga. ",
            "Moda deb shim kiymaysiz. \n" +
                    " Lab bo'yashni bilmaysiz. \n" +
                    " Eng yomoni aytib qo'yay, \n" +
                    " Cho'ntagimni shilmaysiz.",
            "Erta tongda turasiz, \n" +
                    " Hovlini supurasiz! \n" +
                    " Nonushta keyin man ishga. \n" +
                    " Siz esa yer chopishga! \n" +
                    "  \n" +
                    " Shunday ekan o'ylab ko'ring \n" +
                    " Shoshilmang er qilishga. \n" +
                    " Ko'nsangiz gar shu shartga. \n" +
                    " Man roziman xotin qilishga."

        )

        val name_2 = arrayOf(
            "Men sevsam sevmagan qizlar",
            "Mundiyon qizlari uchun she'r"
        )
        val info_2 = arrayOf(
            "O‘t to‘la nigohim boqqanlarimni, \n" +
                    "O‘zimga aytolmas yoqqanlarimni, \n" +
                    "Yodidan chiqarmas raqamlarimni, \n" +
                    "Qalaysiz men sevsam sevmagan qizlar.\n" +
                    "\n" +
                    "Dadasi uzatdi oshnalariga, \n" +
                    "Kulishdi men kabi tashnalariga, \n" +
                    "She'rlar yozar edim poshnalariga, \n" +
                    "Qalaysiz men sevsam sevmagan qizlar.\n" +
                    "\n" +
                    "Tunda borar edim gohida daydib, \n" +
                    "Yozgan hatlarimni bermaydi qaytib, \n" +
                    "O‘g‘lini chaqirar ismimni aytib, \n" +
                    "Qalaysiz men sevsam sevmagan qizlar.\n" +
                    "\n" +
                    "Ko‘ksimda yuragim urib turibdi, \n" +
                    "Ishlarim yurishmay yurib turibdi, \n" +
                    "O‘g‘lingiz she'rlarimni aytib yuribdi, \n" +
                    "Qalaysiz men sevsam sevmagan qizlar.\n" +
                    "\n" +
                    "Bilaklari oppoq yengi topilmas, \n" +
                    "O‘zlaricha osmon tengi topilmas, \n" +
                    "Bugun qo‘shiq aytsam og‘zi yopilmas, \n" +
                    "Qalaysiz men sevsam sevmagan qizlar.\n" +
                    "\n" +
                    "Tan berib shiddatu shitoblarimga, \n" +
                    "Qaboqlarin uyib hitoblarimga, \n" +
                    "Dastxat ololmaydi kitoblarimga, \n" +
                    "Qalaysiz men sevsam sevmagan qizlar.\n" +
                    "\n" +
                    "Honishlar o‘tli nolangizdanam, \n" +
                    "Uzr so‘rolmadim onanggizdanam,\n" +
                    "Hovlimiz kichkina honanggizdanam, \n" +
                    "Qalaysiz men sevsam sevmagan qizlar.\n" +
                    "\n" +
                    "Goh qo‘limdan ketgan ihtiyormisiz, \n" +
                    "Muhlislarim ichra sizham bormisiz, \n" +
                    "Men bahtimni topdim baxtiyormisiz, \n" +
                    "Qalaysiz men sevsam sevmagan qizlar, \n" +
                    "Sovchilar yuborsam tegmagan qizlar.",
            "Mundiyon ko'chalarin kezaman\n" +
                    "Oy yorug'i sokin tunning bag'rida\n" +
                    "Bevafoyim qaytmasligin sezaman\n" +
                    "Ketaversin bahtli bo'lsin maylida\n" +
                    "\n" +
                    "O'zim bilan yana o'zim qolaman\n" +
                    "Joy yo'q ekan netay bizga ko'nglida\n" +
                    "Alamimni may sharobdan olaman\n" +
                    "Omad kelib qolar bir kun sevgida\n" +
                    "\n" +
                    "Mundiyonni go'zallari go'zalsiz\n" +
                    "Bizlar turib boshqasini sevasiz\n" +
                    "Aldanmangda yolg'on shirin so'zlarga\n" +
                    "Baribir ham o'zimizga yor bo'lasiz\n" +
                    "\n" +
                    "Mana qarang obod bo'ldi ko'chalar\n" +
                    "Kunduzgiday bo'lib qoldi kechalar\n" +
                    "Sal sekinroq oshirmangda tezlikni\n" +
                    "O'nga chapga mashinalar ucharlar\n" +
                    "\n" +
                    "Ana qizlar qaytayapti o'qishdan\n" +
                    "Yigitlaram charchab ketdi kutishdan\n" +
                    "Liboslari o'zlariga yarashgan\n" +
                    "Charchamaymiz qizlarimiz sevishdan\n" +
                    "\n" +
                    "Mundiyonni go'zallari go'zalsiz\n" +
                    "Bizlar turib boshqasini sevasiz\n" +
                    "Ishonmangda shirin shirin so'zlarga\n" +
                    "Baribir ham o'zimizga yor bo'lasiz\n" +
                    "\n" +
                    "Chiroylida biram shirin tillari\n" +
                    "Tillariday bo'lsin deyman dillari\n" +
                    "Chin yurakdan bittasini sevadi\n" +
                    "Begonalar bilmasina sirlarin\n" +
                    "\n" +
                    "Mundiyonni tarifidan so'zladik\n" +
                    "Do'stim bilan bitta qo'shiq kuyladik\n" +
                    "Yoqsa huzur yoqmasa gar uzurda\n" +
                    "Hammangizga yoqadi deb o'yladik\n" +
                    "\n" +
                    "Mundiyonni go'zallari go'zalsiz\n" +
                    "Bizlar turib boshqasini sevmangiz\n" +
                    "Ishonmangda shirin shirin so'zlarga\n" +
                    "Baribir ham bizlarga yor bo'lasiz"

        )

        val name_3 = arrayOf(
            "Ko`zgamas ",
            "Umringiz",
            "Azizim",
            "Bahor"
        )
        val info_3 = arrayOf(
            "Ko`zgamas bu qalbimga boq, \n" +
                    " Meni ado etmoqda firoq, \n" +
                    " Javobingdan qalbimda titroq, \n" +
                    " Hor ishqimni qabul et faqat! \n" +
                    " Sevganim chin hech xato emas, \n" +
                    " O`jar yurak o`zgani demas, \n" +
                    " Ishon aldash qo`limdan kelmas, \n" +
                    " Hor ishqimni qabul et faqat! \n" +
                    " Rahm et, Qolmay aqldan ozib, \n" +
                    " Ishqqa armon qabrimni qazib, \n" +
                    " Tiz cho`kaman, Ishnoma yozib, \n" +
                    " Hor ishqimni qabul et faqat! \n" +
                    " Yosh bo`layin ko`zlaringda bas! \n" +
                    " Yuzlaringda yashayin bir pas, \n" +
                    " Lablaringda jon beray besas... \n" +
                    " Hor ishqimni qabul et faqat!",
            "Umringiz baxordek bo`lsin-u, \n" +
                    " Hech yomg`iri bo`lmasin. \n" +
                    " Yozdek issiq bo`lsin-u, \n" +
                    " Saratoni bo`lmasin. \n" +
                    " Kuzdek to`kin bo`lsin-u, \n" +
                    " Hech hazoni bo`lmasin. \n" +
                    " Qishdek oppoq bo`lsin-u, \n" +
                    " Qahratoni bo`lmasin.",
            "Azizim baxt iqbol doim yor bo`lsin \n" +
                    " Yurgan yo`llariz gullarga to`lsin \n" +
                    " Omadingiz ko`rib ko`zlar quvonsin \n" +
                    " Tug`ulgan kuningiz muborak bo`lsin",
            "Bahor ko`rkamligi, subxidam tongi, \n" +
                    " Beg`ubor qalbingiz hamrohi bo`lsin! \n" +
                    " Quvonchlar tilayman yangidan-yangi, \n" +
                    " Dilingiz shodlikka, orzuga to`lsin!!!"

        )

        val name_4 = arrayOf(
            "Yigʻlamang ona",
            "Ota Rozi",
            "Qizim deb",
            "Онам",
            "ONANG UCHUN",
            "OTAJONING ROZI BO'LSA AGAR SENDAN"
        )
        val info_4 = arrayOf(
            "Bu oqshom oʻtirib hayolga toldim \n" +
                    "Oʻsha goʻzal damlarni yodga oldim. \n" +
                    "Jajji qoʻllarimdan ushlab asta. \n" +
                    "İlk qadam tashlashni oʻrgatdiz ona. \n" +
                    "Shu ondan boshlab yura boshladim. \n" +
                    "Tillarim biyron soʻzlay boshladim. \n" +
                    "Goh kulib,goh yigʻlab koʻziz yoshladim. \n" +
                    "Men nodonni kechiring ona \n" +
                    "Eh oʻzim oʻylab. \n" +
                    "Sizni unutdim ona. \n" +
                    "Eh men bemehr nodon bola. \n" +
                    "Holiz ne deb soʻramabmana. \n" +
                    "Meni kechiring yigʻlamang ona. \n" +
                    "Siz mening borimsiz baxtim \n" +
                    "Dunyoda begʻuborim. \n" +
                    "Oyogʻi ostida jannatim \n" +
                    "Poyizga gullar toʻshayman. \n" +
                    "Faqat, faqat sizni deb yashayman. \n" +
                    "İltimos yigʻlamang ona. \n" +
                    "Ne desangiz qilaman. \n" +
                    "Hatto jonim beraman. \n" +
                    "Tanlang shu koʻylaklardan \n" +
                    "Sarasin olib beraman. \n" +
                    "Ezgu niyatlarimdan biri. \n" +
                    "Ona sizni hajga olib boraman. \n" +
                    "Duo qiling qizingizni. \n" +
                    "Sizni baxtli qiladi. \n" +
                    "Gʻamgin boʻlmang hech qachon. \n" +
                    "Mana men borman onajon. \n" +
                    "Sizdan iltimos ona. \n" +
                    "Faqat yigʻlamang ona!!!",
            "Отанг бўлса қилгин хурмат,\n" +
                    "Мадор кетса бўлгин қувват.\n" +
                    "Бу дунёда билгин фарзанд,\n" +
                    "Хаётинг хам нурга тўлар,\n" +
                    "Отанг сендан рози бўлса.\n" +
                    "\n" +
                    "Бўлмаганинг бўлдиради,\n" +
                    "Армонларинг ўлдиради,\n" +
                    "Бахт кўзларинг тўлдиради,\n" +
                    "Обод уйинг файзга тўлар,\n" +
                    "Отанг сендан рози бўлса.\n" +
                    "\n" +
                    "Яшнаб турсин кўнгил боғи,\n" +
                    "Бўлгин унинг суянч тоғи,\n" +
                    "Дуосин ол хаёт чоғи,\n" +
                    "Чин дунёда қийналмайсан,\n" +
                    "Отанг сендан рози бўлса.\n" +
                    "\n" +
                    "Кўзингга сурт босган изин,\n" +
                    "Хикмат билгин айтган сўзин,\n" +
                    "Оқла берган нон-у тузин,\n" +
                    "Топганинг хам халол бўлар,\n" +
                    "Отанг сендан рози бўлса.\n" +
                    "\n" +
                    "Бор умиди сендан ахир,\n" +
                    "Бўлма нокас, бўлмаа бахил,\n" +
                    "Қайтар дунё қайтар охир,\n" +
                    "Фарзандларинг бахти кулар,\n" +
                    "Отанг сендан рози бўлса.\n" +
                    "\n" +
                    "Тўйлар қилсанг кўрки отанг,\n" +
                    "Уйлар қурсанг кўрки отанг,\n" +
                    "Ғаниматдир қилма аттанг,\n" +
                    "Билгин, Аллох рози бўлар,\n" +
                    "Отанг сендан рози бўлса",
            "Суз бераман мен сизга,\n" +
                    "Кунлар келиб курарсиз.\n" +
                    "Уша менинг кизим деб\n" +
                    "Фахрланиб юрарсиз.\n" +
                    "\n" +
                    "Магрур тутиб бошингиз,\n" +
                    "Кувончга сигмай сира.\n" +
                    "Тухтатолмай ёшингиз,\n" +
                    "Дейсиз кизим шоира.\n" +
                    "\n" +
                    "Олманг сира хавотир,\n" +
                    "Сизга килмам хиёнат.\n" +
                    "Кизинг ёмон деганлар,\n" +
                    "Тортиб колсин хижолат.\n" +
                    "\n" +
                    "Вада-вада гап гапдир!\n" +
                    "Мен сузимда тураман.\n" +
                    "Аждодларга муносиб,\n" +
                    "Ёш \"Зулфия\" буламан.\n" +
                    "\n" +
                    "Кизим шоир деб хали\n" +
                    "Осмонларда юрарсиз...",
            "Тўққиз ой вужудим вужудингизда.\n" +
                    "Кўтариб юрдингиз бир парча танам.\n" +
                    "Илк бора йиғладим қўлларингизда.\n" +
                    "Қувониб кўзга ёш олдингиз онам.\n" +
                    "\n" +
                    "Жажжи қўлларимни кўзингиз суриб.\n" +
                    "Ёшингиз артингиз дея жон болам.\n" +
                    "Юзимга боқдингиз жилмайиб кулиб.\n" +
                    "Аллохга шукурлар айткансиз онам.\n" +
                    "\n" +
                    "Тунлари бедорсиз сирдош бешикка.\n" +
                    "Йиғладим холингиз билмай бехабар.\n" +
                    "Аллалар айтдингиз солиб қўшиққа.\n" +
                    "Жим қолдим сўзингиз уғилган онлар.\n" +
                    "\n" +
                    "Улғайиб бўй чўздим қаранг онажон.\n" +
                    "Сиздан бўйим узун миттигина жон.\n" +
                    "Эдимку эсласак ўша дамларни.\n" +
                    "Алишмайман сизни берса хам жахон.\n" +
                    "\n" +
                    "Жаннат оёғингиз остида эрур.\n" +
                    "Тиз чўкиб саждага тегса пешонам.\n" +
                    "Хузур халоватда яшаб бир умр.\n" +
                    "Бахтимга саломат бўлингиз онам.",
            "Koz yoshlari dary bolib oqqanida\n" +
                    "Senga gozal kozi bilan boqqanida\n" +
                    "Boor mehrini sening uchun sochganida\n" +
                    "Nima qilding dostim bugun onang uchun\n" +
                    "\n" +
                    "Kutar Edi tunda sening kelishingni\n" +
                    "Ona degan bir sozingni berishingni\n" +
                    "Oylamagan be Etibor bolishingni\n" +
                    "Nima qilding dostim bugun onang uchun\n" +
                    "\n" +
                    "Ona desang osmonlarga uchar Edi\n" +
                    "Mehri joshib seni mahkam quchar Edi\n" +
                    "Onang senga faqat bahtli bolgin dedi\n" +
                    "Nima qilding dostim bugun onang uchun\n" +
                    "\n" +
                    "Dostim onang qoldirmagin ozini hech\n" +
                    "Duosin ol bolmay turib bu kunlar kech\n" +
                    "Qalbingdagi fisqu fasot niqobing ech\n" +
                    "Nima qilding dostim bugun onang uchun",
            "Omad senga qo’lllarini tutaverar,\n" +
                    "Yaxshi kunlar yo’llaringni kutaverar,\n" +
                    "O’taverar hayot go’zal o’taverar,\n" +
                    "Onajoning rozi bo’lsa agar sendan,\n" +
                    "Otajoning rozi bo’lsa agar sendan.\n" +
                    "\n" +
                    "Ko’p o’yladim, ko’p o’yladim, ko’p o’yladim,\n" +
                    "Erta tongdan to kechgacha xo’p o’yladim.\n" +
                    "Butun umr bo’lmas ekan baxting yarim,\n" +
                    "Onajoning rozi bo’lsa agar sendan,\n" +
                    "Otajoning rozi bo’lsa agar sendan.\n" +
                    "\n" +
                    "Bu dunyoda ota-onang hayot ekan,\n" +
                    "Sahrolarda oyog’ingga botmas tikan,\n" +
                    "Sening uchun hammadan ko’p zahmat chekkan,\n" +
                    "Onajoning rozi bo’lsa agar sendan,\n" +
                    "Otajoning rozi bo’lsa agar sendan.\n" +
                    "\n" +
                    "Bu kunlarni kutganlar kim hammadan ko’p,\n" +
                    "Xizmatin qil, boshingni eg, qo’llarin o’p,\n" +
                    "G’animat bil bugun bordir ertaga yo’q.\n" +
                    "Onajoning rozi bo’lsa agar sendan,\n" +
                    "Otajoning rozi bo’lsa agar sendan.\n" +
                    "\n" +
                    "Ahad Qayum yozar bo’lsang agar chindan,\n" +
                    "Yaratgandan so’ra faqat ich ichingdan,\n" +
                    "Bir yaxshilik qoldirgin sen har bir kundan,\n" +
                    "Onajoning rozi bo’lsa agar sendan,\n" +
                    "Otajoning rozi bo’lsa agar sendan."
        )

        val name_6 = arrayOf(
            "Men seni",
            "Ilk muhabbat",
            "Men sevgi",
            "Telifon"
        )
        val info_6 = arrayOf(
            "Men seni sog`indim (Yurakdagi gap) \n" +
                    " Ko`rgim kelyapti (Xis xayajon gap) \n" +
                    " Qachon kelasan (So`roq gap) \n" +
                    " Men seni chin dildan sevaman (Bo`lmagan gap)",
            "Ilk muhabbat bahor osmonidagi bulutga o`xshaydi \n" +
                    " Oppoq pokiza shaffof na qo`lingiz bilan tuta olasiz \n" +
                    " Na ortidan quvib yetasiz shamol uni qayerga olib \n" +
                    " ketishini ham bilmaysiz ilk muhabbatni natijasiz \n" +
                    " tugashi balki shundandir",
            "Men sevgi respublikasi muhabbat shaxri \n" +
                    " baxt mahallasi visol ko`chasi chapga burilish \n" +
                    " yurakka urilishda yashiyman va go`zal qizlani \n" +
                    " o`z shahrimga taklif etaman",
            "Manga telifon qilmagan axmoq \n" +
                    " O`zi semizroq soch tekisroq \n" +
                    " Oyog` cho`loq Oyog`ida ikki xil paypoq \n" +
                    " Suvga to`ymaydigan buloq \n" +
                    " Javob yozmagan \n" +
                    " SHALPANQULOQ"
        )

        val name_5 = arrayOf(
            "Sog`indingmi",
            "Baxtli kunimda",
            "Arilar"
        )
        val info_5 = arrayOf(
            "Sog`indingmi demang sog`inish gapmi, \n" +
                    " Sizni sog`inmagan yurak yurakmi, \n" +
                    " Do`stlik men uchun yashash demakdir, \n" +
                    " Ahir siz-siz menga hayot kerakmi!",
            "Baxtli kunimda baxtni baxam ko`radi. \n" +
                    " G`amgin ko`nimda g`amimga sherik bo`ladi \n" +
                    " Yig`lasa yig`laydi,kulsam kuladi \n" +
                    " Eng yaxshi do`st sizday bo`ladi.",
            "Arilar shosharkan gulni sog`inib, \n" +
                    " Quyosh xam botarkan,oyni sog`inib. \n" +
                    " Kun xam chiqarkan,tunni sog`inib. \n" +
                    " Men esa yashayman do`stlarim sizni sog`inib!!!!!"
        )

        UserList = ArrayList()
        var user: UserData? = null


        if (change == "1") {
            for (i in name.indices) {
                user = UserData(name[i], info[i])
                UserList.add(user!!)
            }
        } else if (change == "2") {
            for (i in name_2.indices) {
                user = UserData(name_2[i], info_2[i])
                UserList.add(user!!)
            }
        } else if (change == "3") {
            for (i in name_3.indices) {
                user = UserData(name_3[i], info_3[i])
                UserList.add(user!!)
            }
        } else if (change == "4") {
            for (i in name_4.indices) {
                user = UserData(name_4[i], info_4[i])
                UserList.add(user!!)
            }
        } else if (change == "5") {
            for (i in name_5.indices) {
                user = UserData(name_5[i], info_5[i])
                UserList.add(user!!)
            }
        } else if (change == "6") {
            for (i in name_6.indices) {
                user = UserData(name_6[i], info_6[i])
                UserList.add(user!!)
            }
        }

        Adapter = Adapters(UserList, {
            bottomsheetDialog(it)
        })

        binding.Reyc.adapter = Adapter
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
            if (dialogs.tvName.text.isNotEmpty() && dialogs.tvInfo.text.isNotEmpty()) {

                val obj = UserDatas(
                    0,
                    dialogs.tvName.text.toString(),
                    dialogs.tvInfo.text.toString()
                )
                appDataBase.userDao().addUser(obj)
                dialogs.dismiss()
                findNavController().navigate(R.id.action_homeFragment_to_favroiteFragment)
            }
        }

        dialogs.btnShare.setOnClickListener {
            val t1 = userData.textInfo
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, t1)
            startActivity(Intent.createChooser(shareIntent,"Share via"))
        }

        dialogs.btnSms.setOnClickListener {
            sendSMS(dialogs.tvInfo.text.toString())
        }

        dialogs.btnCopy.setOnClickListener {
            (requireActivity().getSystemService(CLIPBOARD_SERVICE) as ClipboardManager).apply {
                setPrimaryClip(ClipData.newPlainText("text", "${dialogs.tvInfo.text}"))
            }

            Toast.makeText(requireContext(), "Text copied to clipboard", Toast.LENGTH_LONG).show()
        }
    }

    fun sendSMS(smss:String) {
        val uri = Uri.parse("smsto:12346556")
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        intent.putExtra("sms_body", "${smss}")
        startActivity(intent)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}