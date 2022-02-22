package uji.al394560.tennisscores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class TennisScoresActivity : AppCompatActivity(), ITennisScoresView {

    lateinit var score1Text : TextView
    lateinit var score2Text : TextView
    lateinit var set1Text : TextView
    lateinit var set2Text : TextView
    lateinit var game1Text : TextView
    lateinit var game2Text : TextView
    lateinit var point1Text : TextView
    lateinit var point2Text : TextView
    lateinit var threeSetsButton : Button
    lateinit var fiveSetsButton : Button
    lateinit var pointAButton : Button
    lateinit var pointBButton : Button
    lateinit var pointResetButton : Button

    lateinit var presenter : TennisScoresPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        score1Text = findViewById(R.id.score1TextView)
        score2Text = findViewById(R.id.score2TextView)
        set1Text = findViewById(R.id.sets1TextView)
        set2Text = findViewById(R.id.sets2TextView)
        game1Text = findViewById(R.id.games1TextView)
        game2Text = findViewById(R.id.games2TextView)
        point1Text = findViewById(R.id.points1TextView)
        point2Text = findViewById(R.id.points2TextView)
        threeSetsButton = findViewById(R.id.radioButton3)
        fiveSetsButton = findViewById(R.id.radioButton5)
        isMaxSetsEnabled = true;

        presenter = TennisScoresPresenter(this)

        pointAButton = findViewById(R.id.pointAButton)
        pointAButton.setOnClickListener { presenter.onAPointScored() }

        pointBButton = findViewById(R.id.pointBButton)
        pointBButton.setOnClickListener { presenter.onBPointScored() }

        pointResetButton = findViewById(R.id.resetButton)
        pointResetButton.setOnClickListener { presenter.pointResetButton() }

    }

    override var isMaxSetsEnabled: Boolean
        get() = threeSetsButton.isEnabled && fiveSetsButton.isEnabled
        set(value) {
            threeSetsButton.isEnabled = value
            fiveSetsButton.isEnabled = value
        }

    override fun displayScores(score1: String, score2: String) {
        TODO("Not yet implemented")
    }

    override fun displaySetResults(set1: String, set2: String) {
        TODO("Not yet implemented")
    }

    override fun displayGames(game1: String, game2: String) {
        TODO("Not yet implemented")
    }

    override fun displayPoints(point1: String, point2: String) {
        TODO("Not yet implemented")
    }
}