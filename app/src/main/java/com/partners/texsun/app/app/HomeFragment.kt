package com.partners.texsun.app.app

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.partners.texsun.R
import com.partners.texsun.app.components.recyclerviews.CustomViewHolder
import com.partners.texsun.app.models.app.HomeAppMenuItem
import com.partners.texsun.app.utils.AuthUtils
import kotlinx.android.synthetic.main.activity_texum.*
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.app_bar_home.view.*
import kotlinx.android.synthetic.main.app_bar_home.view.appToolBar
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.row_home_menu.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    val loggedUser by lazy { AuthUtils.getLoggedUser() }
    val menuItems  by lazy { HomeAppMenuItem.default }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
//        val layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
//        val mainView = View.inflate(context, R.layout.fragment_home, null)
//        view.mainContentApp.addView(mainView, 0, layoutParams)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        postponeEnterTransition()
        if (loggedUser.verifiedAt.isNullOrBlank() || loggedUser.verifiedAt?.isEmpty() == true){

                val action =
                    HomeFragmentDirections.actionHomeFragmentToPendingVerificationFragment()
                findNavController().popBackStack(R.id.pendingVerificationFragment, true)
                findNavController().navigate(action)

        }else{
            setUpView()
        }
    }

    private  fun setUpView(){


        rvHomeMenu.run {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = MenuItemAdapter()
            adapter?.notifyDataSetChanged()
        }
    }

    inner class MenuItemAdapter : RecyclerView.Adapter<CustomViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
            val view = LayoutInflater.from(requireContext()).inflate(R.layout.row_home_menu, parent, false)
            return CustomViewHolder(view)
        }

        override fun getItemCount(): Int = menuItems.count()

        override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
            val view = holder.view
            (menuItems[position]).let {
                menu ->

                view.txtHomeMenu.text = menu.name
            }
        }

    }

}
