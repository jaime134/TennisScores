package uji.al394560.tennisscores

class TennisScoresPresenter(val view: TennisScoresActivity) {

    fun onAPointScored() {
        TODO("Not yet implemented")
    }

    fun onBPointScored() {
        TODO("Not yet implemented")
    }

    fun pointResetButton() {
        TODO("Not yet implemented")
    }

    private fun pointsToString(points: Int, type: ScoreType): String {
        return when (type) {
            ScoreType.Normal -> when (points) {
                0 -> "00"
                else -> points.toString()
            }
            ScoreType.Deuce -> "40"
            ScoreType.Advantage -> "Ad"
            ScoreType.AdvantageOther -> "__"
        }
    }
}