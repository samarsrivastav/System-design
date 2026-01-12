### Step 7: Handling Edge Cases

Handling edge cases is a crucial part of designing a real-world system. In actual production systems, you can’t always rely on perfect input or ideal conditions. It's important to plan for unexpected situations, such as failed payments, lost tickets, or mismatched data, that could arise during regular operations. Properly handling these edge cases ensures that the system remains resilient, reliable, and user-friendly, even under less-than-ideal conditions.

#### Common Edge Cases and Strategies

| **Edge Case**          | **Strategy**                                                                                 |
|-------------------------|---------------------------------------------------------------------------------------------|
| **Lost ticket**         | Provide admin override functionality to manually validate and process the exit.             |
| **Payment failure**     | Implement retry logic through the `PaymentGatewayAdapter` to handle payment failures (e.g., due to network issues). |
| **Mismatched vehicle type** | Ensure validation of vehicle type during entry and exit, allowing the system to reject incompatible vehicle-slot assignments. |
| **Clock issues**        | Use a centralized time service to ensure consistent timestamps across all services and avoid issues like clock skew. |
| **Slot state mismatch** | Implement a reconciliation service to periodically check and correct discrepancies between the system’s slot states and the database. |

> **Interview Tip**: Mention failure scenarios to show you think beyond the happy path.