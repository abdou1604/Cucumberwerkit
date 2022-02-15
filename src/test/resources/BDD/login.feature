Feature: Werk-it creation profile

  Scenario: Cree ub profile avec des données valides

    Given je suis dans la page werk-it
    When je  creer un profile avec des donnees valide
      | First Name | Last Name | Email | Username | Password |
      | abdessalam | rouabha1 | abdel@gmail.com | abdou | cgi123 |
    Then je vérifie la confirmation  de la creation du profile

  