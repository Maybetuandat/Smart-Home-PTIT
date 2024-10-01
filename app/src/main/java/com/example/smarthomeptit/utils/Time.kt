import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun formatDateToString(date: Date): String {
    // Sử dụng Calendar để thao tác với thời gian
    val calendar = Calendar.getInstance()
    calendar.time = date
    calendar.add(Calendar.HOUR, -7) // Giảm 7 giờ

    val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    return formatter.format(calendar.time) // Trả về thời gian đã chỉnh sửa
}
