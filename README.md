# Parking Web Application

## Description

The Parking Web Application is a comprehensive solution for managing parking lot. This application leverages Spring Boot for the backend and Next.js for the frontend to provide a robust and user-friendly interface for parking management. The primary functionalities include vehicle check-in and check-out processes, ensuring smooth and efficient operation of parking lots.

## Features

- **Check-in**: Register a vehicle upon entering the parking lot. The system captures essential details such as vehicle number, time of entry, and assigns a parking spot.
- **Checkout**: Process vehicle departure, calculate the parking duration, and generate the total parking fee based on the duration of the stay.
- **User-friendly Interface**: A responsive and intuitive user interface built with Next.js, making it easy for users to interact with the application.
- **Efficient Backend**: A robust backend powered by Spring Boot ensures reliable data processing and storage.

## Installation

To get the application up and running, follow these steps:

### Prerequisites

- Node.js (for running Next.js)
- Java (for running Spring Boot)
- Maven (for building the Spring Boot application)
- A database system (e.g., MySQL, PostgreSQL)

### Backend Setup (Spring Boot)

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/parking-web-application.git
   cd parking-web-application/backend
   ```
2. **Configure the database:**
   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/parkingdb
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```
3. **Build and run the backend:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

### Frontend Setup (Next.js)

1. **Navigate to the frontend directory:**
   ```bash
   cd ../frontend
   ```
   
2. **Install dependencies:**
   ```bash
   npm install
   ```
3. **Run the frontend:**
   ```bash
   npm run dev
   ```
3. **Open Browser:**
   Navigate to: http://localhost:3000
