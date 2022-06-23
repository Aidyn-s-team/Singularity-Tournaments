package kz.home.singularitytournaments.presentation

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.textfield.TextInputEditText
import kz.home.singularitytournaments.R
import kz.home.singularitytournaments.domain.Match
import kz.home.singularitytournaments.domain.Player
import kz.home.singularitytournaments.domain.Round
import kz.home.singularitytournaments.domain.Tournament
import kz.home.singularitytournaments.presentation.moderator.ModeratorTournamentAdapter
import kz.home.singularitytournaments.presentation.player.RoundsAdapter
import kz.home.singularitytournaments.presentation.player.TournamentAdapter
import org.koin.android.ext.android.inject

val tournamentList = mutableListOf(Tournament("tennis"))
val round = Round(1, listOf(Match(1, Player("T"), Player("J")), Match(1, Player("A"), Player("B"))))
val roundsList = mutableListOf(round)

class MainActivity(
) : AppCompatActivity(R.layout.activity_main) {

    private val tAdapter: ModeratorTournamentAdapter by inject()
    private val tChooseAdapter: TournamentAdapter by inject()
    private val roundsAdapter: RoundsAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter = MainPagerAdapter(this, showCreateDialog = {showCreateDialog()}, tAdapter, tChooseAdapter, roundsAdapter)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPager.adapter = adapter
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Регистрация на турниры"
                1 -> tab.text = "Турнирная сетка"
                else -> tab.text = "Результаты"
            }
        }.attach()
    }

    private fun showCreateDialog(){
        val dialogView = layoutInflater.inflate(R.layout.dialog_create_tournament, null)
        val dialog = AlertDialog.Builder(this).apply {
            setView(dialogView)
        }.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        var text = ""

        val tournamentNameInput = dialogView.findViewById<TextInputEditText>(R.id.name_input)
        tournamentNameInput.setOnEditorActionListener { _, keyCode, _ ->
            if (keyCode == EditorInfo.IME_ACTION_DONE || keyCode == EditorInfo.IME_ACTION_NEXT) {
                text = tournamentNameInput.text.toString()

                val imm: InputMethodManager =
                    getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.toggleSoftInput (InputMethodManager.HIDE_IMPLICIT_ONLY, 0)

                dialogView.findViewById<Button>(R.id.add_button).setOnClickListener {
                    val item = Tournament(text)
                    tournamentList.add(item)
                    tAdapter.addItem(item)
                    dialog.dismiss()
                }
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }

        dialog.show()
    }
}