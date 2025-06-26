# Vehicle-Service-Booking-System
This plan assumes a Scrum-based Agile approach, which is well-suited for iterative development and cross-functional collaboration.

# Overview

## 1. Introduction
This document details the Low-Level Design (LLD) for a Vehicle Service Booking System, which enables users to book vehicle service appointments, track service history, and manage service center operations efficiently.
This design supports Java(Spring Boot) framework for backend development and React framework for frontend development.

## 2. Module Overview
![image](https://github.com/user-attachments/assets/5509de9b-73bc-42dc-89d2-4d68c3b9b37e)

### 2.1 User Management
Handles customer registration, profile management, and service history.

### 2.2 Vehicle Management
Manages customer vehicles including model, make, and registration details.

### 2.3 Service Booking
Allows users to schedule service appointments and track their status.

### 2.4 Service Center Management
Manages service center availability, mechanics, and service types.

### 2.5 Invoice and Billing
Generates invoices for completed services and manages payment records.

## 3. Architecture Overview

### 3.1 Architectural Style
- **Frontend**: React
- **Backend**: REST API-based, Spring Boot
- **Database**: Relational (MySQL/PostgreSQL/SQL Server)

### 3.2 Component Interaction
- The frontend communicates with the backend REST APIs.
- The backend processes requests, interacts with the database, and sends responses.
- All user interactions and bookings are performed through the web interface.
## 4. Module-Wise Design

### 4.1 User Management Module
**Features**
- User registration, login, and profile updates
- View service booking history

**Entities**
- User: UserID, Name, Email, Phone, Address, PasswordHash

### 4.2 Vehicle Management Module
**Features**
- Register and manage vehicles
- Link vehicles to user profiles

**Entities**
- Vehicle: VehicleID, UserID, Make, Model, Year, RegistrationNumber

### 4.3 Service Booking Module
**Features**
- Book service appointments
- Cancel or reschedule bookings
- Track service status

**Entities**
- Booking: BookingID, UserID, VehicleID, ServiceCenterID, Date, TimeSlot, Status

### 4.4 Service Center Management Module
**Features**
- Manage service centers and mechanics
- Define available service types

**Entities**
- ServiceCenter: ServiceCenterID, Name, Location, Contact
- Mechanic: MechanicID, ServiceCenterID, Name, Expertise
- ServiceType: ServiceTypeID, Description, Price

### 4.5 Invoice and Billing Module
**Features**
- Generate invoice upon service completion
- Manage and record payments

**Entities**
- Invoice: InvoiceID, BookingID, ServiceTypeID, TotalAmount, PaymentStatus

## 5. Deployment Strategy

### 5.1 Local Deployment
- Angular/React for frontend (via local dev servers)
- Spring Boot/ASP.NET Core for backend (via localhost server)
- Local relational DB setup for development (MySQL/PostgreSQL/SQL Server)

## 6. Database Design
| Table Name | Primary Key | Foreign Keys |
|------------|-------------|--------------|
| User       | UserID      | -            |
| Vehicle    | VehicleID   | UserID       |
| Booking    | BookingID   | UserID, VehicleID, ServiceCenterID |
| ServiceCenter | ServiceCenterID | - |
| Mechanic   | MechanicID  | ServiceCenterID |
| ServiceType | ServiceTypeID | - |
| Invoice    | InvoiceID   | BookingID, ServiceTypeID |
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


# REST API Endpoints for Vehicle Service Booking System

## 1. User Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/users/register` | Register a new user |
| `POST` | `/api/users/login` | Authenticate user |
| `GET`  | `/api/users/{id}` | Get user profile |
| `PUT`  | `/api/users/{id}` | Update user profile |
| `GET`  | `/api/users/{id}/history` | View service history |

## 2. Vehicle Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/vehicles` | Register a new vehicle |
| `GET`  | `/api/vehicles` | Get all vehicles for a user |
| `GET`  | `/api/vehicles/{id}` | Get vehicle details |
| `PUT`  | `/api/vehicles/{id}` | Update vehicle details |
| `DELETE` | `/api/vehicles/{id}` | Delete a vehicle |

## 3. Service Booking
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/bookings` | Create a new booking |
| `GET`  | `/api/bookings` | Get all bookings for a user |
| `GET`  | `/api/bookings/{id}` | Get booking details |
| `PUT`  | `/api/bookings/{id}` | Update booking (reschedule/cancel) |
| `GET`  | `/api/bookings/{id}/status` | Track booking status |

## 4. Service Center Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/service-centers` | Add a new service center |
| `GET`  | `/api/service-centers` | List all service centers |
| `GET`  | `/api/service-centers/{id}` | Get service center details |
| `POST` | `/api/service-centers/{id}/mechanics` | Add mechanic to a center |
| `GET`  | `/api/service-centers/{id}/mechanics` | List mechanics in a center |
| `POST` | `/api/service-types` | Define a new service type |
| `GET`  | `/api/service-types` | List all service types |

## 5. Invoice and Billing
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/invoices` | Generate invoice for a booking |
| `GET`  | `/api/invoices` | Get all invoices for a user |
| `GET`  | `/api/invoices/{id}` | Get invoice details |
| `PUT`  | `/api/invoices/{id}/status` | Update payment status |
| `GET`  | `/api/invoices/{id}/download` | Download invoice PDF |

