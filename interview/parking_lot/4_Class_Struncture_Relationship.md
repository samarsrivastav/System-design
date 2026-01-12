# Step 4: Defines Class Structures & Relationships

## Layers of Architecture
We will design the architecture layers of the system in a structured way, ensuring separation of concerns and modularity. The system will be organized into the following layers:

- **Client Layer** → **Controller Layer** → **Service Layer** → **Repository Layer** → **Domain Layer**

### Each layer has a distinct role:
- **Client Layer**: Responsible for user interaction and presenting information to the user.
- **Controller Layer**: Handles incoming requests from the client and delegates the tasks to the appropriate service.
- **Service Layer**: Contains the business logic, such as ticket generation and fee calculation.
- **Repository Layer**: Manages data access and persistence.
- **Domain Layer**: Defines the core entities like vehicles, slots, tickets, etc.

## Controllers
- `EntryController.enterVehicle()`
- `ExitController.exitVehicle()`
- `AdminController.addFloor()`, `addSlot()`, `updatePricing()`

## Services
The system will include several services responsible for core business operations. Each service will handle specific tasks:
- **TicketService**: Generates and retrieves tickets
- **SlotService**: Allocates and releases parking slots
- **PricingService**: Calculates fees based on parking duration and type
- **PaymentService**: Processes payments for parking tickets
- **ReceiptService**: Generates receipts after payment
- **AdminService**: Handles administrative tasks like adding floors, updating pricing, and slot management

## Repositories
The Repositories will abstract data access for the core entities like:
- **TicketRepository**
- **SlotRepository**
- **FloorRepository**
- **PricingRuleRepository**
- **PaymentRepository**

Each repository will be responsible for:
- Managing CRUD operations (Create, Read, Update, Delete) for Tickets, Slots, Floors, Pricing Rules, and Payments
- Providing methods to query and persist data efficiently

## Interfaces and Adapters
We will use interfaces and adapters to integrate external services:
- **PaymentGatewayAdapter**
- **RazorpayAdapter**
- **StripeAdapter**

The adapter pattern will allow for:
- Abstracting payment gateway interactions
- Easily switching or adding new payment services like Razorpay or Stripe by implementing the `PaymentGatewayAdapter` interface

> **Interview Tip**: Discuss layering and interfaces to show that you understand separation of concerns.