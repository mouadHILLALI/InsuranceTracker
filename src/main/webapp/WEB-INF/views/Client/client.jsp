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

<!-- Navigation Bar -->
<nav class="bg-blue-600 p-4 text-white shadow-md">
    <div class="container mx-auto flex justify-between items-center">
        <div>
            <a href="/client-dashboard" class="text-xl font-bold">InsuranceTracker</a>
        </div>
        <div>
            <a href="/profile" class="px-4 hover:underline">Profile</a>
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

    <!-- Stats Section -->
    <div class="mt-12 bg-white p-6 rounded-lg shadow-lg">
        <h2 class="text-2xl font-bold mb-6 text-gray-700">Your Insurance Stats</h2>

        <div class="grid grid-cols-1 md:grid-cols-3 gap-8">
            <!-- Active Policies -->
            <div class="bg-blue-100 p-6 rounded-lg text-center shadow card">
                <h3 class="text-3xl font-bold text-blue-600">3</h3>
                <p class="text-gray-700">Active Policies</p>
            </div>

            <!-- Claims Processed -->
            <div class="bg-green-100 p-6 rounded-lg text-center shadow card">
                <h3 class="text-3xl font-bold text-green-600">5</h3>
                <p class="text-gray-700">Claims Processed</p>
            </div>

            <!-- Total Premiums Paid -->
            <div class="bg-yellow-100 p-6 rounded-lg text-center shadow card">
                <h3 class="text-3xl font-bold text-yellow-600">12,500 MAD</h3>
                <p class="text-gray-700">Total Premiums Paid</p>
            </div>
        </div>
    </div>
</div>

</body>
</html>
