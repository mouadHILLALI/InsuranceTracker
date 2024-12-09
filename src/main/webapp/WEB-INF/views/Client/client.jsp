<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Client Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <style>
        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0px 10px 15px rgba(0, 0, 0, 0.1);
            transition: all 0.3s ease;
        }
    </style>
</head>
<body class="bg-gray-50">
<c:if test="${not empty sessionScope.alertMessage}">
    <div class="container mx-auto mt-4">
        <div class="bg-blue-100 border border-blue-400 text-blue-700 px-4 py-3 rounded relative" role="alert">
            <span class="block sm:inline">${sessionScope.alertMessage}</span>
            <button onclick="this.parentElement.style.display='none';" class="absolute top-0 bottom-0 right-0 px-4 py-3">
                <svg class="fill-current h-6 w-6 text-blue-500" role="button" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M14.348 5.652a1 1 0 010 1.415L11.414 10l2.934 2.933a1 1 0 01-1.415 1.415L10 11.414l-2.933 2.934a1 1 0 01-1.415-1.415L8.586 10 5.652 7.067a1 1 0 011.415-1.415L10 8.586l2.933-2.934a1 1 0 011.415 0z"/></svg>
            </button>
        </div>
    </div>
</c:if>
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
<div class="container mx-auto mt-8">
    <div class="bg-white p-6 rounded-lg shadow-lg">
        <h2 class="text-2xl font-bold mb-6 text-gray-700">Manage Your Insurances</h2>
        <div class="grid grid-cols-1 md:grid-cols-3 gap-8">
            <a href="/insurance/car" class="block bg-white border rounded-lg shadow card hover:border-blue-500 transition">
                <div class="p-6 text-center">
                    <img src="https://img.icons8.com/external-flatart-icons-flat-flatarticons/64/000000/external-car-insurance-car-flatart-icons-flat-flatarticons.png" alt="Car Insurance" class="mx-auto mb-4">
                    <h3 class="text-xl font-semibold text-gray-800">Car Insurance</h3>
                    <p class="text-gray-600">Manage and create your car insurance policies with ease.</p>
                </div>
            </a>
            <a href="/insurance/home" class="block bg-white border rounded-lg shadow card hover:border-blue-500 transition">
                <div class="p-6 text-center">
                    <img src="https://img.icons8.com/external-flatart-icons-flat-flatarticons/64/000000/external-home-insurance-house-flatart-icons-flat-flatarticons.png" alt="Home Insurance" class="mx-auto mb-4">
                    <h3 class="text-xl font-semibold text-gray-800">Home Insurance</h3>
                    <p class="text-gray-600">Manage and create your home insurance policies securely.</p>
                </div>
            </a>
            <a href="/insurance/health" class="block bg-white border rounded-lg shadow card hover:border-blue-500 transition">
                <div class="p-6 text-center">
                    <img src="https://img.icons8.com/external-flatart-icons-flat-flatarticons/64/000000/external-health-insurance-medicine-flatart-icons-flat-flatarticons.png" alt="Health Insurance" class="mx-auto mb-4">
                    <h3 class="text-xl font-semibold text-gray-800">Health Insurance</h3>
                    <p class="text-gray-600">Manage and create your health insurance policies easily.</p>
                </div>
            </a>
        </div>
    </div>
    <div class="mt-12 bg-white p-6 rounded-lg shadow-lg">
        <h2 class="text-2xl font-bold mb-6 text-gray-700">Your Insurance Stats</h2>

        <div class="grid grid-cols-1 md:grid-cols-3 gap-8">
            <div class="bg-blue-100 p-6 rounded-lg text-center shadow card">
                <h3 class="text-3xl font-bold text-blue-600">${activeInsurances}</h3>
                <p class="text-gray-700">Active Policies</p>
            </div>
            <div class="bg-green-100 p-6 rounded-lg text-center shadow card">
                <h3 class="text-3xl font-bold text-green-600">${totalContracts}</h3>
                <p class="text-gray-700">total contracts</p>
            </div>
            <div class="bg-yellow-100 p-6 rounded-lg text-center shadow card">
                <h3 class="text-3xl font-bold text-yellow-600">${totalPremium}DH</h3>
                <p class="text-gray-700">Total Premiums Paid</p>
            </div>
        </div>
    </div>
</div>

</body>
</html>
