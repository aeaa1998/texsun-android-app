package com.partners.texsun.app.app.configuration

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.partners.texsun.R
import com.partners.texsun.app.boarding.BoardingActivity
import com.partners.texsun.app.components.recyclerviews.CustomViewHolder
import com.partners.texsun.app.utils.AuthUtils
import kotlinx.android.synthetic.main.app_bar_home.view.*
import kotlinx.android.synthetic.main.fragment_configuration_menu.*
import kotlinx.android.synthetic.main.row_configuration_menu.view.*
import kotlinx.android.synthetic.main.row_header.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [ConfigurationMenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConfigurationMenuFragment : Fragment() {

    private val menu by lazy { ConfigurationMenu.default }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.app_bar_home, container, false)
        val layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        val mainView = inflater.inflate(R.layout.fragment_configuration_menu, view.mainContentApp as ViewGroup, true)
//        view.mainContentApp.addView(mainView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvMenuList.layoutManager = LinearLayoutManager(requireContext())
        rvMenuList.adapter = ConfigAdapter()
        rvMenuList.adapter?.notifyDataSetChanged()
    }

    inner class ConfigAdapter : RecyclerView.Adapter<CustomViewHolder>() {
        override fun getItemViewType(position: Int): Int {
            return menu[position].type.ordinal
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
            val view =  when (viewType){
                ConfigurationMenu.MenuType.header.ordinal -> LayoutInflater.from(requireContext()).inflate(R.layout.row_header, parent, false)

                else -> LayoutInflater.from(requireContext()).inflate(R.layout.row_configuration_menu, parent, false)
            }
            return CustomViewHolder(view)
        }

        override fun getItemCount(): Int {
            return menu.count()
        }

        override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
            val currentTab = menu[position]
            if (currentTab.isHeader){
                holder.view.txtHeaderRow.text = currentTab.name
            }else{
                holder.view.txtConfigNameTab.text = currentTab.name
                if (currentTab.action == "log_out"){
                    holder.view.isClickable = true
                    holder.view.isFocusable = true
                    holder.view.setOnClickListener {
//                        findNavController().navigate(R.id.pendingVerificationFragment)
                        AuthUtils.clearSession()
                        val intent = Intent(activity, BoardingActivity::class.java)
                        startActivity(intent)
                    }

                }
            }
        }

    }


}