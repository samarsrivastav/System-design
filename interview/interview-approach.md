# Strategic Guide on How to Approach a Low-Level Design (LLD) Interview

Low-Level Design (LLD) interviews can be challenging but are a crucial part of software engineering interviews. This article serves as a **step-by-step guide** to approaching an LLD interview, addressing common doubts, and providing strategies to succeed.

By following these steps, you will learn how to:
- Break down the problem systematically
- Design the system efficiently
- Communicate your thought process clearly

Whether you're preparing for an upcoming interview or strengthening your design skills, this guide will help you navigate LLD interviews with confidence.

---

## Step 1: Clarify Requirements

The first step in any LLD interview is **clarifying requirements**. This ensures alignment with the interviewer and prevents building the wrong solution.

### A. Functional Requirements
Functional requirements define **what the system should do**.

**Examples:**
- **E-commerce system:** Browse products, add to cart, process payments
- **Parking lot system:** Park a car, remove a car, check slot availability

**Key Points:**
- Focus on core features
- Mention key workflows
- Identify constraints or business rules

---

### B. Non-Functional Requirements
Non-functional requirements define **how well the system performs**.

**Examples:**
- Scalability
- Latency
- Availability
- Security

**Key Points:**
- Include measurable performance metrics
- Consider reliability, scalability, and availability
- Think about system behavior under high load

---

### C. Hero Use Cases
Hero use cases represent the **most critical and frequent system flows**.

**Examples:**
- **E-commerce:** Search → purchase
- **Parking lot:** Park → retrieve vehicle

**Key Points:**
- Identify primary users and frequent actions
- These drive core system design
- Ensure clarity and correctness

---

## Step 2: Identify Core Entities

Core entities are the **main objects** driving system behavior.

### A. Define Core Domain Entities
**Examples:**
- **Movie streaming:** User, Movie, Subscription
- **Parking lot:** Car, ParkingSlot, Ticket

**Key Points:**
- Identify entities central to the problem
- Avoid unnecessary entities early

---

### B. Attributes, Responsibilities, and Relationships
- **Attributes:** Data held by the entity
- **Responsibilities:** What the entity does
- **Relationships:** How entities interact

**Example:**
- User → has → Subscription
- Movie → belongs to → Genre

---

### C. Supporting Entities
Used to support auxiliary functionality.

**Examples:**
- Actor, Director (streaming)
- ParkingFee, Payment (parking lot)

---

## Step 3: Visualize Interaction Flow

Visualizing interactions clarifies **data flow and behavior**.

### A. Who Interacts with Whom
- Users
- Internal services
- External systems

---

### B. Use Sequence Flows and Flowcharts
- Internal service calls
- External API interactions (payments, notifications)

---

### C. User-System Interactions
- Login
- Purchase
- Form submission

---

### D. External System Calls
**Examples:**
- Payment gateways
- Email/SMS services

**Key Points:**
- Handle latency and failures
- Design fallback mechanisms

---

## Step 4: Define Class Structures and Relationships

### A. Apply OOP and SOLID Principles
- **SRP:** One responsibility per class
- **OCP:** Open for extension, closed for modification
- **LSP:** Substitutability of subclasses

---

### B. Interfaces, Abstract Classes, and Implementations
**Layers:**
- Controller
- Service
- Repository
- Domain models

---

### C. Design for Scalability and Extensibility
- Loose coupling
- High cohesion
- Abstractions for third-party systems

---

### D. Prepare for Production Scale
- Scalability
- Fault tolerance
- Maintainability

---

## Step 5: Define Core Use Cases and Methods

### A. For Every Major Feature, Define
- Method responsibilities
- Input/output models
- Collaborating classes
- Transaction flow

---

### B. Include Use Cases Like
- CRUD operations
- Real-time flows (e.g., seat locking)
- Background tasks (emails, payments)

---

## Step 6: Apply Design Patterns

### A. Choose Patterns and Justify
**Common Patterns:**
- Singleton
- Factory
- Observer
- Strategy

---

### B. Clean Code Practices
- Meaningful naming
- Consistent formatting
- Modularity
- Documentation

---

## Step 7: Handle Edge Cases

### A. Edge Cases and Failure Scenarios
- Concurrency issues
- State inconsistency
- Partial failures
- Retry handling & idempotency

---

### B. Mitigation Strategies
- Locks
- Cache invalidation
- Compensation logic
- Consistency vs availability trade-offs

---

## Step 8: Class Diagram and Package Structure

### A. Class Diagram
Include:
- Classes
- Attributes
- Methods
- Relationships (inheritance, association, composition)

---

### B. Package Structure
- Layered structure
- Feature-based structure
- Utility/helper packages

---

## Step 9: Discuss Future Add-ons

### A. Potential Add-ons
- Third-party integrations
- Scalability improvements
- New features (search, analytics, ML)

---

### B. Ensure Extensibility
- Modular architecture
- Use design patterns
- Clear separation of concerns

---

## FAQs and Common Doubts

### 1. How much detail should I go into?
- Start high-level
- Dive deep when required
- Avoid trivial details

---

### 2. Should I write code?
- Usually no
- Use diagrams or pseudocode unless asked

---

### 3. How much business logic?
- Focus on architecture
- Explain placement (service layer)

---

### 4. Which patterns to use?
- Strategy (pricing)
- Factory (object creation)
- Observer (events)
- Repository (data access)
- Adapter (third-party integration)

---

### 5. What do interviewers judge?
- Edge case handling
- OOP & SOLID principles
- Scalability and maintainability

---

**Final Tip:**  
Think clearly, communicate confidently, and design incrementally. LLD interviews are less about perfection and more about **structured thinking and sound design decisions**.
