# acceptance criteria

- user click `Register` and navigates to register form
- user inputs data
    - email input (email format *)
    - password input
    - first name input
    - last name input
- user clicks the `Register` button, and the user should be saved in db
- input validation *

# frontend

- form template
    - email input
    - password input
    - first name input
    - last name input
    - gdpr checkbox *
    - submit button "Register"

# backend

- entity
    - User
- repository
    - UserRepository
- service
    - UserService
- controller
    - UserController

- spring security config
    - authentication
    - authorization
    - user details service
        - load user by username

no security
no backend validation
no frontend validation
no styling
