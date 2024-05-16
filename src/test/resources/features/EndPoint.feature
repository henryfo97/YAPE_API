#language: es
@Yape_001
Característica: API Yape

  @Yape_002
  Escenario: Validar generacion de Auth - CreateToken
    Dado ingreso body request de usuario
      | username | password    |
      | admin    | password123 |
    Entonces valido el codigo de respuesta "200"
    Dado muestro el resultado

  @Yape_003
  Escenario: Validar listado de Booking - GetBookingIds
    Dado listo bookingid
    Entonces valido el codigo de respuesta del get "200"

  @Yape_004
  Escenario: Validar request de Booking - GetBooking
    Dada envio el id "505" que deso consultar
    Entonces valido el codigo de respuesta para booking "200"
    Y muestro el resultado de booking

  @Yape_005
  Escenario: Validar request de Booking - CreateBooking
    Dado que ingreso el body request
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Jim       | Brown    | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |
    Entonces valido el codigo de respuesta para create booking "200"
    Y muestro el response de create booking

  @Yape_006
  Escenario: Validar request de Booking - UpdateBooking
    Dado que ingreso el body request update
      | Authorization                  | id   | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Basic YWRtaW46cGFzc3dvcmQxMjM= | 1427| Jim2      | Brown2   | 112        | true        | 2018-01-02 | 2019-01-02 | Dinner          |
    Entonces valido el codigo de respuesta para update booking "200"
    Y muestro el response de update booking

  @Yape_007
  Escenario: Validar request de Booking - PartialUpdateBooking
    Dado que ingreso el body request partialupdate
      | Authorization                  | id   | firstname | lastname |
      | Basic YWRtaW46cGFzc3dvcmQxMjM= | 2013 | Jim3      | Brown3   |
    Entonces valido el codigo de respuesta para partialupdate booking "200"
    Y muestro el response de partialupdate booking

  @Yape_008
  Escenario: Validar listado de Booking - DeleteBooking
    Dado ejecuto el delete
      | Authorization                  | id   |
      | Basic YWRtaW46cGFzc3dvcmQxMjM= | 2013 |
    Entonces valido el codigo de respuesta para delete booking "201"
    Y muestro el response de delete booking

  @@Yape_009
  Escenario: Validar listado de Ping - HealthCheck
    Dado ejecuto el HealthCheck
    Entonces valido el codigo de respuesta para health "201"
    Y muestro el response de health

