import android.util.Log

class Controller(private val callback: Callback) {

    fun adu(data1: String, data2: String) {
        when (data1 + data2) {
            "1" + "1", "2" + "2", "3" + "3" -> {
                callback.tampilanHasil("DRAW!")
            }

            "1" + "2", "2" + "3", "3" + "1" -> {
                callback.tampilanHasil("KAMU KALAH :(")

            }

            "3" + "2", "2" + "1", "1" + "3" -> {
                callback.tampilanHasil("KAMU MENANG!")
            }
        }
    }

}