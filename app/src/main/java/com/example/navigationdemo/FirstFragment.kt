package com.example.navigationdemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuHost: MenuHost = requireActivity();

        val button: Button = view.findViewById(R.id.buttonFrag1)
        button.setOnClickListener {
            val popup = PopupMenu(requireActivity(), it) // reminder: "it" refers to the button that was clicked
            popup.setOnMenuItemClickListener(object: PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    TODO("Not yet implemented")
                }
            })
            val inflater: MenuInflater = popup.menuInflater
            inflater.inflate(R.menu.menu_third, popup.menu)
            popup.show()
        }









        menuHost.addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.test_menu, menu)


        }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (menuItem.itemId == R.id.item2){
                    val navController: NavController = view.findNavController()
                    navController.navigate(R.id.secondFragment)
                    return true
                }
                if (menuItem.itemId == R.id.item3){
                    val navController: NavController = view.findNavController()
                    navController.navigate(R.id.thirdFragment)
                    return true
                }
                if (menuItem.itemId == R.id.toast){
                    Toast.makeText(context, "Toast", Toast.LENGTH_SHORT).show()
                    return true

                }


                    return false
            }


        })
    }


}
