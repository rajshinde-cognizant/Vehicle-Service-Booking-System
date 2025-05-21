# Vehicle-Service-Booking-System
This plan assumes a Scrum-based Agile approach, which is well-suited for iterative development and cross-functional collaboration.

# Agile Methodology for Vehicle Service Booking System

## 1. Introduction
This document details the Agile methodology for the Vehicle Service Booking System project. The project enables users to book vehicle service appointments, track service history, and manage service center operations efficiently. The development will be done using Java Spring Boot for the backend and Angular/React for the frontend.

## 2. Team Roles
- **Product Owner**: Defines features, prioritizes backlog, and ensures business value.
- **Scrum Master**: Facilitates Agile practices, removes blockers.
- **Development Team**: Backend (Java Spring Boot), Frontend (React), QA.

## 3. Sprint Plan (6 Sprints Total)
### Sprint 1: Project Setup & User Module Start
**Goal**: Establish project infrastructure and begin user management module.
- **All**: Project setup (Git, DB schema)
- **A**: User registration, login, profile update (backend + frontend)
- **B**: Vehicle entity & DB setup
- **C**: Booking entity & DB setup
- **D**: Service center entity & DB setup

**User Stories**:
- As a user, I want to register and log in securely.
- As a user, I want to update my profile.

### Sprint 2: Vehicle Module & User History
**Goal**: Implement vehicle management and user service history.
- **A**: View service history
- **B**: Add/view/update vehicles (backend + frontend)
- **C**: Booking logic (create, cancel)
- **D**: Add service types, mechanics

**User Stories**:
- As a user, I want to view my service history.
- As a user, I want to register my vehicle.
- As a user, I want to view and update vehicle details.

### Sprint 3: Booking Module & Service Center UI
**Goal**: Develop booking functionality and service center management UI.
- **A**: Integrate user profile with bookings
- **B**: Link vehicles to users
- **C**: Booking status tracking
- **D**: Service center UI (list, filter, assign mechanics)

**User Stories**:
- As a user, I want to book a service appointment.
- As a user, I want to cancel or reschedule a booking.
- As a user, I want to track the status of my service.
- As an admin, I want to manage service centers and mechanics.

### Sprint 4: Integration & Testing
**Goal**: Integrate all modules and perform thorough testing.
- **All**: Integrate modules (User ↔ Vehicle ↔ Booking ↔ Service Center)
- **All**: Write unit tests, API tests
- **All**: Fix bugs, improve UI/UX

**User Stories**:
- As a user, I want a seamless experience across all functionalities.

### Sprint 5: Invoice & Billing (Collaborative)
**Goal**: Implement invoice generation and payment management.
- **All**: Implement invoice generation, payment status
- **All**: Link invoices to bookings and users
- **All**: Frontend for invoice viewing and download

**User Stories**:
- As a user, I want to view and download invoices.
- As an admin, I want to manage payment records.

### Sprint 6: Final QA, Polish & Deployment
**Goal**: Finalize the project with end-to-end testing, performance tuning, and deployment.
- **All**: End-to-end testing
- **All**: Performance tuning
- **All**: Final documentation
- **All**: Deployment to staging/production

**User Stories**:
- As a user, I want a polished and reliable system.
- As an admin, I want the system to be ready for production.
## 4. Module Assignments
| Member | Assigned Module |
|--------|------------------|
| A      | User Management  |
| B      | Vehicle Management |
| C      | Service Booking  |
| D      | Service Center Management |
| All    | Invoice & Billing (Final Sprint) |

## 5. Agile Ceremonies
- **Daily Standups**: 15 mins to sync progress
- **Sprint Planning**: Assign tasks per module
- **Sprint Review**: Demo completed features
- **Sprint Retrospective**: Discuss improvements

## 6. Tools Used
- **IDE**: Visual Studio Code
- **Version Control**: Git (GitHub)
- **Testing**: Postman, JUnit
- **Documentation**: VS code

## 7. Project Structure Overview
```
vehicle-service-booking-system/
│
├── backend/
│   └── spring-boot/                # Java Spring Boot implementation
│    
├── frontend/
│   └── react-app/                  # React frontend
│
├── database/
│   └── schema.sql                  # SQL script for DB schema
│
├── docs/
│   └── LLD.md                      # Low-Level Design document
│
└── README.md
```
**Backend Structure**
```
src/main/java/com/vehiclebooking/
├── controller/
│   ├── UserController.java
│   ├── VehicleController.java
│   ├── BookingController.java
│   ├── ServiceCenterController.java
│   └── InvoiceController.java
│
├── service/
│   ├── UserService.java
│   ├── VehicleService.java
│   ├── BookingService.java
│   ├── ServiceCenterService.java
│   └── InvoiceService.java
│
├── model/
│   ├── User.java
│   ├── Vehicle.java
│   ├── Booking.java
│   ├── ServiceCenter.java
│   ├── Mechanic.java
│   ├── ServiceType.java
│   └── Invoice.java
│
├── repository/
│   ├── UserRepository.java
│   ├── VehicleRepository.java
│   ├── BookingRepository.java
│   ├── ServiceCenterRepository.java
│   └── InvoiceRepository.java
│
└── VehicleBookingApplication.java
```

**Frontend Structure**
```
src/
├── components/
│   └── UserDashboard.jsx
│   └── VehicleManagement.jsx
│   └── BookingForm.jsx
│   └── ServiceCenterViewer.jsx
│   └── InvoiceHistory.jsx
│
├── services/
│   └── userService.js
│   └── vehicleService.js
│   └── bookingService.js
│   └── serviceCenterService.js
│   └── invoiceService.js
│
└── App.js
```


