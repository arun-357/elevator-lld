# 🚀 Elevator System (Low-Level Design)

## 📘 Problem Statement

Design and implement an **Elevator System** that supports:
- Multiple elevators
- Efficient request handling
- State and direction management
- Modular and extensible architecture

---

## ✅ Features

- Multiple elevators handled by a central controller
- Request handling with direction (UP, DOWN)
- Efficient movement using separate queues for UP and DOWN directions
- Proximity-based assignment strategy
- Step-wise simulation of elevator movement
- Easily extensible for scheduling algorithms, maintenance mode, etc.

---

## System Architecture

### 🔹 Core Components

| Component | Responsibility |
|----------|----------------|
| `Elevator` | Maintains state, handles requests, processes floors |
| `ElevatorController` | Accepts and assigns external requests to elevators |
| `Request` | Represents a user request to go to a specific floor in a direction |
| `Direction` | Enum to represent UP, DOWN, IDLE |
