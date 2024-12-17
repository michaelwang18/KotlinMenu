package com.example.navigationdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.navigation.NavController
import androidx.navigation.findNavController

class ThirdFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_third, container, false)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuHost: MenuHost = requireActivity();


        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_third, menu)


            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (menuItem.itemId == R.id.rando){
                    val navController: NavController = view.findNavController()
                    var ranNum = (Math.random()*2).toInt()
                    if (ranNum == 1){
                        navController.navigate(R.id.secondFragment)

                    } else{
                        navController.navigate(R.id.firstFragment)

                    }



                    return true
                }
                if (menuItem.itemId == R.id.num){
                    Toast.makeText(context, (Math.random()*100).toInt().toString(), Toast.LENGTH_SHORT).show()
                    return true
                }
                if (menuItem.itemId == R.id.bool){
                    Toast.makeText(context, "Boo!", Toast.LENGTH_SHORT).show()
                    return true

                }


                return false
            }


        })




    }

}