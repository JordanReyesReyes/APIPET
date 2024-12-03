@Petstore
Feature: API Petstore

  Como un usuario de la API de Petstore
  Quiero gestionar mascotas
  Para poder verificar y administrar los detalles de las mascotas disponibles en el sistema

  @CP01
  Scenario: Obtener todas las mascotas por estado exitosamente
    Given el actor establece el endpoint para obtener mascotas por estado
    When el actor envia una solicitud GET con el estado "available"
    Then el codigo de respuesta deberia ser 200

  @CP02
  Scenario Outline: Crear una mascota exitosamente
    Given el actor establece el endpoint POST para crear una mascota
    When el envia una solicitud HTTP POST con el "<id>" "<name>" "<status>"
    Then el codigo de respuesta deberia ser 200
    Examples:
      | id   | name      | status    |
      | 1    | Rex       | available |
      | 2    | Whiskers  | sold      |

  @CP03
  Scenario: Actualizar una mascota exitosamente
    Given el actor establece el endpoint para actualizar una mascota
    When el envia una solicitud HTTP PUT con el id "1" y los datos actualizados
    Then el codigo de respuesta deberia ser 200

  @CP04
  Scenario: Eliminar una mascota exitosamente
    Given el actor establece el endpoint para eliminar una mascota
    When el envia una solicitud HTTP DELETE con el id "1"
    Then el codigo de respuesta deberia ser 200
