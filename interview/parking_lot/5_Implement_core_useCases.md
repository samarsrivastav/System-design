Step 5: Implement Core Use Cases
The system will be designed around key use cases, with each use case mapped to corresponding service and repository methods.

### Entry Use Case
1. `enterVehicle()` 
   - `SlotService.allocateSlot()`
   - `TicketService.generateTicket()`
   - `TicketRepository.save()`
   - Return `EntryResult`

### Exit Use Case
1. `exitVehicle()`
   - Get Ticket
   - Calculate Fee
   - Process Payment (with retries)
   - Release Slot
   - Generate Receipt
   - Return `ExitResult`

### Admin Use Cases
1. `addFloor()` : Save new floor
2. `addSlot()` : Save new slot
3. `updatePricing()` : Update pricing rules

> **Interview Tip**: During interviews, make sure to map each use case directly to the services and repositories it interacts with. This shows clarity in your design and ensures the workflow is easily understandable.