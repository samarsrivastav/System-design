# Step 2: Identify Core Entities

| **Entity**           | **Key Attributes**                                |
|----------------------|---------------------------------------------------|
| **Vehicle**          | `id`, `licensePlate`, `vehicleType`               |
| **ParkingSlot**      | `id`, `slotType`, `isOccupied`, `floorNumber`     |
| **Floor**            | `id`, `floorNumber`, `slots`                      |
| **Ticket**           | `id`, `vehicleId`, `slotId`, `entryTime`, `isActive` |
| **Receipt**          | `id`, `ticketId`, `exitTime`, `totalFee`, `paymentStatus` |
| **PricingRule**      | `vehicleType`, `ratePerHour`, `flatRate`, `ruleType` |
| **Payment**          | `ticketId`, `amount`, `gateway`, `status`         |
| **EntryResult/ExitResult** | `success`, `data`, `message`                 |

> **Interview Tip**: Model your entities using enums and flags where applicable. It adds clarity and control.
