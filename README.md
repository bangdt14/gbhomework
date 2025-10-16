
# VAT Calculator Automation Test

## 📘 Overview
This repository contains automated test scripts and documentation for a **VAT Calculator** web application.  

---
## 🧪 Automated Test Cases

1. **VAT Calculation (Valid Input)**  
   - Verifies correct VAT computation for valid inputs.

2. **Negative Input Validation**  
   - Ensures invalid or malformed data is correctly rejected.

---

## 🎯 Objectives

| Goal | Description |
|------|--------------|
| **Regression Coverage** | Ensure VAT calculation accuracy is not broken by future code changes. |
| **Input Validation** | Prevent invalid or malformed user inputs from reaching backend systems. |
| **Fast Feedback Loop** | Provide quick validation via automated smoke tests. |
| **Reduced Manual Effort** | Eliminate repetitive manual recalculations. |
| **Confidence in Core Functionality** | Maintain reliability in business-critical calculations. |

---

## 🧩 Framework Details

**Technology Stack:**  
- Selenium WebDriver  
- Java  
- Cucumber (BDD)

### Key Benefits

| Category | Benefit |
|-----------|----------|
| **Readability** | Gherkin scenarios are readable and reviewable by non-developers. |
| **Reusability** | Steps like “user selects country” are reusable across all tests. |
| **Scalability** | Adding new test cases (e.g., different VAT rates or countries) is straightforward. |
| **Maintainability** | Clear separation between feature files, step definitions, and code. |
| **CI/CD Integration** | Compatible with Jenkins, GitHub Actions, or Azure DevOps pipelines. |
| **Reporting** | Supports HTML and Allure reports for test summary and visualization. |
| **Cross-browser Testing** | Selenium supports all major browsers (Chrome, Firefox, Edge, Safari) |

---

## 🐞 Bug Report Example

### Bug 001 — Decimal Precision Issue
**Title:** Input field accepts more than 2 decimal places  
**Severity:** Medium  
**Environment:** SIT/ UAT/ Prod  
**OS platform/ version:** Chrome 140, Windows 11  
**Steps to Reproduce:**
1. Open VAT Calculator.
2. Select country (e.g., Germany) and VAT rate (e.g., 19%).
3. Enter a Net value with >2 decimals (e.g., `123.4567`).

**Expected:** Restrict to 2 decimal places (e.g., `123.45`).  
**Actual:** Field accepts more than 2 decimals.  

**Attachment:** Screenshot showing input field accepting extra decimals.

---

### Bug 002 — Missing Error Message for Max Amount
**Title:** No error message displayed when amount exceeds `999,999,999`  
**Severity:** Medium  
**Environment:** SIT/ UAT/ Prod  
**OS platform/ version:** Chrome 140, Windows 11   
**Steps to Reproduce:**
1. Open VAT Calculator.
2. Enter `1,000,000,000` as Net amount.

**Expected:** Display error:  
> “Amount exceeds the maximum allowed value (999,999,999).”

**Actual:** Input restricted, but no error shown.  

**Attachemnt:** Screenshot showing absence of error message after entering a large amount.  

---

### Bug 003 — Invalid Input Type Not Handled
**Title:** Alphabetic or special characters accepted in amount field  
**Severity:** High  
**Environment:** SIT/ UAT/ Prod  
**OS platform/ version:** Chrome 140, Windows 11  
**Steps to Reproduce:**
1. Open VAT Calculator.
2. Enter invalid inputs (`abc`, `@#$`).

**Expected:** Show error  
> “Invalid input. Please enter a numeric value only.”  
and prevent calculation.

**Actual:** No validation triggered; field accepts invalid input.

**Attachment:** Screenshot showing absence of error message after entering a non numeric value.  

---

## ❓ Open Questions / Clarifications Needed

1. Should the field labels on the site be updated to be more user-friendly and improve readability?
   - “Net” → instead of “Price without VAT”
   - “VAT” → instead of “Value-Added Tax”
   - “Gross” → instead of “Price incl. VAT”
2. For amounts > `999,999,999`, what exact behavior or message is expected?
3. Should error messages appear **inline** beside the field or as **popup alerts**?
4. When values exceed two decimals:
   - Should the calculator **round** or **reject** the input?
5. Pressing **Enter** currently refreshes the page:
   - Should this behaviour be fixed to improve user experience?


