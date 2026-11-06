# Restaurant Recipe Manager

My first Spring Boot application, built as a final project for a Databases course. It is a full-stack web application designed to manage a restaurant's recipes, ingredients, and categories, with a strong focus on integrating complex SQL queries and reports into a Java backend.

## Technologies and Tools

- **Backend:** Java 17, Spring Boot (Spring MVC), Spring Data JPA / Hibernate
- **Database:** MySQL
- **Frontend:** Thymeleaf, HTML, CSS
- **Build and Utilities:** Maven, Lombok

## Key Features

- **Data Management (CRUD):** Add, edit, and delete recipe categories through a user-friendly interface.
- **Advanced SQL Reporting:** Pages dedicated to running complex native SQL queries, including:
  - Filtering and sorting (e.g., vegetarian recipes ordered by preparation time and name).
  - Relational data mapping using `JOIN`s (e.g., recipes requiring exactly 500g of onions).
  - `SELF JOIN`s to find ingredient pairs used in the exact same quantities across different recipes.
  - Subqueries for comparative data (e.g., finding recipes that use more garlic than "Tocanita de pui").
  - Aggregations (`GROUP BY`) to calculate minimum, maximum, and average preparation times per category.
- **Data Integrity Auditing:** Displays the results of a MySQL stored procedure designed to detect inconsistent recipes (e.g., soups without water, vegetarian recipes with meat).

## Project Architecture

The application follows a standard layered architecture:

```text
├── controller/        # Web controllers handling HTTP requests and routing
├── service/           # Core business logic bridging controllers and data access
├── dao/
│   ├── entity/        # JPA Entities (Reteta, Ingredient, Categorie, SetIngrediente, Exceptie)
│   ├── repository/    # Spring Data interfaces featuring native SQL queries
│   └── service/       # Data access services for database interactions
└── templates/         # Thymeleaf HTML views for the frontend
```
