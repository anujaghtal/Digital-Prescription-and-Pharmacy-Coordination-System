# Digital-Prescription-and-Pharmacy-Coordination-System
Platform where doctors issue digital prescriptions linked to nearby pharmacy inventory. Doctor prescription panel, patient portal, pharmacy dashboard, prescription QR code, medicine availability checker, refill alerts, prescription history


# 🏥 Digital Prescription and Pharmacy Coordination System

## 📌 Project Overview

The **Digital Prescription and Pharmacy Coordination System** is a full-stack web application designed to digitize and manage medical prescriptions between doctors, patients, pharmacists, and administrators.

It improves healthcare efficiency by enabling secure, role-based digital prescription handling and real-time coordination.

---

## 🎯 Objectives

- Digitize prescription creation and management
- Enable secure communication between healthcare roles
- Allow patients to access prescriptions online
- Reduce manual paperwork
- Improve pharmacy coordination and accuracy

---

## 👥 User Roles

### 👨‍💼 Admin
- Manage users
- Monitor system activity
- Control access permissions

### 👨‍⚕️ Doctor
- Create prescriptions
- View patient history
- Assign medicines

### 🧑 Patient
- View prescriptions
- Download prescription reports
- Track medical history

### 💊 Pharmacist
- View prescriptions
- Update medicine status (pending/dispensed)
- Manage basic inventory

---

## 🏗️ System Architecture

Frontend (React.js)
↓ REST API (JWT Authentication)
Backend (Spring Boot)
↓
MySQL Database

---

## ⚙️ Tech Stack

### Backend
- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security (JWT)
- MySQL
- Lombok
- Swagger / OpenAPI

### Frontend
- React.js (Vite)
- Axios
- React Router DOM
-Tailwind CSS / Material UI

---

## 🗄️ Database Structure

### Tables

- users
- roles
- user_roles
- doctors
- patients
- pharmacists
- prescriptions
- medicines
- prescription_medicines

---

## 🔐 Security Features

- JWT Authentication
- BCrypt password encryption
- Role-based access control
- Stateless session management

---

## 📡 API Endpoints

### Authentication
- POST `/auth/register`
- POST `/auth/login`

### Users
- GET `/users`
- GET `/users/{id}`
- DELETE `/users/{id}`

### Prescriptions
- POST `/prescriptions`
- GET `/prescriptions/{id}`
- GET `/prescriptions/patient/{id}`
- GET `/prescriptions/doctor/{id}`

### Pharmacy
- PUT `/pharmacy/update-status`

---

## 🧩 Project Modules

### Authentication Module
Handles login, registration, and JWT token generation.

### Doctor Module
- Create prescriptions
- Manage patients
- Assign medicines

### Patient Module
- View prescriptions
- Download reports

### Pharmacy Module
- Update medicine status
- View prescriptions

### Admin Module
- Manage users
- System monitoring

---

## 🧱 Backend Structure
controller
service
serviceImpl
repository
entity
dto
security
config
exception



## 🎨 Frontend Structure
src/
├── components
├── pages
├── services
├── routes
├── context
├── utils
└── App.jsx


---

## 🔄 Workflow

1. User logs in/registers
2. JWT token is generated
3. Role-based dashboard is shown
4. Doctors create prescriptions
5. Patients view prescriptions
6. Pharmacists update status
7. Admin manages system

---

## 🚀 Features

### Core Features
- Role-based authentication
- Prescription management
- Pharmacy coordination
- Patient record tracking

### Advanced Features (Optional)
- PDF prescription generation
- Email notifications
- Search & filtering
- Analytics dashboard
- Audit logs

---

## 📈 Future Enhancements

- Mobile application (Android/iOS)
- AI-based prescription suggestions
- Drug interaction warnings
- Cloud deployment (AWS/Azure)
- Real-time notifications (WebSocket)

---

## 🏁 Conclusion

This system digitizes healthcare prescriptions and improves coordination between doctors, patients, and pharmacies with a secure and scalable architecture.

---

## 👨‍💻 Author

Project: Digital Prescription and Pharmacy Coordination System  
Stack: Spring Boot + React + MySQL  

