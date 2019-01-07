package com.example.win10.dragdroprecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val imageList = arrayListOf("https://techviral.net/wp-content/uploads/2016/03/HD-GAMES.png",
        "https://wallpapersite.com/images/pages/pic_w/1333.jpg",
        "https://stmed.net/sites/default/files/pc-gaming-hd-wallpapers-33488-4650955.jpg",
        "https://wallpapersite.com/images/pages/ico_n/16808.jpg",
        "https://freedomapkdownload.online/wp-content/uploads/2018/08/Freedom-Game-List-Over-250-Hackable-Android-Games-and-Apps.jpg",
        "https://cdn.allwallpaper.in/wallpapers/1920x1080/4320/deadpool-game-1920x1080-wallpaper.jpg",
        "https://c1.staticflickr.com/5/4049/4499462704_4f24d270ae_b.jpg",
        "http://a2zhdimages.com/wp-content/uploads/2018/09/Top-Most-Popular-PUBG-Game-HD-Wallpapers.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3gxIc2TXZdY-8uhhyyx7AneNlYg9nLn1VeihY4bjB3eYnINJxHA",
        "https://stmed.net/sites/default/files/tom-clancy%27s-rainbow-six%3A-siege-hd-wallpapers-33829-3217052.jpg",
        "https://i.pinimg.com/564x/2b/fa/90/2bfa903970e95998c5adc4762b3efb4f.jpg",
        "https://i.pinimg.com/564x/dc/6a/a3/dc6aa3ca987b9b13af1c584fa5d0c1f2.jpg",
        "https://i.pinimg.com/564x/5c/30/50/5c3050b0905cb163c628a604d20ac8c2.jpg",
        "https://i.pinimg.com/564x/38/75/0a/38750a0fb593fe04a003e8868a738eb7.jpg",
        "https://i.pinimg.com/564x/15/5a/64/155a643df10ce10258e2d3ff71243492.jpg",
        "https://i.pinimg.com/564x/13/e3/7d/13e37d31cf3531909acfd189fab79145.jpg")

    private var adapter: CustomAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_Photo_List.layoutManager = GridLayoutManager(applicationContext, 2)
        adapter = CustomAdapter(this@MainActivity,imageList)

        //Drag And Drop RecyclerView  Item
        var callback: ItemTouchHelper.Callback = object : ItemTouchHelper.Callback() {
            override fun getMovementFlags(p0: RecyclerView, p1: RecyclerView.ViewHolder): Int {
                return makeFlag(ItemTouchHelper.ACTION_STATE_DRAG, ItemTouchHelper.DOWN or ItemTouchHelper.UP or ItemTouchHelper.START or ItemTouchHelper.END)
            }

            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                Collections.swap(imageList, viewHolder.adapterPosition, target.adapterPosition)
                adapter!!.notifyItemMoved(viewHolder.adapterPosition, target.adapterPosition)
                return true
            }

            override fun onSwiped(p0: RecyclerView.ViewHolder, p1: Int) {
            }
        }

        var mItemTouchHelper = ItemTouchHelper(callback)
        mItemTouchHelper.attachToRecyclerView(rv_Photo_List)
        rv_Photo_List.adapter = adapter
    }
}
