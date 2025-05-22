// Parse hour and minute values supplied as strings and calculate the time difference between them

object TimeDifferenceFromString:
    def getDuration(start: String, end: String): Int = {
        import java.time.*
        import java.time.format.DateTimeFormatter
        import scala.math.*
        
        // Define the time format
        val formatter = DateTimeFormatter.ofPattern("HH:mm")

        val startTime = LocalTime.parse(start, formatter)
        val endTime = LocalTime.parse(end, formatter)

        val stayPeriod = Duration.between(startTime, endTime)

        val fullHours = stayPeriod.toHours.toInt
        val totalHours = ceil(stayPeriod.toMinutes / 60.0).toInt

        // Calculate the total cost example where the first unfinished hour costs 3,
        // and each additional unfinished hour costs 4
        3 + ((fullHours - 1 + (totalHours - fullHours)) * 4)
  }
end TimeDifferenceFromString