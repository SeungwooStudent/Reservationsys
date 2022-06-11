$(document).ready(function () {

    getReservation();
//
    function getReservation() {

        $.ajax({
            type: "GET",
            url: "http://192.168.0.233:8080/v1/reservation/all",
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",

            success: function (json) {

                $('#reservation_body').html("");
                var list = json;
                var listLen = list.length;


                for (var i = 0; i < listLen; i++) {

                    var str = "<tr>" +
                        "<td></td>" +
                        "<td>" + list[i].id + "</td>" +
                        "<td>" + list[i].name + "</td>" +
                        "<td>" + list[i].phoneNumber + "</td>" +
                        "<td>" + list[i].count + "</td>" +
                        "<td>" + list[i].roomNo + "</td>" +
                        "<td>" + list[i].startDate + " / " + list[i].endDate + "</td>" +
                        "<td>" + list[i].service + "</td>" +
                        "<td></td>" +
                        "</tr>";
                    $('#reservation_body').append(str);

                }

            }
        })

    }
})