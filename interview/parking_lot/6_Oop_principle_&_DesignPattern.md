# Step 6: Apply OOP Principles & Design Patterns

The system design incorporates essential design patterns and OOP principles to ensure flexibility, scalability, and maintainability.

## Design Patterns Used
- **Adapter Pattern**: Abstraction of payment gateways
- **Repository Pattern**: Isolation of database operations
- **Service Layer Pattern**: Centralization of business logic

## OOP Principles Applied
- **SRP (Single Responsibility Principle)**: Each class has one clear responsibility
- **ISP (Interface Segregation Principle)**: Role-specific interfaces (e.g., for payment)
- **DIP (Dependency Inversion Principle)**: Services depend on interfaces, not concrete implementations
- **Open/Closed Principle**: The system is open for extension but closed for modification
- **Encapsulation**: Domain entities encapsulate both data and behavior

> **Interview Tip**: Highlight how applying these design patterns and principles ensures the system is both flexible and easy to extend, allowing for new features like additional payment gateways or vehicle types without major code changes.