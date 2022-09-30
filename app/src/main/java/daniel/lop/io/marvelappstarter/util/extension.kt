package daniel.lop.io.marvelappstarter.util

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment


fun Fragment.toast(message: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(
        requireContext(),
        message,
        duration
    ).show()
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun String.limitDescription(character: Int): String {
    //this é exatamente a string
    if (this.length > character) {
        val firstCharacter = 0
        return "${this.substring(firstCharacter, character)}..."
    }
    return this
}