package com.example.e4clinic.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.e4clinic.R
import com.example.e4clinic.databinding.FragmentHomeBinding
import com.example.e4clinic.ui.activities.HomeActivity
import com.example.e4clinic.ui.core.BaseFragment
import com.example.e4clinic.ui.core.BaseViewModel


class HomeFragment : BaseFragment<BaseViewModel, FragmentHomeBinding>(BaseViewModel::class.java) {
    override fun getLayoutRes(): Int = R.layout.fragment_home

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initToolBar()
        initHorizontalPercChart()

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding.txtMonthYear.text = ""
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initToolBar() {


    }

    private fun initHorizontalPercChart() {
        val row = TableRow(requireContext())
        val params1: TableRow.LayoutParams = TableRow.LayoutParams(
            TableLayout.LayoutParams.MATCH_PARENT,
            TableLayout.LayoutParams.WRAP_CONTENT,
            10f
        )
        row.layoutParams = params1
        row.setPadding(50, 10, 50, 10) // row.setBackgroundColor(Color.parseColor("#22000000"));


        val tv = TextView(requireContext())
        val params2: TableRow.LayoutParams = TableRow.LayoutParams(0, 110, 50f)
        tv.layoutParams = params2
        tv.textSize = 30f
        tv.setBackgroundResource(R.drawable.chart_bg)
        // tv.setBackgroundColor(Color.parseColor("#659D32"));

        // tv.setBackgroundColor(Color.parseColor("#659D32"));
        val tv2 = TextView(requireContext())
        val params3: TableRow.LayoutParams =
            TableRow.LayoutParams(0, TableLayout.LayoutParams.MATCH_PARENT, 10f)
        tv2.layoutParams = params3
        tv2.setBackgroundColor(Color.parseColor("#ffff19"))

        val tv3 = TextView(requireContext())
        val params4: TableRow.LayoutParams =
            TableRow.LayoutParams(0, TableLayout.LayoutParams.MATCH_PARENT, 40f)
        tv3.layoutParams = params4
        tv3.setBackgroundResource(R.drawable.green_chart_bg)
        //tv3.setBackgroundColor(Color.parseColor("#FF0000"));

        //tv3.setBackgroundColor(Color.parseColor("#FF0000"));
        row.addView(tv)
        row.addView(tv2)
        row.addView(tv3)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

        }
        return super.onOptionsItemSelected(item)
    }
}