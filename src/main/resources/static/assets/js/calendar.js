calendar = {
    callCalendarForMonth: function(){
      var query = {
                 date: "2022-09-01"
             };
                             $
                                 .ajax({
                                     type: "GET",
                                     url: "http://192.168.0.233:8080/v1/reservation/available_rooms_month/",
                                     data: query,
                                     contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                                     success: function (json) {
                                         alert(json);
                                     }
                                 });
    }
}
