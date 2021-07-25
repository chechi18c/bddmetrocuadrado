#language: es

Característica: calcular opción para crédito de vivienda
  Como usuario registrado en el sitio metro cuadrado,
  Deseo poder calcular opciones de crédito de vivienda,
  Para realizar una compra de apartamento nuevo, de acuerdo con el dinero que me pueda prestar el banco.

  Esquema del escenario: calcular monto máximo de préstamo de acuerdo a ingresos mensuales
    Dado que ingresé el valor de ingresos mensuales <ingresos mensuales>, el plazo del crédito <plazo>
    Cuando calculo el valor del crédito
    Entonces obtendré el valor del crédito que mejor se adapte a mi capacidad de pago, segun mis ingresos

    Ejemplos:
      | ingresos mensuales | plazo   |
      | 4000000            | 5 Años  |
      | 4000000            | 10 Años |
      | 4000000            | 15 Años |
      | 4000000            | 20 Años |


