// Parse hour and minute values supplied as strings and calculate the time difference between them

object TimeDifferenceFromString:
  def getDuration(start: String, end: String): Unit =
    import java.time.*
    import java.time.format.DateTimeFormatter
    import scala.math.*

    // Define the time format (or dd-MM-yyyy, etc. if needed)
    val formatter = DateTimeFormatter.ofPattern("HH:mm")

    val startTime = LocalTime.parse(start, formatter)
    val endTime   = LocalTime.parse(end, formatter)

    val stayPeriod = Duration.between(startTime, endTime)

    val fullHours  = stayPeriod.toHours.toInt
    val totalHours = ceil(stayPeriod.toMinutes / 60.0).toInt

    // Business logic goes here, don't forget to change the return type to what you need
    println(s"Full hours: $fullHours, including unfinished hours: $totalHours")
    
  end getDuration
end TimeDifferenceFromString
