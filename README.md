# Job Scheduler & Automation System

## 📌 Overview
This project is a simplified Job Scheduler & Automation Dashboard built as part of the Dotix Technologies Full Stack Developer Skill Test.

The system allows users to:
- Create background jobs
- Track job execution status
- Run jobs asynchronously
- Trigger outbound webhooks on job completion

---

## 🛠 Tech Stack

**Note:** The assignment suggested using Node.js or Python for the backend, but this project implements the backend using **Java**.

### Frontend
- React (Vite)
- JavaScript
- HTML5
- CSS

### Backend
- Java
- Spring Boot
- REST APIs

### Database
- MySQL

### Integrations
- Webhook.site (Outbound webhook testing)

---

## 📂 Project Structure

```

JobScheduler/
├── frontend/            # React (Vite) frontend
│   ├── src/
│   │   ├── components/  # Reusable UI components
│   │   ├── pages/       # Page components (Dashboard, Job Details, Create Job)
│   │   └── App.jsx      # Main App
│   └── package.json
├── backend/             # Spring Boot backend
│   ├── src/main/java/   # Java source code
│   │   └── com/example/jobscheduler/
│   │       ├── controller/ # REST Controllers
│   │       ├── model/      # Entity classes
│   │       ├── repository/ # Spring Data JPA Repositories
│   │       └── service/    # Business logic / Job Runner
│   ├── src/main/resources/
│   │   └── application.properties  # Database & app config
│   └── pom.xml
├── README.md
└── .gitignore

````

---

## ⚙️ Setup Instructions

### 1️⃣ Backend
```bash
cd backend
# Make sure you have Java & Maven installed
mvn clean install
mvn spring-boot:run
# Backend runs on http://localhost:8080
````

### 2️⃣ Frontend

```bash
cd frontend
npm install
npm run dev
# Frontend runs on http://localhost:5173 (Vite default)
```

### 3️⃣ Database

* Create MySQL database: `job_scheduler_db`
* Update credentials in `backend/src/main/resources/application.properties`
* Suggested table schema:

```sql
CREATE TABLE jobs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    task_name VARCHAR(255) NOT NULL,
    payload JSON,
    priority ENUM('Low','Medium','High') DEFAULT 'Low',
    status ENUM('pending','running','completed') DEFAULT 'pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

---

## 🖥 Frontend Features

* Job Dashboard (list all jobs with status & priority filters)
* Create Job form (`taskName`, `payload`, `priority`)
* Job Detail view (readable JSON payload)
* Run Job button → triggers backend `/run-job/:id`

---

## 🔌 Backend APIs

| Method | Endpoint      | Description                           |
| ------ | ------------- | ------------------------------------- |
| POST   | /jobs         | Create a new job                      |
| GET    | /jobs         | List all jobs                         |
| GET    | /jobs/:id     | Get job details                       |
| POST   | /run-job/:id  | Run a job (simulate async processing) |

**Job Runner Logic:**

1. Change status → `running`
2. Wait 3 seconds to simulate processing
3. Change status → `completed`
4. Trigger outbound webhook to `https://webhook.site/<your-id>` with payload:

```json
{
  "jobId": 1,
  "taskName": "Example Job",
  "priority": "High",
  "payload": { "data": "example" },
  "completedAt": "2026-01-11T15:00:00Z"
}
```

---

## 🏗 Architecture Overview

```
[React Frontend] <---> [Spring Boot REST API] <---> [MySQL Database]
                                          |
                                          v
                                 [Webhook.site Integration]
```

* Frontend: React + Tailwind
* Backend: Spring Boot with REST APIs and Job Runner service
* Database: MySQL
* Webhook: Outbound POST triggered on job completion

---

## 📄 AI Usage Log

| Tool    | Model / Version | Usage Area                    | Notes                                     |
| ------- | --------------- | ----------------------------- | ----------------------------------------- |
| ChatGPT | GPT-4           | Backend REST API & Job Runner | Helped create endpoints & async job logic |
| ChatGPT | GPT-4           | Frontend components           | Dashboard, filters, Run Job button        |
| ChatGPT | GPT-4           | Documentation & README        | README structure, formatting, API docs    |

<img width="1916" height="1028" alt="Screenshot 2026-01-11 143843" src="https://github.com/user-attachments/assets/35a18596-c8b0-45a9-8620-286326f7f7bc" />
<img width="1919" height="1028" alt="Screenshot 2026-01-11 143859" src="https://github.com/user-attachments/assets/56a51f68-377b-4040-99d7-1ae7defb4fad" />
<img width="1910" height="1025" alt="Screenshot 2026-01-11 144606" src="https://github.com/user-attachments/assets/6d88c78a-b01b-4fce-a63c-aac4069875b0" />
<img width="1919" height="960" alt="Screenshot 2026-01-11 144621" src="https://github.com/user-attachments/assets/d4e1ff0f-b5bb-43c7-a539-f79eafa2a64d" />
<img width="1917" height="947" alt="Screenshot 2026-01-11 144637" src="https://github.com/user-attachments/assets/2f4d713d-6b9d-4620-8696-f8d60b95208e" />
<img width="1919" height="949" alt="Screenshot 2026-01-11 144652" src="https://github.com/user-attachments/assets/356b1365-e4fa-4a2e-8163-a5e08b76a163" />
<img width="1914" height="958" alt="Screenshot 2026-01-11 144707" src="https://github.com/user-attachments/assets/a3d0acd9-8daf-46cf-b70b-617c255aa69b" />







