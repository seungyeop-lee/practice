package court

import java.time.DayOfWeek
import java.time.LocalDateTime

class Reservation {

    static belongsTo = Player //Reservation이 Player에 속해 있음을 명시

    String courtName
    Date date
    Player player
    String sportType

    static constraints = {
        //문자열 값이 Tennin이거나 Soccer이어야 한다.
        sportType(inList: ["Tennis", "Soccer"])
        //커스텀 검증기를 이용한 특정 시간대 확인
        date(validator: {
            if (it.getAt(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY &&
                    (it.getAt(Calendar.HOUR_OF_DAY) < 8 || it.getAt(Calendar.HOUR_OF_DAY) > 22)) {
                return ['invalid.holidayHour']
            } else if (it.getAt(Calendar.HOUR_OF_DAY) < 9 || it.getAt(Calendar.HOUR_OF_DAY) > 21) {
                return ['invalid.weekdayHour']
            }
        })
    }
}
