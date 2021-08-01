#language: es

Característica: buscar mejor opción de cuota para el crédito de vivienda
  Como usuario del sitio metro cuadrado,
  Deseo poder calcular el valor de la cuota para el crédito de vivienda,
  Para elegir un valor que sea fácil de pagar durante el periodo de tiempo seleccionado para pagar el préstamo.

  Esquema del escenario: calcular el valor de la cuota para el crédito de vivienda de acuerdo con valor del préstamo
    Dado que ingresé el valor del crédito <valor del crédito>, el plazo del crédito <plazo>
    Cuando calculo el valor de la cuota del crédito
    Entonces pueda obtener un valor que sea fácil de pagar durante la vigencia del préstamo

    Ejemplos:
      | valor del crédito | plazo   |
      | 290000000         | 5 Años  |
      | 290000000         | 10 Años |
      | 290000000         | 15 Años |
      | 290000000         | 20 Años |
