package uji.al394560.tennisscores

import android.os.Parcel
import android.os.Parcelable

enum class ScoreType {
    Normal, Deuce, Advantage, AdvantageOther
}

internal class TennisScore() : Parcelable {
    var type: ScoreType = ScoreType.Normal
        private set
    var points: Int = 0
        private set
    var games: Int = 0
        private set
    var sets: Int = 0
        private set
    private val prevSets = ArrayList<Int>()
    val previousSets: List<Int> = prevSets

    constructor(parcel: Parcel) : this() {
        type = parcel.readType()
        points = parcel.readInt()
        games = parcel.readInt()
        sets = parcel.readInt()
        prevSets.addAll(parcel.createIntArray()!!.toList())
    }

    fun reset() {
        points = 0
        sets = 0
        games = 0
        prevSets.clear()
    }

    fun addPoint(other: TennisScore) {
        when(type) {
            ScoreType.Normal -> points = when (points) {
                0 -> 15
                15 -> 30
                30 -> {
                    if (other.points == 40) {
                        type = ScoreType.Deuce
                        other.type = ScoreType.Deuce
                    }
                    40
                }
                40 -> {
                    addGame(other)
                    0
                }
                else -> throw Exception("Impossible points: $points")
            }
            ScoreType.Deuce -> {
                type = ScoreType.Advantage
                other.type = ScoreType.AdvantageOther
            }
            ScoreType.Advantage -> addGame(other)
            ScoreType.AdvantageOther -> {
                type = ScoreType.Deuce
                other.type = ScoreType.Deuce
            }
        }
    }

    private fun clearPoints() {
        type = ScoreType.Normal
        points = 0
    }

    private fun clearGames() {
        clearPoints()
        prevSets.add(games)
        games = 0
    }

    private fun addGame(other: TennisScore) {
        clearPoints()
        other.clearPoints()
        games++
        if (games == 6)
            addSet(other)
    }

    private fun addSet(other: TennisScore) {
        clearGames()
        other.clearGames()
        sets++
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeType(type)
        parcel.writeInt(points)
        parcel.writeInt(games)
        parcel.writeInt(sets)
        parcel.writeIntArray(prevSets.toIntArray())
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TennisScore> {
        override fun createFromParcel(parcel: Parcel): TennisScore {
            return TennisScore(parcel)
        }

        override fun newArray(size: Int): Array<TennisScore?> {
            return arrayOfNulls(size)
        }
    }
}

private fun Parcel.writeType(type: ScoreType) = writeInt(type.ordinal)

private fun Parcel.readType() = ScoreType.values()[readInt()]
