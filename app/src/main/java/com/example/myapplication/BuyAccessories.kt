package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_buy_accessories.*

class BuyAccessories : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_accessories)

    }
    public val emails = arrayOf<String>("chaitanyasonics@gmail.com","ak17098kumar@gmail.com", "pandeymansi027@gmail.com")

    fun subs1(view: View){
        var count1  = TextPersonName5.editableText.toString().toInt()
        count1--
        TextPersonName5.setText(count1.toString())
    }
    fun add1(view: View){
        var counta1  = TextPersonName5.text.toString().toInt()
        counta1++
        TextPersonName5.setText(counta1.toString())
    }
    fun subs2(view: View){
        var count2  = TextPersonName6.text.toString().toInt()
        count2--
        TextPersonName6.setText(count2.toString())
    }
    fun add2(view: View){
        var counta2  = TextPersonName6.text.toString().toInt()
        counta2++
        TextPersonName6.setText(counta2.toString())
    }
    fun subs3(view: View){
        var count3  = edt1.text.toString().toInt()
        count3--
        edt1.setText(count3.toString())
    }
    fun add3(view: View){
        var counta3  = edt1.text.toString().toInt()
        counta3++
        edt1.setText(counta3.toString())
    }
    fun subs4(view: View){
        var count4  = edt2.text.toString().toInt()
        count4--
        edt2.setText(count4.toString())
    }
    fun add4(view: View){
        var counta4  = edt2.text.toString().toInt()
        counta4++
        edt2.setText(counta4.toString())
    }
    fun subs5(view: View){
        var count5  = edt33.text.toString().toInt()
        count5--
        edt33.setText(count5.toString())
    }
    fun add5(view: View){
        var counta5  = edt33.text.toString().toInt()
        counta5++
        edt33.setText(counta5.toString())
    }
    fun subs6(view: View){
        var count6  = edt44.text.toString().toInt()
        count6--
        edt44.setText(count6.toString())
    }
    fun add6(view: View){
        var counta6  = edt44.text.toString().toInt()
        counta6++
        edt44.setText(counta6.toString())
    }
//    fdd
fun subs7(view: View){
    var count7  = edt55.text.toString().toInt()
    count7--
    edt55.setText(count7.toString())
}
    fun add7(view: View){
        var counta7  = edt55.text.toString().toInt()
        counta7++
        edt55.setText(counta7.toString())
    }
    fun subs8(view: View){
        var count8  = edt66.text.toString().toInt()
        count8--
        edt66.setText(count8.toString())
    }
    fun add8(view: View){
        var counta8  = edt66.text.toString().toInt()
        counta8++
        edt66.setText(counta8.toString())
    }

  fun buy(view: View){
      var count1  = TextPersonName5.editableText.toString().toInt()
      var count2  = TextPersonName6.text.toString().toInt()
      var count3  = edt1.text.toString().toInt()
      var count4  = edt2.text.toString().toInt()
      var count5  = edt33.text.toString().toInt()
      var count6  = edt44.text.toString().toInt()
      var count7  = edt55.text.toString().toInt()
      var count8  = edt66.text.toString().toInt()

       val costTotal:String =((125 * count1)+(140 * count2)+(90 * count3)+(130 *count4)+(200*count5)+(125 * count6)+(85 * count7)+(110 * count8)).toString()
      val intent = Intent(this,OrderActivithyMarket::class.java)
      intent.putExtra(OrderActivithyMarket.TOTAL_COST,costTotal)
      startActivity(intent)
  }

}