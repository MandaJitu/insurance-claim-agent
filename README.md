# 🧾 Autonomous Insurance Claims Processing Agent

A Spring Boot–based lightweight agent that processes **FNOL (First Notice of Loss)** documents, extracts key claim information, validates data completeness, and routes insurance claims to the appropriate workflow based on defined business rules.

This project is implemented as part of an **Autonomous Insurance Claims Processing Agent assessment**.

---

## 📌 Problem Statement

Insurance companies receive FNOL documents in structured and semi-structured formats (PDF/TXT). The objective is to build an automated agent that:

* Extracts key fields from FNOL documents
* Identifies missing or inconsistent mandatory fields
* Classifies claims and routes them to the correct workflow
* Provides a short explanation for the routing decision

---

## ✅ Features

* 📄 FNOL **PDF processing** using Apache PDFBox
* 🧾 Extraction of **user-filled PDF form fields (AcroForm)**
* 🔍 Validation of **mandatory fields**
* 🧠 **Rule-based routing engine**
* 🌐 **Spring Boot REST API** for claim processing
* 📦 Structured **JSON output** as per assessment requirements

---

## 🏗️ Technology Stack

* **Java 17**
* **Spring Boot**
* **Apache PDFBox**
* **Jackson (JSON processing)**
* **Maven**

---

## 🧠 High-Level Architecture

```
Client uploads FNOL PDF
        ↓
Spring Boot REST API
        ↓
PDF Extraction (AcroForm + Text)
        ↓
Field Validation
        ↓
Routing Rules Engine
        ↓
JSON Response
```

---

## 📂 Project Structure

```
insurance-claim-agent/
│
├── controller/
│   └── ClaimController.java
├── service/
│   └── ClaimProcessingService.java
├── extractor/
│   └── FnolExtractor.java
├── parser/
│   └── ClaimFieldParser.java
├── validator/
│   └── ClaimValidator.java
├── router/
│   └── ClaimRouter.java
├── model/
│   └── ClaimData.java
├── ClaimsApplication.java
└── pom.xml
```

---

## 📑 Fields Extracted

### Policy Information

* Policy Number
* Policyholder Name

### Incident Information

* Date
* Location
* Description

### Asset Details

* Estimated Damage

### Other Mandatory Fields

* Claim Type

---

## 🔁 Routing Rules

| Condition                                              | Route               |
| ------------------------------------------------------ | ------------------- |
| Estimated damage < 25,000                              | Fast-track          |
| Any mandatory field missing                            | Manual Review       |
| Description contains `fraud`, `staged`, `inconsistent` | Investigation Flag  |
| Claim type = injury                                    | Specialist Queue    |
| Otherwise                                              | Standard Processing |

---

## 🌐 REST API

### Endpoint

```
POST /api/claims/process
```

### Request

* **Content-Type:** `multipart/form-data`
* **Body Parameter:**

  * `file` → FNOL PDF document

### Sample cURL Request

```bash
curl -X POST http://localhost:8080/api/claims/process \
-F "file=@ACORD-Automobile-Loss-Notice.pdf"
```

---

## 📤 Sample JSON Response

```json
{
  "extractedFields": {
    "policyNumber": "ABC123",
    "policyHolderName": "Jitu",
    "location": "Bangalore",
    "description": "Hello world",
    "estimatedDamage": 50000
  },
  "missingFields": [],
  "recommendedRoute": "Specialist Queue",
  "reasoning": "Claim type is injury and all mandatory fields are present"
}
```

---

## ▶️ How to Run the Application

### Prerequisites

* Java 17 or higher
* Maven

### Steps

```bash
git clone https://github.com/MandaJitu/insurance-claim-agent.git
cd insurance-claim-agent
mvn spring-boot:run
```

The application will start on:

```
http://localhost:8080
```

---

## 🧠 Design Considerations

* **AcroForm extraction** is used to correctly read user-filled PDF fields
* **Layered architecture** ensures clean separation of concerns
* **Rule-based routing** provides transparency and explainability
* The system is easily extensible to support:

  * NLP / LLM-based extraction
  * Workflow engines
  * Database persistence

---

## 🚀 Future Enhancements

* Swagger / OpenAPI documentation
* Database integration
* AI-based field extraction
* Fraud scoring and analytics
* Batch FNOL processing

---

## 👤 Author

**Manda Jitu**
Java Backend Developer
GitHub: [https://github.com/MandaJitu](https://github.com/MandaJitu)
