package uji.al394560.tennisscores

import android.widget.Button

interface ITennisScoresView {
    fun displayScores(score1: String, score2 : String)
    fun displaySetResults(set1: String, set2 : String)
    fun displayGames(game1: String, game2 : String)
    fun displayPoints(point1: String, point2 : String)

    var isMaxSetsEnabled : Boolean
}