package kz.home.singularitytournaments.presentation

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener
import kz.home.singularitytournaments.R
import kz.home.singularitytournaments.domain.Match
import kz.home.singularitytournaments.domain.User
import kz.home.singularitytournaments.domain.Round
import kz.home.singularitytournaments.domain.Tournament
import kz.home.singularitytournaments.presentation.login.rootNode
import kz.home.singularitytournaments.presentation.moderator.AllRoundsAdapter
import kz.home.singularitytournaments.presentation.moderator.ModeratorTournamentAdapter
import kz.home.singularitytournaments.presentation.player.RoundsAdapter
import kz.home.singularitytournaments.presentation.player.TournamentAdapter
import org.koin.android.ext.android.inject

val tournamentList = mutableListOf<Tournament>()
val match1 = Match(1,1, User("Tomiris", "yyu"), User("Lazzet", "jgv"))
val match2 = Match(1,2, User("Aidyn", "yyu"), User("Nursulu", "jgv"))
val match3 = Match(2,1, User("Tomiris", "yyu"), User("Nursulu", "jgv"))
val match4 = Match(2,2, User("Aidyn", "yyu"), User("Lazzet", "jgv"))
val match5 = Match(3,1, User("Tomiris", "yyu"), User("Aidyn", "jgv"))
val match6 = Match(3,2, User("Lazzet", "yyu"), User("Nursulu", "jgv"))

val matchList1 = mutableListOf(match1, match2)
val matchList2 = mutableListOf(match3, match4)
val matchList3 = mutableListOf(match5, match6)

val round1 = Round(1,
    listOf(match1,match2))
val round2 = Round(2,
    listOf(match3, match4))
val round3 = Round(3,
    listOf(match5, match6))

val roundsList = mutableListOf(round1, round2, round3)

class MainActivity(
) : AppCompatActivity(R.layout.activity_main) {

    private val tAdapter: ModeratorTournamentAdapter by inject()
    private val tChooseAdapter: TournamentAdapter by inject()
    private val roundsAdapter: RoundsAdapter by inject()
    private val allRoundsAdapter: AllRoundsAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var user = intent.getParcelableExtra<User>("user")
        if (user == null) {
            user = User("1", "1")
        }

        val adapter = MainPagerAdapter(this,
            showCreateDialog = {showCreateDialog()}, tAdapter, tChooseAdapter, roundsAdapter, user, allRoundsAdapter)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPager.adapter = adapter
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Game registration"
                1 -> tab.text = "Rounds"
                else -> tab.text = "Results"
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
                    val item = Tournament(text, "")
                    val reference = rootNode.getReference("Tournaments")
                    reference.child(text).setValue(item)
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