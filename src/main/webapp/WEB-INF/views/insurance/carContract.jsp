<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Insurance Contract</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <style>
        .contract-card {
            max-width: 800px;
            margin: auto;
            padding: 20px;
            border: 1px solid #e2e8f0;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }
        .contract-header {
            text-align: center;
            font-size: 1.5rem;
            font-weight: bold;
            color: #1a202c;
        }
        .contract-details {
            margin-top: 20px;
        }
        .details-row {
            display: flex;
            justify-content: space-between;
            margin-bottom: 10px;
        }
        .label {
            font-weight: 600;
            color: #4a5568;
        }
        .value {
            color: #2d3748;
        }
    </style>
</head>
<body class="bg-gray-100">

<!-- Navbar -->
<nav class="bg-blue-600 p-4 text-white shadow-md">
    <div class="container mx-auto flex justify-between items-center">
        <div>
            <a href="/Auth/client" class="text-xl font-bold">InsuranceTracker</a>
        </div>
        <div>
            <a href="/Auth/profile" class="px-4 hover:underline">Profile</a>
            <a href="/insurances" class="px-4 hover:underline">My Insurances</a>
            <a href="/Auth/logout" class="px-4 hover:underline">Logout</a>
        </div>
    </div>
</nav>

<!-- Contract Details -->
<div class="container mx-auto mt-8">
    <div class="contract-card">
        <div class="contract-header">
            Car Insurance Contract
        </div>
        <div class="contract-details">
            <!-- Contract Information -->
            <div class="details-row">
                <span class="label">Insurance ID:</span>
                <span class="value">${insurance.id}</span>
            </div>
            <div class="details-row">
                <span class="label">Vehicle Type:</span>
                <span class="value">${insurance.vehiculeType}</span>
            </div>
            <div class="details-row">
                <span class="label">Start Date:</span>
                <span class="value">${insurance.startDate}</span>
            </div>
            <div class="details-row">
                <span class="label">End Date:</span>
                <span class="value">${insurance.endDate}</span>
            </div>
            <div class="details-row">
                <span class="label">Driver Age:</span>
                <span class="value">${insurance.driverAge}</span>
            </div>
            <div class="details-row">
                <span class="label">Professional Use:</span>
                <span class="value">
                    <c:choose>
                        <c:when test="${insurance.isProfessionalUse}">
                            Yes
                        </c:when>
                        <c:otherwise>
                            No
                        </c:otherwise>
                    </c:choose>
                </span>
            </div>
            <div class="details-row">
                <span class="label">Accident History:</span>
                <span class="value">
                    <c:choose>
                        <c:when test="${insurance.hasAccidents}">
                            Yes
                        </c:when>
                        <c:otherwise>
                            No
                        </c:otherwise>
                    </c:choose>
                </span>
            </div>
            <div class="details-row">
                <span class="label">Contract ID:</span>
                <span class="value">${contract.id}</span>
            </div>
            <div class="details-row">
                <span class="label">Total Premium:</span>
                <span class="value">${contract.total} DH</span>
            </div>
        </div>
    </div>
    <div class="col-span-2 text-right mt-4">
        <form action="/insurance/downloadPdf" method="get">
            <input value="${insurance.id}" name="id" type="hidden">
            <button type="submit" class="bg-green-600 hover:bg-green-700 text-white font-bold py-2 px-4 rounded-lg shadow-md transition duration-300">
                Download PDF
            </button>
        </form>
    </div>
</div>

</body>
</html>
